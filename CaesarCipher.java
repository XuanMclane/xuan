import edu.duke.*;
public class CaesarCipher {
	
	public static void main(String[] args){
		CaesarCipher cc = new CaesarCipher(5);
		System.out.println(cc.encrypt("First Legion attack it!"));
	}
	private String alphabet;
	private String shiftedAlphabet;
	public CaesarCipher(int key){
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
	}
	
	public void testCaesar(int key){
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message);
		System.out.println("Key is"+ key + "\n" + encrypted);
		
	}

	public String encrypt(String input){
		StringBuilder encrypted = new StringBuilder(input);
		for(int i =0 ; i< input.length(); i++){
			char currChar = encrypted.charAt(i);
			if(Character.isUpperCase(currChar)){
				int index = alphabet.indexOf(currChar);
				if(index!=-1){
					char newChar = shiftedAlphabet.charAt(index);
					encrypted.setCharAt(i, newChar);
				}
			}
			if(Character.isLowerCase(currChar)){
				currChar = Character.toUpperCase(currChar);
				int index = alphabet.indexOf(currChar);
				if(index!=-1){
					char newChar = shiftedAlphabet.charAt(index);
					newChar = Character.toLowerCase(newChar);
					encrypted.setCharAt(i, newChar);
				}
			}			
		}
		return encrypted.toString();
	}
	
}

