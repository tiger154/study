package play;

import com.jeonhwan.algorithm.sort.MergeSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Java use 'call by value'
 *  - When pass object, we can change it's property like reference.
 *  - But If we assign new Instance or null, it's gonna point new address.
 *  -
 *
 *
 *
 *
 */
public class PassByWhat {
    private static Logger log = LoggerFactory.getLogger(MergeSort.class);


    /**
     * Test when assign primitive values, If it works as copy of value or not
     * Here I assigned y = x , and changed y = 3.
     * If it's a reference then x, y all need to print 3.
     * If not it means it's copy of value.
     *
     */
    @Test
    public void testPrimitive(){
        int x = 1;
        int y = 2;
        y = x;
        y = 3;
        log.debug("x: {}, y: {}", x,y);
    }

    /**
     * Here it sets like this ->  oldDog = aDog = new Dog('Max')
     * And tried to change oldDog's name to 'Old Max'
     * If it pass '==' operation and 'equals' operation, It means we can change property
     *
     * But remember it test just only change property from assigned var.
     *
     */
    @Test
    public void testObjSimple() {

       Dog aDog =  new Dog("Max");
       Dog oldDog = aDog;
       // 1. Check if its same address in memory
       assertTrue(aDog == oldDog & aDog.equals(oldDog));

       // 2. Change oldDog's value and test, if it also change aDogs value
       oldDog.setName("Old Max");
       assertTrue(aDog == oldDog & aDog.equals(oldDog));

       log.debug("test yes");
    }

    /**
     * We test if we pass an object to a function,
     *   1) (Inside the function) Try to change property
     *     - Compare if it affects outside of function  --> Yes
     *   2) (Inside the function) Try to assign new instance
     *     - Compare if it affects outside of function  --> No
     *
     *
     *  If it pass by reference, when assign new instance, it also affect outside of function.
     *  But It didn't so it's not pass by reference.
     *
     *  Then Why it works on change property data.
     *  It pass copy value of reference, let say
     */
    @Test
    public void testObjAssignNew() {

        Dog aDog =  new Dog("Max");
        Dog oldDog = aDog;

        foo(aDog);
        aDog.getName().equals("Max");   // true
        aDog.getName().equals("Fifi");  // false

        if(aDog == oldDog) {
            log.debug("it's same!");
        }

        log.debug("test yes");
    }

    // test property with assign new instance
    public static void foo(Dog d) {
        d.getName().equals("Max");   // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
        d = new Dog("Fifi");
        d.getName().equals("Fifi");
    }

    // test property without changing pointer address
    public static void changeValue(Dog d) {
        d.setName("No Max");
    }

}
