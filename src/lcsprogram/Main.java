/*
Main class where the Execution begins
 */

package lcsprogram;

import java.io.*;

/**
 *
 * @author Avinash
 */
public class Main {

    public static void main(String[] args) {
       
    String Path1="left.txt";
    String Path2="top.txt";
    String leftString = null;
    String topString = null;
    String l = null;
    String t = null;
    char[] left;
    char[] top;
    //Read from the first file
    try{

  FileInputStream fstream = new FileInputStream(Path1);
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  while ((strLine = br.readLine()) != null)
  {
      if(l==null)
          l =strLine;
      else
          l=l+strLine;
  }
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }


    //read from the second file

    try{

  FileInputStream fstream = new FileInputStream(Path2);
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
 String strLine;
  while ((strLine = br.readLine()) != null)
  {
      if(t==null)
          t =strLine;
      else
          t=t+strLine;
  }
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }


/*Remove the spaces*/
leftString=l.replaceAll(" ","");
topString=t.replaceAll(" ","");


editdistance d=new editdistance(leftString,topString);
d.normalizedEditDistance();
System.out.println();
LCS L=new LCS(leftString,topString);
L.longestCommonSequence();
System.out.println();
LinearTime lin=new LinearTime();
left=leftString.toCharArray();
top=topString.toCharArray();
lin.lcs_recursive(left,top);
lin.printlcs();



    }

}
