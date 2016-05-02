package com.map.practice;

import java.util.Random;

/*
 * shuffle the array of songs with no songs repeated in the array
 * Time complexity is O(n) 
 */
public class ShuffleSongs {

	public static void main(String[] args) {

		int[] a = new int[]{1,2,3,4,5,6};
		
		Random r  = new Random();
		int i=0;
		for(int count = 1;count<=6;count++)
		{
			int index = r.nextInt(6-i)+i;
			System.out.println("Playing song :"+ a[index]+":"+index);
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
			i++;
		}
	}

}
