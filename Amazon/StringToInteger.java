package Amazon;
/* Input: s = "1337c0d3"
// Output: 1337

// Explanation:
// Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
*/

import java.util.List;

class StringToInteger {

    /* Mine
     * 2ms Beats 29.88%
     */ 
    public static int myAtoi(String s) {
        /*
         * Early Return
        */
        int len = s.length();
        if(len<1){return 0;}
        char[] chs = s.toCharArray();
        int i = 0;
        int result = 0;
        boolean flag = true;
        while(i<len && chs[i]==' '){ i++; }

        /*
         * use a multiplier (1 for positive, -1 for negative). 
         * This avoids repetitive conditional checks during return
        */
        if(i<len && (chs[i]=='-' || chs[i]=='+')){ flag = (chs[i++] == '+');}

        while(i<len && Character.isDigit(chs[i])){
            /*
             * Character.getNumericValue(chs[i]) is slower because it involves multiple checks and conversions. 
             * Instead, directly subtract '0' from chs[i]
            */
            int digit = Character.getNumericValue(chs[i++]);
            if(result > (Integer.MAX_VALUE - digit) / 10){
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result*10 + digit;
        }
        return flag ? result : -result;
    }

    public static int myAtoi2(String s) {
                /*
         * 1. Early Return
        */
        if(s.isEmpty() || s.length()<1){return 0;}
        int len = s.length();
        char[] chs = s.toCharArray();
        int i = 0;
        int result = 0;
        int flag = 1;
        while(i<len && chs[i]==' '){ i++; }

        /*
         * 2. use a multiplier (1 for positive, -1 for negative). 
         * This avoids repetitive conditional checks during return
        */
        if(i<len && (chs[i]=='-' || chs[i]=='+')){ flag = (chs[i++] == '-') ? -1 : 1;}

        int threshold = Integer.MAX_VALUE / 10;
        while(i<len && Character.isDigit(chs[i])){
            /*
             * 3. Character.getNumericValue(chs[i]) is slower because it involves multiple checks and conversions. 
             * Instead, directly subtract '0' from chs[i]
            */
            int digit = chs[i++] - '0';
            /*
             * 4. Precompute the safe threshold for overflow checks and 
             * eliminate division operations inside the loop.
            */
            if (result > threshold || (result == threshold && digit > 7)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result*10 + digit;
        }
        return flag * result;
    }
    
    public static void main(String[] args) {
        String s = "    -042";
        int result = myAtoi(s);

        System.out.println(result);

    }
}