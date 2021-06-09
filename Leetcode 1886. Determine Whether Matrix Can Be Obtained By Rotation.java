class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int count = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == target[i][j])
					count++;
			}
		}
		if (mat.length*mat.length == count)
			return true;
		for (int i = 0; i < 3; i++) {
			if (check1(mat, target))
				return true;
		}

		return false;
    }
    public static boolean check1(int matrix[][], int b[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			int li = 0;
			int ri = matrix[i].length - 1;
			while (li < ri) {
				int temp = matrix[i][li];
				matrix[i][li] = matrix[i][ri];
				matrix[i][ri] = temp;
				li++;
				ri--;
			}

		}
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == b[i][j])
					count++;
			}
		}
		if (matrix.length * matrix.length == count)
			return true;
		return false;
	}
}
