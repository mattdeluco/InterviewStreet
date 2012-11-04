import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Solution {

	private static List<List<Integer>> testList;
	
	public static void countSwaps(List<Integer> list) {
		
		int totalSwaps = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 1 ; i < list.size() ; i++) {
			int swaps = 0;
			
			if (map.containsKey(list.get(i)))
				swaps += map.get(list.get(i));
			
			for (int j = i ; j > 0 ; j--) {
				if (list.get(i).compareTo(list.get(j-1)) < 0)
					swaps++;
				else if (list.get(i).compareTo(list.get(j-1)) == 0)
					break;
			}
			
			totalSwaps += swaps;
			map.put(list.get(i), swaps);
		}
		
		System.out.println(totalSwaps);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = lnr.readLine()) != null) {
			int lineNum = lnr.getLineNumber() - 1;
			if (lineNum == 0) {
				testList = new ArrayList<List<Integer>>(Integer.parseInt(line));
			} else if (lineNum % 2 == 1) {
				testList.add(new ArrayList<Integer>(Integer.parseInt(line)));
			} else {
				List<Integer> list = testList.get((lineNum/2) - 1);
				for (String i : line.split(" ")) {
					list.add(new Integer(Integer.parseInt(i)));
				}
			}
		}
		
		for (List<Integer> list : testList) {
			countSwaps(list);
		}
	}

}
