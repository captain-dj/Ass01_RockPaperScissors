import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain;
        do {
            // Get moves from players A and B
            String playerA = getPlayerMove(scanner, "Player A, enter your move (R/P/S): ");
            String playerB = getPlayerMove(scanner, "Player B, enter your move (R/P/S): ");

            // Display moves and determine winner
            System.out.println("Player A chose: " + playerA);
            System.out.println("Player B chose: " + playerB);
            determineWinner(playerA, playerB);

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainInput = scanner.nextLine().toUpperCase();
            playAgain = playAgainInput.equals("Y");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Method to get a valid move from a player
    private static String getPlayerMove(Scanner scanner, String prompt) {
        String move;
        do {
            System.out.print(prompt);
            move = scanner.nextLine().toUpperCase();
        } while (!isValidMove(move));
        return move;
    }

    // Method to validate if the move is valid (R, P, or S)
    private static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    // Method to determine the winner based on moves
    private static void determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println("It's a tie! Both players chose " + playerA);
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("S") && playerB.equals("P")) ||
                (playerA.equals("P") && playerB.equals("R"))) {
            displayWinMessage(playerA, playerB);
            System.out.println("Player A wins!");
        } else {
            displayWinMessage(playerB, playerA);
            System.out.println("Player B wins!");
        }
    }

    // Method to display the win message based on moves
    private static void displayWinMessage(String winnerMove, String loserMove) {
        switch (winnerMove) {
            case "R":
                System.out.println("Rock breaks Scissors!");
                break;
            case "P":
                System.out.println("Paper covers Rock!");
                break;
            case "S":
                System.out.println("Scissors cuts Paper!");
                break;
        }
    }
}