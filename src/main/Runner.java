package main;

import MergeSortArrays.MergeSortedArrayImpl;

public class Runner {
	public static void main(String[] args) {
		
		// Heap heap = new Heap(10);
		
		// heap.insert(2);
		// heap.insert(4);
		// heap.insert(5);
		// heap.insert(7);
		// heap.insert(8);
		// heap.insert(3);
		// heap.insert(11);
		// heap.printHeap();
		
		// System.out.println("---------------------------");
		// heap.delete(7);
		// heap.printHeap();

		    int[] num1 = { 1,2,3,0,0,0 };
		    int[] num2 = { 2,5,6 };
			MergeSortedArrayImpl mergeSortedArrayImpl = new MergeSortedArrayImpl();
		    mergeSortedArrayImpl.merge(num1, 3, num2, 3);
	
		    for(int i=0; i< num1.length; i++) {
		        System.out.println(num1[i]);
		    }
	}
}
