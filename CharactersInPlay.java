import java.util.*;
import edu.duke.*;
public class CharactersInPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharactersInPlay cip = new CharactersInPlay();
		cip.tester();
	}
	
	private ArrayList<String> name;
	private ArrayList<Integer> number;
	
	public CharactersInPlay() {
		name = new ArrayList<String>();
		number = new ArrayList<Integer>();
	}
	
	public void update(String person){
		int index = name.indexOf(person);
		if(index == -1){
			name.add(person);
			number.add(1);
		}else{
			int num = number.get(index);
			number.set(index, num+1);
		}
	}
	
	public void findAllCharacters(FileResource resource){
		name.clear();
		number.clear();
		for(String s: resource.lines()){
			StringBuilder person = new StringBuilder();
			for(int i = 0; i<s.length();i++){
				char ch = s.charAt(i);
				if(ch!='.'){
					if(ch!=' '){
						person.append(ch);
					}
				}else{
					break;
				}				
			}
			update(person.toString());
		}
	}

	public void charactersWithNumParts(int num1, int num2){
		for(int i=0;i<name.size();i++){
			if(number.get(i)>=num1 && number.get(i)<=num2){
				System.out.println(name.get(i)+" "+number.get(i));
			}
		}
	}
	
	void tester(){
		FileResource resource = new FileResource("data/macbeth.txt");
		findAllCharacters(resource);
		for(int i=0; i<name.size();i++){
			if(number.get(i)>1){
				System.out.println(name.get(i)+" "+number.get(i));
			}
		}
		charactersWithNumParts(3,8);
	}
}
