import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can be used to populate a list */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        System.out.println(staff);

        //the list is currently TNPG
        /*
         * The list iterator method makes a new list iterator that is positioned at the head of the list
         * | = iterator position
         */
        ListIterator<String> iterator = staff.listIterator();

        /* The next method advances the itterator over the next element of the list */
        iterator.next(); // T|NPG // returns element traversed over

        String avenger = iterator.next(); // TN|PG
        System.out.println(avenger); //prints Natasha

        /* add method inserts an element at the iterator position
         * The iterator is then positioned after the element that was added
         */
        iterator.add("Steve"); //TNS|PG
        iterator.add("Clint"); //TNSC|PG

        System.out.println(staff);

        /* remove method removes last returned element from next or previous */

        //iterator.remove();// you cant remove unless you call next or previous again, throws an error
        iterator.next(); //TNSCP|G
        iterator.remove(); //Peter is removed now TNSC|G
        System.out.println(staff);

        /* Use the set method to update last returned element, like remove where you have to next or previous first */
        iterator.previous(); //TNS|CG
        iterator.set("T'Challa"); //Clit is changed as clint is what it last jumped over // TNS|TG
        System.out.println(staff);

        /* the has next method deturmines if there is a node after the itterator, usually while loop condition */
        iterator = staff.listIterator(); // back to the begining

        while(iterator.hasNext()){
            String skib = iterator.next();
                if(skib.equals("Natasha")){
                    iterator.remove();
                }
        }

        /* enhansed for loops work with linked lists */
        for(String n : staff){
            System.out.println(n + " ");
        }

        /* ConcurrentModificationException
         *you cannot modify a list while using an iterator unless you use iterator to do the modifying 
         */

        iterator = staff.listIterator(); // |TSTG

        while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Tony")){
                //staff.remove("Tony"); NOT ALLOWED NO MESSING WITH THE LIST WHILE AN ITERATOR IS AT WORK
            }
        }

        /* The enhansed for loop AUTOMATICALY creates an iterator */
        for(String n : staff){
            if (n.equals("Tony"))
                iterator.add("Bruce");// sence inhanced for loop is making an iterator then error
            System.out.println(n + " ");
        }
        System.out.println(staff);
    }
}
