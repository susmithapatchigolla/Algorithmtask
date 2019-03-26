import java.util.*;
public class army {
 
public  long c;
 public    long d;
  public  long res=0;
 public   long start;
 public  long end;
  
 
  
  
  public long  res() {
    
    Scanner sc = new Scanner(System.in);
    

    int n =sc.nextInt();
    
 
    
     start = sc.nextLong();
     
 
     end= sc.nextLong();
     

     
    TreeMap<Long,Long> tr1=new TreeMap<Long,Long>();
    
    TreeMap<Long,Long> tr2=new TreeMap<Long,Long>();
    for(int i=0;i<n;i++)
    {
        long x = sc.nextLong();
        long p = sc.nextLong();
        tr1.put((x-p),(x+p));
   
}
Map.Entry<Long,Long> temp = tr1.entrySet().iterator().next();
 
     c = temp.getKey();
     d = temp.getValue();
  
    tr1.forEach((key,value)-> {
    if(key<=d){
        d = Math.max(d,value);
    }
    else
    {
        tr2.put(c,d);
        c=key;
        d=value;
    }}
    );
  
    tr2.put(c,d);
 
for(Map.Entry<Long,Long> entry:tr2.entrySet()){
 Long k=entry.getKey();
 long v=entry.getValue();
  if(start>=end)
        {
            start=end;
            break;
        }
         if(k<=start && start<=v)
            start =v;
        else if(start<=k && end>=v )
        {
          res+=k-start;
            start = v;
           
        }
        else if(start<=k && end>=k && end<=v)
        {
          res+=k-start;
            start = v;
           
        }
        
          else if(start<=k &&end<=k)
        {
            res+=end-start;
            start = end;
        }
        
        
 
}
    if(start<end)
        res+=end-start;
    return res;
    
  }
  
  
 
    
      public static void main(String args[]) {
        army indianarmy=new army();
         System.out.println(indianarmy.res());
      }
 
 
 
 
 
 
      
      
}
