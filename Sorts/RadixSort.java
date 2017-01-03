import java.util.*;

/* 
	RadixSort: Sorts integer with O(N*M) runtime.
	where N is size of Array and M is number of digits
	in an maximum element of an Array.
	
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


public class RadixSort {
	static int maxSize = 1000000;
	public static void main(String[] args){
		Random rand = new Random();
		int[] arrayToSort = new int[maxSize];
		
		for (int i=0; i<arrayToSort.length; i++){
			arrayToSort[i] = rand.nextInt(Integer.MAX_VALUE);
			}
		
		long start = System.currentTimeMillis();
		sort(arrayToSort);
		long stop = System.currentTimeMillis();
		
		show(arrayToSort);
		System.out.println(stop-start);
		
	}
	
	public static int[] sort(int[] a){
		// Place gets the position of a number
		for (int place=1; place<=1000000000; place *= 10){
			countingSort(a, place);
		}
		return a;
	}
	
	public static int[] countingSort(int[] a, int place){
		
		int[] output = new int[a.length];
		int[] count = new int[10];
		
		// Gets the count of numbers
		for (int i=0; i<a.length; i++){
			int digit = getValue(a[i], place);
			count[digit] += 1;
		}
		
		// Adds count[i-1] value to count[i];
		for (int j=1; j<count.length; j++){
			count[j] += count[j-1];
		}
		
		// Sorts array
		for (int k=a.length-1; k>=0; k--){
			int digit = getValue(a[k], place);
			output[ count[digit] - 1] = a[k];
			count[digit]--;
		}
		// Copies output array back to original array
		for (int i=0; i<a.length; i++){
			a[i] = output[i];
		}
		return a;
	}
	
	public static int getValue(int i, int place){
		return ((i/place) % 10);
	}
	
	public static void show(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(a[i] + ", ");
		}
	}
}
