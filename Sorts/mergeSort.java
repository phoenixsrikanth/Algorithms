import java.util.Arrays;
import java.util.*;

/* 
	Merge Sort: Sorts integer with O(n log(n)) runtime.
	This program sorts One million integers with a 
	timer to show the implementation of Merge Sort.

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

public class mergeSort {
	private static int MAX = 1000000;
	public static int[] helper;
		
	public static void main(String[] args){
		Random rand = new Random();
		int[] toSort = new int[MAX];
		for (int i=0; i<=toSort.length - 1; i++){
			toSort[i] = rand.nextInt(Integer.MAX_VALUE); 
		}
		sort(toSort);
		show(toSort);		
	}

	public static void show(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i]);
			System.out.print(", ");
		}
	}
	
	public static void sort(int[] a){
		
		helper = new int[a.length];
		mergeSort(a, 0, a.length-1);
		}
		
	private static void mergeSort(int[] list, int low, int hi){
		if (hi<=low){
			return;
		}
		int mid = low + (hi - low)/2;
		mergeSort(list, low, mid);
		mergeSort(list, mid+1, hi);
		merge(list, low, mid, hi);
		
	}
	
	private static boolean less(int i, int j) {
		if (i < j){
			return true;
		}
		return false;
	}
	
	public static void merge(int[] list, int lo, int mid, int hi){
		
		int i =lo;
		int j = mid+1;
		

		for (int k = lo; k<=hi; k++){
			helper[k] = list[k];
		}
		
		for (int k=lo; k<=hi; k++){
			if (i > mid){
				list[k] = helper[j];
				j++;
			}
			else if(j > hi){
				list[k] = helper[i];
				i++;
			}
			else if (less(helper[j], helper[i])){
				list[k] = helper[j];
				j++;
			}
			else {
				list[k] = helper[i];
				i++;
			}
		}
	}
}
