
/**
 * Write a description of class UniqueIPTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class UniqueIPTester {
    
    public void testerUniqueIP(){
        LogAnalyzer logA = new LogAnalyzer();
        logA.readFile("testNew.txt");
        int range = logA.countUniqueIPsInRange(300, 399);
        ArrayList<String> ipVisitedInDay = logA.uniqueIPVisitsOnDay("Mar 24");
        System.out.println("Solo son: " + range + " IPs");
        System.out.println("Visited: " + ipVisitedInDay.size() + " IPs");
        logA.printAllHigherThanNum(400);
    }

}
