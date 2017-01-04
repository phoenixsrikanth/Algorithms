import java.util.*;

/* 
	Heap Sort: Sorts integer with O(n log(n)) runtime.
	This program sorts One million integers with a 
	timer to show the implementation of Heap Sort.

	Copyright (C) 2017 Srikanth Goli (https://github.com/phoenixsrikanth/)

	This program is free software; you can redistribute it and/or
	modify it under the terms of the GNU General Public License
	as published by the Free Software Foundation; either version 2
	of the License, or (at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program; if not, write to the Free Software
	Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

public class heapSort {

	public static int Max = 1000000;
	
	public static void main(String[] args){
		Random rand = new Random();
		int[] numbersToSort = new int[Max];
		for (int i=1; i<numbersToSort.length; i++){
			numbersToSort[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		long Start = System.currentTimeMillis();
		sort(numbersToSort);
		long Stop = System.currentTimeMillis();
		
		show(numbersToSort);
		System.out.println(Stop-Start);
	}
	
	public static void show(int[] a){
		for (int i=1; i<a.length; i++){
			System.out.print(a[i] + ", " );
		}
	}
	
	public static void sort(int[] a){
		
		int len = a.length-1;
		for (int i = len/2; i>=1; i--){
			sink(a, i, len);
		}
		while (len>1){
			exchange(a, 1, len--);
			sink(a, 1, len);
		}
	}
	
	// Re-arrange the heap property.
	public static void sink(int[] arr, int k, int len){
		
		int N = len;
		
		while (2*k <= N){
			int j = 2*k;
			if (j<N && less(arr[j], arr[j+1])){
				j++;
			}
			if (!less(arr[k], arr[j]))
				break;
			exchange(arr, k, j);
			k = j;
		}
	}
	
	public static void exchange(int[] k, int i, int j){
		int temp = k[i];
		k[i] = k[j];
		k[j] = temp;
	}
	
	public static boolean less(int i, int j){
		if (i<j)
			return true;
		else 
			return false;
	}
}
