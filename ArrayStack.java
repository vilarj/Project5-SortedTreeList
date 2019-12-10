package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int initialCapacity) {
		checkCapacity(initialCapacity);

		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}

	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException(
					"Attempt to create a stack whose " + "capacity exceeds allowed " + "maximum of " + MAX_CAPACITY);
		}
	}

	private void checkInitialization() {
		if (!initialized) {
			throw new SecurityException("ArrayStack object is not initialized " + "properly");
		}
	}

	private void ensureCapacity() {
		if (topIndex == stack.length - 1) {
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}

	@Override
	public void push(T anEntry) {

		checkInitialization();
		ensureCapacity();
		stack[topIndex + 1] = anEntry;
		topIndex++;
	}

	@Override
	public T pop() {
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} // end if
	} // end pop

	@Override
	public T peek() {
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	} // end peek

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void clear() {
		while(topIndex != -1) {
			pop();
		}

	}

}
