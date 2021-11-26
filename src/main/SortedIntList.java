package main;

import java.util.*;


	
public class SortedIntList extends ArrayIntList {

	private boolean unique = false;
	
	/**
	 * Constructor create an list of integer with 
	 * capacity of 10 and uniqueness is false
	 */
	public SortedIntList() {
		super();
	}
	
	/**
	 * Constructor create an list of integer with 
	 * capacity as integer given and uniqueness is false
	 * @param capacity integer represent capacity to be define
	 */
	public SortedIntList(int capacity) {
		super(capacity);
	}
	
	/**
	 * Constructor create an list of integer with 
	 * capacity of 10 and uniqueness as given 
	 * @param unique boolean represent uniqueness
	 */
	public SortedIntList(boolean unique) {
		super();
		this.unique = unique;
	}
	
	/**
	 * Constructor create an list of integer with 
	 * capacity as integer given and uniqueness as given
	 * @param unique boolean represent uniqueness
	 * @param capacity integer represent capacity to be define
	 */
	public SortedIntList(boolean unique, int capacity) {
		super(capacity);
		this.unique = unique;
	}
	
	/**
	 * This method adds the given value to the list 
	 * If the list is unique then only add when this value 
	 * id not contained in the list.
	 *  @param value integer represents the value 
	 * need to be added
	 */
	public void add(int value) {
		if(value < super.get(0) || super.size() == 0) {
			super.add(0, value);
		}else{
			for(int i = 1; i <= super.size(); i ++) {
				if(value >= super.get(i - 1) && (value <= super.get(i)
						|| i == super.size())) {
					if(unique){
						if(!super.contains(value)) {
							super.add(i, value);
							value = value -1;
						}
					}else {
						super.add(i, value);
						value = value -1;
					}
				}
			}
		}
	}
	
	/**
	 * add to specific index not allowed
	 */
	public void add(int index, int value) {
		throw new UnsupportedOperationException("Please use correct argument to add value.");
	}
	
	/**
	 * Show uniqueness
	 * @return boolean as current uniqueness
	 */
	public boolean getUnique() {
		return unique;
	}
	
	/**
	 * set current list to given uniqueness
	 * @param value boolean as uniqueness needs
	 * to be change to 
	 */
	public void setUnique(boolean value) {
		if(value && !unique) {
			for(int i = 0; i < super.size() - 1; i ++) {
				if(super.get(i) == super.get(i + 1)) {
					super.remove(i);
					i --;
				}
			}
		}else if(!value) {
			unique = false;
		}else {
			unique = value;
		}
	}
	
	/**
	 * show max value in list exception when 
	 * there is no maximum 
	 * @return integer as maxmum value 
	 */
	public int max() {
		if(super.size() == 0) {
			throw new NoSuchElementException(
					"This list does not have a maximum.");
		}else {
			return super.get(super.size() - 1);
		}
	}
	
	/**
	 * show min value in list exception when 
	 * there is no minimum 
	 * @return integer as minimum value 
	 */
	public int min() {
		if(super.size() == 0) {
			throw new NoSuchElementException(
					"This list does not have a maximum.");
		}else {
			return super.get(0);
		}
	}
	
	/**
	 * show the string version of list
	 * @return String as the string version of data list
	 */
	public String toString() {
		String output = super.toString();
		if(unique) {
			output += "U";
		}
		return output;
		
	}
	
	/**
	 * This method show the index of the given value 
	 * Will return a negative index of where it can 
	 * be add to if this value is not currently in list
	 * @param value integer as given value 
	 * @return integer as the index of the given value
	 */
	public int indexOf(int value) {
		int [] data = new int [super.size()];
		for(int i = 0; i < super.size(); i ++) {
			data[i] = super.get(i);
		}
		return Arrays.binarySearch(data, 0, super.size(), value);
	}
}
