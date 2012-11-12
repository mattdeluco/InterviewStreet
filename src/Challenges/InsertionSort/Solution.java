import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	private static Long swapCount;
	
	public static List<String> merge(List<String> left, List<String> right) {
		
		List<String> list = new ArrayList<String>(left.size() + right.size());
		int lIdx = 0, rIdx = 0;
		
		while (lIdx < left.size() && rIdx < right.size()) {
			Integer l = Integer.parseInt(left.get(lIdx));
			Integer r = Integer.parseInt(right.get(rIdx));
			if (l > r) {
				list.add(right.get(rIdx++));
				swapCount += left.size() - lIdx;
			} else {
				list.add(left.get(lIdx++));
			}
		}
		
		list.addAll(left.subList(lIdx, left.size()));
		list.addAll(right.subList(rIdx, right.size()));
		
		return list;
		
	}
	
	public static List<String> mergeSort(List<String> list) {
		if (list.size() <= 1) return list;
		
		List<String> left = list.subList(0,  list.size()/2);
		List<String> right = list.subList(list.size()/2, list.size());
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}

	public static void main(String[] args) throws IOException {
		
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
		int numTests = Integer.parseInt(lnr.readLine());
		
		while (numTests-- > 0) {
			swapCount = 0L;
			
			Integer numValues = Integer.parseInt(lnr.readLine());
			List<String> values = new ArrayList<String>(Arrays.asList(lnr.readLine().split("\\s+")));
			
			mergeSort(values);
			
			System.out.println(swapCount);
		}
		
	}

}
