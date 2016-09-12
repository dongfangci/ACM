package LeetCode;
/*
 *求一个数组里第二大的数 
 * 这里假设数组数没有重复
 * */
public class TopK {
	public int secondMax(int[] a){
		if(a == null)
			throw new NullPointerException("null");
		if(a.length < 2)
			throw new NullPointerException("InvalidInput");
		int max,second;
		if(a[0] < a[1]){
			max = a[1];
			second = a[0];
		}
		else{
			max = a[0];
			second = a[1];
		}
		
		for(int i = 2; i < a.length; i++){
			if(a[i] > max){
				second = max;
				max = a[i];
			}
			else if(a[i] > second){
				second = a[i];
			}
		}
		
		return second;
	}
}
