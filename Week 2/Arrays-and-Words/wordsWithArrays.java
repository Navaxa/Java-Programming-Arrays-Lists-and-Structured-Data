
/**
 * Write a description of class wordsWithArrays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class wordsWithArrays {
    StorageResource myWords;
    
    public wordsWithArrays(){
        myWords = new StorageResource(); 
    }
    
    public void readWords(){
        myWords.clear();
        FileResource resource = new FileResource();
        
        for(String word : resource.words()){
            myWords.add(word.toLowerCase());
        }
    }
    
    public boolean contains(String[] list, String word, int number){
        for(int k = 0; k < number; k++){
            if(list[k].equals(word)){
                return true;
            }
        }
        return false;
    }
    
    public int numberOfUniquedWords(){
        int numStorage = 0;
        String[] words = new String[myWords.size()];
        for(String s : myWords.data()){
            if(!contains(words, s, numStorage)){
                words[numStorage] = s;
                numStorage++;
            }
        }
        return numStorage;
    }
    
    public void tester(){
        readWords();
        System.out.println("numero de palabras leidas: " + myWords.size());
        int unique = numberOfUniquedWords();
        System.out.println("Array count: "  + unique);
    }
        
}
