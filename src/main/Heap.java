package main;

public class Heap {
	
	private int[] heapData;
	private int size;
	
	public Heap(int capacity) {
		heapData = new int[capacity];
	}
	
	public void insert(int data) {
		heapData[size++] = data;
		if(size == 1) {
			return;
		}
		heapify(data);
	}
	
	public void heapify(int data) {
		int index = size - 1;
		while(index > 0 && heapData[getParentIndex(index)] < data) {
			int parentIndex = getParentIndex(index);
			int parentNum = heapData[parentIndex];
			heapData[index] = parentNum;
			index = getParentIndex(index);
		}

		heapData[index] = data;
	}
	
	private int getParentIndex(int index) {
		if(index == 0 || index == 1 || index == 2) {
			return 0;
		}
		
		return (index - 1 ) / 2;
	}
	
	public void printHeap() {
		if(size > 0) {
			for(int i=0; i<size; i++) {
				System.out.println(heapData[i]);
			}			
		}
	}
}
