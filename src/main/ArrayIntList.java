package main;



public class ArrayIntList {
	public static final int DEFAULT_CAPACITY = 10;
	
	private int[] currentData;
	private int size = 0;
	/**
	 * Constructor create an list of integer with 
	 * capacity of 10
	 */
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor create an list of integer with 
	 * capacity of given capacity
	 * @param capacity integer represent capacity to be define
	 */
	public ArrayIntList(int capacity) {
		if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }else {
        	currentData = new int[capacity];
        }
	}
	
	/**
	 * This method adds the given value to the list 
	 * @param value integer represents the value 
	 * need to be added
	 */
	public void add(int value) {
		add(size, value);
	}
	
	/**
	 * This method add the given value at the given 
	 * index position of the list
	 * @param index integer as the given index needs 
	 * to be added at 
	 * @param value integer as the given value needs 
	 * to be added
	 */
	public void add(int index, int value) {
		checkIndex(index, 0, size);
		ensureCapacity(size + 1);
		
		for(int i = size; i > index; i--) {
			currentData[i] = currentData[i - 1];
		}
		currentData[index] = value;
		size++;
	}
	
	/**
	 * show the data store at the given index
	 * @param index integer as which index of data 
	 * needs to be show 
	 * @return integer as the data at given index
	 */
	public int get(int index) {
		return currentData[index];
	}
	
	/**
	 * This method show the index of the given value 
	 * @param value integer as given value 
	 * @return integer as the index of the given value
	 */
	public int indexOf(int value) {
		for(int i = 0; i < size; i ++) {
			if(currentData[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method removes the data store at given index
	 * @param index integer as which index needs to remove
	 */
	public void remove(int index) {
		checkIndex(index, 0, size);
		for(int i = index; i < size - 1; i ++) {
			currentData[i] = currentData[i + 1];
		}
		size --;
	}
	
	/**
	 * This method give the current number of element
	 * in the list 
	 * @return integer as current number of element
	 */
	public int size() {
		return size;
	}
	
	/**
	 * show the string version of list
	 * @return String as the string version of data list
	 */
	public String toString() {
		String result = "S:[";
		for(int i = 0; i < size; i ++) {
			if(i > 0) {
				result += ", ";
			}
			result += currentData[i];
		}
		result += "]";
		return result;
	}
	
	/**
	 * removes all values in list 
	 */
	public void clear() {
		size = 0;
	}
	
	/**
	 * check if the list contains the given value
	 * @param value integer as value needs to be check
	 * @return boolean show if the value is in the list
	 */
	public boolean contains(int value) {
		return !(indexOf(value) < 0);
	}
	
	/**
	 * This method check for id the given index is out
	 * of bound by minimum index and maximum index of the list
	 * @param index integer as the index being checked
	 * @param min integer as minimum index of the list
	 * @param max integer as maximum index of the list
	 */
	private void checkIndex(int index, int min, int max) {
		if(index < min || index > max) {
			throw new ArrayIndexOutOfBoundsException("Wrong index: " + index + 
					" must be between: " + min + " and " + max);
		}
	}
	
	/**
	 * show if the list is empty or not 
	 * @return boolean true for empty false or not 
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * This method make sure that the list is large 
	 * enough for the given capacity number of data
	 * @param capacity integer as given capacity of 
	 * data need to be stored in the list
	 */
	public void ensureCapacity(int capacity) {
		if(capacity > currentData.length) {
			int[] newList = new int[capacity];
			for (int i = 0; i < size; i++) {
                newList[i] = currentData[i];
            }
			currentData = newList;
		}
	}
}


