package TicTac_Program;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        System.out.println("Tic-Tac-Toe!");
        do {
            System.out.println("Гра триває \\ (* - *) \\");
            game.printBoard();
            int row;
            int col;
            do {
                System.out.println("Гравець [ " + game.getCurrentPlayer() + " ] введіть числа де перше рядок, а друге стовпчик");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while (!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin()) {
            System.out.println("Нічия \\_(* - *)_/");
        } else {
            System.out.println("Результат гри: ");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayer()) + " Перемога за наступним гравцем!");
        }
    }
}
