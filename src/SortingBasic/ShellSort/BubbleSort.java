package SortingBasic.ShellSort;

public class BubbleSort {

	//算法类不允许产生任何实例
	private BubbleSort() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		boolean swapped = false;
		
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (arr[i-1].compareTo(arr[i]) > 0) {
					swap(arr, i-1, i);
					swapped = true;
				}
			}
			//优化，每一趟Bubble Sort都将最大的元素放在了最后的位置
			//所以下一次排序，最后的元素可以不再考虑
			n--;
		} while (swapped);
		
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 测试InsertionSort
	public static void main(String[] args) {
		
		// 测试排序算法辅助函数
		int N = 20000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingBasic.BubbleSort.BubbleSort", arr);
        
		return;
	}

}
