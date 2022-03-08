import java.util.ArrayList;
import java.util.List;

public class StackImplementation<T> implements Stack<T> {

	T data;
	
	List<T> stack = new ArrayList<T>();
	
	public void push(T item) {
		stack.add(item);
	}

	public T pop() {
		if (stack.isEmpty()) {
			return null;
		}
		else {
			data = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return data;
		}
	}
		
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
