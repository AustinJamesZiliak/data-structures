import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();
        // push comands to top of stack
        commands.push("Insert: 'hello'");
        commands.push("Insert: ','");
        commands.push("Insert: ' '");
        commands.push("Insert: 'World'");
        commands.push("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: '!'");

        System.out.println(commands);

        //simulate the user pressing undo 4 times
        for (int i = 0; i<4;i++)
            System.out.println("Undo " + commands.pop());
    }
}
