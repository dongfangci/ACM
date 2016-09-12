package Recurtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permate {
    private ArrayList<String> list = new ArrayList<String>();
    
    public ArrayList<String> Permutation(String str) {
        
       if( str == null )
           return list;
        if(str.length() == 0)
            return list;
        permutation(str.toCharArray(),0);
        Collections.sort(list);
        return list;
        
    }

	private void permutation(char[] a, int begin) {
		if(begin == a.length-1){
			list.add(new String(a));
			return;
		}
		
		for(int i = begin; i < a.length; i++){
			if(i != begin && a[i] == a[begin])
			//if(a[i] == a[begin])
				continue;
			
			swap(a,i,begin);
			permutation(a,begin+1);
			swap(a,i,begin);
		}
	}

	private void swap(char[] a, int i, int j) {
		if(i != j){
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Permate pm = new Permate();
		String s = "123";
		List<String> l = new ArrayList<String>();
		l = pm.Permutation(s);
		System.out.println(l);
	}
}
