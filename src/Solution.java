import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
		int numTests = Integer.parseInt(lnr.readLine());
		
		while (numTests-- > 0) {
			
			Integer numValues = Integer.parseInt(lnr.readLine());
			String[] values = lnr.readLine().split(" ");
			
			int totalCount = 0;
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			for (int i = 0; i < values.length && i < numValues; i++) {
				
				Integer v = Integer.parseInt(values[i]);
				totalCount += set.tailSet(v, false).size();
				set.add(v);
				
			}
			
			System.out.println(totalCount);
			
		}
		
	}

}
