package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.ArrayIntList;
import main.SortedIntList;



class SortedIntListTest {
	
	/**
	 * Check the add functions for the default
	 * sorted int list. Chack for the max and min 
	 * also the get index of. 
	 */
	@Test
	void test1() {
		SortedIntList tester = new SortedIntList();
		tester.add(4);
		tester.add(8);
		tester.add(79);
		tester.add(8);
		tester.add(5);
		tester.add(7);
		tester.add(4);
		String ans = tester.toString();
		System.out.println(ans);
		System.out.println("The max value is: " + tester.max());
		System.out.println("The min value is: " + tester.min());
		System.out.println("The index of max value is: " 
				+ tester.indexOf(tester.max()));
		try {
			tester.add(16, 0);
		}catch(UnsupportedOperationException a){
			System.out.println(a);
		}
	}

	/**
	 * This test check for the sorted list with uniqueness
	 * as true. Check see if there is reduncendent 
	 * Then change usequeness to false add in value that 
	 * is redundent. after this check for add to specific
	 * index should expect a exception.
	 */
	@Test
	void test2() {
		SortedIntList tester = new SortedIntList(true);
		tester.add(4);
		tester.add(8);
		tester.add(79);
		tester.add(8);
		tester.add(5);
		tester.add(7);
		tester.add(4);
		String ans = tester.toString();
		System.out.println(ans);
		System.out.println("The uniqueness is : "
				+ tester.getUnique());
		tester.setUnique(false);
		tester.add(tester.get(0));
		System.out.println("after change uniqueness "
				+ "the list looks like: " + tester.toString());
		try {
			tester.add(1, 0);
		}catch(UnsupportedOperationException a){
			System.out.println(a);
		}
	}
	
	/**
	 * This test check for the sorted list with
	 * given capacity having uniquness set true a
	 * and not set true as default. Print out
	 * to see the differences.
	 */
	@Test
	void test3() {
		SortedIntList testerWithUn = new SortedIntList(true, 15);
		testerWithUn.add(4);
		testerWithUn.add(8);
		testerWithUn.add(79);
		testerWithUn.add(8);
		testerWithUn.add(5);
		testerWithUn.add(7);
		testerWithUn.add(4);
		String ans = testerWithUn.toString();
		System.out.println(ans);
		
		SortedIntList tester = new SortedIntList(15);
		tester.add(4);
		tester.add(8);
		tester.add(79);
		tester.add(8);
		tester.add(5);
		tester.add(7);
		tester.add(4);
		String ansT = tester.toString();
		System.out.println(ansT);
	}

}
