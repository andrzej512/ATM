import java.util.ArrayList;
import java.util.Scanner;

public class BankNotesCalculatorType2 implements iBankNotesCalculator {
    Scanner scanner = new Scanner(System.in);

    public void calculateBanknotes(double amount, ArrayList<Integer> availableBanknotes) {

        int[] notes = new int[]{200};
        int[] noteCounter = new int[1];

        for (int i = 0; i < 1; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = (int)amount / notes[i];
                amount = amount % notes[i];
                availableBanknotes.set((2-i),availableBanknotes.get(2-i)-noteCounter[i]);
            }
        }
    }

    public boolean validateBanknotes(double amount) {
        boolean isValid = false;
        double reminder = amount % 200;
        if (reminder != 0) {
            System.out.println("Available banknotes : 200. Enter different amount !");
        } else isValid = true;

        return isValid;
    }

    public boolean validateEnteredBanknotes(ArrayList<Integer> banknotesToPayIn, int wantedAmount) {
        boolean isValid = false;
        if ((!banknotesToPayIn.isEmpty() && (banknotesToPayIn.get(0) * 200) == wantedAmount)) {
            isValid = true;
            return isValid;
        } else
            System.out.println("Entered sum of banknots is incorrect");
        System.out.println("the sum must be equal to entered banknotes");
        return isValid;



    }
    public void setEnteredBanknotes(ArrayList<Integer> banknotesToPayIn, ArrayList<Integer> availableBanknotesInATM) {
        availableBanknotesInATM.set(0, banknotesToPayIn.get(0) + availableBanknotesInATM.get(0));
        System.out.println("set entered banknotes");
    }

    public ArrayList createBankNotesListToPayIn(int amountToPayIn) {
        ArrayList<Integer> banknotesToPayIn = new ArrayList<>();
        if (validateBanknotes(amountToPayIn)) {

            System.out.println("Enter banknotes");
            System.out.println("banknote 200: quantity -> ");
            banknotesToPayIn.add(0, Integer.parseInt(scanner.next()));

        }
        return banknotesToPayIn;
    }

}

