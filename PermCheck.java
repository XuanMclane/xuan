// https://codility.com/programmers/task/perm_check/

public class PermCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,1,4}));
		System.out.println(solution(new int[] {1,2,3}));
		System.out.println(solution(new int[] {1,2,3,4}));
	}
	
	public static int solution(int[] A){
		int[] B = new int[A.length];
		for(int i =0; i<A.length; i++){
			int index = A[i]-1;
			if(index >= A.length){
				return 0;
			}
			int unique = B[index];
			if(unique>0){
				return 0;
			}
			B[index] = 1;
		}
		return 1;
	}

}
