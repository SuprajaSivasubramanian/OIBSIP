import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number guessing game");
        System.out.println("1) Play");
        System.out.println("2) Score");
        System.out.println("3) Exit");
        System.out.println("--------------------");
        try {
            System.out.print("Choose an option:");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"Enter the range of numbers ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thank you!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("The Randomnumber is Lower than your guess number");
            } else if (userGuess < randomNumber) {
                System.out.println("The Randomnumber is Higher than your guess number ");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You guessed in " + guess + " try!");
        } else {
            System.out.println("You guessed in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("you completed the game!!");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}