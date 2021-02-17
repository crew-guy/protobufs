package ankitprotobuf;

import example.enumerator.EnumExample;

public class EnumMain {
    public static void main(String[] args) {

        EnumExample.EnumMessage.Builder builder2 = EnumExample.EnumMessage.newBuilder();

        builder2.setId(3243);
        builder2.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumExample.EnumMessage message2 = builder2.build();

        System.out.println(message2);
    }
}
