package Search;

import java.util.Arrays;

import Sort.QuickSort;

public class BiSearch {

	public int biSearch(int[] a,int key){
		if(a == null)
			throw new NullPointerException("Null");
		Arrays.sort(a);
		return biSearch2(a,key,0,a.length-1);
	}

	private int biSearch(int[] a, int key, int lo, int hi) {
		if(lo > hi)
			return -1;
		int mid = (lo + hi)/2;
		if(key < a[mid])
			return biSearch(a,key,lo,mid-1);
		else if(key > a[mid])
			return biSearch(a,key,mid+1,hi);
		else
			return mid;
		
	}
	
	
	private int biSearch2(int[] a, int key, int lo, int hi) {
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if(key < a[mid])
				hi = mid;
			else if(key > a[mid])
				lo = mid;
			else 
				return mid;
			
		}
		return -1;
		
	}

	
	public static void main(String[] args) {
		int[] a = new int[15];
		//int[] a = null;
		for(int i = 0; i < a.length; i++){
			a[i] =(int) (Math.random()*10);
		}
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
		
		BiSearch b1 = new BiSearch();
		int plot = b1.biSearch(a, 3);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
		System.out.println(plot);
		
	}
}
