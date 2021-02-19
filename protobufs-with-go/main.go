package main

import (
	"fmt"
	"io/ioutil"
	"log"

	complexpb "protocol-buffers/protobufs-with-go/src/complex"
	enumpb "protocol-buffers/protobufs-with-go/src/enum_example"
	simplepb "protocol-buffers/protobufs-with-go/src/simple"

	"github.com/golang/protobuf/jsonpb"
	"google.golang.org/protobuf/proto"
)

func main() {
	fmt.Println("Hello world")
	sm := doSimple()

	// Reading and writing from file
	readAndWriteDemo(sm)

	// Working with enum values
	doEnum()

	// Working with complex values
	doComplex()

	// Converting and re-converting back from json
	jsonDemo(sm)
}

func doEnum() {
	em := enumpb.EnumMessage{
		Id:           421,
		DayOfTheWeek: enumpb.DayOfTheWeek_FRIDAY,
	}

	em.DayOfTheWeek = enumpb.DayOfTheWeek_MONDAY
	fmt.Println(em)
}

func doComplex() {
	cm := complexpb.ComplexMessage{
		OneDummy: &complexpb.DummyMessage{
			Id:   1,
			Name: "First Message",
		},
		MultipleDummy: []*complexpb.DummyMessage{
			&complexpb.DummyMessage{
				Id:   2,
				Name: "Second Message",
			},
			&complexpb.DummyMessage{
				Id:   3,
				Name: "Third Message",
			},
		},
	}

	fmt.Println(cm)
}

func jsonDemo(sm proto.Message) {
	smAsString := toJSON(sm)
	fmt.Println(smAsString)
	sm2 := &simplepb.SimpleMessage{}
	fromJSON(smAsString, sm2)
	fmt.Println("Successfully created proto struct", sm2)
}

func toJSON(pb proto.Message) string {
	marshaler := jsonpb.Marshaler{}
	out, err := marshaler.MarshalToString(pb)
	if err != nil {
		log.Fatalln("Can't convert to JSON", err)
		return ""
	}
	return out
}

func fromJSON(fname string, pb proto.Message) {
	err := jsonpb.UnmarshalString(fname, pb)
	if err != nil {
		log.Fatalln("Couldn't unmarshal the JSON into the pb struct", err)
	}
}

func readAndWriteDemo(sm proto.Message) {
	writeToFile("simple.bin", sm)
	sm2 := &simplepb.SimpleMessage{}
	readFromFile("simple.bin", sm2)
	fmt.Println(sm2)
}

func writeToFile(fname string, pb proto.Message) error {

	// Takes in pb message as input and returns a byte array
	out, err := proto.Marshal(pb)

	if err != nil {
		log.Fatalln("Can't serialize bytes", err)
		return err
	}

	if err := ioutil.WriteFile(fname, out, 0644); err != nil {
		log.Fatalln("Can't write to file", err)
		return err
	}

	fmt.Println("Data has been written")
	return nil

}

func readFromFile(fname string, pb proto.Message) error {
	in, err := ioutil.ReadFile(fname)
	if err != nil {
		log.Fatalln("Something went wrong when reading the file", err)
		return err
	}

	err2 := proto.Unmarshal(in, pb)
	if err2 != nil {
		log.Fatalln("Couldn't put the bytes into the protobufs struct", err)
		return err2
	}

	return nil
}

func doSimple() *simplepb.SimpleMessage {
	sm := simplepb.SimpleMessage{
		Id:         12345,
		IsSimple:   false,
		Name:       "Bob",
		SampleList: []int32{1, 2, 3, 4, 5},
	}

	fmt.Println(sm)

	sm.Name = "I renamed you"

	fmt.Println(sm)

	fmt.Println(sm.GetId())

	return &sm
}
