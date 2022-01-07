package AMZN;

/*
1492. The kth Factor of n

You are given two positive integers n and k.
A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order,
return the kth factor in this list or return -1 if n has less than k factors.
 */
public class KthFactorOfN {
    // O(sqrt n) O(1)
    static int kthFactor(int n, int k) {
        for (int d = 1; d <= n / 2; ++d)
            if (n % d == 0 && --k == 0)
                return d;
        return k == 1 ? n : -1;
    }

    public static void main(String[] args) {

        // 3
        int n1 = 12;
        int k1 = 3;
        System.out.println(kthFactor(n1,k1));

        // 7
        int n2 = 7;
        int k2 = 2;
        System.out.println(kthFactor(n2,k2));

        // -1
        int n3 = 4;
        int k3 = 4;
        System.out.println(kthFactor(n3,k3));
    }
}
