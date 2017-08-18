import java.util.*;

public class TimeConversion {

    static String timeConversion(String s) {
        if(s.equals("12:00:00AM"))
        	return "00:00:00";
        else if(s.equals("12:00:00PM"))
        	return "12:00:00";
        
        int h = Integer.parseInt(s.substring(0, 2));
        String remaining = s.substring(2, 8);
        String ampm = s.substring(8, 10);
        
        if(ampm.equals("AM")) {
        	if(h == 12) {
        		h = 0;
        	} else {
        		
        	}
        } else {
        	if(h == 12) {
        		
        	} else {
        		h += 12;
        	}
        }
        
        String reth = Integer.toString(h);
        if(reth.length() == 1)
        	reth = "0" + reth;
        
        return reth + remaining;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
        in.close();
    }
}
