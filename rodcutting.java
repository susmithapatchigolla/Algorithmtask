import java.util.*;
 
class rodcutting {
    public static void main(String args[] ) throws Exception {
       int t,input,i,n=0;
       int rod;
       Scanner sc=new Scanner(System.in);
       t=sc.nextInt();
       for(i=0;i<t;i++)
       {
           input=0;
           n=0;
           input=sc.nextInt();
           rod=3;
           while(rod<=input)
           {
              n++;
              rod=rod*2+1;
               
           }
          
           System.out.println(n);
       }
    }
}