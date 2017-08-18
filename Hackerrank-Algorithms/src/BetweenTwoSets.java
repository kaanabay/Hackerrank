import java.util.*;

public class BetweenTwoSets {

	
	static int gcd(int a, int b) {
		if(a == 0)
			return b;
		return gcd(b%a, a);
	}
	
	static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
	static int gcdOfArray(int[] a) {
		int ret = a[0];
		for(int i=1; i<a.length; i++) {
			ret = gcd(ret, a[i]);
		}
		return ret;
	}
	
	static int lcmOfArray(int[] b) {
		int ret = b[0];
		for(int i=0; i<b.length; i++) {
			ret = lcm(ret,b[i]);
		}
		return ret;
	}
	
	static boolean allElementsEvenlyDivide(int[] a, int x) {
		for(int i=0; i<a.length; i++) {
			if(x % a[i] != 0)
				return false;
		}
		return true;
	}
	
	static boolean allElementsAreDividedEvenly(int[] b, int x) {
		for(int i=0; i<b.length; i++) {
			if(b[i] % x != 0)
				return false;
		}
		return true;
	}
	
    static int getTotalX(int[] a, int[] b) {
        int lcmOfA = lcmOfArray(a);
        int gcdOfB = gcdOfArray(b);
        int count = 0;
        for(int i=lcmOfA; i<=gcdOfB; i+=lcmOfA) {
        	if (allElementsEvenlyDivide(a, i) && allElementsAreDividedEvenly(b, i))
        		count++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
