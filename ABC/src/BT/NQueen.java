package BT;

public class NQueen {



    public static void main(String s[]) {

        int[][] result = new int[4][4];
        solveNQueen(0, 4, result);
        printResult(result);


    }








    private static void printResult(int[][] result) {

        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }








    private static boolean solveNQueen(int queen, int N, int[][] result) {

        if (queen==N) {
            return true;
        }

        for (int row=0;row<4;row++) {

            if (isSafePlace(row, queen, result)) {

                result[row][queen] = 1;
                printResult(result);
                System.out.println();
                if (solveNQueen(queen+1, N, result)) {
                    return true;
                }
                result[row][queen] = 0;

            }

        }
        return false;

    }








    public static boolean isSafePlace(int row, int column, int[][] result) {

     // since we are filling one column at a time,
        // we will check if no queen is placed in that particular row
        for (int i = 0; i < column; i++) {
            if (result[row][i] == 1) {
                return false;
            }
        }
        // we are filling one column at a time,so we need to check the upper and
        // diagonal as well
        // check upper diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (result[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal
        for (int i = row, j = column; i < result.length && j >= 0; i++, j--) {
            if (result[i][j] == 1) {
                return false;
            }
        }
        // if we are here that means we are safe to place Queen at row,column
        return true;
    }


















}