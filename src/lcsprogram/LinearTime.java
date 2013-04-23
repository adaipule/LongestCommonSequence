/*
 This class computes and returns the longest common subsequence of two sequences.
 The LCS is computed using the recursive linear memory algorithm.
 */

package lcsprogram;

import java.util.*;

/**
 *
 * @author Avinash
 */
public class LinearTime {
         private    Vector<Character> s;
            public LinearTime()
            {
                s=new Vector<Character>();
            }


public int ComputeMiddle(char[] left,char[] top){
    int topLength=top.length;
    int leftLength=left.length;
    int horizontalSplit=(leftLength/2);
    int row,col;
    int [][] table1=new int[2][topLength+1];//upper table
    int [][] table2=new int[2][topLength+1];//lower tabel



    /*compute the forward middle row */
       //initialize the column
        for(col=0;col<topLength+1;col++)
        {
            table1[0][col]=col;
        }

        //start building the table using two rows
        for(row=1;row<=horizontalSplit;row++)
        {
            table1[1][0]=row;//initilize the rwo
            for(col=1;col<topLength+1;col++)
            {
                if(top[col-1]==left[row-1])
                {
                    table1[1][col]=table1[0][col-1];
                }
                else{
                    if(table1[0][col]<=table1[1][col-1])
                    {
                        table1[1][col]=table1[0][col]+1;
                    }
                    if(table1[1][col-1]<table1[0][col])
                    {
                        table1[1][col]=table1[1][col-1]+1;
                    }
                }
            }//end of for loop of top length

         //now shift the lower row to upper row a
            for(col=0;col<topLength+1;col++)
            {
                table1[0][col]=table1[1][col];
            }
        }//end of forloop  left length



    /*This is used to calculate the reverse middle row*/
    //initializ
      for(col=0;col<topLength+1;col++)
        {
            table2[0][col]=col;
        }

      //start building the table using two rows
    int size=left.length-horizontalSplit;
    for(row=1;row<=size;row++)
        {
            table2[1][0]=row;
            for(col=1;col<topLength+1;col++)
            {
               if(top[topLength-col]==left[leftLength-row])
                {
                    table2[1][col]=table2[0][col-1];
                }
                else{
                    if(table2[0][col]<=table2[1][col-1])
                    {
                        table2[1][col]=table2[0][col]+1;
                    }
                    if(table2[1][col-1]<table2[0][col])
                    {
                        table2[1][col]=table2[1][col-1]+1;
                    }
                }
            }//end of for loop of top length

         //now shift the lower row to upper row a
            for(col=0;col<topLength+1;col++)
            {
                table2[0][col]=table2[1][col];
            }
        }//end of forloop  left length


       
//This finds the vertical split index using forwardmiddle row and reverse middle row
    int min=table1[1][0]+table2[1][topLength];
    int splitindex=0;
    for(col=0;col<=topLength;col++)
    {
        if((table1[1][col]+table2[1][topLength-col])<=min)
        {
            min=table1[1][col]+table2[1][topLength-col];
            splitindex=col;
        }

    }

return splitindex-1;

}//end of function Compute Middle



void lcs_recursive(char[] X,char[] Y)
{
    int x,y;
    char[] Xfront;
    char[] Yfront;
    char[] Xback ;
    char[] Yback ;

//check if the lenght of the string X is one
    if(X.length==1)
    {
        for(int i=0;i<Y.length;i++)
        {
            if(X[0]==Y[i])
            {
                s.add(X[0]);
                break;
            }
        }
    }

 //check if the length of the string Y is one
    else if(Y.length==1)
    {
        for(int i=0;i<X.length;i++)
        {
            if(Y[0]==X[i])
            {
                s.add(Y[0]);
                break;
            }
        }
    }//end of the if


    else{
        x=X.length/2-1;
        //compute the vertical split
        y=ComputeMiddle(X,Y);
        int i;
        Xfront=new char[x+1];
        //calculate the xfront
        for( i=0;i<=x;i++)
        {
            Xfront[i]= X[i];
        }
        //calculate the yfront
        Yfront=new char[y+1];
        for(i=0;i<=y;i++)
        {
            Yfront[i]=Y[i];
        }
        int j=0;
        int size=X.length-(x+1);
        //calculate xback
        Xback=new char[size];
        for(i=x+1;i<=X.length-1;i++)
        {
            Xback[j]=X[i];
            j++;
        }

        j=0;
        size=Y.length-(y+1);
        //calculate yback
        Yback=new char[size];
        for(i=y+1;i<=Y.length-1;i++)
        {
            Yback[j]=Y[i];
            j++;
        }
     lcs_recursive(Xfront,Yfront);
     lcs_recursive(Xback,Yback);


    }//end of the else



}//end of the lcs_recursive

void printlcs()
{
System.out.println("The LOngest Common Sequence using linear programming");
for(int i=0;i<s.size();i++)
{
System.out.print(s.elementAt(i)+" ");
}
System.out.println();

}//end printlcs


}//end of class Linear Time

