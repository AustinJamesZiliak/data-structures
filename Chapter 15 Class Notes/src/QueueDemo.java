import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // create a print queue of strings using a queue
        Queue<String> jobs = new LinkedList<>();

        //add jobs
        jobs.add("joe: quarter 2 sales report");
        jobs.add("Cathy: secret files");

        //start printer
        System.out.println("Printing "+ jobs.remove());

        //add more jobs
        jobs.add("Austin: Blackmail on Mr. Miller");
        jobs.add("Jack: bank report June");
        jobs.add("Austin: Is this illegal?");

        //printer keeps going
        System.out.println("Printing "+ jobs.remove());

        //add more
        jobs.add("Boss: Austins warrent for arrest");

        //print rest of jobs
        while(jobs.size() > 0)
            System.out.println("Printing "+ jobs.remove());
    }
}
