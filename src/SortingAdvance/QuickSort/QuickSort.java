package SortingAdvance.QuickSort;

import java.util.Arrays;

public class QuickSort {

	//算法类不允许产生任何实例
	private QuickSort() {}
	
	// 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
	private static int partion(Comparable[] arr, int l, int r) {
		
		Comparable v = arr[l];
		
		int j = l;
		for (int i = l+1; i <= r; i++) {
			if (arr[i].compareTo(v) < 0) {
				j++;
				swap(arr, j, i);
			}
		}
		
		swap(arr, l, j);
		
		return j;
	}
	
	// 递归使用快速排序,对arr[l...r]的范围进行排序
	private static void sort(Comparable[] arr, int l, int r) {
		
		if (l >= r) 
			return;
		
		int p = partion(arr, l, r);
		sort(arr, l, p-1);
		sort(arr, p+1, r);
	}

	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		sort(arr, 0, n-1);
	}

	private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
	
	// 测试QuickSort
	public static void main(String[] args) {
		
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingAdvance.QuickSort.QuickSort", arr);
		SortTestHelper.printArray(arr);
        
		return;
	}

}
