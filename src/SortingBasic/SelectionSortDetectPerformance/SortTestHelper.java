package SortingBasic.SelectionSortDetectPerformance;

import java.lang.reflect.Method;

public class SortTestHelper {

	//SortTestHelper不允许产生任何实例
	private SortTestHelper() {};
	
	//生成有n个元素的随机数组，每个元素的随机范围为[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
		
		//assert [boolean表达式] //断言
		//如果[boolean表达式]为true，则程序继续执行。如果为false，则程序抛出AssertionError，并终止执行。
		assert rangeL <= rangeR;
		
		Integer[] arr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));//随机生成[rangeL, rangeR]内的元素
		}
		
		return arr;
	}
	
	//打印arr数组的所有内容
	public static void printArray(Object arr[]) {
		
		for (Object obj : arr) {
			System.out.print(obj+" ");
		}
		System.out.println();
		
		return;
	}
	
	//判断arr数组是否有序
	public static boolean isSorted( Comparable[] arr) {
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i+1]) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	//测试sortClassName所对应的排序算法排序arr数组所得到的结果的正确性和算法运行时间
	public static void testSort(String sortClassName, Comparable[] arr) {
		
		//通过Java的反射机制，通过排序的类名，运行排序函数
		try {
			// 通过sortClassName获得排序函数的Class对象
			Class sortClass = Class.forName(sortClassName);
			// 通过排序函数的Class对象获得名为 sort 的排序方法
			Method sortMethod = sortClass.getMethod("sort", new Class[] {Comparable[].class});
			// 排序参数只有一个，是可比较数组arr
			Object[] params = new Object[] {arr};
			
			long startTime = System.currentTimeMillis();
			//调用排序函数
			sortMethod.invoke(null, params);
			long endTime = System.currentTimeMillis();
			
			assert isSorted( arr );
			
			System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
