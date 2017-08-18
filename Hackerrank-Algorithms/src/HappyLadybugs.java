import java.util.*;

public class HappyLadybugs {

	private static String checkAdjacency(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i=0; i<s.length()-1; i++) {
			if(s.charAt(i+1) != s.charAt(i)) {
				if(hm.containsKey(s.charAt(i+1)))
					return "NO";
				hm.put(s.charAt(i), 1);
			}
		}
		return "YES";
	}
	
	private static String makeHash(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch)+1);
			} else {
				hm.put(ch, 1);
			}
		}
		
		
		
		for(Map.Entry<Character, Integer> m: hm.entrySet()) {
			if(m.getValue() == 1 && m.getKey() != '_')
				return "NO";
		}
		
		if(!hm.containsKey('_')) {
			return checkAdjacency(s);
		}
		
		return "YES";
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            in.nextInt();
            String b = in.next();
            System.out.println(makeHash(b));
        } in.close();
    }
}
