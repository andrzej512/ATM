import java.io.File;

public class ATMConfigurator {

    private int bankNotes50;
    private int bankNotes100;
    private int bankNotes200;
    private int id;

    public ATMConfigurator(int id, int banknotes50, int banknotes100, int banknotes200) {
        this.bankNotes50 = banknotes50;
        this.bankNotes100 = banknotes100;
        this.bankNotes200 = banknotes200;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBanknotes50() {
        return bankNotes50;
    }

    public void setBanknotes50(int banknotes50) {
        this.bankNotes50 = banknotes50;
    }

    public int getBanknotes100() {
        return bankNotes100;
    }

    public void setBanknotes100(int banknotes100) {
        this.bankNotes100 = banknotes100;
    }

    public int getBanknotes200() {
        return bankNotes200;
    }

    public void setBanknotes200(int banknotes200) {
        this.bankNotes200 = banknotes200;
    }
}
