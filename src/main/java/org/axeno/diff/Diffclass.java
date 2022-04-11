package org.axeno.diff;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Diffclass {
	
	  public int max(int a, int b) { return (a > b)? a : b; }
	 
	public List<List<String>> diffwbyw(List<String> oldtxt,List<String> newtxt) {
        int m = oldtxt.size()+1;
        int n = newtxt.size()+1;
		int[][] grid = new int [m][n];
		for (int i=0; i<m; i++)
	    {
	    for (int j=0; j<n; j++)
	    {
	        if (i == 0 || j == 0) 
	        {  grid[i][j] = 0; }
	        
	        else if(oldtxt.get(i-1).equals(newtxt.get(j-1)))
	               { grid[i][j] = grid[i-1][j-1] + 1;}
	        
	        else
	          {  grid[i][j] = max(grid[i][j-1],grid[i-1][j]);   }
	     }
	   }
		List<List<String>> ans=new ArrayList<List<String>>();
		int i=m-1,j=n-1;
		while(i>0 || j>0) {
			
			if(i==0) {
				  List<String> temp = new ArrayList<String>(2);
				  temp.add(" "+newtxt.get(j-1));
				  temp.add("2");
				  ans.add(temp);
				  j--;
			}
			
			else if(j==0) {
				  List<String> temp = new ArrayList<String>(2);
				  temp.add(" "+oldtxt.get(i-1));
				  temp.add("1");
				  ans.add(temp);
				  i--;
			}
			
			else if(oldtxt.get(i-1).equals(newtxt.get(j-1))) {
			  List<String> temp = new ArrayList<String>(2);
			  temp.add(" "+oldtxt.get(i-1));
			  temp.add("0");
			  ans.add(temp);
              i--;
              j--;
          }
			
          else if (grid[i-1][j] > grid[i][j-1]) {
			  List<String> temp = new ArrayList<String>(2);
			  temp.add(" "+oldtxt.get(i-1));
			  temp.add("1");
			  ans.add(temp);
              i--;
          }
			
          else {
        	  List<String> temp = new ArrayList<String>(2);
			  temp.add(" "+newtxt.get(j-1));
			  temp.add("2");
			  ans.add(temp);
			  j--;
          }
      }
		Collections.reverse(ans);
		return ans;
  }
		
}

