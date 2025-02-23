package Binary;

/*
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
*/
public class OneBitChar {

    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length<2){ return true; }
        int i=0;
        while(i<bits.length-1){
            i = bits[i] == 1 ? i+2 : i+1;
        }
        return i == bits.length-1;
    }

    /*
     * Wrong Answer 77 / 93 testcases passed
    */
    public static boolean isOneBitCharacter2(int[] bits) {
        int i=0;
        while(i<bits.length){
            i = bits[i] == 1 ? i+2 : i+1;
        }
        if(bits[i-1]==0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // int[] bits = {1,1,1,0};
        // System.out.println(isOneBitCharacter(bits));
        int[] bits2 = {1,1,0};
        System.out.println(isOneBitCharacter2(bits2));
    }
}
