import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

       Scanner in = new Scanner(System.in);
        String sInput = in.nextLine();
        System.out.println(sInput);
        String[] input = sInput.split(" ");
        PokerPlayWinner pokerPlayWinner = new PokerPlayWinner();
        System.out.println("Winner of Poker Play -> " + pokerPlayWinner.checkWinner(input));
    }

}
