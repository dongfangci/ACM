package String;

import java.awt.image.ReplicateScaleFilter;

public class StringTest {
	public String replaceWithSpace(String s){
		if(s == null)
			return null;
		if(s == "")
			return "";
		int n = s.length();
		int cnt = 0;
		
		for(int i = 0; i < n; i++){
			if(s.charAt(i) == ' ')
				cnt++;
		}
		
		int nl = n + cnt*2;
		char[] c = new char[nl];
		int j = 0;
		for(int i = 0; i < n; i++){
			if(s.charAt(i) != ' '){
				c[j] = s.charAt(i);
				j++;
			}
			else{
				c[j++] = '%';
				c[j++] = '2';
				c[j++] = '0';
				
			}
		}
		
		return new String(c);
	}
	
	public static void main(String[] args) {
		StringTest t = new StringTest();
		String s1 = "abc  fr gt";
//		for(int i = 0; i < s1.length(); i++)
//			System.out.println(s1.charAt(i));
//		System.out.println(s1.length());
		String ns1 = t.replaceWithSpace(s1);
		System.out.println(ns1);
	}
}
