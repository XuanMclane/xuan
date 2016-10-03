
public class WordPlay {
	
	public static void main(String[] args){
		WordPlay a = new WordPlay();
		System.out.println(a.isVowel('F'));
		System.out.println(a.isVowel('a'));
		System.out.println(a.isVowel('d'));
		System.out.println(a.replaceVowel("Hello World", '*'));
		System.out.println(a.emphasize("dna ctgaaactga", 'a'));
		System.out.println(a.emphasize("Mary Bella Abracadabra", 'a'));
	}
	
	public boolean isVowel(char ch){
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
			return true;
		}
		return false;
	}
	
	public String replaceVowel(String phrase, char ch){
		StringBuilder out = new StringBuilder(phrase);
		for(int i =0; i<phrase.length();i++){
			char newch = out.charAt(i);
			if(isVowel(newch)){
				out.setCharAt(i, ch);
			}
		}
		return out.toString();
	}
	
	public String emphasize(String phrase, char ch){
		StringBuilder out = new StringBuilder(phrase);
		for(int i= 0; i<phrase.length();i++){
			char newch = out.charAt(i);
			if(Character.toLowerCase(newch) == Character.toLowerCase(ch)){
				if(i%2==0){out.setCharAt(i, '*');}
				else{out.setCharAt(i, '+');}
			}
		}
		return out.toString();
	}

}
