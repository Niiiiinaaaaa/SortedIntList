package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import main.ArrayIntList;



class ArrayIntListTest {
	/**
	 * Set up an ArrayIntlist as tester and set 
	 * default Capacity add 15 values and check
	 * toString function and print the tester list. 
	 * Test for out of bond add value exception 
	 * should return a index out of bound exception
	 * By adding more values than default capacity
	 * this also checked the ensure Capacity method 
	 * when the exceeding values can successfully 
	 * add into the list.
	 */
	@Test
	void test1() {
		ArrayIntList tester = new ArrayIntList();
		for(int i = 0; i < 15; i++) {
			tester.add(i);
		}
		String ans = tester.toString();
		System.out.println(ans);
		try {
			tester.add(16, 0);
		}catch(IndexOutOfBoundsException a){
			System.out.println(a);
		}
	}

	/**
	 * This test check for the add and add to specific 
	 * index function. Meanwhile printing out the list 
	 * and the value that was added to the specific index.
	 * Then remove that value being added. In the end 
	 * clear all values in the current list
	 */
	@Test
	void test2() {
		ArrayIntList tester = new ArrayIntList(20);
		tester.add(10);
		tester.add(12);
		tester.add(30);
		tester.add(0);
		System.out.println("Four values has been added to current list:  "
				+ tester.toString());
		tester.add(1,6);
		System.out.println("Now add value at index of 1: " 
				+ tester.toString());
		int checkAdd = tester.get(1);
		System.out.println("The value that is added in was: " 
				+ checkAdd);
		tester.remove(1);
		System.out.println("Now remove this value from the list: "
				+ tester.toString());
		tester.clear();
		System.out.println("At the end remove all values from the list: "
				+ tester.toString());
		
		
	}
	
	/**
	 * This test will check for if a given value is contained
	 * in the list. Then if the value is in the list check for 
	 * the index of that value. Knowing the index we can remove 
	 * this value from the list. After removing check if the 
	 * remainder list is empty. If not, clear all values then 
	 * check for is empty again. 
	 */
	@Test
	void test3() {
		ArrayIntList tester = new ArrayIntList();
		for(int i = 0; i < 15; i++) {
			tester.add(i + 1);
		}
		System.out.println("We create a list looks like: "
				+ tester.toString());
		System.out.println("This list has " + tester.size() + " values.");
		if(tester.contains(5)) {
			System.out.println("This list does exists value of 5.");
		}
		int index = tester.indexOf(5);
		System.out.println("The index of 5 is: " + index);
		tester.remove(index);
		if(!tester.isEmpty()) {
			System.out.println("After remove this value the list looks like: "
					+ tester.toString());
			System.out.println("This list now has " + tester.size() + " values.");
		}
		tester.clear();
		if(tester.isEmpty()) {
			System.out.println("Clear all values now list is empty"
					+ tester.toString());
			System.out.println("This list now has " + tester.size() + " values.");
		}
	}
	

}
