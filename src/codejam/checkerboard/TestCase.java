package codejam.checkerboard;

import java.util.Arrays;

public class TestCase {

	private final int n;
	private final boolean[][] matrix;

	public TestCase(TestCaseBuilder builder) {
		this.n = builder.n;
		this.matrix = builder.matrix;
	}

	public void print() {

		System.out.println("TestCase n = " + n);
		for (boolean[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}

	}

	/**
	 * 
	 * @return -1 for IMPOSSIBLE or minimum number of steps
	 */
	
	public int toCheckerboard() {
		
		int swaps = 0;
		int needToSwap = -1;
		
		for (int i = 0; i != n * 2; ++i) {
			boolean actual = matrix[i][0];
			boolean expected = i % 2 == 1;
			
			if (actual != expected) {
				
				if (needToSwap == -1) {
					needToSwap = i;
				}
				else {
					boolean[] tmp = matrix[needToSwap];
				  matrix[needToSwap] = matrix[i];
				  matrix[i] = tmp;
				  swaps++;
				  needToSwap = -1;
				}
			}
			
		}

		if (needToSwap != -1) {
			return -1;
		}
		
		
		for (int i = 0; i != 2 *n; ++i) {
			boolean actual = matrix[0][i];
			boolean expected = i % 2 == 1;
			
			if (actual != expected) {
				
				if (needToSwap == -1) {
					needToSwap = i;
				}
				else {
					
					boolean[] tmp = new boolean[n * 2];
					
					for (int j = 0; j != 2 * n; ++j) {
						tmp[j] = matrix[j][needToSwap];
					}

					for (int j = 0; j != 2 * n; ++j) {
						matrix[j][needToSwap] = matrix[j][i];
					}

					for (int j = 0; j != 2 * n; ++j) {
						matrix[j][i] = tmp[j];
					}

				  swaps++;
				  needToSwap = -1;
				}
			}
			
		}
		
		if (needToSwap != -1) {
			return -1;
		}
		
		return swaps;
	}
	
	public boolean validate() {
		
		for (int col = 0; col != n * 2; ++col) {
			
			for (int row = 0; row != n * 2; ++row) {
				boolean actual = matrix[row][col];
				boolean expected = (row % 2 == 1) ^ (col % 2 == 1);
				
				if (actual != expected) {
					return false;
				}
			}
			
		}
		
		return true;
	}
	
	
	public static class TestCaseBuilder {

		private final int n;
		private final boolean[][] matrix;
		private int i = 0;

		public TestCaseBuilder(int n) {
			this.n = n;
			this.matrix = new boolean[2 * n][];
		}

		public TestCaseBuilder addRow(boolean[] row) {
			if (i < matrix.length) {
				this.matrix[i++] = row;
			}
			return this;
		}

		public TestCase build() {
			return new TestCase(this);
		}
	}
}
