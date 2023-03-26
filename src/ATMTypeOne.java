import java.io.FileNotFoundException;

public class ATMTypeOne extends ATM implements iCheckCard {


    ATMTypeOne(ATMConfigurator data) throws FileNotFoundException {
        this.id = data.getId();
        cardsValidator = new CardsValidator();
        bankNotesCalculator = new BankNotesCalculatorType1();
        printMenu = new MenuVersion1();
        createBanknotesList(data);
        this.atmBalance = data.getBanknotes50() * 50 + (data.getBanknotes100() * 100);
    }


}




