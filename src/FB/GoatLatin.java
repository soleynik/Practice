package FB;
/*
824. Goat Latin

You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:

If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    // O(n^2) O(n)
    static String toGoatLatin(String sentence) {
        if(sentence == null || sentence.length() == 0)
            return "";
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u', 'A', 'E','I','O','U'));
        StringBuilder sb = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");
        for(String s:sentence.split(" ")){
            if(sb.length() != 0)
                sb.append(" ");
            char ch = s.charAt(0);
            if(vowels.contains(ch))
                sb.append(s);
            else{
                sb.append(s.substring(1));
                sb.append(ch);
            }
            sb.append("ma").append(suffix);
            suffix.append("a");

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        String sentence1 = "I speak Goat Latin";
        System.out.println(toGoatLatin(sentence1));


        // Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
        String sentence2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(sentence2));

    }
}
