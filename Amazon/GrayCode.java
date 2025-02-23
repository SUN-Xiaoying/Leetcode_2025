package Amazon;

import java.util.ArrayList;
import java.util.List;


/*
 * Input: n = 2
    Output: [0,1,3,2]
    Explanation:
    The binary representation of [0,1,3,2] is [00,01,11,10].
    - 00 and 01 differ by one bit
    - 01 and 11 differ by one bit
    - 11 and 10 differ by one bit
    - 10 and 00 differ by one bit
    [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
    - 00 and 10 differ by one bit
    - 10 and 11 differ by one bit
    - 11 and 01 differ by one bit
    - 01 and 00 differ by one bit
*/

public class GrayCode {

    // Binary calcuation
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int total = 1 << n; // Total numbers in the Gray code sequence: 2^n

        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1)); // Compute Gray code for each number
        }

        return result;
    }

    /*
     * 40ms Beats 5.98%, I'm proud
    */
    public static List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        List<String> strs = new ArrayList<>();
        strs.add("0");
        strs.add("1");
        while(i<n-1){
            strs = recursion(strs);
            i++;
        }
        for(String str: strs){
            result.add(Integer.parseInt(str, 2));
        }
        return result;
    }

    public static List<String> recursion(List<String> strs){
        List<String> result = new ArrayList<>();
        for (String str: strs) {
            result.add("0" + str);
        }
        for(int i=strs.size()-1; i>=0; i--){
            result.add("1" + strs.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        grayCode2(2);
    }
}
