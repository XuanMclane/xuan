import java.util.*;
import edu.duke.*;
public class CodonCount {
	
	public static void main(String[] args){
		CodonCount cc = new CodonCount();
		String dna = "CGTTCAAGTTCAA";
		cc.buildCodonMap(2, dna);
		String out = cc.getMostCommonCodon();
		System.out.println(out);
	}
	
	private HashMap<String,Integer> map ;
	
	public CodonCount(){
		map= new HashMap<String,Integer>();
	}
	
	public void buildCodonMap(int start, String dna){
		map.clear();
		for(int i = start; i<dna.length()-2;i+=3){
			StringBuilder s = new StringBuilder(3);
			s.append(dna.charAt(i));
			s.append(dna.charAt(i+1));
			s.append(dna.charAt(i+2));
			String out = s.toString();
			if(map.keySet().contains(out)){
				map.put(out,map.get(out)+1);
			}else{
				map.put(out, 1);
			}
		}
	}
	
	public String getMostCommonCodon(){
		int max = 0;
		StringBuilder out =new StringBuilder();
		for(String s : map.keySet()){
			if(map.get(s)>max){
				max = map.get(s);
			}
		}
		for(String s : map.keySet()){
			if(map.get(s)==max){
				out.append(s);
				out.append(" ");
			}
		}
		return out.toString();
	}

	public void printCodonCounts(int start, int end){
		for(String s : map.keySet()){
			if(map.get(s)>=start && map.get(s)<=end){
				System.out.println(s);;
			}
		}
	}
}
