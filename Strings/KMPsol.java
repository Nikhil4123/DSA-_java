import java.util.ArrayList;

class KMPsol {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();

        if (M == 0 || M > N) return result; // Edge case: empty pattern or larger pattern than text

        int[] lps = new int[M];
        computeLpsArray(pat, M, lps);

        int i = 0, j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                result.add(i - j + 1); // Store 1-based index
                j = lps[j - 1]; // Use LPS array to skip redundant comparisons
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Move j back using LPS
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    void computeLpsArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Move len back
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        KMPsol sol = new KMPsol();
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        ArrayList<Integer> result = sol.search(pat, txt);
        System.out.println(result); // Output: [11]
    }
}
