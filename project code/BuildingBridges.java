

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//GFG
//Problem link-https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
//Consider a 2-D map with a horizontal river passing through its center. There are
//n cities on the southern bank with x-coordinates a(1) � a(n) and n cities on the 
//northern bank with x-coordinates b(1) � b(n). You want to connect as many north-south 
//pairs of cities as possible with bridges such that no two bridges cross. When connecting 
//cities, you can only connect city a(i) on the northern bank to city b(i) on the southern
//bank. Maximum number of bridges that can be built to connect north-south pairs with 
//the aforementioned constraints.
//
//The values in the upper bank can be considered as the northern x-coordinates of
//the cities and the values in the bottom bank can be considered as the corresponding
//southern x-coordinates of the cities to which the northern x-coordinate city can be connected.
//
//Examples: 
// 
//
//Input : 6 4 2 1
//        2 3 6 5
//Output : Maximum number of bridges = 2
//Explanation: Let the north-south x-coordinates
//be written in increasing order.
//
//1  2  3  4  5  6
//  \  \
//   \  \        For the north-south pairs
//    \  \       (2, 6) and (1, 5)
//     \  \      the bridges can be built.
//      \  \     We can consider other pairs also,
//       \  \    but then only one bridge can be built 
//        \  \   because more than one bridge built will
//         \  \  then cross each other.
//          \  \
//1  2  3  4  5  6 
//
//Input : 8 1 4 3 5 2 6 7 
//        1 2 3 4 5 6 7 8
//Output : Maximum number of bridges = 5


//Algorithm
//1. Sort the points with respect to south co-ordinates
//2. Find the longest non-decreasing subsequence of norht co-ordinates
//3. Length of LIS is the maximum number of bridges that can be built

public class BuildingBridges {

	static class Endpoints implements Comparator<Endpoints>{
		
		int np;
		int sp;
		
		

		public Endpoints(int np, int sp) {
			super();
			this.np = np;
			this.sp = sp;
		}



		public Endpoints() {
			super();
		}



		@Override
		public int compare(Endpoints o1, Endpoints o2) {
			// TODO Auto-generated method stub
			if(o1.sp<o2.sp) return -1;
			else if(o1.sp>o2.sp) return 1;
			else return o1.np-o2.np;
		}
		
	}
	private static int numberOfBrides(int [] [] arr) {
		
		List<Endpoints> li= new ArrayList<BuildingBridges.Endpoints>();
		for(int i=0;i<arr[0].length;i++) {
			li.add(new Endpoints(arr[0][i], arr[1][i]));
		}
		
		Collections.sort(li, new Endpoints());
		
		int [] lis= new int[arr[0].length];
		lis[0]=1;
		
		int max=1;  
		for(int i=1;i<arr[0].length;i++) {
			lis[i]=1;
			for(int j=0;j<i;j++) {
				if(li.get(i).np>=li.get(j).np && lis[i]<=lis[j]) {
					lis[i]=lis[j]+1;
					max=Math.max(max, lis[i]);
				}
			}
		}
		return max;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] arr= {{0,2,1,1 },{1,4,4,3 }};
		System.out.println(numberOfBrides(arr));
	}

}