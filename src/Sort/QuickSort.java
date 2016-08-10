package Sort;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
	Random random = new Random();
	public void quickSort(int[] a){
		if(a == null)
			throw new NullPointerException("Null Pointer");
		quickSort(a, 0, a.length-1);
	}
	

	
	private void quickSort(int[] a, int lo, int hi){
		if(lo >= hi)
			return;
		int par = partition(a, lo, hi);
		quickSort(a, lo, par-1);
		quickSort(a, par+1, hi);
	}

	private int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int tmp = a[lo];
		while(true){
			while(a[++i] < tmp) if(i == hi) break;
			while(a[--j] > tmp) if(j == lo) break;
			if(i >= j)
				break;
			swap(a, i, j);
		}
		swap(a,lo,j);
		return j;
	}
	
	private int partition2(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int rm = random.nextInt(hi - lo) + lo;
		swap(a,lo,rm);
		int tmp = a[lo];
		//System.out.println(rm);
		while(true){
			while(a[++i] < tmp) if(i == hi) break;
			while(a[--j] > tmp) if(j == lo) break;
			if(i >= j)
				break;
			swap(a, i, j);
		}
		swap(a,lo,j);
		return j;
	}
	
	private int partition3(int[] a, int lo, int hi) {
		int i = lo;
		//int j = hi + 1;
		int tmp = a[lo];
		while(true){
			while(a[lo] < tmp){ 
				if(lo == hi) break;
				lo++;
			}
			while(a[hi] > tmp) {
				if(hi == lo) break;
				hi--;
				}
			if(lo >= hi)
				break;
			swap(a, lo, hi);
		}
		swap(a,i,hi);
		return hi;
	}
	
	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
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
		
		QuickSort q1 = new QuickSort();
		q1.quickSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
		
	}

}
