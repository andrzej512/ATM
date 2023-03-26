import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Files {


    File CardsFile = new File("src/DebitCards.txt");
    File ALLATMsFile = new File("src/AllATMsFile.txt");
    Scanner readFile = new Scanner(CardsFile).useDelimiter(",");
    Scanner readNewFile = new Scanner(ALLATMsFile).useDelimiter(",");
    ATMSmallFactory atmSmallFactory = new ATMSmallFactory();
    ArrayList<Card> allLoadedCards;
    ArrayList<ATM> allLoadedATMs;

    private static Files fileHandler;


    private Files() throws FileNotFoundException {

    }

    public static Files getFileHandler() throws FileNotFoundException {

        if (fileHandler == null) {
            fileHandler = new Files();
            fileHandler.loadAllATMsFromNewFile();
            fileHandler.loadCardsFromFile();

        }
        return fileHandler;
    }

    public ArrayList<ATM> getAllATMs(){
        return this.allLoadedATMs;
    }
    public ArrayList<Card> getALLCards(){return this.allLoadedCards;};
    public void writeCardsToFIle() throws IOException {
        FileWriter writeToFile = new FileWriter("DebitCards.txt", false);
        for (Card x : allLoadedCards) {
            writeToFile.write(String.valueOf(x.getId()));
            writeToFile.write(",");
            writeToFile.write(String.valueOf(x.getNumber()));
            writeToFile.write(",");
            writeToFile.write(String.valueOf(x.getCardBalance()));
            writeToFile.write("\n");
            System.out.println("written line to Cards file " + x.getId() + " " + x.getNumber() + " " + x.getCardBalance());

        }

        writeToFile.close();

    }

    public ArrayList<Card> loadCardsFromFile() throws FileNotFoundException {
        ArrayList<Card> allCards = new ArrayList<Card>();
        while (readFile.hasNext()) {
            String[] s = readFile.nextLine().split(",");
            System.out.println("Cards file loaded: " + s[0] + " " + s[1] + " " + s[2]);
            allCards.add(new Card(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Double.parseDouble(s[2])));
        }
        return this.allLoadedCards = allCards;
    }


    public ArrayList<ATM> loadAllATMsFromNewFile() throws FileNotFoundException {
        ArrayList<ATM> allATMs = new ArrayList<ATM>();
        while (readNewFile.hasNext()) {
            String[] s = readNewFile.nextLine().split(",");
            System.out.println("ATM file loaded: " + s[0] + " " + s[1] + " " + s[2] + " " + s[3]);
            ATMConfigurator atmConfig = new ATMConfigurator(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            allATMs.add(atmSmallFactory.createATM(atmConfig));
        }
        return this.allLoadedATMs = allATMs;
    }


    public void writeATMsToFIle() throws IOException {
        FileWriter writeToFile = new FileWriter("ALLATMsFile.txt", false);
        for (ATM x : allLoadedATMs) {
            writeToFile.write(String.valueOf(x.getId()));
            writeToFile.write(",");
            writeToFile.write(String.valueOf(x.getAvailableBanknotes().get(0)));
            writeToFile.write(",");
            writeToFile.write(String.valueOf(x.getAvailableBanknotes().get(1)));
            writeToFile.write(",");
            writeToFile.write(String.valueOf(x.getAvailableBanknotes().get(2)));
            writeToFile.write("\n");

        }
        writeToFile.close();
    }
}













