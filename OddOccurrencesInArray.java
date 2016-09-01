// https://codility.com/programmers/task/odd_occurrences_in_array/


public class OddOccurrencesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
	}
	public static int solution(int[] A){
		int un = 0;
		for(int i = 0; i<A.length; i++){
			un ^= A[i];
		}
		return un;
	}
}
