import edu.duke.*;
public class WordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLengths wl = new WordLengths();
		wl.testCountWordLengths();
	}
	
	public void countWordLengths(FileResource resource, int[] counts){
		for(String word : resource.words()){
			int k = word.length();
			if(!Character.isLetter(word.charAt(0))){
				k = k-1;
			}
			if(!Character.isLetter(word.charAt(word.length()-1))){
				k = k-1;
			}
			if(k>=counts.length-1){
				k = counts.length-1;
			}
			if(k<0){
				k = 0;
			}
			counts[k] += 1;
		}
	}
	
	public int indexOfMax(int[] array){
		int max = array[0];
		int maxIndex = 0;
		for(int i = 0 ;i<array.length;i++){
			if(max<array[i]){
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	void testCountWordLengths(){
		FileResource resource = new FileResource("data/smallHamlet.txt");
		int[] counts =  new int[31];
		countWordLengths(resource,counts);
		for(int i =0; i< counts.length; i++){
			System.out.println(i+"\t"+counts[i]);
		}
		int max = indexOfMax(counts);
		System.out.println("max is "+max);
	}
}
