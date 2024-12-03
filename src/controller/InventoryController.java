package controller;

import dao.InventoryDAO;
import model.Item;
import view.MainView;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryController {
    private ArrayList<Item> itemList;
    private MainView view;
    private InventoryDAO dao;

    //Konstanten
    private final int MIN_ID_LENGTH = 6;
    private final int MIN_NAME_LENGTH = 8;
    private final int MIN_DATE_LENGTH = 4;

    public InventoryController(){
        itemList = new ArrayList<>();
        view = new MainView(500, 200, "Geräteverwaltung");
        dao = new InventoryDAO();

        view.addSaveHandler( this::saveNewItem );
        view.addLoadHandler( this::loadItem );
        view.addDeleteHandler( this::deleteItem );

        itemList = dao.loadInventory();
    }

    /**
     * Save Action aufgerufen von Save Button
     * @param event
     */
    private void saveNewItem( ActionEvent event ){

        System.out.println( event.getActionCommand() );
        //Todo: neues Objekt von Item erzeugen und speichern
        //1. Schritt: Versuchen, die eingetragenen Daten zu holen
        String id = view.getIdText();
        String name = view.getNameText();
        String date = view.getDateText();

        if( id.length() < MIN_ID_LENGTH || !isIdUnique(id) ) {
              view.showErrorMessage("Die Id soll mindestens "+MIN_ID_LENGTH+" Stellen haben und noch nicht genutzt werden");
              return;
        }

        if( name.length() < MIN_NAME_LENGTH ) {
            view.showErrorMessage("Der Name soll mindestens "+MIN_NAME_LENGTH+" Stellen haben");
            return;
        }

        if( date.length() < MIN_DATE_LENGTH ) {
            view.showErrorMessage("Das Datum soll mindestens "+MIN_DATE_LENGTH+" Stellen haben");
            return;
        }

        boolean isBroken = view.getIsBroken();
        //Daten sind valide
        boolean success = itemList.add( new Item(id, name, date, isBroken) );

        if(!success){
            view.showErrorMessage("Gerät konnte nicht gespeichert werden.");
            return;
        }

        dao.saveInventory(itemList);
        System.out.println(itemList.getLast().getName());

        view.showInfoMessage("Gerät wurde gespeichert");



    }

    private boolean isIdUnique( String id){
        for( var item : itemList ){
            if(item.getId().equals(id)){
                return false;
            }
        }

        return true;
    }

    /**
     * Load Action aufgerufen von Load Button
     * @param event Action Event
     */
    private void loadItem( ActionEvent event){

        System.out.println( event.getActionCommand() );

        itemList = dao.loadInventory();


        showAllData();
    }

    /**
     * Zeigt alle bisher gespeicherten Daten an
     */
    private void showAllData(){

        String text = "";

        for( Item item : itemList){
            String isBroken = "nein";

            if(item.isBroken())
                isBroken = "ja";

            text +="ID: " + item.getId() + "\n";
            text +="Name: " + item.getName() + "\n";
            text +="Gekauft: " + item.getDate() + "\n";
            text +="Defekt: " + isBroken + "\n\n";
        }

        view.showInfoMessage( text );
    }


    /**
     * Delete Action aufgerufen von Delete Button
     * @param event Action Event
     */
    private void deleteItem( ActionEvent event){

        System.out.println( event.getActionCommand() );

        String id = view.getIdText();

        System.out.println(itemList.size());

        for( var item : itemList ){
            if(item.getId().equals(id)){ //das ist die gesuchte Id, wenn wahr
                itemList.remove(item);
                return;
            }
        }
        //ToDo: evtl. Fehlerbehebung nötig beim Löschen des Items

        System.out.println(itemList.size());
    }
}
