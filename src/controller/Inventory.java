package controller;

import model.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Inventory {

    private ArrayList<Item> itemList;

    public Inventory(){
        itemList = new ArrayList<>();
        itemList.add( new Item( "T123455", "Toaster", LocalDate.now() ));

        System.out.println(itemList.get(0).getName());


    }

}
