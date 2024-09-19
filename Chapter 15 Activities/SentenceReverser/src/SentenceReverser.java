import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
    	

        Stack<String> words = new Stack<>();
        // Complete this method. Use a Stack.
        String reversed = "";
        while (scanner.hasNext()){
            while (scanner.hasNext()){
                String curWord = scanner.next();
                if (curWord.contains(".")){
                    words.push(curWord.substring(0,curWord.length()-1));
                    break;
                }
                else
                    words.push(curWord);
            }

            while (words.size() > 0){
                reversed += " "+words.pop();
            }
            reversed += ".";
        }
        return reversed;






    }
}
