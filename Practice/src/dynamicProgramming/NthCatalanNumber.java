package dynamicProgramming;

//import java.math.BigInteger;

/*
 * Given n find the nth Catalan Number.
 * 
 * https://www.geeksforgeeks.org/program-nth-catalan-number/
 */
public class NthCatalanNumber {
	// Recursive
	int solve(int n) {
		int res = 0;
		if (n <= 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			res += solve(i) * solve(n - i - 1);
		}
		return res;
	}
	// DP solution
	int solveDP(int n) {
		int[] catalan = new int[n+2];
		catalan[0] = 1;
		catalan[1] = 1;
		for(int i=2;i<=n;i++) {
			catalan[i] = 0;
			for(int j=0;j<i;j++) catalan[i] += catalan[j]*catalan[i-j-1];
		}
		return catalan[n];
	}
	
	/* Using Binomial Permutation - (2*N)!/ ((N! * N!)* (n+1))
	BigInteger solveBigInt(int n) {
		BigInteger b = new BigInteger("1");
		// calculating n!
		for (int i = 1; i <= n; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}
		// calculating n! * n!
		b = b.multiply(b);
		BigInteger d = new BigInteger("1");
		// calculating (2n)!
		for (int i = 1; i <= 2 * n; i++) {
			d = d.multiply(BigInteger.valueOf(i));
		}
		// calculating (2n)! / (n! * n!)
		BigInteger ans = d.divide(b);
		// calculating (2n)! / ((n! * n!) * (n+1))
		ans = ans.divide(BigInteger.valueOf(n + 1));
		return ans;
	}*/
}
