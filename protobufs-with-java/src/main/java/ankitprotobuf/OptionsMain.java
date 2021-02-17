package ankitprotobuf;

import com.example.options.OptionMessageTest;

public class OptionsMain {
    public static void main(String[] args) {
        OptionMessageTest.Builder opmsg_builder = OptionMessageTest.newBuilder();

        OptionMessageTest message = opmsg_builder.setIsValid(true).setInt(43).build();

        System.out.println(message);

    }
}
