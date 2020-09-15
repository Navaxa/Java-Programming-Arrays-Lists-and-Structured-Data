
/**
 * Write a description of class FreqWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;
public class FreqWords {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public FreqWords(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }
    
    public void findIndexOfMax(){
        int value = myFreqs.get(0);
        int maxIndex = value;
        
        String word = myWords.get(0);
        String maxWord = word;
        
        for(int k = 0; k < myFreqs.size(); k++){
            int index = myFreqs.get(k);
            word = myWords.get(k);
            if(index > maxIndex){
                maxIndex = index;
                maxWord = word;
            }
        }
        System.out.println(maxWord + " repeat " + maxIndex);

    }
    
    public void tester(){
        for(int  k = 0; k < myWords.size(); k++){
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        }
        findUnique();
        System.out.println("Unique words " + myWords.size());
        findIndexOfMax();
    }
}
