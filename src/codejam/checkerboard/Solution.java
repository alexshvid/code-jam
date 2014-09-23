package codejam.checkerboard;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import codejam.checkerboard.TestCase.TestCaseBuilder;

public class Solution {

	private int testCasesNum;

	private List<TestCase> testCases = new ArrayList<TestCase>();

	public void run() throws Exception {

		readTestCases(new BufferedReader(new InputStreamReader(System.in)));

		//print();

		solve();
		
	}

	public void solve() {
		
		int c = 1;
		for (TestCase testCase : testCases) {
			int steps = testCase.toCheckerboard();
			boolean valid = steps == -1 ? false : testCase.validate();
			if (steps == -1 || !valid) {
				System.out.println("Case #" + c + ": IMPOSSIBLE");
			}
			else {
				System.out.println("Case #" + c + ": " + steps);
			}
			c++;
		}
	}
	
	public void print() {
		System.out.println("testCasesNum = " + testCasesNum);
		for (TestCase testCase : testCases) {
			testCase.print();
			int steps = testCase.toCheckerboard();
			System.out.println("steps = " + steps);
			System.out.println("validate = " + testCase.validate());
			testCase.print();
		}
	}

	public void readTestCases(BufferedReader reader) throws Exception {

		this.testCasesNum = Integer.parseInt(reader.readLine());

		for (int i = 0; i != testCasesNum; ++i) {

			int n = Integer.parseInt(reader.readLine());

			TestCaseBuilder builder = new TestCaseBuilder(n);

			for (int j = 0; j != 2 * n; ++j) {

				boolean[] row = new boolean[2 * n];

				String line = reader.readLine();

				for (int col = 0; col != 2 * n; ++col) {
					char ch = line.charAt(col);
					if ('1' == ch) {
						row[col] = true;
					} else if ('0' == ch) {
						row[col] = false;
					} else {
						new IllegalArgumentException("invalid line = " + line);
					}
				}

				builder.addRow(row);

			}

			testCases.add(builder.build());
		}

	}

	public static void main(String[] args) {

		//System.out.println("Checkerboard matrix " + Arrays.toString(args));

		try {
			
			if (args.length > 0) {
				System.setIn(new FileInputStream(args[0]));
			}
			
			if (args.length > 1) {
				System.setOut(new PrintStream(new FileOutputStream(args[1])));
			}
			
			new Solution().run();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
