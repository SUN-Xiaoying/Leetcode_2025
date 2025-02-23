package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * https://leetcode.com/problems/word-break/
*/
public class WordBreak {

    // public static boolean wordBreak_dp(String s, List<String> wordDict) {

    // }

    /*
     * 4ms Beats 72.20%
    */
    public static boolean wordBreak_cache(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len]=true;

        for(int i=len-1; i>=0; i--){
            dp[i]=false;
            for(String word: wordDict){
                if(dp[i]){
                    break;
                }
                if(i+word.length()<=len && s.substring(i, i+word.length()).equals(word)){
                    dp[i] = dp[i+word.length()];
                }
            }
        }

        return dp[0];
    }

    /*
     * Time Limit Exceeded 35 / 47 testcases passed
     * Need to improve dynamic programming
    */
    public static boolean wordBreak_decisionTree(String s, List<String> wordDict) {
        for(String str: wordDict){
            if(s.startsWith(str)){
                if(s.length()==str.length() || wordBreak_decisionTree(s.substring(str.length()), wordDict)){
                    return true;
                }
            }  
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        String s1 = "applepenapple";
        List<String> wordDict1 = new ArrayList<>(Arrays.asList("apple","pen"));
        System.out.println(wordBreak_cache(s1, wordDict1));
    }
}
