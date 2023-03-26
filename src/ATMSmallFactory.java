import java.io.FileNotFoundException;

public class ATMSmallFactory {

    public ATMSmallFactory() {
    }

    public ATM createATM(ATMConfigurator atmConfig) throws FileNotFoundException {
        if (atmConfig.getBanknotes50() != 0 && atmConfig.getBanknotes100() != 0 && atmConfig.getBanknotes200() == 0) {
            return new ATMTypeOne(atmConfig);
        } else if (atmConfig.getBanknotes50() == 0 && atmConfig.getBanknotes100() == 0 && atmConfig.getBanknotes200() != 0) {
            return new ATMTypeTwo(atmConfig);
        } else if (atmConfig.getBanknotes50() != 0 && atmConfig.getBanknotes100() != 0 && atmConfig.getBanknotes200() != 0) {
            return new ATMTypeThree(atmConfig);
        }
        else return null;
    }
}








