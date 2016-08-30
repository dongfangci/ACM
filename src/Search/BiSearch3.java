package Search;
/*
 * 
 * 旋转数组的最小值
 * 1,2,3,4,5----> 3,4,5,1,2
 * /
 */
public class BiSearch3 {
	public static int biSearch(int[] a){
		if(a == null)
			throw new NullPointerException("Null");
		
		return biSearch(a,0,a.length-1);
}

	private static int biSearch(int[] a, int lo, int hi) {
		int mid =0;
		while( lo <= hi ){
			if(hi - lo == 1)
				break;
		 mid = (lo + hi)/2;
		 if(a[mid] > a[lo])
			 lo = mid;
		 else if(a[mid] < a[hi])
			 hi = mid;
		 
		}
	
		return a[hi];
	}
		
	public static void main(String[] args) {
		int[] a ={4,5,9,1,2,3};
		System.out.println(a);
		int res = biSearch(a);
		System.out.println(res);
		
	}
}
