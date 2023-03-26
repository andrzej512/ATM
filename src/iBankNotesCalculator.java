import java.util.ArrayList;

public interface iBankNotesCalculator {

    void calculateBanknotes(double amount, ArrayList<Integer> availableBanknotes);
    boolean validateBanknotes(double amount);
    boolean validateEnteredBanknotes(ArrayList<Integer> banknotesToPayIn, int amount);
    void setEnteredBanknotes(ArrayList<Integer> banknotesToPayIn, ArrayList<Integer> availableBanknotesInATM);
    ArrayList createBankNotesListToPayIn(int amountToPayIn);

}
