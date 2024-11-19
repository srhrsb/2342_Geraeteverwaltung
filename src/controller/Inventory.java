package controller;

import model.Item;
import view.MainView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Inventory {

    private ArrayList<Item> itemList;
    private MainView view;

    public Inventory(){
        itemList = new ArrayList<>();
        itemList.add( new Item( "T123455", "Toaster", "5/2023" ));

        Item firstItem = itemList.get(0);

        System.out.println(firstItem.getName());

        view = new MainView(500, 150, "Geräteverwaltung");



    }

}
