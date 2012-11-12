

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	private static Integer mergeSwaps;
	private static Integer insertionSwaps;
	
	public static List<String> merge(List<String> left, List<String> right) {
		
		List<String> list = new ArrayList<String>(left.size() + right.size());
		int lIdx = 0, rIdx = 0;
		
		while (lIdx < left.size() && rIdx < right.size()) {
			Integer l = Integer.parseInt(left.get(lIdx));
			Integer r = Integer.parseInt(right.get(rIdx));
			if (l > r) {
				list.add(right.get(rIdx++));
				mergeSwaps += left.size() - lIdx;
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
	
	public static void insertionSort(List<String> list) {
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j > 0; j--) {
				Integer j1 = Integer.parseInt(list.get(j));
				Integer j0 = Integer.parseInt(list.get(j-1));
				if (j1 < j0) {
					list.set(j, j0.toString());
					list.set(j-1, j1.toString());
					insertionSwaps++;
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(System.in));
		int numTests = Integer.parseInt(lnr.readLine());
		
		while (numTests-- > 0) {
			int perm = 0;
			mergeSwaps = 0;
			insertionSwaps = 0;
			
			Integer test = Integer.parseInt(lnr.readLine());  // reads the line with number of values for test
			
			List<String> values = new ArrayList<String>(Arrays.asList(lnr.readLine().split("\\s+")));
			String[] insertionSortArray = new String[values.size()];
			Permutations<String> p = Permutations.create(values.toArray(new String[0]), insertionSortArray);
			
			while (p.next()) {
				mergeSwaps = 0;
				insertionSwaps = 0;
				String[] mergeSortArray = Arrays.copyOf(insertionSortArray, insertionSortArray.length);
				insertionSort(Arrays.asList(insertionSortArray));
				mergeSort(Arrays.asList(mergeSortArray));
				if (!insertionSwaps.equals(mergeSwaps)) {
					System.out.println("Test Length: " + test + ", permutation: " + perm++);
					System.out.println("  Insertion Sort: " + insertionSwaps + ", Merge Sort: " + mergeSwaps);
					System.out.println(Arrays.toString(insertionSortArray));
				}
			}
			
		}
	}
		
}
