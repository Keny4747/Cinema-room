package cinema_jetbrains;

import java.util.Arrays;


public class MultidimensionalArrays {

	public static void main(String[] args) {

		// Arrays with 2 dimensions: the second loop increase value of array
		int[][] twoDimArray = new int[2][10];

		for (int i = 0; i < twoDimArray.length; i++) {
			for (int j = 0; j < twoDimArray[i].length; j++) {
				twoDimArray[i][j] = 1;
			}
		}

		for (int i = 0; i < twoDimArray.length; i++) {
			for (int j = 0; j < twoDimArray[i].length; j++) {
				twoDimArray[i][j]++;
				System.out.print(twoDimArray[i][j] + " ");
			}
			System.out.println();
		}

		// three-dimensional arrays:Here 2 is the number of rows, 3 is the number of
		// columns and 4 is the number of elements in a nested array.
		int[][][] threeDimArray = new int[2][3][4];

		int element = 0;

		for (int i = 0; i < threeDimArray.length; i++) {
			for (int j = 0; j < threeDimArray[i].length; j++) {
				for (int k = 0; k < threeDimArray[i][j].length; k++) {
					threeDimArray[i][j][k] = element;
				}
				element++;
			}
		}
		
		//lets print 
		for (int i = 0; i < threeDimArray.length; i++) {
		    for (int j = 0; j < threeDimArray[i].length; j++) {
		        System.out.print(Arrays.toString(threeDimArray[i][j]) + " ");
		    }
		    System.out.println();
		}
		
		//exercise:
		
		
        int n = 5;
        
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.abs(j - i);
            }
        }
        for (int i = 0; i < n; i++) {
            String str = Arrays.toString(matrix[i]);
            str = str.replace("[", "")
                    .replace(",", "")
                    .replace("]", "");
            System.out.println(str);
        }
	}

}
