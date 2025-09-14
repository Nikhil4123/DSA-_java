import java.util.*;

public class PasswordCrack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        
        while (t-- > 0) {
            int n = scanner.nextInt(); 
            String a = scanner.next(); 
            String b = scanner.next(); 
            
            System.out.println(canCrackPassword(n, a, b) ? "YES" : "NO");
        }
        scanner.close();
    }

    public static boolean canCrackPassword(int n, String a, String b) {
        boolean hasBothBits = false; 
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '1' && !hasBothBits) {
                return false; 
            }
            if (b.charAt(i) == '1' && b.charAt(i) == '0') {
                hasBothBits = true; 
            }
        }
        return true;
    }
}