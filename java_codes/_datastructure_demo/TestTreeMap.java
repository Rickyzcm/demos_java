package _datastructure_demo;

import java.util.*;

public class TestTreeMap {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("c","cat");
		map.put("b","banana");
		map.put("a","apple");
		map.put("d","dior");
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()) {
			Object key = iter.next();
			System.out.println("map key "+key.toString()+" value="+map.get(key));
		}
		TreeMap tab = new TreeMap();
		tab.put("c","cat");
		tab.put("b","banana");
		tab.put("a","apple");
		tab.put("d","dior");
		
		Iterator iter2 = map.keySet().iterator();
		while(iter2.hasNext()) {
			Object key = iter2.next();
			System.out.println("map key "+key.toString()+" value="+map.get(key));
		}
	}
}

