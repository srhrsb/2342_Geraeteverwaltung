package dao;

import model.Item;

import javax.annotation.processing.Filer;
import java.io.*;
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
                if(item != null) {
                    String line = item.getId() + SEPARATOR +
                            item.getName() + SEPARATOR +
                            item.getDate() + "\n";

                    csv.write(line);
                }
            }
        }
        catch( IOException e ){ //in der Variable e wird der Fehler angenommen
            System.err.println("IO Error: "+ e.getMessage());

        }
        catch( Exception e ){
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

    /**
     * Erzeugt aus der csv Datei die Liste mit den Inventargegenständen
     * @return Liste
     */
    public ArrayList<Item> loadInventory(){

        //Leere Liste erzeugen
        ArrayList<Item> itemList = new ArrayList<>();

        //Objekt FileReader zunächst ungültig
        FileReader file = null;
        try{
            file = new FileReader( PATH ); //FileReader (jetzt gültig)
            BufferedReader reader = new BufferedReader( file ); //Reader zum zeilenweise Lesen
            String line; //einzelne Zeile, zunächst leer

            //Schleife => Lese solange line nicht null ist
            while( ( line = reader.readLine() ) != null){

                String[] data = line.split( SEPARATOR );

                String id = data[0];
                String name = data[1];
                String date = data[2];

                Item item = new Item( id, name, date );
                itemList.add(item);
            }
        }
        catch( IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        finally {

        }

      return itemList;
    }

}
