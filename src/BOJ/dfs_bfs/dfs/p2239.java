package BOJ.dfs_bfs.dfs;

import java.util.Scanner;

public class p2239 {

    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zeroCnt = 0;

        for (int i = 0 ; i < 9 ; i ++) {
            String str = sc.nextLine();
            for (int j = 0 ; j < 9 ; j ++) {
                sudoku[i][j] = str.charAt(j) - 48;
                if (sudoku[i][j] == 0) zeroCnt ++;
            }
        }

        makeSudoku(zeroCnt);
    }

    private static void makeSudoku(int zeroCnt) {
        if (zeroCnt == 0) {
            for (int i = 0 ; i < 9 ; i ++) {
                for (int j = 0 ; j < 9 ; j ++) {
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        for (int i = 0 ; i < 9 ; i ++) {
            for (int j = 0 ; j < 9 ; j ++) {

                if (sudoku[i][j] != 0) continue;

                for (int newNumber = 1 ; newNumber <= 9 ; newNumber ++) {
                    sudoku[i][j] = newNumber;
                    if (checkSudoku(i, j) == true) {
                        makeSudoku(zeroCnt - 1);
                    }
                    sudoku[i][j] = 0;
                }

                if (sudoku[i][j] == 0) {
                    return;
                }
            }
        }
    }

    private static boolean checkSudoku(int x, int y) {
        int newNumber = sudoku[x][y];
        int rowCheck = 0;   // x행에 newNumber가 2개 이상 있으면 실패
        int colCheck = 0;   // y행에 newNumber가 2개 이상 있으면 실패

        for (int i = 0 ; i < 9 ; i ++) {
            if (sudoku[x][i] == newNumber) rowCheck ++;
            if (sudoku[i][y] == newNumber) colCheck ++;
        }

        if (rowCheck > 1 || colCheck > 1) return false;

        // x, y가 포함된 정사각형에 newNumber가 2개 이상 있으면 실패
        int squareCheck = 0;
        int firstRow, lastRow, firstCol, lastCol;

        if (x <= 2) { firstRow = 0; lastRow = 2; }
        else if (x >= 6) { firstRow = 6; lastRow = 8; }
        else { firstRow = 3; lastRow = 5; }

        if (y <= 2) { firstCol = 0; lastCol = 2; }
        else if (y >= 6) { firstCol = 6; lastCol = 8; }
        else { firstCol = 3; lastCol = 5; }

        for (int i = firstRow ; i <= lastRow ; i ++) {
            for (int j = firstCol ; j <= lastCol ; j ++) {
                if (sudoku[i][j] == newNumber) squareCheck ++;
            }
        }

        if (squareCheck > 1) return false;
        return true;
    }
}
