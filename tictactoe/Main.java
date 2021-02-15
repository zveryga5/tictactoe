package tictactoe;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void vivod(String arr[][]) {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "         ";
        int count = 0;
        int xwin = 0;
        int owin = 0;


        String arr[][] = new String[3][3];
        int dvig = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = line.substring(j + dvig, j + 1 + dvig);
            }
            dvig += 3;
        }

        System.out.println("---------");
        vivod(arr);
        System.out.println("---------");

        boolean xo = true;
        boolean check = true;

        while (check) {
            System.out.print("Enter the coordinates: ");
            String coord = scanner.nextLine();
            String[] pieces = coord.split(" ");
            int k = 1;

            try {
                int first = Integer.parseInt(pieces[0]);
                int second = Integer.parseInt(pieces[1]);
                if (first > 3 || first < 1 || second > 3 || second < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");

                } else {
                    if (!arr[first - 1][second - 1].equals("X") && !arr[first - 1][second - 1].equals("O")) {
                        if (xo == true) {
                            arr[first - 1][second - 1] = "X";
                            xo = false;
                            count++;
                        } else {
                            arr[first - 1][second - 1] = "O";
                            xo = true;
                            count++;
                        }
                        System.out.println("---------");
                        vivod(arr);
                        System.out.println("---------");

                    } else {
                        System.out.println("This cell is occupied! Choose another one!");

                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                check = true;
            }

            for (int v = 0; v < 3; v++) {
                if (arr[v][0].equals("X") && arr[v][1].equals("X") && arr[v][2].equals("X")) {
                    xwin++;
                } else if (arr[v][0].equals("O") && arr[v][1].equals("O") && arr[v][2].equals("O")) {
                    owin++;
                }
            }

            for (int v = 0; v < 3; v++) {
                if (arr[0][v].equals("X") && arr[1][v].equals("X") && arr[2][v].equals("X")) {
                    xwin++;
                } else if (arr[0][v].equals("O") && arr[1][v].equals("O") && arr[2][v].equals("O")) {
                    owin++;
                }
            }

            if (arr[0][0].equals("X") && arr[1][1].equals("X") && arr[2][2].equals("X")) {
                xwin++;
            } else if (arr[0][0].equals("O") && arr[1][1].equals("O") && arr[2][2].equals("O")) {
                owin++;
            }

            if (arr[0][2].equals("X") && arr[1][1].equals("X") && arr[2][0].equals("X")) {
                xwin++;
            } else if (arr[0][2].equals("O") && arr[1][1].equals("O") && arr[2][0].equals("O")) {
                owin++;
            }

            if (xwin == 1 && owin == 0) {
                System.out.println("X wins");
                break;
            } else if (xwin == 0 && owin == 1) {
                System.out.println("O wins");
                break;
            } else if (count == 9 && xwin == 0 && owin == 0) {
                System.out.println("Draw");
                break;
            }

        }

    }
}

