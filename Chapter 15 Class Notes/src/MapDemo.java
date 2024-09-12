import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*
         * The Map interface is generic
         * The first type is the key
         * the second is the value
         */
        Map<String, Color> favColors = new HashMap<>();
        // add elements using put method

        favColors.put("Henry", Color.BLUE);
        favColors.put("Jack", Color.RED);
        favColors.put("Priya", Color.GREEN);

        // two diferent elements with same value
        favColors.put("Austin", Color.GREEN);

        // NO SAME KEYS YOU IDIOT, YOU LOOSE THE OLD ONE YOU NIMWIT
        favColors.put("Austin", Color.ORANGE);

        // You can greate a set of keys in a map
        Set<String> keys = favColors.keySet();
        for(String key: keys){
            System.out.println(key + " ("+key.hashCode()+"): "+favColors.get(key));
        }
    }
}
