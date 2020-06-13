package edu.nju.se.algorithm.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {12,61,2,0,6,8,7,3,1,61,23};
		new MergeSort().mergeSort(arr);
		for(int i : arr) {
			System.out.print(i + ",");
		}
	}
	
	public void mergeSort(int[] arr){
	    mSort(arr, 0, arr.length-1);
	}

	private void mSort(int[] arr, int low, int high) {
		if(low >= high)
			return;
		int mid = (low + high) / 2;
		mSort(arr, low, mid);
		mSort(arr, mid+1, high);
		doMerge(arr, low, mid, high);
	}

	private void doMerge(int[] arr, int low, int mid, int high) {
		int i=low;
		int j=mid+1;
		
		int[] temp = new int[arr.length];
		int index = low;
		
		while(i<=mid && j<=high) {
			
			temp[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
			
		}
		
		while(i<=mid) {
			temp[index++] = arr[i++];
		}
		
		while(j<=high) {
			temp[index++] = arr[j++];
		}
		
		for(int k=low; k<index; k++) {
			arr[k] = temp[k];
		}
		
		
	}

}
