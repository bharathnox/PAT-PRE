// Convert n to 1 in minimum steps, using only these operations:

// Divide by any factor of n (except n itself).
// Subtract 1 (n - 1).

import java.util.Scanner;

public class ConvertToOne {
    public static int minSteps(int n, int count) {
        if (n == 1) return count; // Base case
        
        int minSteps = minSteps(n - 1, count + 1); // Try subtracting 1
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                minSteps = Math.min(minSteps, minSteps(n / i, count + 1));
                minSteps = Math.min(minSteps, minSteps(n / (n / i), count + 1));
            }
        }
        
        return minSteps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        
        System.out.println("Minimum steps: " + minSteps(n, 0));
    }
}
