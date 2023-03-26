import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class ATM {
    Scanner scanner = new Scanner(System.in);
    iCheckCard cardsValidator;
    iBankNotesCalculator bankNotesCalculator;
    iPrintMenu printMenu;
    protected int id;
    protected double atmBalance;
    protected Files fileHandler = Files.getFileHandler();

    public ArrayList<Integer> availableBanknotesInATM = new ArrayList<>();


    ATM() throws FileNotFoundException {

    }

    public int getId() {
        return id;
    }

    public double getATMBalance() {
        return atmBalance;
    }

    public void setATMBalance(double amount) throws IOException {
        this.atmBalance = amount;
        fileHandler.writeATMsToFIle();
    }

    public void printMenu(Card activeCard, ATM activeATM) throws IOException {printMenu.printMenu(activeCard,activeATM);}
    public ArrayList createBankNotesListToPayIn(int amountToPayIn) throws IOException {return bankNotesCalculator.createBankNotesListToPayIn(amountToPayIn);}
    public boolean validateATMBalance(double wantedAmount) {

        boolean isTransactionValid = false;

        if (wantedAmount > getATMBalance()) {
            System.out.println("Insuffucient ATM balance !");
            return isTransactionValid;
        } else
            isTransactionValid = true;
        return isTransactionValid;
    }

    public boolean validateBanknotes(double amount){
        return bankNotesCalculator.validateBanknotes(amount);
    }
    public boolean validateEnteredBanknotes(ArrayList<Integer> enteredBanknotes, int amount){
        return bankNotesCalculator.validateEnteredBanknotes(enteredBanknotes, amount);
    }

    public void setEnteredBanknotes(ArrayList<Integer> enteredBanknotes){
        bankNotesCalculator.setEnteredBanknotes(enteredBanknotes, availableBanknotesInATM);

    }

    public ArrayList<Integer> getAvailableBanknotes(){
        return availableBanknotesInATM;
    }

    public void calculateBanknotes(double amount){
        bankNotesCalculator.calculateBanknotes(amount,availableBanknotesInATM);
    }

    public Card checkCard(ArrayList<Card> allCards) {
        return cardsValidator.checkCard(allCards);
    }

    public boolean closeOrContinue() {
        System.out.println("1.back to Menu");
        System.out.println("2.Quit program");
        int choice = Integer.parseInt(scanner.next());
        if (choice == 1) {
            return true;
        }
        return false;

    }
    public ArrayList<Integer>  createBanknotesList(ATMConfigurator data){
        Collections.addAll(availableBanknotesInATM, data.getBanknotes50(), data.getBanknotes100(), data.getBanknotes200());
        return availableBanknotesInATM;
    }


}
