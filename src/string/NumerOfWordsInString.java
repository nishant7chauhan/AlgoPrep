package string;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class NumerOfWordsInString {
	
	HashMap<String,Integer> res = new HashMap<>();
	
	 void calculateCount(String s1) {
		
		for(String s : s1.split(" ")) {
			if(res.containsKey(s)) {
				res.put(s, res.get(s)+1);
			}
			else
				res.put(s, 1);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "My name is my name and name and and and";
		NumerOfWordsInString obj = new NumerOfWordsInString();
		obj.calculateCount(s);
		
		int value = Collections.max(obj.res.values());
		for (Entry<String, Integer> entry : obj.res.entrySet()) {  
            if (entry.getValue()==value) {
                System.out.println(entry.getKey() + ": " + value);   
            }
        }

	}


}
