package main;

import java.util.Arrays;

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
	
	public void heapify(int value) {
		int index = size - 1;
		while(index > 0 && heapData[getParentIndex(index)] < value) {
			int parentIndex = getParentIndex(index);
			int parentNum = heapData[parentIndex];
			heapData[index] = parentNum;
			index = getParentIndex(index);
		}

		heapData[index] = value;
	}
	
	public void delete(int value) {
		int index = findIndex(value);
		if(index != Integer.MIN_VALUE) {
			heapData[index] = heapData[size - 1];
			heapData[--size] = 0;
			
			int parentIndex = getParentIndex(index);
			value = heapData[index];
			if(heapData[index] > heapData[parentIndex]) {
				heapify(heapData[index]);
			}
			if(heapData[index] < heapData[findReplacerIndex(index)]) {
				adjustLowerOrder(heapData[index]);
			}
		}
		
	}
	
	private void adjustLowerOrder(int value) {
		int index = findIndex(value);
		int replacerIndex = findReplacerIndex(index);
		int replacer = heapData[replacerIndex];
//		int[] originalArr = Arrays.copyOf(heapData, heapData.length);
		while(index < size - 1 && value < replacer && replacerIndex < size -1) {
			
//			originalArr[index] = replacer;
//			index = findIndex(replacer);
//			replacer = findReplacer(replacer);
			heapData[index] = replacer;
			index = replacerIndex;
			replacerIndex = findReplacerIndex(replacerIndex);
			if(replacerIndex < size - 1) {
				replacer = heapData[replacerIndex];
			}
		}
//		heapData = originalArr;
		heapData[index] = value;
		
	}
	
	public int[] getDataArray() {
		return Arrays.copyOf(heapData, size);
	}
	
	private int findReplacerIndex(int valueIndex) {
//		int index = findIndex(value);
		if(((valueIndex * 2) + 1) <= size -1){
			if(((valueIndex * 2) + 2) <= size - 1) {
				return heapData[(valueIndex * 2) + 1] > heapData[(valueIndex * 2) + 1] ? (valueIndex * 2) + 1 : (valueIndex * 2) + 2;
			}
			return (valueIndex * 2) + 1;
		}
//		int leftValue = ((index * 2) + 1) < heapData.length ? heapData[(index * 2) + 1] : 0;
//		int rightValue = ((index * 2) + 2) < heapData.length ? heapData[(index * 2) + 2] : 0;
		return Integer.MAX_VALUE;
	}
	
	private int findIndex(int value) {
		int index = Integer.MIN_VALUE;
		for(int i=0; i<size; i++) {
			if(heapData[i] == value) {
				return i;
			}
		}
		return index;
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
