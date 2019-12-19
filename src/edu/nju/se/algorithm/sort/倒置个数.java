package edu.nju.se.algorithm.sort;

import java.util.*;

public class 倒置个数 {
	
	static int num = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		scanner.nextLine();
		for (int t = 0; t < tc; t++) {
			int n = scanner.nextInt();
			scanner.nextLine();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}

			mergeSort(arr);
			System.out.println(num);
			num = 0;

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
		}

		scanner.close();
	}
	
	public static void mergeSort(int[] arr){
	    int[] temp =new int[arr.length];
	    internalMergeSort(arr, temp, 0, arr.length-1);
	}
	private static void internalMergeSort(int[] arr, int[] temp, int left, int right){
	    //当left==right的时，已经不需要再划分了
	    if (left<right){
	        int middle = (left+right)/2;
	        internalMergeSort(arr, temp, left, middle);          //左子数组
	        internalMergeSort(arr, temp, middle+1, right);       //右子数组
	        mergeSortedArray(arr, temp, left, middle, right);    //合并两个子数组
	    }
	}
	// 合并两个有序子序列
	private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right){
	    int i=left;      
	    int j=middle+1;
	    int k=0;
	    while (i<=middle && j<=right){
	    	if(arr[i] > arr[j]) {
	    		num = num + middle+1 - i;
	    	}
	        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
	    }
	    while (i <=middle){
	        temp[k++] = arr[i++];
	    }
	    while (j<=right){
	        temp[k++] = arr[j++];
	    }
	    //把数据复制回原数组
	    for (i=0; i<k; ++i){
	        arr[left+i] = temp[i];
	    }
	}

}
