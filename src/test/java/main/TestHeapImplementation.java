package test.java.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Heap;

public class TestHeapImplementation {
	
	@Test
	public void insertNumber() {
		Heap heap = new Heap(10);
		
		heap.insert(2);
		heap.insert(4);
		
//		Assertions.assertArrayEquals(new int[] { 4, 2}, heap.getDataArray());
		Assertions.assertEquals(4, heap.getDataArray()[0]);
		Assertions.assertNotEquals(2, heap.getDataArray()[0]);
	}
	
	@Test
	public void deleteNumber() {
		Heap heap = new Heap(10);
		
		heap.insert(2);
		heap.insert(4);
		heap.insert(5);
		heap.insert(7);
		heap.insert(8);
		heap.insert(3);
		heap.insert(11);
		
		heap.delete(5);
		
//		Assertions.assertArrayEquals(new int[] { 11, 7, 8, 2, 4, 3 }, heap.getDataArray());
		Assertions.assertEquals(4, heap.getDataArray()[4]);
	}
}
