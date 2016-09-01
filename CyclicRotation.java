// https://codility.com/programmers/task/cyclic_rotation/

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = solution(new int[] {3,8,9,7,6}, 3);
		System.out.println(Arrays.toString(arr));

	}
	
	public static int[] solution(int[] A, int K){
		if(A.length <= 1){
			return A;
		}
		int[] arr=new int[A.length];
		K = K % A.length;
		System.arraycopy(A, 0, arr, K, A.length - K);
		System.arraycopy(A, A.length - K, arr, 0, K);
		return arr;
	}

}
