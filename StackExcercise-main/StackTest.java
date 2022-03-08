import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest
{
    @Test
    public void testPushAndPop()
    {
        Stack<Integer> stack = new StackImplementation<Integer> ();
        
        stack.push(10);

        int item = stack.pop();
        
        if (item != 10)
            fail ("Added 10, popped " + item);
        
        if (! stack.isEmpty())
            fail ("Added 10 and popped it, stack not empty");
    }

    @Test
    public void testRemoveOnEmptyStack()
    {
        Stack<Integer> stack = new StackImplementation<Integer> ();
        
        Integer item = stack.pop();
        
        if (item != null)
            fail ("Popped on empty stack, got " + item);
    }
    
    @Test
    public void testIsEmpty()
    {
        Stack<Integer> stack = new StackImplementation<Integer> ();
        
        if (! stack.isEmpty())
            fail ("Empty stack not reporting as empty");
        
        stack.push(10);

        if (stack.isEmpty())
            fail ("Added 10 but stack reporting as empty");
        
        stack.pop();
        
        if (! stack.isEmpty())
            fail ("Added 10 and popped it, stack not empty");
    }
    
    @Test
    public void testOrder()
    {
        Stack<Integer> stack = new StackImplementation<Integer> ();

        for (int i = 0; i < 10; i++)
            stack.push(i);

        for (int i = 9; i >= 0; i--)
        {
            int item = stack.pop ();
            
            if (item != i)
                fail ("Expecting " + i + " on pop, got " + item);
        }
        
        // We've removed all the items, make sure the stack is empty
        if (! stack.isEmpty())
            fail ("Stack not empty after removing all elements");
   }

    @Test
    public void testRemoveOrder()
    {
        Stack<Integer> stack = new StackImplementation<Integer> ();

        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(2);

        int item = stack.pop();
        
        if (item != 2)
            fail ("Expecting 2, got " + item);
        
        item = stack.pop();
        
        if (item != 1)
            fail ("Expecting 1, got " + item);
        
        item = stack.pop();
        
        if (item != 2)
            fail ("Expecting 2, got " + item);
        
        item = stack.pop();
        
        if (item != 1)
            fail ("Expecting 1, got " + item);
   }
}