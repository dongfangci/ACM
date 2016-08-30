package String;

public class StringAnswer {
}


/**
 * 344. Reverse String
 * 
 * Write a function that takes a string as input and returns the string reversed.

	Example:
	Given s = "hello", return "olleh".

 * 
 * /
 */
 class Solution {
 //1
    public String reverseString(String s) {
        return  new StringBuilder(s).reverse().toString();
    }

 //2
 public String reverseString2(String s) {
     char[] c = s.toCharArray();
     for (int i=0,j=c.length-1;i<j;i++,j--){
         char temp = c[i];
         c[i]=c[j];
         c[j]=temp;
     }
     return new String(c);
 }
 }