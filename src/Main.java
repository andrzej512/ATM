import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        World w = new World();
        ATM selectedATM;
        Card selectedCard;
        selectedATM = w.checkATM();
        selectedCard = selectedATM.checkCard(w.allCards);

        selectedATM.printMenu(selectedCard, selectedATM);


    }
}
