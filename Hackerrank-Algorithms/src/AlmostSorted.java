import java.util.*;

public class AlmostSorted {

	public static ArrayList<Integer> swappingMethod(ArrayList<Integer> nums) {
		ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(2, -1));
		int breakPoints = 0;
		int count = 0, i1 = -1, i2 = -1;
		int size = nums.size();
		for(int i=0; i<size-1; i++) {
			if(nums.get(i) > nums.get(i+1)) {
				breakPoints++;
				if(count == 0) { 
					i1 = i; i2 = i+1;
				}
				else if(count == 1) i2 = i+1;
				count++;
			}
		}
		
		//ret0 = -2 succeed, end main
		//ret0 = -1 fail, proceed with reverseMethod
		
		if(breakPoints == 0) {
			ret.set(0, -2);
		} else if(breakPoints == 1) {
			if(i1 == 0) {
				if (nums.get(0) < nums.get(2)) {
					ret.set(0, i1+1); ret.set(1, i2+1);
				}
			} else if(i2 == size-1) {
				if(nums.get(size-1) > nums.get(size-3)) {
					ret.set(0, i1+1); ret.set(1, i2+1);
				}
			} else {
				if(nums.get(i1-1) < nums.get(i2) &&
						nums.get(i1) < nums.get(i2+1)) {
					ret.set(0, i1+1); ret.set(1, i2+1);
				}
				
			}
		} else if(breakPoints == 2) {

			if(nums.get(i1) > nums.get(i2-1) &&
					nums.get(i2) < nums.get(i1+1) ) {
				ret.set(0, i1+1); ret.set(1, i2+1);
			}
		}
		
		return ret;
	}
	
	public static ArrayList<Integer> reversingMethod(ArrayList<Integer> nums) {
		ArrayList<Integer> ret = new ArrayList<Integer>(Collections.nCopies(2, -1));
		int size = nums.size();
		boolean decreased = false;
		boolean increasedForASecondTime = false;
		int i1 = -1, i2 = -1;
		
		for(int i=0; i<size-1; i++) {
			if(decreased && increasedForASecondTime) {
				if(nums.get(i+1) < nums.get(i)) {
					ret.set(0, -1);
					return ret;
				}
			} else if(decreased && !increasedForASecondTime) {
				if(nums.get(i+1) > nums.get(i)) {
					increasedForASecondTime = true;
				}
				i2 = i;
			} else if(!decreased && !increasedForASecondTime) {
				if(nums.get(i+1) < nums.get(i)) {
					decreased = true;
				}
				i1 = i;
			}
		}
		
		if(decreased && !increasedForASecondTime) {
			ret.set(0, i1+1); ret.set(1, i2+2);
		} else if(i1 == 0) {
			if(nums.get(i1) < nums.get(i2+1)) {
				ret.set(0, i1+1); ret.set(1, i2+1);
			}
		} else {
			if(nums.get(i1) < nums.get(i2+1) &&
					nums.get(i2) > nums.get(i1-1)) {
				ret.set(0, i1+1); ret.set(1, i2+1);
			}
		}
		
		
		return ret;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++) {
        	int push = in.nextInt();
        	numbers.add(push);
        } in.close();
        
        //DEAL WITH THE CONDITION WHERE N IS 2
        if(n == 2) {
    		System.out.println("yes");
        	if(numbers.get(0) > numbers.get(1))
        		System.out.println("swap 1 2");
        	return;
        }
        
        ArrayList<Integer> resultList = swappingMethod(numbers);
                
        if(resultList.get(0) == -2) {
        	System.out.println("yes");
        	return;
        } else if(resultList.get(0) == -1) {

        	resultList = reversingMethod(numbers);
        	if(resultList.get(0) == -1) {
        		System.out.println("no");
        		return;
        	}
        	
        	System.out.println("yes");
        	System.out.println("reverse " + resultList.get(0) + " " + resultList.get(1));
        	
        	
        } else {
        	System.out.println("yes");
        	System.out.println("swap " + resultList.get(0) + " " + resultList.get(1));
        }
        
    }
}