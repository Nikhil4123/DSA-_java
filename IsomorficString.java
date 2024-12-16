import java.util.HashMap;
import java.util.Map;


class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        // Create two hash maps to store character mappings from s -> t and t -> s
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        // Iterate through each character in the strings
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Check if there's already a mapping in s -> t
            if (mapS.containsKey(charS)) {
                // If the mapping doesn't match the current character in t, return false
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                // Add new mapping from charS to charT
                mapS.put(charS, charT);
            }
            
            // Check if there's already a mapping in t -> s
            if (mapT.containsKey(charT)) {
                // If the mapping doesn't match the current character in s, return false
                if (mapT.get(charT) != charS) {
                    return false;
                }
            } else {
                // Add new mapping from charT to charS
                mapT.put(charT, charS);
            }
        }
        
        // If we complete the loop without mismatches, the strings are isomorphic
        return true;
    }

    public static void main(String[] args) {
        solution  solution= new solution();

        // Test case 1: "egg" and "add" -> should return true
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Are \"" + s1 + "\" and \"" + t1 + "\" isomorphic? " + solution.isIsomorphic(s1, t1));

        // Test case 2: "foo" and "bar" -> should return false
        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Are \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + solution.isIsomorphic(s2, t2));

        // Test case 3: "paper" and "title" -> should return true
        String s3 = "paper";
        String t3 = "title";
        System.out.println("Are \"" + s3 + "\" and \"" + t3 + "\" isomorphic? " + solution.isIsomorphic(s3, t3));

        // Test case 4: "ab" and "aa" -> should return false
        String s4 = "ab";
        String t4 = "aa";
        System.out.println("Are \"" + s4 + "\" and \"" + t4 + "\" isomorphic? " + solution.isIsomorphic(s4, t4));
    }
}
