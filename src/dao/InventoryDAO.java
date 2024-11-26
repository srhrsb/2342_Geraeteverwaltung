package dao;

import model.Item;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryDAO {

    private final String PATH="data/saveData.csv";
    private final String SEPARATOR = ",";

    /**
     * Speichert die Invantarliste als csv Datei
     * @param currentInventory Inventarliste
     * @return Erfolgsmeldung
     */
    public boolean saveInventory( ArrayList<Item> currentInventory){
        //hier kann einiges schief gehen, das vorab nicht
        //zu prüfen ist
        FileWriter csv = null;
        try{
            csv = new FileWriter( PATH );
            for(var item : currentInventory ){
                String line = item.getId() + SEPARATOR +
                              item.getName() + SEPARATOR +
                              item.getDate() + "\n";

                csv.write( line );
            }
        }
        catch( IOException e ){ //in der Variable e wird der Fehler angenommen
            System.err.println("Error: "+ e.getMessage());
        }
        finally {
            //wird immer ausgeführt, egal ob ein Fehler auftrat oder nicht
            //Beispiel: Schließen von Dateien
            if (csv != null) {
                try {
                    csv.close();
                } catch( IOException e ) {
                    System.err.println("Error" + e.getMessage() );
                }
            }
        }
        return true;
    }

    public ArrayList<Item> loadInventory(){
      return null;
    }

}
