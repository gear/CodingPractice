/* ExplodeMatrix.java
 * Scan a n-by-m matrix, if encounter a 0, turn all elements in
 * its rows and colums to 0.
 * Must perform in place (i.e. O(1) space)
 */

public class ExplodeMatrix {

	/**************************************************/
	// The solution idea comes from assuming that I
	// can use extra space, what is the size of array
	// should I use? Array of size m! 
	// By looking at the whole matrix, we have tons of
	// free space if one the 0 blows up (array of m+n-1)
	// 
	// First, zero out all horizontal element, mark the
	// first blown up row to use as blow up mark for the
	// vertical.
	// Second, use the aforementioned row to zero out all
	// columns.
	/**************************************************/
	public void explode(int[][] field) {
		
		if (field == null)
			throw new NullPointerException();

		if (field[0] == null)
			throw new NullPointerException();

		int n = field.length;
		int m = field[0].length;
	
		boolean blownup = false;
		int blown_index = -1;
		for (int i = 0; i < n; ++i) {
			col_loop:
			for (int j = 0; j < m; ++j) {
				if (field[i][j] == 0) {
					if (blownup) {
						for(int k = 0; k < m; ++k) {
							if (field[i][k] == 0) {
								field[blown_index][k] = 1;
							} else {
								field[i][k] = 0;
							}
						}
					} else {
						for(int k = 0; k < m; ++k) {
							if (field[i][k] == 0)
								field[i][k] = 1;
							else
								field[i][k] = 0;
							blown_index = i;
						}
						blownup = true;	
					}
					break col_loop;
				}
			}
		}

		for (int j = 0; j < m; ++j) {
			if (field[blown_index][j] == 1)
				for (int i = 0; i < n; ++i) 
					field[i][j] = 0;
		}
	}

	public static void main(String[] args) {
		ExplodeMatrix test = new ExplodeMatrix();
		int[] r1 = new int[] {2, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r2 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r3 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r4 = new int[] {2, 1, 1, 1, 0, 1, 1, 1, 1};
		int[] r5 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 2};
		int[] r6 = new int[] {1, 1, 1, 1, 2, 1, 1, 1, 1};
		int[] r7 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r8 = new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1};
		int[] r9 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r10 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r11 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r12 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r13 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r14 = new int[] {1, 1, 0, 1, 1, 1, 0, 1, 1};
		int[] r15 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r16 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] r17 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};

		int[][] test_mat = new int[][] {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17};
		test.explode(test_mat);		
		for (int i = 0; i < test_mat.length; i++) {
			for (int j = 0; j < test_mat[0].length; j++) {
				System.out.print(test_mat[i][j] + " ");
			}	
			System.out.print("\n");
		}
	}
}
