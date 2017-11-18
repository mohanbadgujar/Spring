import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MyMap {

	public static void main(String args[]) {
		
		Map<String,String> map = new HashMap<>();
		map.put("name","Mohan");
		map.put("address","Dhule");
		
		
		//It is same as HashMap instead maintains insertion order.
		LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();
		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");		
		
		
		// It is same as HashMap instead maintains ascending order.
		TreeMap<Integer, String> treehm = new TreeMap<Integer, String>();
		treehm.put(100, "Amit");
		treehm.put(102, "Ravi");
		treehm.put(101, "Vijay");
		treehm.put(103, "Rahul");
		
		
		
		//A Hashtable is an array of list. Each list is known as a bucket. The position of bucket is identified by calling the hashcode() method. A Hashtable contains values based on the key.
		//It is synchronized.
		  Hashtable<Integer,String> ht=new Hashtable<Integer,String>();  
		  
		  ht.put(100,"Amit");  
		  ht.put(102,"Ravi");  
		  ht.put(101,"Vijay");  
		  ht.put(103,"Rahul");  
		
		
		
		
		System.out.println("Values before remove: " + map);
		// Remove value for key 102
		map.remove("name");
		System.out.println("Values after remove: " + map);
		
		
		
		/*Set<String> key = map.keySet();
		
		for(String keys : key)
		{
			System.out.println(keys+" "+map.get(keys));	
		}*/
		
	}
}
