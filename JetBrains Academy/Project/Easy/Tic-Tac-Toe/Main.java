package tictactoe;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char[] lineBoard = new char[9];
    static int Xcord;
    static int Ycord;

    public static void main(String[] args) {

        String cells = scanner.next();
        char[] xo = cells.toCharArray();

        input(cells);
        board = fillTable(xo);
        drawTable(board);
        getCoordinates();
        drawTable(board);


    }

    static void input(String cells) {


        //char[] xo = cells.toCharArray();
        System.out.print("Enter cells: ");
        System.out.println(cells);

        //char[][] xoMatx = fillTable (xo);
        //drawTable(xoMatx);


    }

    static char[][] fillTable(char[] xo) {

        char[][] xoMatx = {
                {xo[0], xo[1], xo[2]},
                {xo[3], xo[4], xo[5]},
                {xo[6], xo[7], xo[8]},
        };

        return xoMatx;
    }

    static void drawTable(char[][] arr) {

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean isEmpty(char[][] board, int x, int y) {

        int x1 = 0;
        int y1 = 0;
        int z1 = 0;
        if (x == 1) {
            if (y == 3) {
                x1 = 0;
                y1 = 0;
                z1 = 0;

            }
            if (y == 2) {
                x1 = 1;
                y1 = 0;
                z1 = 3;
            }
            if (y == 1) {
                x1 = 2;
                y1 = 0;
                z1 = 6;
            }
        }
        // second column
        if (x == 2) {
            if (y == 3) {
                x1 = 0;
                y1 = 1;
                z1 = 1;
            }
            if (y == 2) {
                x1 = 1;
                y1 = 1;
                z1 = 4;

            }
            if (y == 1) {
                x1 = 2;
                y1 = 1;
                z1 = 7;

            }
        }
        //Third column
        if (x == 3) {
            if (y == 3) {
                x1 = 0;
                y1 = 2;
                z1 = 2;

            }
            if (y == 2) {
                x1 = 1;
                y1 = 2;
                z1 = 5;

            }
            if (y == 1) {

                x1 = 2;
                y1 = 2;
                z1 = 8;

            }
        }
        char target = board[x1][y1];
        if (target == '_') {
            return true;
        } else {
            return false;
        }
    }

    static char[][] getValue(char[][] board, int x, int y) {
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;
        if (x == 1) {
            if (y == 3) {
                x1 = 0;
                y1 = 0;
                z1 = 0;

            }
            if (y == 2) {
                x1 = 1;
                y1 = 0;
                z1 = 3;
            }
            if (y == 1) {
                x1 = 2;
                y1 = 0;
                z1 = 6;
            }
        }
        // second column
        if (x == 2) {
            if (y == 3) {
                x1 = 0;
                y1 = 1;
                z1 = 1;
            }
            if (y == 2) {
                x1 = 1;
                y1 = 1;
                z1 = 4;

            }
            if (y == 1) {
                x1 = 2;
                y1 = 1;
                z1 = 7;

            }
        }
        //Third column
        if (x == 3) {
            if (y == 3) {
                x1 = 0;
                y1 = 2;
                z1 = 2;

            }
            if (y == 2) {
                x1 = 1;
                y1 = 2;
                z1 = 5;

            }
            if (y == 1) {

                x1 = 2;
                y1 = 2;
                z1 = 8;

            }
        }
        board[x1][y1] = 'X';
        return board;
    }


    static void getCoordinates() { // gets coordinates and checks whether it satisfies specific conditions
        System.out.print("Enter coordinates: ");
        while (true) {

            while (!(scanner.hasNextInt())) {
                System.out.println("You should enter numbers!");
            }

            Xcord = scanner.nextInt();
            Ycord = scanner.nextInt();
            System.out.printf("%d %d%n", Xcord, Ycord);

            if (Xcord > 3 || Xcord < 1 || Ycord > 3 || Ycord < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                if (isEmpty(board, Xcord, Ycord)) {
                    board = getValue(board, Xcord, Ycord);

                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }

            }
        }
    }


}