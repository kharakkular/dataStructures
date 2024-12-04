package main;

public class Runner {
	public static void main(String[] args) {
		
		Heap heap = new Heap(10);
		
		heap.insert(2);
		heap.insert(4);
		heap.insert(5);
		heap.insert(7);
		heap.insert(8);
		heap.insert(3);
		heap.insert(11);
		heap.printHeap();
		
		System.out.println("---------------------------");
		heap.delete(7);
		heap.printHeap();
	}
}
