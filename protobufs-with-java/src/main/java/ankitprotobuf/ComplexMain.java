package ankitprotobuf;

import example.complex.Complex.DummyMessage;
import example.complex.Complex.ComplexMessage;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        ComplexMessage.Builder builder = ComplexMessage.newBuilder();


        // Singular field
        builder.setDummyOneMsg(newDummyMessage(3432,"another dummy message"));

        // Repeated field
        builder.addMultipleDummyMsg(newDummyMessage(54, "yet another dummy message"));

        ComplexMessage message = builder.build();
        builder.addAllMultipleDummyMsg((Arrays.asList(
                newDummyMessage(5564, "first dummy message"),
                newDummyMessage(542, "second dummy message")
        )));

        System.out.println(message);
    }
    public static DummyMessage newDummyMessage (Integer id, String name){
        DummyMessage.Builder dummy_builder = DummyMessage.newBuilder();
        DummyMessage message = dummy_builder.setId(355).setName("one dummy").build();

        return message;
    }
}
