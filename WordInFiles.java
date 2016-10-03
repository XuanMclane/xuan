import java.io.File;
import java.util.*;
import edu.duke.*;
public class WordInFiles {
	public static void main(String[] args){
		WordInFiles wif = new WordInFiles();
		wif.tester();
	}
	
	private HashMap<String,ArrayList<String>> map;
	
	public WordInFiles(){
		map = new HashMap<>();
	}
	
	public void addWordsFromFile(File f){
		String s = f.toString();
		FileResource fr = new FileResource(f);
		for(String w: fr.words()){
			if(!map.keySet().contains(w)){
				ArrayList<String> list = new ArrayList<>();
				list.add(s);
				map.put(w, list);
			}else{
				ArrayList<String> list = map.get(w);
				if(!list.contains(s)){
					list.add(s);
					map.put(w, list);
				}
			}
		}
	}

	public void buildWordFileMap(){
		map.clear();
		File f1 = new File("data/brief1.txt");
		File f2 = new File("data/brief2.txt");
		File f3 = new File("data/brief3.txt");
		File f4 = new File("data/brief4.txt");
		addWordsFromFile(f1);
		addWordsFromFile(f2);
		addWordsFromFile(f3);
		addWordsFromFile(f4);
	}
	
	public int maxNumber(){
		int max = 0;
		for(String w: map.keySet()){
			ArrayList<String> list = map.get(w);
			if(list.size()>max){
				max = list.size();
			}
		}
		return max;
	}

	public String wordsInNumFiles(int number){
		StringBuilder out = new StringBuilder();
		for(String w : map.keySet()){
			ArrayList<String> list = map.get(w);
			if(list.size()==number){
				out.append(w);
				out.append(" ");
			}
		}
		return out.toString();
	}

	public String printFilesIn(String name){
		StringBuilder out = new StringBuilder();
		if(map.keySet().contains(name)){
			ArrayList<String> list = map.get(name);
			for(int i =0; i<list.size();i++){
				out.append(list.get(i));
				out.append(" ");
			}
			return out.toString();
		}
		return null;
	}

	public void tester(){
		buildWordFileMap();
		int i = maxNumber();
		System.out.println(i);
		String s = wordsInNumFiles(2);
		System.out.println(s);
		String name = printFilesIn("cats");
		System.out.println(name);
	}
}
