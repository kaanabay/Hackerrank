import java.util.*;


class Box {
    
	private int[] dims = new int[3];
	
    Box(int a, int b, int c) {
        dims[0] = a; dims[1] = b; dims[2] = c;
        Arrays.sort(dims);
    }
    
    public int getLowest() {
    	return dims[0];
    }
    
    public int getMiddle() {
    	return dims[1];
    }
    
    public int getHighest() {
    	return dims[2];
    }
    
    public int getSize() {
    	return dims[0]*dims[1]*dims[2];
    }

    
    
};

public class Boxes {
	
	
    public static void main(String[] args) {
    	final double modulo = (int) Math.pow(10,9) + 7;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Box[] allBoxes = new Box[n];
        int[] lowest = new int[n];
        int[] middle = new int[n];
        int[] highest = new int[n];
        for(int a0 = 0; a0 < n; a0++){
            int ai = in.nextInt();
            int bi = in.nextInt();
            int ci = in.nextInt();
            Box myBox = new Box(ai,bi,ci);
            lowest[a0] = myBox.getLowest();
            middle[a0] = myBox.getMiddle();
            highest[a0] = myBox.getHighest();
            allBoxes[a0] = myBox;
        } in.close();
        
        int maxl,maxm,maxh;
        long allVolumesSummed = 0;
        long count = 0;
        
        for(int i=0; i<n; i++) {
        	maxl = allBoxes[i].getLowest();
        	maxm = allBoxes[i].getMiddle();
        	maxh = allBoxes[i].getHighest();
        	allVolumesSummed += allBoxes[i].getSize();
        	count++;
        	for(int j=i+1; j<n; j++) {
        		int newl = allBoxes[j].getLowest();
        		int newm = allBoxes[j].getMiddle();
        		int newh = allBoxes[j].getHighest();
        		if(newl > maxl)
        			maxl = newl;
        		if(newm > maxm)
        			maxm = newm;
        		if(newh > maxh)
        			maxh = newh;
        		allVolumesSummed += maxl*maxm*maxh;
        		count++;
        	}
        }
        System.out.println((int)((double)allVolumesSummed / count) % modulo);
    }
}
