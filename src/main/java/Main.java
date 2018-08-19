import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        PokerPlayWinner pokerPlayWinner = new PokerPlayWinner();
        Scanner in = new Scanner(System.in);
        System.out.println("DealerPoker/Poker?");
        String option = in.nextLine();
        if (option.equals("Poker")) {
            System.out.println("Enter Input (ex:- 10D 10H 10S 8H 6H AD 9S 9F 8D 7H):");
            String sInput = in.nextLine();
            String[] input = sInput.split(" ");
            System.out.println("Winner of Poker Play -> " + pokerPlayWinner.checkWinner(input));
        } else if (option.equals("DealerPoker")) {
            System.out.println("Enter Input (ex:- 10D 10H 10S 8H 6H AD 9S 9F 8D):");
            String sInput = in.nextLine();
            String[] input = sInput.split(" ");
            System.out.println("Winner of Dealer Poker Play -> " + pokerPlayWinner.checkDealWinner(input));
        }
    }

}
