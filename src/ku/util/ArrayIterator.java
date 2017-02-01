package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	private int cursor;
	private boolean alcall;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.cursor = 0;
		this.alcall = false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			this.alcall = true;
			return this.array[this.cursor++];

		} else
			throw new NoSuchElementException();
	}

	/**
	 * Check the array has the next element or not
	 * 
	 * @return true if the array has the next element, otherwise return false
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < this.array.length; i++) {
			if (this.array[i] != null) {
				this.cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Change the value of that element to null
	 * 
	 * @throws IllegalStateException
	 *             if next method isn't called or remove method is called more
	 *             than once.
	 */
	@Override
	public void remove() {
		if (this.alcall) {
			this.array[this.cursor - 1] = null;
			this.alcall = false;
		} else
			throw new IllegalStateException();
	}

}
