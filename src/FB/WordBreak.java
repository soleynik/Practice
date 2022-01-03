package FB;

import java.util.*;
/*
        139. Word Break

        Given a string s and a dictionary of strings wordDict, return true if s can be segmented
        into a space-separated sequence of one or more dictionary words.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {

    //DP O(n^3) O(n)
    static boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // Trie O(n^2) O(n)
    // NOT WORKING
    static class TrieNode{
        TrieNode[] links;
        boolean isWord;
        public TrieNode(){
            links = new TrieNode[26];
            isWord = false;
        }
    }

    static void insert(String word, TrieNode node){
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(node.links[ch] == null)
                node.links[ch] = new TrieNode();
            node = node.links[ch];
        }
        node.isWord = true;
    }
    static boolean wordBreakTrie(String s, List<String> wordDict){
        TrieNode node = new TrieNode();
        TrieNode current;
        for(String i:wordDict)
            insert(i, node);
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = len - 1; i >= 0; i--){
            current = node;
            for(int j = i; j < len; j++){
                current = current.links[charArray[j] - 'a'];
                if(current != null && current.isWord && dp[j+1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        //true
        String s1 = "leetcode";
        List<String> l1 = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s1, l1));
        System.out.println(wordBreakTrie(s1, l1));
        //true
        String s2 = "applepenapple";
        List<String> l2 = new ArrayList<>(Arrays.asList("apple","pen"));
        System.out.println(wordBreak(s2, l2));

        //false
        String s3 = "catsandog";
        List<String> l3 = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(wordBreak(s3, l3));
    }
}
