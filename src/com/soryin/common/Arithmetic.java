package com.soryin.common;

/**
 * 排序算法
 *  @author soryin
 * */
public class Arithmetic {
	
	/**
	 * 二分插入查询
	 * */
	public void binaryInsertongSort(Long[] array){
		 for (int i = 0; i < array.length; i++)
         {
             int start, end, mid;
             start = 0;
             end = i - 1;
             mid = 0;
             long temp = array[i];
             while (start <= end)
             {
                 mid = (start + end) / 2;
                 if (array[mid] > temp)					//要排序元素在已经排过序的数组左边
                 {
                     end = mid - 1;
                 }
                 else
                 {
                     start = mid + 1;
                 }
             }
             for (int j = i - 1; j > end; j--)			//找到了要插入的位置，然后将这个位置以后的所有元素向后移动

             {
                 array[j + 1] = array[j];
             }
             array[end + 1] = temp;
             

         }
		 for (Long long1 : array) {
			System.out.println(long1);
		}
		
	}
	/**
	 * 冒泡排序,从小到大
	 * @param 长整形数组
	 * @return 最小的元素
	 * */
	public static Long bubbleSort(Long[] arg){
		long temp;
		for (int i = 0; i < arg.length-1; i++) {					//-1是因为最后一个没必要再跟它本身比较
			for (int j = 0; j < arg.length-i-1 ; j++) {				//嵌套循环，形成逐一对比
				if (arg[j] > arg[j+1]) {										//小元素换位
				temp = arg[j];
				arg[j] = arg[j+1];
				arg[j+1] = temp;
				}
			}
		
		}
		return arg[0];
	}
	/**
	 * 冒泡排序,从大到小
	 * @param 长整形数组
	 * @return 最大的元素
	 * */
	public static Long max_BubbleSort(Long[] arg){
		long temp;
		for (int i = 0; i < arg.length-1; i++) {					//-1是因为最后一个没必要再跟它本身比较
			for (int j = 0; j < arg.length-i-1 ; j++) {				//嵌套循环，形成逐一对比
				if (arg[j] < arg[j+1]) {										//大元素换位
				temp = arg[j];
				arg[j] = arg[j+1];
				arg[j+1] = temp;
				}
			}
		
		}
		return arg[0];
	}
}
