package Recurtest;
/*计算 C（n）= 2 * ( c(0) + c(1) + ... + c(n-1) ) / n + n;
 * 采用递归和动态规划的方法进行
 */
public class Recurtest1 {

	public float funcRec(int n){	//第一种递归解法
		if(n == 0)
			return 1;
		
		float sum = 0;
		for(int i = 0; i < n; i++){
			sum += funcRec(i);
		}
		return 2 * sum / n + n;
	}
	
	public float funcRec2(int n){	//递归解法
		if(n == 0)
			return 1;
		else{
		float sum = 0;
		for(int i = 0; i < n; i++){
			sum += funcRec2(i);
		}
		return 2 * sum / n + n;
		}
	}
	
	public float funcDynamic (int n){	//动态规划O(n^2)时间复杂度
		float[] c = new float[n+1];
		c[0] = 1;
		for(int i =1; i <= n; i++){
			float sum = 0;
			for(int j = 0; j < i; j++)
				sum += c[j];
			c[i] = 2 * sum / i + i;
		}
		
		return c[n];
	}
	
	public float funcDynamic2 (int n){	//动态规划O(n)时间复杂度
		float[] c = new float[n+1];
		float[] sum = new float[n+1];
		c[0] = 1;
		sum[0] = 0;
		for(int i =1; i <= n; i++){
			sum[i] = sum[i-1] + c[i-1];
			c[i] = 2 * sum[i] / i + i;
		}
		
		return c[n];
	}
	public static void main(String[] args) {
		Recurtest1 r1 = new Recurtest1();
		System.out.println(r1.funcRec(8));
		System.out.println(r1.funcRec2(8));
		System.out.println(r1.funcDynamic(8));
		System.out.println(r1.funcDynamic2(8));
	}
}
