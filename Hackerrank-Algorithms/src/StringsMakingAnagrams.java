import java.util.*;
public class StringsMakingAnagrams {
    
    private static Map<Character, Integer> aHash = new HashMap<Character,Integer>();
    private static Map<Character, Integer> bHash = new HashMap<Character,Integer>();
    
    public static int numberNeeded(String first, String second) {
    	int ret = 0;
    	for(char c = 'a'; c <= 'z'; c++) {
    		int aCount = (aHash.containsKey(c)) ? aHash.get(c) : 0 ;
    		int bCount = (bHash.containsKey(c)) ? bHash.get(c) : 0 ;
    		ret += Math.abs(aCount-bCount);
    	}
    	return ret;
    }
    
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        
        for(int i=0; i<a.length(); i++) {
        	char ch = a.charAt(i);
        	if(aHash.containsKey(ch))
        		aHash.replace(ch, aHash.get(ch)+1);
        	else
        		aHash.put(ch, 1);
        }
        for(int i=0; i<b.length(); i++) {
        	char ch = b.charAt(i);
        	if(bHash.containsKey(ch))
        		bHash.replace(ch, bHash.get(ch)+1);
        	else
        		bHash.put(ch, 1);
        } in.close();
        System.out.println(numberNeeded(a, b));
    }
}
