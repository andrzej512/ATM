import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Card {
    private int number;
    private double balance;
    private int id;
    private Files fileHandler = Files.getFileHandler();
    Scanner scanner = new Scanner(System.in);

    Card(int id, int number, double balance) throws FileNotFoundException {
        this.number = number;
        this.balance = balance;
        this.id = id;
    }

    Card() throws FileNotFoundException {
    }

    public int getNumber() {
        return number;
    }

    public double getCardBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void setCardBalance(double amount) throws IOException {
        this.balance = amount;
        fileHandler.writeCardsToFIle();
    }

    public void takeMoneyOut(Card activeCard, ATM activeATM) throws IOException {
        System.out.println("What amount do you want to take out ?");
        double amount = Double.parseDouble(scanner.next());

        if (validateCardBalance(amount) && activeATM.validateATMBalance(amount) && activeATM.validateBanknotes(amount)) {//to samo co activeATM.validateATMBalance(amount) == true
            double newCardBalance = activeCard.getCardBalance() - amount;
            double newATMBalance = activeATM.getATMBalance() - amount;
            System.out.println("card operation : " + activeCard.getCardBalance() + " minus " + amount);
            System.out.println("ATM operation : " + activeATM.getATMBalance() + " minus " + amount);
            System.out.println("New Card balance " + newCardBalance);
            System.out.println("New ATM balance " + newATMBalance);


            activeATM.calculateBanknotes(amount);
            activeCard.setCardBalance(newCardBalance);
            activeATM.setATMBalance(newATMBalance);
        } else
            System.out.println("Transaction has been terminated, try again");

    }


    public void payIn(Card activeCard, ATM activeATM) throws IOException {
        int amountToPayIn;
        boolean disableCheck = false;
        ArrayList banknotesToPayIn;

        do {
            System.out.println("What amount do you want to pay in ?");
            amountToPayIn = Integer.parseInt(scanner.next());
            banknotesToPayIn = activeATM.createBankNotesListToPayIn(amountToPayIn);
            disableCheck = activeATM.validateEnteredBanknotes(banknotesToPayIn, amountToPayIn);

        } while (!disableCheck);


        double newCardBalance = activeCard.getCardBalance() + amountToPayIn;
        double newATMBalance = activeATM.getATMBalance() + amountToPayIn;
        activeATM.setEnteredBanknotes(banknotesToPayIn);
        activeCard.setCardBalance(newCardBalance);
        activeATM.setATMBalance(newATMBalance);


    }


    public boolean validateCardBalance(double wantedAmount) {
        boolean isTransactionValid = false;

        if (wantedAmount > getCardBalance()) {
            System.out.println("Insufficient card balance !");
            return isTransactionValid;
        } else
            isTransactionValid = true;
        return isTransactionValid;

    }


}
