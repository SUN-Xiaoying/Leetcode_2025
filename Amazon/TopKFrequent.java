package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/*
 * https://leetcode.com/problems/top-k-frequent-words/description/
*/
public class TopKFrequent {

    /*
     * 7ms Beats 68.39%
    */
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int value=0;
        for(String str: words){
            // TODO: One line: map.getOrDefault(word, 0) + 1
            value = map.containsKey(str) ? map.get(str) + 1 : 1;
            map.put(str, value);
        }

        // Convert map entries to a list
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1, e2) -> {
            int valueComparison = e2.getValue().compareTo(e1.getValue()); // Compare by values in descending order
            if (valueComparison == 0) {
                return e1.getKey().compareTo(e2.getKey()); // If values are the same, compare keys alphabetically
            }
            return valueComparison;
        });

        for (int i = 0; i < Math.min(k, entryList.size()); i++) {
            result.add(entryList.get(i).getKey());
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        List<String> result = topKFrequent(words, 2);
        for(String str: result){
            System.out.println(str);
        }
    }
}
