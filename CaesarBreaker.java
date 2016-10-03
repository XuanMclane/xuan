
public class CaesarBreaker {
	
	public static void main(String[] args){
		CaesarBreaker cb = new CaesarBreaker();
		System.out.println(cb.halfOfString("Qbkm Zgis", 0));
		System.out.println(cb.halfOfString("Qbkm Zgis", 1));
	}
	
	public String halfOfString(String message, int start){
		StringBuilder out = new StringBuilder();
		for(int i = start; i<message.length(); i+=2){
			char ch = message.charAt(i);
			out.append(ch);
		}
		return out.toString();
	}
	
	public int[] countLetters(String input){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] counts = new int[26];
		for(int i =0 ; i<input.length();i++){
			char letter = input.charAt(i);
			letter = Character.toUpperCase(letter);
			int k = indexOf(alphabet, letter);
			counts[k] +=1;
		}
		return counts;
	}
	
	public int indexOf(String list, char letter){
		for(int i =0; i< list.length(); i++){
			if(list.charAt(i)==letter){
				return i;
			}
		}
		return -1;
	}
	
	public int maxIndex(int[] counts){
		int maxLetter = counts[0];
		int max = 0;
		for(int i = 0 ;i<counts.length;i++){
			if(maxLetter<counts[i]){
				maxLetter = counts[i];
				max = i;
			}
		}
		return max;
	}
	
	public int getKey(String s){
		int[] counts = countLetters(s);
		int max = maxIndex(counts);
		int key = 30 - max;
		return key;
	}
	
	public String decryptTwoKeys(String s){
		String out1 = halfOfString(s,0);
		String out2 = halfOfString(s,1);
		int key1 = getKey(out1);
		int key2 = getKey(out2);
		CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
		String out = cc.encrypt(s);
		return out;
	}
}
