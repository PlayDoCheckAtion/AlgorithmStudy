package SortingAdvance.MergeSort;

import java.util.Arrays;

public class Main {

	// 比较InsertionSort和MergeSort两种排序算法的性能效率
    // 整体而言,MergeSort的性能最优,对于近乎有序的数组的特殊情况,见测试3的详细注释
	public static void main(String[] args) {

		int N = 50000;
		
		// 测试1：一般测试
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);//复制arr1数组元素
		
		SortTestHelper.testSort("SortingAdvance.MergeSort.InsertionSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSort", arr2);

		System.out.println();
		
		// 测试2：有序性更强的测试
		System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
		
		arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
		arr2 = Arrays.copyOf(arr1, arr1.length);//复制arr1数组元素
		
		SortTestHelper.testSort("SortingAdvance.MergeSort.InsertionSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSort", arr2);

		System.out.println();
		
		// 测试3：测试近乎有序的数组
		// 对于近乎有序的数组,数组越有序,InsertionSort的时间性能越趋近于O(n)
		// 所以可以尝试,当swapTimes比较大时,MergeSort更快
		// 但是当swapTimes小到一定程度,InsertionSort变得比MergeSort快
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);//复制arr1数组元素
		
		SortTestHelper.testSort("SortingAdvance.MergeSort.InsertionSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSort", arr2);
		
		return;
	}

}
