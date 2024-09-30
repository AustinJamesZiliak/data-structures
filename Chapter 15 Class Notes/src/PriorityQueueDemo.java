import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // create a to do list // needs to be compareable
        // work order has prority and description
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(0, "Water plants"));
        toDo.add(new WorkOrder(7, "Call mom"));
        toDo.add(new WorkOrder(4, "Make dinner"));
        toDo.add(new WorkOrder(2, "attempt to avoid arrest"));
        toDo.add(new WorkOrder(1, "Gambling"));
        toDo.add(new WorkOrder(1, "Assend to godhood"));
        toDo.add(new WorkOrder(0, "Betting on black"));
        toDo.add(new WorkOrder(1, "Beat the alligations"));
        toDo.add(new WorkOrder(314159263, "Respond to jacks message (Maybe)"));
        toDo.add(new WorkOrder(8, "Leave jack on read"));

        // NOT STORED IN PRIORITY ORDER DIM WIT
        System.out.println(toDo);

        // REMOVED IN PRIORITY ORDER
        while (toDo.size() > 0)
            System.out.println(toDo.remove());

    }
}
