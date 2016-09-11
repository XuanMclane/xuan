//https://codility.com/programmers/task/missing_integer/

import java.util.Arrays;
public class MissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[]{2,2,3,4,4,6}));
	}
	
	public static int solution(int[] A){
		Arrays.sort(A);
		int minimum = 1;
		for(int value: A){
			if(value == minimum){
				minimum++;
			}
		}
		return minimum;
	}

}
