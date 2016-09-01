// https://codility.com/programmers/task/perm_missing_elem/


public class PermMissingElem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[]{2,1,3,5}));
	}
	
	public static int solution(int[] A){
		long n = A.length;
		long elem = (n+1) * (n+2) / 2;
		for(int i : A){
			elem -= i;
		}
		return (int)elem;
	}
}
