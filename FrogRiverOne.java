// https://codility.com/programmers/task/frog_river_one/

import java.util.*;
public class FrogRiverOne {
	public static void main(String[] args){
		System.out.println(solution(5,new int[]{1,3,1,4,2,3,5,4}));
	}
	
	public static int solution(int X, int[] A){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<A.length;i++){
			set.add(A[i]);
			if(set.size()==X){return i;}
		}
		return -1;
	}
}
