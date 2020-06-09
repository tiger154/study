package exam.leetcode.easy;

import com.jeonhwan.exam.leetcode.easy.Lcp_14;
import com.jeonhwan.exam.leetcode.easy.RomanToInteger_13;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Lcp_14Test {





    @Test
    public void testman() {
        //["flower","flow","flight"]
        // ["dog","racecar","car"]
        String[] strs = new String[]{"flower","flow","flight"};

        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"flower","flow","flight"});
        list.add(new String[]{"dog","racecar","car"});
        list.add(new String[]{"dog","dockdo","dorage"});
        list.add(new String[]{"c","c"});
        list.add(new String[]{"c","db"});

        for (String[] arr: list) {
            Lcp_14 lcp_14 = new Lcp_14();
            String lcp = lcp_14.vertical_with_return(arr);
            System.out.println("lcp is: " + lcp);
        }
    }





}
