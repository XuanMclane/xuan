
public class CaesarCipherTwo {
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	
	public CaesarCipherTwo(int key1, int key2){
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
	}
	
	public String encrypt(String input){
		StringBuilder encrypted = new StringBuilder(input);
		String[] shiftedAlphabet = {shiftedAlphabet1,shiftedAlphabet2};
		for(int i =0 ; i< input.length(); i++){
			int k = i%2;
			char currChar = encrypted.charAt(i);
			if(Character.isUpperCase(currChar)){
				int index = alphabet.indexOf(currChar);
				if(index!=-1){
					char newChar = shiftedAlphabet[k].charAt(index);
					encrypted.setCharAt(i, newChar);
				}
			}
			if(Character.isLowerCase(currChar)){
				currChar = Character.toUpperCase(currChar);
				int index = alphabet.indexOf(currChar);
				if(index!=-1){
					char newChar = shiftedAlphabet[k].charAt(index);
					newChar = Character.toLowerCase(newChar);
					encrypted.setCharAt(i, newChar);
				}
			}			
		}
		return encrypted.toString();
	}
	
}
