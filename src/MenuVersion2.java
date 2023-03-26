import java.io.IOException;
import java.util.Scanner;

public class MenuVersion2 implements iPrintMenu{

    Scanner scanner = new Scanner(System.in);

    public void printMenu(Card activeCard, ATM activeATM) throws IOException {
        boolean displayMenu = true;
        while (displayMenu == true) {
            System.out.println("Select option");
            System.out.println("1: Take money out");
            System.out.println("2: Quit");

            int choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    activeCard.takeMoneyOut(activeCard, activeATM);
                    break;
                case 2:
                    break;
                default:

            }
            if (choice == 4) {
                displayMenu = false;
            } else
                displayMenu = activeATM.closeOrContinue();
        }
    }

}
