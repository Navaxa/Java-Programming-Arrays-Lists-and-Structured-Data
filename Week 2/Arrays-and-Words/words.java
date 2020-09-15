
/**
 * Write a description of class words here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class words {
    
    StorageResource myWords;
    
    public words(){
        myWords = new StorageResource();
    }
    
    public int getCount(){
        return myWords.size();
    }
    
    public void readWords(String source){
        myWords.clear();
        if(source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String word: resource.words()){
                myWords.add(word.toLowerCase());
            }
        }
        else
        {
            FileResource resource = new FileResource(source);
            for(String word: resource.words()){
                myWords.add(word.toLowerCase());
            }
        }
    }
}