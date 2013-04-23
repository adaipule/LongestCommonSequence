/*
 This class computes and returns the longest common subsequence of two sequences.
 The LCS is computed using  the basic dynamic programming algorithm that
 stores the entire table in memory.
 */

package lcsprogram;

/**
 *
 * @author Avinash
 */
import java.util.*;
public class LCS {

         private  char[] top;
         private    char[] left;
         private    int[][] table;
         private    int topLength;//length of the secondstring
         private    int leftLength;//length of the first string
         private    Vector<Character> s;
            public LCS(String s1,String s2)
            {
                 left=s1.toCharArray();
                 top=s2.toCharArray();
                 topLength=top.length;
                 leftLength=left.length;
                 table=new int[leftLength+1][topLength+1];
                 s=new Vector<Character>();
            }



    public void createTable(){

        int i,j,col,row;
        //initialize
        for(row=0;row<leftLength+1;row++)
        {
              table[row][0]=row;
        }
        for(col=0;col<topLength+1;col++)
        {
            table[0][col]=col;
        }
        

        //start building the table 
        for(row=1;row<=leftLength;row++)
        {
     
            for(col=1;col<topLength+1;col++)
            {
                if(top[col-1]==left[row-1])
                {
                    table[row][col]=table[row-1][col-1];
                }
                else{
                    if(table[row-1][col]<=table[row][col-1])
                    {
                        table[row][col]=table[row-1][col]+1;
                    }
                    if(table[row][col-1]<table[row-1][col])
                    {
                        table[row][col]=table[row][col-1]+1;
                    }
                }
            }//end of for loop of col

         
        }//end of forloop  row

   }//end of the create table


public void longestCommonSequence()
{
   createTable();
    int row,col;
    row=leftLength;
    col=topLength;
    while(row>0&&col>0)
    {
        //comare the charater
        if(left[row-1]==top[col-1])
        {
            s.add(Character.valueOf(left[row-1]));
            row--;
            col--;
        }
        else{
            if(table[row-1][col]<table[row][col-1])
            {
                row--;
            }
            else
             {
                col--;
             }
        }
   }//end of while
System.out.println("The LOngest Common Sequence by using table");
for(int i=s.size()-1;i>=0;i--)
{
System.out.print(s.elementAt(i)+" ");
}
System.out.println();
}//end of longest Common Sequence


}//end of the class LCS


