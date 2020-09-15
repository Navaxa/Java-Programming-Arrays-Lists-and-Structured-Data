
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
    
    private ArrayList<LogEntry> records;
    
    public LogAnalyzer(){
        records = new ArrayList<LogEntry>();
    }
    
    public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for ( String line : fr.lines()){
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
    }
    
    public int uniqueIPs(){
        ArrayList<String> uniqueIps = new ArrayList<String>();
        
        for (LogEntry le: records){
            String ipAddress = le.getIpAddress();
            if(!uniqueIps.contains(ipAddress)) {
                uniqueIps.add(ipAddress);
            }
        }
        return uniqueIps.size();
    }
        
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
    
    public void printAllHigherThanNum(int Num) { 
         
        for(LogEntry le: records) {
        // Status code in LogEntrys
        int statusCode = le.getStatusCode();
        //if StatusCode greater than Num
            if(statusCode > Num) {
                //print StatusCode
                System.out.println("StatusCode greater than "+Num+": "+statusCode);
            }
        }
           
     } 
    
    public ArrayList<String> uniqueIPVisitsOnDay (String someDay) { 
        ArrayList <String> day = new ArrayList <String>();
        String myString = "";
        for(LogEntry le : records){
            Date d = le.getAccessTime();
            String ipAddr = le.getIpAddress();
            myString = d.toString();
            int idx = day.indexOf(ipAddr);
            if( myString.contains(someDay) && !day.contains(ipAddr)){
                day.add(ipAddr);
            }
        }
        return day;
    }
    
    public int countUniqueIPsInRange (int low, int high){
        ArrayList<String> myIPs = new ArrayList<String>();
        for ( LogEntry le : records){
            int status = le.getStatusCode();
            if(status >= low && status <= high) {
                String ipAddr = le.getIpAddress();
                myIPs.add(ipAddr);
            }
        }
        return myIPs.size();
    }
    
    
    public HashMap<String, Integer> countVisitedPerIP(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        
        for(LogEntry le : records){
            String ipAddr = le.getIpAddress();
            if(!counts.containsKey(ipAddr)){
                counts.put(ipAddr, 1);
            } else {
                counts.put(ipAddr, counts.get(ipAddr) + 1);
            }
        }
        return counts;
    }
    
    public int mostNumberVisitByIp(HashMap<String,Integer> counts){
        int maxValue = 0;
        for(String s : counts.keySet()){
            int valueCounts = counts.get(s);
            if(valueCounts > maxValue){
                maxValue = valueCounts;
            }
        }
        return maxValue;    
    }
    
    public ArrayList iPsMostVisits (HashMap<String,Integer> counts) {
        ArrayList<String> dirIP = new ArrayList<String>(); 
        int maxValue = mostNumberVisitByIp(counts);
        for(String s: counts.keySet()){
            if(counts.get(s) == maxValue){
                dirIP.add(s);
            }
            
        }
        return dirIP;
    }
    
    public HashMap iPsForDays () {
        HashMap<String, ArrayList<String>> ip4Day = new 
        HashMap<String, ArrayList<String>>();
        ArrayList<String> disIP = new ArrayList<String>();
        String ip = "";
        
        for (LogEntry le : records){
            Date d = le.getAccessTime();
            String ipAddr = le.getIpAddress();
            ip = d.toString();
            disIP = uniqueIPVisitsOnDay("ddddd");
            ip4Day.put(ip, disIP);
        }
        
        return ip4Day;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> counts){  
        int max = 0;
        String day = "";
        for(String s : counts.keySet()){
            int size = counts.get(s).size();
            if ( size > max ) { 
                max = size;
                day = s;
            }
        }
        return day;
    }
    
  public ArrayList iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map, String day){
      ArrayList<String> list = map.get(day);
      HashMap<String, Integer> countIP = new HashMap<String, Integer>();
      int maxCount = 0;
      for (int count : countIP.values())
          if (count > maxCount) maxCount = count;

      // fill output list
      for (String ip : countIP.keySet())
          if (countIP.get(ip) == maxCount) {
              list.add(ip);
          }
      return list;
  }
}
