https://codility.com/programmers/task/binary_gap/

class Solution {
    public int solution(int N) {
        String out = new String();
        out = Integer.toBinaryString(N);
        int len = out.length();
        int longest=0;
        int count=-1;
        for(int i=0;i<len;i++){
            char ch = out.charAt(i);
            if(ch=='1'){
              longest=longest>count?longest:count;
              count=0;
            }
            else{count++;}
        }
        return longest;
    }
}
