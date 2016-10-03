import java.util.*;
import edu.duke.*;
public class GladLibMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GladLibMap glm = new GladLibMap();
		glm.makeStory();
	}
	
	private HashMap<String,ArrayList<String>> myMap;
	
	private Random myRandom;
	
	private static String dataSourceURL="http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";
	
	public GladLibMap(){
		myMap = new HashMap<String,ArrayList<String>>();
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
	}
	
	public GladLibMap(String source){
		myMap = new HashMap<String,ArrayList<String>>();
		initializeFromSource(source);
		myRandom = new Random();
	}
	
	private void initializeFromSource(String source){
		String[] labels = {"country","color","name","noun","animal","adjective","timeframe"};
		for(String s: labels){
			ArrayList<String> list =  readIt(source+"/"+s+".txt");
			if(!myMap.keySet().contains(s)){
			myMap.put(s, list);}
		}
	}

	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if(source.startsWith("Http")){
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}else{
			FileResource resource = new FileResource(source);
			for(String line: resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}
	
	private String getSubstitute(String label){
		if(label.equals("number")){
			return  ""+myRandom.nextInt(50)+5;
		}
		ArrayList<String> list = myMap.get(label);
		return randomFrom(list);
	}
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if(first==-1 || last==-1){
			return w;
		}
		String prefix = w.substring(0, first);
		String suffix = w.substring(last+1);
		String sub = getSubstitute(w.substring(first+1,last));
		return prefix+sub+suffix;
	}
	
	private void printOut(String s, int linewidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if(charsWritten+w.length()>linewidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+"     ");
			charsWritten += w.length()+1;
		}
	}

	private String fromTemplate(String source){
		String story = "";
		if(source.startsWith("Http")){
			URLResource resource = new URLResource(source);
			for(String w: resource.words()){
				story = story + processWord(w);
			}
		}else{
			FileResource resource = new FileResource(source);
			for(String w: resource.words()){
				story = story + processWord(w);
			}
		}
		return story;
	}
	
	public int totalWordsInMap(){
		int total = 0;
		for(String s: myMap.keySet()){
			ArrayList<String> list = myMap.get(s);
			total += list.size();
		}
		return total;
	}
	
	public int totalWordsConsidered(){
		int total = 0;
		FileResource resource = new FileResource("data/madtemplate.txt");
		ArrayList<String> words = new ArrayList<String>();
		String[] labels = {"country","color","name","noun","animal","adjective","timeframe"};
		for(String w: resource.words()){
			for(int i=0;i<labels.length;i++){
				if(w.equals(labels[i])){
					words.add(w);
				}
			}
		}
		for(int i=0;i<words.size();i++){
			String s = words.get(i);
			ArrayList<String> list = myMap.get(s);
			total += list.size();
		}
		return total;
	}

	public void makeStory(){
		System.out.println("\n");
		String story = fromTemplate("data/madtemplate.txt");
		printOut(story,60);
	}
}
