import java.io.FileNotFoundException;

public class ATMTypeTwo extends ATM implements iCheckCard {


    ATMTypeTwo(ATMConfigurator data)throws FileNotFoundException {
        this.id = data.getId();
        cardsValidator = new CardsValidator();
        bankNotesCalculator = new BankNotesCalculatorType2();
        printMenu = new MenuVersion2();
        this.availableBanknotesInATM = createBanknotesList(data);
        this.atmBalance = data.getBanknotes200() * 200;
    }

}
