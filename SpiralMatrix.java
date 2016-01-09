/* SpiralMatrix.java
 * Print the input matrix in spiral order */

import java.util.ArrayList;

public class SpiralMatrix {
	/* O(n) space solution */
	public void printSprial(int[][] mat) {

		// Input checking
		if (mat == null)
			throw new NullPointerException("Null Input Matrix");
		if (mat.length <= 0)
			throw new NegativeArraySizeException("Input Matrix is empty or invalid");
		if (mat[0] == null)
			throw new NullPointerException("Matrix contains null row");
		
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		int[] result = new int[mat.length*mat[0].length];

		int direction = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		while(k < result.length) {
			visited[i][j] = true;	
			result[k] = mat[i][j];
			direction = whichWay(direction, mat.length, mat[0].length, visited, i, j);
			switch (direction) {
				case 0: // right
					++j; break;
				case 1: // down
					++i; break;
				case 2: // left
					--j; break;
				case 3: // up
					--i; break;
				default: 
					break;
			}
			++k;
		}
		System.out.println("Input Matrix:");
		for (int x = 0; x < mat.length; ++x) {
			for (int y = 0; y < mat[0].length; ++y)
				System.out.print(mat[x][y] + " ");
			System.out.print("\n");
		}
		System.out.println("Output Spiral Array:");
		for (int x = 0; x < result.length; ++x)
			System.out.print(result[x] + " ");
		
	}

	int whichWay(int direction, int n, int m, boolean[][] visited, int i, int j) {
		boolean left = true;
		boolean right = true;
		boolean up = true;
		boolean down = true;

		if (j == m-1) 
			right = false;
		if (i == n-1)
			down = false;
		if (j == 0)
			left = false;
		if (i == 0)
			up = false;
	
		if (!(right || down || left || up))
			return -1;

		switch (direction) {
			case 0:
				if (right)
					if (!visited[i][j+1])
						return 0;
				return 1;
			case 1:
				if (down)
					if (!visited[i+1][j])
						return 1;
				return 2;
			case 2:
				if (left)
					if (!visited[i][j-1])
						return 2;
				return 3;
			case 3:
				if (up)
					if (!visited[i-1][j])
						return 3;
				return 0;	
			default:
				return -1;
		}
	}
	
	/* Think of the matrix as layers */
	public int[] toSpiral(int[][] mat) throws NullPointerException {
	
		if (mat == null) 
			throw new NullPointerException("Input matrix is null");
		if (mat.length <= 0)
			throw new NullPointerException("Input matrix is empty");
		if (mat[0] == null)
			throw new NullPointerException("Matrix is corrupted");
		if (mat[0].length <= 0)
			throw new NullPointerException("Matrix rows are empty");
		
		int n = mat.length;
		int m = mat[0].length;
		
		int s = m*n;
		int[] result = new int[m*n];
		int k = 0;

		int layer = 0;

		int nlayer = (m < n) ? (m / 2) : (n / 2);
		while (layer <= nlayer) {

			int i = 0;
			int j = 0;

			// right
			i = layer;
			int j_start = layer;	
			int j_end = (m-1) - layer;
			for (j = j_start; j <= j_end; ++j) {
				result[k] = mat[i][j];
				++k;
			}
			if (k == s) 
				break;
	
			// down
			j = j_end;
			int i_start = layer + 1;
			int i_end = (n-1) - layer;
			for (i = i_start; i <= i_end; ++i) {
				result[k] = mat[i][j];
				++k;
			}
			if (k == s) 
				break;

			// left
			i = i_end;
			j_start = (m-1) - layer - 1;
			j_end = layer;
			for (j = j_start; j >= j_end; --j) {
				result[k] = mat[i][j];
				++k;
			}
			if (k == s) 
				break;

			// up
			j = j_end;
			i_start = (n-1) - layer - 1;
			i_end = layer + 1;
			for (i = i_start; i >= i_end; --i) {
				result[k] = mat[i][j];
				++k;
			}
			if (k == s) 
				break;
			++layer;		
		}

		return result;
	}

	public static void main (String[] args) {
		SpiralMatrix test = new SpiralMatrix();
		int[] r1 = new int[] {1, 2, 3, 4, 0, 2, 3, 4};
		int[] r2 = new int[] {5, 6, 7, 8, 5, 1, 2, 4};
		int[] r3 = new int[] {7, 6, 5, 4, 3, 1, 0, 8};
		int[][] mat = new int[][] {r1, r2, r3};

		int[] result = test.toSpiral(mat);
		
		System.out.println("Input Matrix:");
		for (int x = 0; x < mat.length; ++x) {
			for (int y = 0; y < mat[0].length; ++y)
				System.out.print(mat[x][y] + " ");
			System.out.print("\n");
		}
		System.out.println("Output Spiral Array:");
		for (int x = 0; x < result.length; ++x)
			System.out.print(result[x] + " ");
	}
}
