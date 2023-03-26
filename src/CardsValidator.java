import java.util.ArrayList;
import java.util.Scanner;

public class CardsValidator implements iCheckCard {
    Scanner scanner = new Scanner(System.in);

    public Card checkCard(ArrayList<Card> allCards) {

        int enteredCard = 0;
        do {
            enteredCard = enterCard();
        } while (!checkIfCardExists(enteredCard, allCards));
        int finalEnteredCard = enteredCard;

        return allCards.stream().filter(n -> finalEnteredCard == n.getNumber()).findFirst().get();
    }

    public boolean checkIfCardExists(int enteredCard, ArrayList<Card> allCards) {
        boolean exists = false;
        for (int i = 0; i < allCards.stream().count(); i++) {
            if (enteredCard == (allCards.get(i).getNumber())) {
                exists = true;
                break;
            }

        }
        System.out.print("the card does not exist !");

        return exists;
    }

    public int enterCard() {
        System.out.println("Enter card number");
        return Integer.parseInt(scanner.next());
    }

}
