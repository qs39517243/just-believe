package cycle;

/**
 * @author liquanshuzero
 *
 * first git hub program
 * about cycle, simple recursion and time complexity
 *
 * 2018年5月31日
 */

public class Cycle {
	
	//time complexity:O(N)
	//return 1+2+……+number
	public static int doFor1(int number) {
		int temp = 0;
		for (int i=0; i<=number; i++) {
			temp += i;
		}
		return temp;
	}
	
	//time complexity:O(N²)
	//for+for return 1+(1+2)+(1+2+3)+……+(1+2+3+……+number)
	public static int doFor2(int number) {
		int temp = 0;
		
		for (int i=0; i<=number; i++) {
			for (int j=0; j<=i; j++) {
				temp += j;
			}
		}
		return temp;
	}
	
	//
	//recursion return 1+2+3+……+number-1
	public static int recursion(int number) {
		if (number == 0) {
			return 0;
		}else if (number == 1) {
			return 1;
		}else
			return number += recursion(number-1);
	}
	
	public static void main(String[] args) {
		int num = 3;
		System.out.println(doFor1(num));
		System.out.println(doFor2(num));
		System.out.println(recursion(num));
	}
}
