// https://codility.com/programmers/task/frog_jmp/


public class FrogJmp {
	public static void main(String[] args){
		System.out.println(solution(10,85,30));
	}
	
	public static int solution(int X, int Y, int D){
		int K = Y - X - D;
		int N = 0;
		if(X >= Y){
			N = 0;
		}
		else{
			if(K<0){
				N = 1;
			}
			else{
				if(K%D == 0){
					N = K/D + 1;
				}else{
					N = K/D + 2;
				}
			}
		}
		return N;
	}
}
