
public class Recursion {
	
	
	/**
	 * Steven McGinnis
	 * stevenm1@muskingum.edu
	 * Recursive array element checks largest array by looking at the last element in the array and decreasing down through it.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursion re = new Recursion();
		int arr[] = {9, 6, 7, 13, 6, 21, 53, 14, 8, 30};
		int n = arr.length;
		System.out.println(re.go(arr, n));
	}

	
	public int go(int[] arr, int n) {
		//Base Case
		if(n==1) {
			return arr[0];
		}
		else {
			return Math.max(arr[n-1], go(arr, n-1));//Recursive Case Using Max math and a decresing call of go and the array
		}
	}
		 
}

