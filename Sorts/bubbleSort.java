package sorting;
import java.util.*;
import java.util.Arrays;

/* 
	Bubble Sort: Sorts integer with O(N^2) runtime on average.
	While the best case is O(N). This program sorts One million 
	integers with a timer to show the implementation of Bubble
	Sort.
	
	**WARNING** Make sure you run this program on a powerful machine
	or decrease maxSize value to small number.
	
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

public class bubbleSort {

	static int maxSize = 1000000;
	
	public static void main(String[] args){
		
		int[] toSort = new int[maxSize];
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<toSort.length; i++){
			toSort[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		
		long Start = System.currentTimeMillis();
		bubbleSort(toSort);
		long Stop = System.currentTimeMillis();
		
		show(toSort);
		System.out.println(Stop-Start);
	}

	public static int[] bubbleSort(int[] a){
		
		for (int i = 0; i<a.length-1; i++){
			for (int j=0; j <a.length-1-i; j++){
				if (less(a[j+1], a[j])){
					exchange(a, j+1, j);
				}
			}
		}
		return a;
	}
	
	public static void exchange(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean less(int i, int j){
		if (i<j)
			return true;
		else
			return false;
	}
	
	public static void show(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i] + ", ");
		}
	}
}
