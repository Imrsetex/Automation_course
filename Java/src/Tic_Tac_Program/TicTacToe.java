package TicTac_Program;

class TicTacToe {

    private char[][] board;
    private char currentPlayerMark;

    TicTacToe() {
        board = new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
    }

    // Надає доступ до поточної позначки гравця
    char getCurrentPlayer() {
        return currentPlayerMark;
    }

    // Скинути значення
    void initializeBoard() {

        // Цикл по рядкам
        for (int i = 0; i < 3; i++) {

            // Цикл по колонкам
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }


    // Друк поля
    void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Проходоми по циклу, і якщо хоч один елемент виявиться порожнім '-' то повернемо false.
    // В іншому випадку поле заповнене.
    boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    // Повертає істину, якщо є перемога, інакше брехня
    boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    //Перевірка рядків
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    // Перевірка стовпців на переможні
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++)
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        return false;
    }

    //Перевірка по діагоналі на виграшну лінію
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }


    //Перевірка, чи всі три значення однакові які вказують на перемогу.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }


    // Зміна гравця
    public void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    //Розміщує позначку на клітинку, задану рядком і колонкою з позначкою вибраного гравця
    public boolean placeMark(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }

        return false;
    }
}
