import java.io.IOException;
import java.util.Scanner;

public class MenuVersion1 implements iPrintMenu {

    Scanner scanner = new Scanner(System.in);

    public void printMenu(Card activeCard, ATM activeATM) throws IOException {
        boolean displayMenu = true;
        while (displayMenu) {
            System.out.println("Select option");
            System.out.println("1: Take money out");
            System.out.println("2: Pay in");
            System.out.println("3: Check card balance");
            System.out.println("4: Quit");

            int choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    activeCard.takeMoneyOut(activeCard, activeATM);
                    break;
                case 2:
                    activeCard.payIn(activeCard, activeATM);
                    break;
                case 3:
                    System.out.println("Card balance : " + activeCard.getCardBalance());
                case 4:
                    break;
                default:
                    // will be run when no condition met

            }
            if (choice == 4) {
                displayMenu = false;
            } else
                displayMenu = activeATM.closeOrContinue();
        }
    }


}
