
/**
 * Write a description of class CountTester here.
 * 
 * @author (Miguel Nava) 
 * @version (a version number or a date)
 */
import java.util.*;
public class CountTester {
    
    public void testCounts() {
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("weblog1_log .txt");
        //int uniqueIP = logA.uniqueIPs();
        //System.out.println("Unique IP : " + uniqueIP);
        HashMap<String,Integer> counts = logA.countVisitedPerIP();
        System.out.println(counts);
        int maxValue = logA.mostNumberVisitByIp(counts);
        System.out.println("max Value: " + maxValue);
        ArrayList<String> maxIP = logA.iPsMostVisits(counts);
        System.out.println("IP address with most number of visit: " 
        + maxIP);
        HashMap <String, ArrayList<String>> ip4Day = logA.iPsForDays();
        System.out.println("IPs for Day: " + ip4Day);
        String mostDay = logA.dayWithMostIPVisits(ip4Day);
        System.out.println("The Dat mos Visited is: " + mostDay);
        ArrayList<String> mostIP = logA.iPsWithMostVisitsOnDay(ip4Day, "Sep 30" );
        System.out.println(mostIP);
        System.out.println(logA.uniqueIPVisitsOnDay("Sep 27"));
        
    }

}
