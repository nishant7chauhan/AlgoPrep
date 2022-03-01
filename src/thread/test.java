package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test {
    public static void main(String args[]) {
List<Integer> list = new ArrayList<>();

list.add(3);
list.add(1);
list.add(2);
list.add(3);

for(int i =0;i<list.size();i++){
	
	System.out.print(Integer.bitCount(list.get(i))+" --> "+ list.get(i) + " ");
	
   
    
}
System.out.print("\n ");

Collections.sort(list,new Comparator<Integer>(){
   public int compare(Integer o1, Integer o2){
       if(Integer.bitCount(o1) < Integer.bitCount(o2)){
           return -1;
       }else return 1;
   }
    
});

for(int i =0;i<list.size();i++){
	
	System.out.print(Integer.bitCount(list.get(i))+" --> "+ list.get(i) + " ");
    
}


    }
}
