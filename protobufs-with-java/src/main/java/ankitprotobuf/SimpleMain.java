package ankitprotobuf;

import example.enumerator.EnumExample;
import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;

public class SimpleMain {
    public static void main(String [] args){
        System.out.println("Hi ! ");
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();


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

        SimpleMessage message = builder.build();

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
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
