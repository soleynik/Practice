package AMZN;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
937. Reorder Data in Log Files

You are given an array of logs. Each log is a space-delimited string of words, where the first
word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same,
then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.
 */
public class ReorderDataInLogFiles {
    // O(m*n*logn) O(mlogn)
    static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {

        // ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
        String[] logs1 = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.stream(reorderLogFiles(logs1)).collect(Collectors.toList()));

        // ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
        String[] logs2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(Arrays.stream(reorderLogFiles(logs2)).collect(Collectors.toList()));
    }
}
