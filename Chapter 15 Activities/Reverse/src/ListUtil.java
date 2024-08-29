import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        LinkedList<String> newList = new LinkedList<>();
        ListIterator<String> iter = strings.listIterator();
        while (iter.hasNext()){
            iter.next();
        }
        while (iter.hasPrevious()){
            String name = iter.previous();
            newList.addLast(name);
        }
        ListIterator<String> iter2 = newList.listIterator();
        iter = strings.listIterator();

        while (iter2.hasNext()){
            iter.next();
            iter.set(iter2.next());
        }
            
    }
}