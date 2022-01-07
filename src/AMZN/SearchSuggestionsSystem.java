package AMZN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
1268. Search Suggestions System

You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of
searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than
three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.
 */
public class SearchSuggestionsSystem {
    // O(n) O(n)

    static class Trie {
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
    static public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        Arrays.sort(products);
        for (String p : products) { // build Trie.
            Trie t = root;
            for (char c : p.toCharArray()) { // insert current product into Trie.
                if (t.sub[c - 'a'] == null)
                    t.sub[c - 'a'] = new Trie();
                t = t.sub[c - 'a'];
                if (t.suggestion.size() < 3) // maintain 3 lexicographically minimum strings.
                    t.suggestion.offer(p); // put products with same prefix into suggestion list.
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { // search product.
            if (root != null) // if current Trie is NOT null.
                root = root.sub[c - 'a'];
            ans.add(root == null ? List.of() : root.suggestion); // add it if there exist products with current prefix.
        }
        return ans;
    }

    public static void main(String[] args) {

        // [
        //["mobile","moneypot","monitor"],
        //["mobile","moneypot","monitor"],
        //["mouse","mousepad"],
        //["mouse","mousepad"],
        //["mouse","mousepad"]
        //]
        String[] products1 = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord1 = "mouse";
        System.out.println(suggestedProducts(products1, searchWord1));

        // [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        System.out.println(suggestedProducts(products2, searchWord2));

        // [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
        String[] products3 = {"bags","baggage","banner","box","cloths"};
        String searchWord3 = "bags";
        System.out.println(suggestedProducts(products3, searchWord3));

    }
}
