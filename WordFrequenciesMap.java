import java.util.*;
import edu.duke.*;
public class WordFrequenciesMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordFrequenciesMap wfm = new WordFrequenciesMap();
		wfm.tester();
	}
	
	public void countWords(String filename){
		FileResource fr = new FileResource(filename);
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> counters = new ArrayList<Integer>();
		for(String w : fr.words()){
			int index = words.indexOf(w);
			if(index==-1){
				words.add(w);
				counters.add(1);
			}else{
				int value = counters.get(index);
				counters.set(index, value + 1);
			}
		}
		int total = 0;
		for(int k = 0; k< words.size(); k++){
			if(counters.get(k)>500){
				System.out.println(counters.get(k)+"\t"+words.get(k));
			}
			total += counters.get(k);
		}
		System.out.println("Total: "+total +"\t"+ "Different: "+words.size());
	}

	public void countWordsMap(String filename){
		FileResource fr = new FileResource(filename);
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String w: fr.words()){
			if(!map.keySet().contains(w)){
				map.put(w, 1);
			}else{
				int value = map.get(w);
				map.put(w, value+1);
			}
		}
		int total =0;
		for(String w : map.keySet()){
			if(map.get(w)>500){
				System.out.println(map.get(w)+"\t"+w);
			}
			total += map.get(w);
		}
		System.out.println("Total: "+total+"\t"+"Different: "+map.keySet().size());
	}

	public void tester(){
		String filename = "data/kjv10.txt";
		double start = System.currentTimeMillis();
		countWords(filename);
		double end = System.currentTimeMillis();
		double time = (end-start)/1000;
		System.out.println("Time: "+time);
		start = System.currentTimeMillis();
		countWordsMap(filename);
		end = System.currentTimeMillis();
		time = (end-start)/1000;
		System.out.println("Time: "+time);
		
	}
}


