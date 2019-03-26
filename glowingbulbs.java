import java.util.*;
 
public class glowingbulbs {
 
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		long t = s.nextLong();
 
		while (t-- > 0) {
			s.nextLine();
			String input = s.nextLine();
 
			long k = s.nextLong();
			System.out.println(Sol(k, input));
		}
		s.close();
	}
 
	public static long Sol(long k, String input) {
		ArrayList<Integer> sw = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '1') {
				sw.add(i + 1);
			}
		}
		long res = 0;
		long low = 1;
		long high = 1000000000000000L;
		long mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (getMultiples(mid, sw) >= k) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}
 
	public static long getMultiples(long x, ArrayList<Integer> sw) {
		long ans = 0;
		for (long i = 1; i < (1 << sw.size()); i++) {
			long p = 1;
			long sign = -1;
			for (int j = 0; j < sw.size(); j++) {
				if (((i >> j) & 1) == 1) {
					p = p * sw.get(j);
					sign = sign * -1;
				}
			}
			ans = ans + (x / p) * sign;
		}
		return ans;
	}
}
