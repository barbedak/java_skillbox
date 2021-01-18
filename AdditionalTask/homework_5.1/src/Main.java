public class Main {
    static int n = 3;
    static int m = 2;

    public static int[][] generateMatrix(int n, int m){
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for (int k = 0; k < m; k++){
                matrix[i][k] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }
    public static int[][] transpositionMatrix (int[][] matrix){
        int[][] transposedMatrix = new int[m][n];
        for(int i = 0; i < n; i++){
            for (int k = 0; k < m; k++){
                transposedMatrix[k][i] = matrix[i][k];
            }
        }
        return transposedMatrix;
    }
    public static void printMatrix(int[][] matrix, String message) {
        System.out.println(message);
        for (int[] stringMatrix : matrix) {
            System.out.println();
            for (int element : stringMatrix) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(n,m);
        printMatrix(matrix,"Original matrix:");
        System.out.println();
        printMatrix(transpositionMatrix(matrix), "Transposed matrix:");
    }
}