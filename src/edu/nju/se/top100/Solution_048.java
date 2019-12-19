package edu.nju.se.top100;

/**
 * 旋转图像
 * 
 * @author zongk
 *
 */

public class Solution_048 {

	public void rotate(int[][] matrix) {
		
		for(int i=matrix.length/2; i>=1; i--) {
			int lu = i - 1;
			int len = 2 * (matrix.length / 2 - i + 1) + matrix.length % 2;
			int[] upLine = new int[len];
			int[] rightLine = new int[len];
			int[] leftLine = new int[len];
			int[] downLine = new int[len];
			for(int k=0; k<len; k++) {
				upLine[k] = matrix[lu][lu+k];
			}
			for(int k=0; k<len; k++) {
				rightLine[k] = matrix[lu+k][lu+len-1];
			}
			for(int k=0; k<len; k++) {
				leftLine[k] = matrix[lu+k][lu];
			}
			for(int k=0; k<len; k++) {
				downLine[k] = matrix[lu+len-1][lu+k];
			}
			
			for(int k=0; k<len; k++) {
				matrix[lu+k][lu+len-1] = upLine[k];
			}
			for(int k=0; k<len; k++) {
				matrix[lu+len-1][lu+k] = rightLine[len - k - 1];
			}
			for(int k=0; k<len; k++) {
				matrix[lu+k][lu] = downLine[k];
			}
			for(int k=0; k<len; k++) {
				matrix[lu][lu+k] = leftLine[len - k - 1];
			}
		}
		
	}

}
