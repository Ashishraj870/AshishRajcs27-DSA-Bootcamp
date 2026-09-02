import java.util.*;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();

        // Step 1: Store allowed characters
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        // Step 2: Check each word
        for (String word : words) {
            boolean isValid = true;

            for (char ch : word.toCharArray()) {
                if (!set.contains(ch)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) count++;
        }

        return count;
    }
}