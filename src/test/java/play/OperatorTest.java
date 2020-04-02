package play;

import org.junit.Test;

public class OperatorTest {


    /**
     * We can sum if you know ascii table
     *   - Ascii number's range is 48~57
     *   - So if char is between
     *
     * 1) Java use UNICODE not Ascii Code
     *   - UNICODE is a table
     *   - UTF-8 is a rule how to save
     * 2) Ascii is a part of UNICODE(utf-8)
     *
     *  * https://medium.com/@jeongdowon/unicode%EC%99%80-utf-8-%EA%B0%84%EB%8B%A8%ED%9E%88-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-b6aa3f7edf96
     *
     * Dec  Char                           Dec  Char     Dec  Char     Dec  Char
     * ---------                           ---------     ---------     ----------
     *   0  NUL (null)                      32  SPACE     64  @         96  `
     *   1  SOH (start of heading)          33  !         65  A         97  a
     *   2  STX (start of text)             34  "         66  B         98  b
     *   3  ETX (end of text)               35  #         67  C         99  c
     *   4  EOT (end of transmission)       36  $         68  D        100  d
     *   5  ENQ (enquiry)                   37  %         69  E        101  e
     *   6  ACK (acknowledge)               38  &         70  F        102  f
     *   7  BEL (bell)                      39  '         71  G        103  g
     *   8  BS  (backspace)                 40  (         72  H        104  h
     *   9  TAB (horizontal tab)            41  )         73  I        105  i
     *  10  LF  (NL line feed, new line)    42  *         74  J        106  j
     *  11  VT  (vertical tab)              43  +         75  K        107  k
     *  12  FF  (NP form feed, new page)    44  ,         76  L        108  l
     *  13  CR  (carriage return)           45  -         77  M        109  m
     *  14  SO  (shift out)                 46  .         78  N        110  n
     *  15  SI  (shift in)                  47  /         79  O        111  o
     *  16  DLE (data link escape)          48  0         80  P        112  p
     *  17  DC1 (device control 1)          49  1         81  Q        113  q
     *  18  DC2 (device control 2)          50  2         82  R        114  r
     *  19  DC3 (device control 3)          51  3         83  S        115  s
     *  20  DC4 (device control 4)          52  4         84  T        116  t
     *  21  NAK (negative acknowledge)      53  5         85  U        117  u
     *  22  SYN (synchronous idle)          54  6         86  V        118  v
     *  23  ETB (end of trans. block)       55  7         87  W        119  w
     *  24  CAN (cancel)                    56  8         88  X        120  x
     *  25  EM  (end of medium)             57  9         89  Y        121  y
     *  26  SUB (substitute)                58  :         90  Z        122  z
     *  27  ESC (escape)                    59  ;         91  [        123  {
     *  28  FS  (file separator)            60  <         92  \        124  |
     *  29  GS  (group separator)           61  =         93  ]        125  }
     *  30  RS  (record separator)          62  >         94  ^        126  ~
     *  31  US  (unit separator)            63  ?         95  _        127  DEL
     *
     *  Time Complexity is O(N)
     *  Space Complexity is..
     *
     */
    @Test
    public void sum_int_and_string() {
        //String str = "123";
        //String str = "  123";
        //String str = "  -123";
        //String str = "  -123word";
        //String str = "hey there  -123word";
        //String str = "--123word";
        //String str = "- 123word";
        //String str = "-91283472332";
        //String str = "91283472332";
        //String str = "+1";
        //String str = "+-1";
        //String str = "+1";
        String str = "2147483646";


        int sum_unicode = stoi(str);


        // 0000 0000 0000 0000 => 4
        // 00000000 00000000 => 8
        // 0000000000000000 => 16
        // A23 1010 0010 0011 => A23 = 1010 0010 0011
        System.out.println(sum_unicode);
    }


    public int stoi(String str) {
        int sum_unicode = 0;
        boolean is_negative = false;
        // This is right calculation man
        // 48(0) ~ 57(9)

        // need to check if it exist..
        // (s.charAt(1) - 48) somehow it's convert ?

        // This is a core concept! And its probably actual java implementation for String to int
        for (int i =0; i < str.length(); i++) {

            // 1. All filter here

            // 1.1. if just a space skip man~
            if (str.charAt(i) == ' ') { continue; }

            // 1.2 +, - detail check, check if next char is int
            if ((str.charAt(i) == '+' || str.charAt(i) == '-')) {
                // 1.2.1 if next value is not num exit
                if (i < str.length()-1 && is_not_num(str.charAt(i+1))) {
                    return 0;
                }
                // 1.2.2 if negative set save operator
                if (str.charAt(i) == '-' ) {
                    is_negative = true;
                }
                // and continue both + or - case
                continue;
            }




            // 1.3 if it's not number then just finish this
            if(((str.charAt(i) - 48) < 0 || (str.charAt(i) - 48) > 9)) {
                return 0;
            }

            // 1.4 Check overflow and return it! (-2^31 ~ 2^31-1)
            if (is_negative) {
                int min_d_10 = Integer.MIN_VALUE / 10;
                int negative_sum_unicode = sum_unicode * -1;
                if ( negative_sum_unicode < min_d_10 || (negative_sum_unicode == min_d_10 && ((str.charAt(i) - 48) * -1) < -8) ) {
                    return Integer.MIN_VALUE;
                }
            } else {
                int max_d_10 = Integer.MAX_VALUE / 10;
                if ( sum_unicode > max_d_10 || (sum_unicode == max_d_10 && (str.charAt(i) - 48) > 7) ) {
                    return Integer.MAX_VALUE;
                }
            }



            // 4. make as integer with simple math
            sum_unicode =  sum_unicode * 10 + (str.charAt(i) - 48);

            // 5. if next value is not integer 48~57 then exit!
            if (i < str.length()-1 && ((str.charAt(i+1) - 48) < 0 || (str.charAt(i+1) - 48) > 9)) {
                break;
            }
        }

        // calculate for negative here
        if (is_negative) {
            sum_unicode = sum_unicode * -1;
        }
        return sum_unicode;
    }

    public boolean is_not_num(char c){
        if(((c - 48) < 0 || (c - 48) > 9)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_num(char c){
        if(((c - 48) < 0 || (c - 48) > 9)) {
            return false;
        } else {
            return true;
        }
    }

}
