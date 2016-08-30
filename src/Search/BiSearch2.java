package Search;
/*
 * 数组先降序排列后升序排列，找最小值
 * 利用二分查找
 * 
 * /
 */
import java.util.Arrays;

public class BiSearch2 {
	public static int biSearch(int[] a){
		if(a == null)
			throw new NullPointerException("Null");
		
		return biSearch(a,0,a.length-1);
}

	private static int biSearch(int[] a, int lo, int hi) {
		int mid =0;
		while( lo <= hi ){
			 mid = (lo + hi)/2;
			if(a[mid] < a[mid + 1] && a[mid-1] < a[mid])
				hi = mid-1 ;
			else if(a[mid-1] > a[mid] && a[mid] > a[mid+1])
				lo = mid+1 ;
			else
				break;
		}
	
		return a[mid];
	}
	
	public static void main(String[] args) {
		int[] a ={15,8,5,3,69};
		System.out.println(a);
		int res = biSearch(a);
		System.out.println(res);
		
	}
}