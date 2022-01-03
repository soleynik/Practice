package FB;

import java.util.*;

/*
        140. Word Break II

        Given a string s and a dictionary of strings wordDict, add spaces in s to construct a
        sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreakII {

        static Map<String, List<String>> map = new HashMap<>();

        public static List<String> wordBreakII(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }
            if (map.containsKey(s)) {
                return map.get(s);
            }
            if (wordDict.contains(s)) {
                res.add(s);
            }
            for (int i = 1; i < s.length(); i++) {
                String t = s.substring(i);
                if (wordDict.contains(t)) {
                    List<String> temp = wordBreakII(s.substring(0, i), wordDict);
                    if (temp.size() != 0) {
                        for(String value : temp) {
                            res.add(value + " " + t);
                        }
                    }
                }
            }
            map.put(s, res);
            return res;
        }

        public static void main(String[] args) {
            // Output: ["cats and dog","cat sand dog"]
            String s1 = "catsanddog";
            List<String> l1 = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
            System.out.println(wordBreakII(s1, l1));

            // Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
            String s2 = "pineapplepenapple";
            List<String> l2 = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
            System.out.println(wordBreakII(s2, l2));

            // Output: []
            String s3 = "catsandog";
            List<String> l3 = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
            System.out.println(wordBreakII(s3, l3));
        }
}
