import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
		int numTests = Integer.parseInt(lnr.readLine());
		
		while (numTests-- > 0) {
			
			Integer numValues = Integer.parseInt(lnr.readLine());
			
			int totalCount = 0;
			String[] values = lnr.readLine().split(" ");
			List<Integer> list = new LinkedList<Integer>();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for (int i = 0; i < values.length && i < numValues; i++) {
				
				Integer v = Integer.parseInt(values[i]);
				Integer swaps = map.containsKey(v) ? map.get(v) : new Integer(0);
				
				ListIterator<Integer> iter = list.listIterator(list.size());
				while (iter.hasPrevious()) {
					Integer p = iter.previous();
					if (v.compareTo(p) < 0)
						swaps++;
					else if (v.compareTo(p) == 0)
						break;
				}
				
				list.add(v);
				map.put(v, swaps);
				totalCount += swaps;
				
			}
			
			System.out.println(totalCount);
			
		}
		
	}

}
