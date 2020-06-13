package edu.nju.se.algorithm.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {12,61,2,0,6,8,7,3,1,61,23};
		new QuickSort().quickSort(arr);
		for(int i : arr) {
			System.out.print(i + ",");
		}
	}
	
	public void quickSort(int[] arr){
	    qsort(arr, 0, arr.length-1);
	}
	
	private void qsort(int[] arr, int low, int high) {
		if(low >= high) {
			return;
		}
		int loca = doDevide(arr, low, high);
		qsort(arr, low, loca-1);
		qsort(arr, loca + 1, high);
		
	}

	private int doDevide(int[] arr, int low, int high) {
		
		int num = arr[low];
		
		while(low < high) {
			
			while(arr[high] >= num && low < high) {
				high--;
			}
			arr[low] = arr[high];
			
			while(arr[low] <= num && low < high) {
				low++;
			}
			arr[high] = arr[low];
			
		}
		arr[low] = num;
		
		return low;
	}

}
