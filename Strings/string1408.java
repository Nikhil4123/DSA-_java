import java.util.ArrayList;
import java.util.List;

public class string1408 {
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        Solution solution = new Solution();
        List<String> result = solution.stringMatching(words);
        
        System.out.println("Substrings found: " + result);
    }
}

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if i is not equal to j and words[i] is a substring of words[j]
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
