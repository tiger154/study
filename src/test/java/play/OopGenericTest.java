package play;

import com.jeonhwan.algorithm.sort.MergeSort;


import javafx.util.Pair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class OopGenericTest {

    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for(int i=0; i<src.size(); i++) {
            dest.set(i, src.get(i));
        }
    }

    /**
     * Test difference between super and extends(Generic)
     *   refer:
     *   - http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeArguments.html#FAQ103
     *   - https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
     */
    @Test
    public void copy_test() {

        List<Object> output = new ArrayList<Object>();
        output.add(new Object());
        List<Long> input = new ArrayList<Long>();
        input.add(1L);


        OopGenericTest.copy(output, input);

        log.debug("copy test man");

    }

    @Test
    public void generic_test_a() {

//        List<Number> numberList = new ArrayList<>();
//        List<BigDecimal> bigDecimalList = new ArrayList<>();
//
//        List<?> c = (List<BigDecimal>) bigDecimalList;
//        numberList = (List<Number>) c;
//
//        //numberList =  bigDecimalList;


        Object[] objArr = new String[10];
        objArr[0] = new Long(0L); // compiles working... but runtime error..(It's not type-safe...)


        Object[] itemArray;
        itemArray = new Object[10];

        itemArray[0] = 1;
        itemArray[1] = "하이";
        itemArray[2] = new LinkedList<>();


        Object hey = itemArray[2];


        LinkedList list = new LinkedList();

        list.add("abc");
        list.add(new Date());
        // String haha = list.get(0);
        // Date haha2 = list.get(1);

        log.debug("hey");
    }


    @Test
    public void generic_upcast_demo() {

        // 1. Array Super - Sub relation test
        Number[] a = new Number[1];
        BigDecimal[]b = new BigDecimal[1];

        a = b;

        // 2. Genric Super - Sub relation test
        List<Number> numberList = new ArrayList<>();
        List<BigDecimal> bigDecimalList = new ArrayList<>();

        numberList =   (List<Number>) (List<?>) bigDecimalList;
    }

    @Test
    public void erase_test() {
        // 1. Runtime type check
        log.debug("runtime type of ArrayList<String>: {}", new ArrayList<String>().getClass());
        log.debug("runtime type of ArrayList<Long>: {}", new ArrayList<Long>().getClass());
    }


    @Test
    public void obj_to_string_test() {
        Object a = new Object();
        String b = (String) a;

        java.lang.String c = "cc";
        Object d = (Object) c;

        LinkedList<String> e = new LinkedList<>();
        List<String> f = e;

        log.debug("hey");
    }

    @Test
    public void unchecked_cast_test() {

        // Object arg = new Object();

        List<Integer> arg = new ArrayList<Integer>();
        arg.add(1);
        m2(arg);

    }

    public void m2(Object arg) {
        List<String> list = (List<String>) arg;
        String a = list.get(0);
        log.debug("hey");
    }


    @Test
    public void erase_a() {

        Number[] a = new Number[10];

        a[0] = new Integer(1);
        a[1] = new Double(1.1);


        log.debug("ha");

    }

    public <T> void demo(T hey) {
        // T[] there = new T[10];
        String a = "dd";
        T ddd = (T)a;
    }


    @Test
    public void binary_test() {
        int hey = 65 >> 1;



        log.debug("hoo");
    }

}
