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
		heap.insert(5);
		heap.insert(7);
		heap.insert(8);
		heap.insert(3);
		heap.insert(11);
		
//		Assertions.assertArrayEquals(new int[] { 4, 2}, heap.getDataArray());
		Assertions.assertEquals(11, heap.getDataArray()[0]);
		Assertions.assertNotEquals(2, heap.getDataArray()[0]);
		Assertions.assertEquals(4, heap.getDataArray()[6]);
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
		
		heap.delete(7);
		
//		Assertions.assertArrayEquals(new int[] { 11, 7, 8, 2, 4, 3 }, heap.getDataArray());
		// { 11, 5, 8, 2, 4, 3 }
		Assertions.assertEquals(4, heap.getDataArray()[4]);
		Assertions.assertEquals(5, heap.getDataArray()[1]);
	}
	
	@Test
	public void deleteNumber11() {
		Heap heap = new Heap(10);
		
		heap.insert(2);
		heap.insert(4);
		heap.insert(5);
		heap.insert(7);
		heap.insert(8);
		heap.insert(3);
		heap.insert(11);
		
		heap.delete(11);
		
//		Assertions.assertArrayEquals(new int[] { 11, 7, 8, 2, 4, 3 }, heap.getDataArray());
		// { 11, 5, 8, 2, 4, 3 }
		Assertions.assertEquals(8, heap.getDataArray()[0]);
		Assertions.assertEquals(4, heap.getDataArray()[2]);
		Assertions.assertNotEquals(8, 2);
	}
}
