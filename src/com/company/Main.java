package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Random rdm = new Random();

        giveIntro();
        int gameNumber = computersPick(rdm);
        int inputNumber = playersPick(console);
        playGame(inputNumber, gameNumber, console);

    }

    public static void playGame (int inputNumber, int gameNumber, Scanner console) {

        victory(inputNumber, gameNumber);

        while (inputNumber != gameNumber) {

            System.out.println(digitMatch(gameNumber, inputNumber));
            System.out.print("Make another guess: ");
            inputNumber = console.nextInt();
            checkPick(inputNumber, console);
            victory(inputNumber, gameNumber);

        }
    }

    public static int playersPick(Scanner console) {

        System.out.println("Please make your pick, a number between 10-99; ");

        int inputNumber = console.nextInt();

        checkPick(inputNumber, console);

        return inputNumber;
    }

    public static int checkPick (int inputNumber, Scanner console) {

        while (inputNumber < 10 || inputNumber >= 100) {
            System.out.println("Your pick was invalid, try again please: ");
            inputNumber = console.nextInt();
        }
        return inputNumber;
    }

    public static int computersPick(Random rdm) {

        int min = 10;
        int max = 99;

        int gameNumber = rdm.nextInt((max - min) + 1) + min;

        return gameNumber;
    }

    public static String digitMatch(int gameNumber, int inputNumber) {

        if (inputNumber % 10 == gameNumber % 10 && (inputNumber / 10) == (gameNumber / 10)
            || inputNumber % 10 == (gameNumber / 10) && (inputNumber / 10) == gameNumber % 10) {
            return "Your guess matched 2 digits.\n";
        }
            else if (inputNumber % 10 == gameNumber % 10) {
            return ("Your guess matched 1 digit: " + (gameNumber % 10) + "\n");
        } else if (inputNumber % 10 == gameNumber / 10) {
            return ("Your guess matched 1 digit: " + (gameNumber / 10) + "\n");
        } else if (inputNumber / 10 == gameNumber % 10) {
            return ("Your guess matched 1 digit: " + (gameNumber % 10) + "\n");
        } else if ((inputNumber / 10) == (gameNumber / 10)) {
            return ("Your guess matched 1 digit: " + (gameNumber / 10) + "\n");
        }
        return "None of your digits matched the computers number.\n";
    }

    public static void giveIntro() {
        System.out.println("This is a small guessing game");
        System.out.println("The computer chooses a random number");
        System.out.println("Between 10-99, you then try to guess it");
        System.out.println("If your guess matches either or both of the digits");
        System.out.println("The computer will tell you.");
        System.out.println("Have fun and good luck! \n");
    }

    public static void victory(int gameNumber, int inputNumber) {
        if (gameNumber == inputNumber) {
            System.out.println("Congratulations! You have won the game!\n");
            playAgain();
        }
    }

    public static void playAgain() {

        Scanner console = new Scanner(System.in);
        Random rdm = new Random();

        System.out.println("Would you like to play another?");
        System.out.println("Answer with 'yes' or 'no'");
        String answer = console.next();

        if (answer.equals("yes")) {
            playGame(playersPick(console), computersPick(rdm), console);
        }
    }
}
