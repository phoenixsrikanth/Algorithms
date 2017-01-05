import java.util.*;
import java.util.Arrays;

/* 
	Quick Sort: Sorts integer with O(n log(n)) runtime.
	This program sorts One million integers with a 
	timer to show the implementation of QuickSort.

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

public class quickSort {
	public static final int Max = 1000000;
	public static void main(String[] args){
		int[] toSort = new int[Max];
		Random rand = new Random();
		
		for (int i=0; i<toSort.length; i++){
			toSort[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		long Start = System.currentTimeMillis();
		quickSort(toSort);
		long Stop = System.currentTimeMillis();
		
		show(toSort);
		System.out.println(Stop-Start);
	}
	
	public static void quickSort(int[] a){
		
		sort(a, 0, a.length-1);
	}
	
	public static void sort(int[] a, int low,int hi){
		
		if (hi <= low){
			return;
		}
		int j = quick(a, low, hi);
		sort(a, low, j-1);
		sort(a, j+1, hi);
	}
	
	public static int quick(int[] a, int low, int hi){
		int i = low;
		int j = hi+1;
		int breaker = a[low];
		while(true){
			while (less(a[++i], breaker)){
				if (i == hi){
					break;
				}
			}
			while (less(breaker, a[--j])){
				if (j == low){
					break;
				}
			}
			if (i>= j){
				break;
			}
			exchange(a, i, j);
		}
		exchange(a, low, j);
		return j;
	}
	
	public static void show(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i]);
			System.out.print(", ");
		}
	}
	
	public static void exchange(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean less(int i, int j){
		if (i<=j){
			return true;
		}
		else {
			return false;
		}
	}
}
