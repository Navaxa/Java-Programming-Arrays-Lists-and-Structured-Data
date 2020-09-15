
/**
 * Write a description of class CodonesFrequnecy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class CodonesFrequnecy {

    private HashMap<String, Integer> codonesMap;
    
    public CodonesFrequnecy(){
        codonesMap = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap( int start, String adn){
        codonesMap.clear();
        int count = 0;
        
        for (int i=start; i<adn.length()-2; i+=3){
            //This is our codon, from start to 2 more characters, as String
            String codon = adn.substring(i, i+3);
            /*If during our loop, the codon found is a new one, we add it to our hashmap
             * as a key and with value 1. As we want to count how many different codons we
             * found in our print statement, we will add 1 to count every time we find one.
             */
            if (!codonesMap.containsKey(codon)){
                codonesMap.put(codon, 1);
                count ++;
                // For test purposes: System.out.println("adding new word to hashmap!");
            }
            //If the codon is already a Key, we add one to the value of that codon.
            else{
                codonesMap.put(codon,codonesMap.get(codon) + 1);
                //For test purposes: System.out.println("adding 1 to existing codon!");
            }
        }
        System.out.println("Reading frame starting with " + start +
                           ", results in " + count + " unique codons");
    }

    public String getMostCommonCodon(){
        int maxValue = 0;
        String bestValue = "";
        
        for(String s: codonesMap.keySet()){
            if(codonesMap.get(s) > maxValue){
                maxValue = codonesMap.get(s);
                bestValue = s;
            }
        }
        
        return "and most common codon is " + bestValue.toUpperCase() + " with count " + maxValue;
    }
    
    public void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between " + start +  " and " + end + " inclusive are: \n");
        for(String w : codonesMap.keySet()){
            int HashMap = codonesMap.get(w);
            if(HashMap >= start && HashMap <= end){
                System.out.println( w.toUpperCase() + "\t" + codonesMap.get(w));
            }
        }
    }
    
    public void file(){
        int start = 0;
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAAT";      
        dna = dna.toLowerCase();
        buildCodonMap(start,dna);
        System.out.println(getMostCommonCodon());
        printCodonCounts(4,8);
        
    }
}
