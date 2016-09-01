// https://codility.com/programmers/task/tape_equilibrium/


public class TapeEquilibrium {
	public static void main(String[] args){
		System.out.println(solution(new int[]{-1000,1000}));
		System.out.println(solution(new int[]{3,1,2,4,3}));
	}
	
	public static int solution(int[] A){
		if(A.length <= 1){
			return 0;
		}
		int min = 0;
		int sum_left = 0;
		int sum_right = 0;
		for(int i = 0; i < A.length; i++){
			sum_right += A[i];
		}
		min = Math.abs(sum_right-2*A[0]);
		for(int i = 0; i < A.length-1; i++){
			sum_left += A[i];
			sum_right -= A[i];
			min = min<Math.abs(sum_left - sum_right)?min:Math.abs(sum_left - sum_right);
		}
		return min;
	}
}
