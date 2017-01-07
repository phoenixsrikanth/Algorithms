import java.util.Arrays;
import java.util.*;

/* 
	Selection Sort: Sorts integers with O(N^2) runtime.
	Insertion Sort: Sorts integers with O(N^2) runtime on average.
	While the best runtime for Insertion Sort is O(N).
	
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

public class Selection_Insertion_Sort {

	public static int[] selectionSort(int[] list){
		
		for (int i=0; i< list.length; i++){
			int min = i;
			
			for (int j = i+1; j<list.length; j++){
				if (less(list[j], list[min])){
					min = j;
					exchange(list, i, min);
				}
			}
		}
		return list;
	}
	
	public static int[] InsertionSort(int[] list){
		
		for (int i=1; i<list.length; i++){
			
			for  (int j=i; j>0 && less(list[j], list[j-1]); j--){
				exchange(list, j, j-1);
			}
		}
		return list;
	}

	
	private static boolean less(int i, int j) {
		if (i < j){
			return true;
		}
		return false;
	}
	
	public static void exchange(int[] list, int i, int j){
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
	}
	public static boolean checker(int[] a){
		for (int i=0; i< a.length-1; i++){
			if (less(a[i+1], a[i])){
				return false;
			}
		}
		return true;
	}

	public static void display(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i]);
			System.out.print(", ");
		}
	}
	
	public static void main(String[] args){
		int Max = 3;
		int[] arrList = new int[Max];
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<arrList.length; i++){
			arrList[i] = scan.nextInt();			
		}
		
	    InsertionSort(arrList);
	    display(arrList);
		
		}
}
