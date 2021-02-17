package ankitprotobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ProtoToJSON {
    public static void main(String [] args) throws InvalidProtocolBufferException {
        System.out.println("Hi ! ");
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();


        // Simple field
        builder.setName("Sample name")
                .setNumber(32)
                .setIsValid(false);


        // Repeated Field
        builder.addPhone("pehla");


        // Chaining commands
        builder.addPhone("dusra")
                .addPhone("teesra");

        builder.addAllPhone(Arrays.asList("chautha", "paanchva"));


        System.out.println(builder.toString());

        Simple.SimpleMessage message = builder.build();

        message.getName();

//        builder.clear()

        builder.setPhone(2, "doosra");

        // Write the protocol buffer's binary to a file
        try{
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // send as byte array
        //byte[] bytes = message.toByteArray();


        try{
            System.out.println("Reading from file.......");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            Simple.SimpleMessage messageFromFile = Simple.SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Print this as a JSON
        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();

        // Parse JSON into a protobuf
        JsonFormat.parser().ignoringUnknownFields().merge(jsonString,builder2);

        System.out.println(builder2);
    }
}
