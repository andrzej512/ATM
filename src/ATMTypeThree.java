import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ATMTypeThree extends ATM implements iCheckCard {

    ATMTypeThree(ATMConfigurator data) throws FileNotFoundException {
        this.id = data.getId();
        cardsValidator = new CardsValidator();
        bankNotesCalculator = new BankNotesCalculatorType3();
        printMenu = new MenuVersion1();
        createBanknotesList(data);
        this.atmBalance = data.getBanknotes50() * 50 + (data.getBanknotes100() * 100) + (data.getBanknotes200() * 200);
    }

}


