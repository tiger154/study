package play;

import org.junit.Test;

public class StringTest {

    @Test
    public void stringConcatSpeedTest() {
        long now = System.currentTimeMillis();

        fast();
        System.out.println("fast elapsed " + ( System.currentTimeMillis() - now) + " ms");


        now = System.currentTimeMillis();
        slow();
        System.out.println("slow elapsed " + ( System.currentTimeMillis() - now) + " ms");

    }


    /**
     *  String + String doesn't change original value,
     *  It create new Instance and set value => it works like enum value, old value gonna be garbage collection
     */
    @Test
    public void stringAddressCompare() {
        String a = "aa";
        String b = new String("bb");

        System.out.printf("a | value: %-4s, address: %s\n", a, a.hashCode());
        System.out.printf("b | value: %-4s, address: %s\n", b, b.hashCode());

        a = a + b;

        System.out.printf("a | value: %-4s, address: %s\n", a, a.hashCode());
        System.out.printf("b | value: %-4s, address: %s\n", b, b.hashCode());
    }


    private static void fast() {
        StringBuilder s = new StringBuilder();
        for(int i=0; i<100000; i++) {
            s.append("*");
        }
    }

    private static void slow() {
        String s = "";
        for(int i=0; i<100000; i++) {
            s+="*";
        }
    }


}
