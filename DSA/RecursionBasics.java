import java.util.Scanner;

public class RecursionBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        print(1,n);
    }
    public static void print(int s , int e){
        if(s>e) return ;
        System.out.println(s);
        print(s+1,e);

    }
}