import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice: rock, paper, or scissors.");

        String userChoice;
        String computerChoice;
        int computerIndex;
        boolean playAgain = true;

        while (playAgain) {
            
            System.out.print("Your turn: ");
            userChoice = scanner.nextLine().toLowerCase();

            
            while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                System.out.print("Your turn: ");
                userChoice = scanner.nextLine().toLowerCase();
            }

            
            computerIndex = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors
            computerChoice = choices[computerIndex];

            
            System.out.println("Computer chooses: " + computerChoice);

            
            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);

            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();

            while (!playAgainResponse.equals("yes") && !playAgainResponse.equals("no")) {
                System.out.print("Invalid response. Please enter yes or no: ");
                playAgainResponse = scanner.nextLine().toLowerCase();
            }

            if (playAgainResponse.equals("no")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }

        scanner.close();
    }

    
    private static String determineWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "It's a tie!";
        } else if (user.equals("rock") && computer.equals("scissors") ||
                   user.equals("paper") && computer.equals("rock") ||
                   user.equals("scissors") && computer.equals("paper")) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}