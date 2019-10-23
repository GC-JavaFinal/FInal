import java.util.Scanner;

public class Main {

    public static TicTacToe game = new TicTacToe();
    public static int playerInput;

    public static void main(String[] args) {
        System.out.println("\n\n\nWelcome to Tic Tac Toe! You can mark a spot by\n" +
                "entering a 1-9. You will be X and the Computer will be O.");

        while (!game.boardFilled()) {
            playerTurn();
            if (game.threeInARow(playerInput, true)) {
                game.setWinState(1);
                break;
            }
            if (game.boardFilled()) break;
            game.cpuTurn();
            if (game.cpuThreeInARow()) {
                game.setWinState(2);
                break;
            }
        }

        //based on win state add score and display appropriate message
        if (game.getWinState() == 1) {
            //win
            System.out.println(game + "\nYou win, you got three in a row!");
        }
        else if (game.getWinState() == 2) {
            //lose
            System.out.println(game + "\nYou lost, the cpu got three in a row.");
        }
        else if (game.getWinState() == 0) {
            //draw
            System.out.println(game + "\nIts a draw, the board is filled " + "\nwith no winners.");
        }

        playAgain();
    }

    public static void playerTurn() {
        String board = game.toString();

        Scanner in = new Scanner(System.in);
        System.out.println(board + "\nEnter a place to mark 1-9 > ");
        playerInput = in.nextInt();

        if (!game.playerTurn(playerInput)) {
            System.out.println("That spot if already filled or you\n" + "entered an invalid input.");
            playerTurn();
        }
    }

    public static void playAgain() {
        Scanner in = new Scanner(System.in);
        System.out.println("Game is over, play again? (y/n) > ");
        String response = in.next();

        if (response.equals("y")) {
            game = new TicTacToe();
            main(new String[0]);
        }
    }
}
