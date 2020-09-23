package processor;

import java.util.*;

public class Matrix {
    // variables
    private boolean exitFlag = false;
    private final Scanner scanner = new Scanner(System.in);

    // enum
    //Statement[] statements = Statement.values();
    //methods
    void matrixImplement() {
        // input
        int statements = input();
        // actions
        switch (statements) {
            case 0:
                System.out.println("Your choice: > 0");
                setExit(true);
                isExit();
                break;
            case 1:
                System.out.println("Your choice: > 1");
                forAdd();
                break;
            case 2:
                System.out.println("Your choice: > 2");
                forMultiByConst();
                break;
            case 3:
                System.out.println("Your choice: > 3");
                forMultiMatx();
                break;
            case 4:
                System.out.println("Your choice: > 4");
                transpose();
                break;
            case 5:
                System.out.println("Your choice: > 5");
                forDeterminant();
                break;
            case 6:
                System.out.println("Your choice: > 6");
                forInverse();
                break;
        }
    }

    // get/set for Exit
    public void setExit(boolean exit) {
        exitFlag = exit;
    }

    public boolean isExit() {
        return exitFlag;
    }

    // input methods
    public int input() {
        System.out.printf("1. Add matrices%n" +
                "2. Multiply matrix by a constant%n" +
                "3. Multiply matrices%n" +
                "4. Transpose matrix%n" +
                "5. Calculate a determinant%n" +
                "6. Inverse matrix%n" +
                "0. Exit%n");
        int choice = scanner.nextInt();
        return choice;
    }

    public double[][] inputMatx() {
        int rows = scanner.nextInt();
        int col = scanner.nextInt();
        double[][] matx = new double[rows][col];
        System.out.println("Enter matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                matx[i][j] = scanner.nextDouble();
            }
        }
        return matx;
    }

    // add
    private boolean checkEquals(double[][] First, double[][] Second) {
        if (First[0].length != Second[0].length || First.length != Second.length) {
            return false;
        }
        return true;
    }

    private double[][] addition(double[][] First, double[][] Second) {
        int rows = First.length;
        int col = First[0].length;
        double[][] matx = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                matx[i][j] = First[i][j] + Second[i][j];
            }
        }
        return matx;
    }

    public void forAdd() {
        System.out.println("Enter size of first matrix: ");
        double[][] First = inputMatx();
        System.out.println("Enter size of second matrix: ");
        double[][] Second = inputMatx();
        if (!checkEquals(First, Second)) {
            System.out.println("ERROR");
        } else {
            double[][] addResult = addition(First, Second);
            draw(addResult);
        }

    }

    //Multiply matrix to a constant
    private double[][] multiplies(double[][] matx, double constNum) {
        int rows = matx.length;
        int col = matx[0].length;
        double[][] matxMultResult = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                matxMultResult[i][j] = matx[i][j] * constNum;
            }
        }
        return matxMultResult;
    }

    public void forMultiByConst() {
        System.out.println("Enter size of matrix: ");
        double[][] matxForMultByConst = inputMatx();
        System.out.println("Enter constant: ");
        double multConst = scanner.nextInt();
        double[][] multResult = multiplies(matxForMultByConst, multConst);
        draw(multResult);
    }

    //Multiply matrices
    private boolean checkEqualsForMult(double[][] First, double[][] Second) {
        if (First[0].length != Second.length) {
            return false;
        }
        return true;

    }

    private double[][] multuplyMatrices(double[][] First, double[][] Second) {
        int rows = First.length;
        int col = Second[0].length;
        double[][] matx = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                double cap = 0;
                double[] firstRow = First[i];
                for (int z = 0; z < First[0].length; z++) {
                    cap += (firstRow[z] * Second[z][j]);
                }
                matx[i][j] = cap;
            }
        }
        return matx;
    }

    public void forMultiMatx() {
        System.out.println("Enter size of first matrix: ");
        double[][] First = inputMatx();
        System.out.println("Enter size of second matrix: ");
        double[][] Second = inputMatx();
        if (!checkEqualsForMult(First, Second)) {
            System.out.println("ERROR");
        } else {
            double[][] multiMatxResult = multuplyMatrices(First, Second);
            draw(multiMatxResult);
        }

    }

    //Transpose matrix
    private int chooseTranspose() {
        System.out.printf("1. Main diagonal%n" +
                "2. Side diagonal%n" +
                "3. Vertical line%n" +
                "4. Horizontal line%n");
        int choice = scanner.nextInt();
        return choice;
    }

    private boolean checkEqualsForTrans(double[][] Matx) {
        if (Matx[0].length != Matx.length) {
            return false;
        }
        return true;

    }

    private double[][] transMainDiagonal(double[][] First) {
        int rows = First.length;
        int col = First[0].length;
        double[][] matx = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            double[] row = First[i];
            for (int j = 0; j < col; j++) {
                matx[j][i] = row[j];
            }
        }
        return matx;
    }

    private double[][] transSideDiagonal(double[][] First) {
        int rows = First.length;
        int col = First[0].length;
        double[][] matx = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            double[] row = First[i];
            for (int j = 0; j < col; j++) {
                matx[j][rows - 1 - i] = row[rows - 1 - j];
            }
        }
        return matx;
    }

    private double[][] transVertical(double[][] First) {
        int rows = First.length;
        int col = First[0].length;
        double[][] matx = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            double[] row = First[i];
            for (int j = 0; j < col / 2; j++) {
                double cap = row[j];
                row[j] = row[rows - 1 - j];
                row[rows - 1 - j] = cap;
            }
            matx[i] = row;
        }
        return matx;
    }

    private double[][] transHorizontal(double[][] First) {
        int rows = First.length;
        int col = First[0].length;
        double[][] matx = new double[rows][col];
        for (int i = 0; i < rows; i++) {
            double[] row = First[rows - 1 - i];
            matx[i] = row;
        }
        return matx;
    }


    public void forTransMainDiagonal() {
        System.out.println("Enter size of matrix: ");
        double[][] matx = inputMatx();
        if (!checkEqualsForTrans(matx)) {
            System.out.println("ERROR");
        } else {
            double[][] transResult = transMainDiagonal(matx);
            draw(transResult);
        }

    }

    public void forTransSideDiagonal() {
        System.out.println("Enter size of matrix: ");
        double[][] matx = inputMatx();
        if (!checkEqualsForTrans(matx)) {
            System.out.println("ERROR");
        } else {
            double[][] transResult = transSideDiagonal(matx);
            draw(transResult);
        }

    }

    public void forTransVertical() {
        System.out.println("Enter size of matrix: ");
        double[][] matx = inputMatx();
        if (!checkEqualsForTrans(matx)) {
            System.out.println("ERROR");
        } else {
            double[][] transResult = transVertical(matx);
            draw(transResult);
        }

    }

    public void forTransHorizontal() {
        System.out.println("Enter size of matrix: ");
        double[][] matx = inputMatx();
        if (!checkEqualsForTrans(matx)) {
            System.out.println("ERROR");
        } else {
            double[][] transResult = transHorizontal(matx);
            draw(transResult);
        }

    }

    public void transpose() {
        int choice = chooseTranspose();
        switch (choice) {
            case 1:
                System.out.println("Your choice: > 1");
                forTransMainDiagonal();
                break;
            case 2:
                System.out.println("Your choice: > 2");
                forTransSideDiagonal();
                break;
            case 3:
                System.out.println("Your choice: > 3");
                forTransVertical();
                break;
            case 4:
                System.out.println("Your choice: > 4");
                forTransHorizontal();
                break;
        }

    }

    //Calculate a determinant
    public double[][] generateSubArray(double A[][], int N, int j1) {
        double[][] m = new double[N - 1][];
        for (int k = 0; k < (N - 1); k++)
            m[k] = new double[N - 1];

        for (int i = 1; i < N; i++) {
            int j2 = 0;
            for (int j = 0; j < N; j++) {
                if (j == j1)
                    continue;
                m[i - 1][j2] = A[i][j];
                j2++;
            }
        }
        return m;
    }

    public double determinant(double A[][], int N) {
        double res;

        // Trivial 1x1 matrix
        if (N == 1) res = A[0][0];
            // Trivial 2x2 matrix
        else if (N == 2) res = A[0][0] * A[1][1] - A[1][0] * A[0][1];
            // NxN matrix
        else {
            res = 0;
            for (int j1 = 0; j1 < N; j1++) {
                double[][] m = generateSubArray(A, N, j1);
                res += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
            }
        }
        return res;
    }

    public void forDeterminant() {
        System.out.println("Enter size of matrix: ");
        double[][] matx = inputMatx();
        int N = matx.length;
        if (!checkEqualsForTrans(matx)) {
            System.out.println("ERROR");
        } else {
            System.out.println("The result is: ");
            System.out.println(determinant(matx, N));
        }

    }

    //Inverse matrix
    public void forInverse() {
        System.out.println("Enter size of matrix: ");
        double[][] matx = inputMatx();
        if (!checkEqualsForTrans(matx)) {
            System.out.println("ERROR");
        } else {
            System.out.println("The result is: ");
            draw(invert(matx));
        }

    }

    public double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i] * b[index[i]][k];

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }

    // drawing the matrix
    public void draw(double[][] arr) {
        int rows = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
