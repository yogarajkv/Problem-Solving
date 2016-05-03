package com.map.practice;

public class SortedMatrix {

	public static void main(String[] args) {
		
		int mat[][] = new int[][] { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };

	int x=50;
              int n=4;
              int j=n-1;
              int i=0;
              while(i<n && j>=0){
            	  System.out.println(j);
            	  if (mat[i][j]==x)
            	  {
            		  System.out.println("Found");
            		  return ;
            	  }
            	  else if (mat[i][j]>x)
            		  j--;
            	  else
            		  i++;
              }
              
              System.out.println("Not found");
		

	}

}
