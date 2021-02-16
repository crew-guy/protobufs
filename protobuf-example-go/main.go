package main

import (
	"fmt"
)

func main() {
	doSimple()

}

func doSimple() {
	sm := simplepb.SimpleMessage{
		Id:       12345,
		NameList: []string{"Tom", "Dick", "Harry"},
		IsValid:  true,
	}

	fmt.Println(sm)

	// sm.Id = 465887
}
