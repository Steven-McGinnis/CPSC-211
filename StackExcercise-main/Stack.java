public interface Stack<T>
{
    void push (T item);
	// Remove and return top item, return null if stack is empty
    T pop ();
    boolean isEmpty ();
}
