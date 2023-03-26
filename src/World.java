import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class World {

    Scanner scanner = new Scanner(System.in);

    Files fileHandler = Files.getFileHandler();
    ArrayList<ATM> allATMs = fileHandler.getAllATMs();
    ArrayList<Card> allCards = fileHandler.getALLCards();
    public World() throws FileNotFoundException {


    }

    public ATM checkATM() {
        int enteredATM;
        do {enteredATM = enterATM();
        } while (!checkIfATMExists(enteredATM, allATMs));

        return allATMs.get(enteredATM - 1);
    }

    public int enterATM() {
        System.out.println("enter ATM number");
        return Integer.parseInt(scanner.next());
    }

    public boolean checkIfATMExists(int enteredATM, ArrayList<ATM> allATMs) {
        boolean exists = false;
        for (int i = 0; i < allATMs.stream().count(); i++) {
            if (enteredATM == (allATMs.get(i).getId())) {
                exists = true;
                break;
            }
        }

        if (!exists){  System.out.print("ATM does notexist !");}
        return exists;
    }

}

