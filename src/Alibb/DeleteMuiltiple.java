package Alibb;

import java.util.Scanner;

public class DeleteMuiltiple {
	/*阿里笔试题1，去重复得单词，三个或三个以上得去重，数字不去重*/
	  static boolean flag=false;
	  public static void main(String[] args) {
		  Scanner in=new Scanner(System.in);
	      String s=in.nextLine();
	      int len=s.length();
	      if(len<=2) {
	    	  System.out.println(s);
	    	  return;
	      }
	      while(!flag) {
	       s=sub(s);
	      }
	      System.out.println(s);
	  }
	  
	  
	  public static String sub(String s) {
		  char[] ca=s.toCharArray();
		  int len=s.length();
		  if(len<2) {
			  flag=true;
			  return s;
		  }
	      String str=s.toString();
	      int index=0;
	      int i=0;
	      for(;i<len;i++) {
	    	  if(ca[i]<='9'&&ca[i]>='0')  {
	    		  index=i+1;
	    		  continue;
	    	  }
	    	  int j=i;
	    	  int start=s.substring(index,i).indexOf(ca[i]+"");
	    	  int l=0;
	    	  while(start>=0) {
	    		  if(j+j-start<=len&&s.substring(start,j).equals(s.substring(j,j+j-start))) {
	    				  l++;
	    				  int temp=j;
	    				  j=j+j-start;
	    				  start=temp;
	    		  }
	    		  else {
	    			  start=s.substring(index,i).indexOf(ca[i]+"",start+1);
	    			  if(l>=2) { 
	    				  str=str.substring(0, i)+str.substring(j,len);
	    				  break;
  				  }
	    			  l=0;
	    		  }
	    	  }
	      }
	     if(i==len) flag=true;
	     return str;
	  }
}
