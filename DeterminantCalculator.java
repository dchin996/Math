// Darin Chin
// Determinant Calculator
// May 16 2016
// Determinant calculator using recursion.

import java.io.*;
import java.util.*;

public class DeterminantCalculator {

	public static void main(String[] args) {
		System.out.println("Determinant Calculator");
      	System.out.println();
      	System.out.println("created by Darin Chin");
      	System.out.println();
      	System.out.println("Please enter the number of rows of your square matrix \"A\"");
      	Scanner input = new Scanner(System.in);
      	int n = input.nextInt();
		double[][] matrix = new double[n][n];
		System.out.println("now, enter the elements in your matrix from left to right,");
		System.out.println("and down the rows. You should enter " + (n * n) + " value(s)");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
		double det = calculateDet(matrix, n);
		System.out.println("det(A) = " + det);
	}
	
	// recursive method
	public static double calculateDet(double[][] matrix, int N) {
		double det = 0;
		if (N == 1) {
			det = matrix[0][0];
		} else if (N == 2) { //matrix.length != 1
			det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		} else {
			det = 0;
			for (int i = 0; i < N; i++) {
				// if matrix[i][0] == 0 , skip
				if (matrix[i][0] == 0) 
					continue;
				double[][] newMatrix = new double[N - 1][N - 1];
				int i2 = 0;
				for (int j = 0; j < N; j++) {
					if (i != j) {
						for (int k = 0; k < N - 1; k++) {
							newMatrix[i2][k] = matrix[j][k + 1];
						}
						i2++;
					}
				}
				det += Math.pow(-1, i) * matrix[i][0] * calculateDet(newMatrix, N - 1);
			}
		}
		return det;
	}
}