import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static List<List<Integer>> testList;

	public static void sort(List<Integer> list) {
		int swaps = 0;
		for (int i = 1 ; i < list.size() ; i++) {
			int j = i;
			Integer x = list.get(j);
			while (j > 0 && x.compareTo(list.get(j-1)) < 0) {
				list.set(j, list.get(j-1));
				list.set(j-1, x);
				j--;
				swaps++;
			}
		}
		System.out.println(swaps);
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
					list.add(Integer.parseInt(i));
				}
			}
		}
		
		for (List<Integer> list : testList) {
			sort(list);
		}
	}

}
