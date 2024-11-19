package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton saveBtn, loadBtn;

    private JTextField idTf, nameTf, dateTf;

    public MainView(){
        setSize( 500, 300);
        setTitle("Fenster");
        createUI();
    }

    public MainView( int width, int height ){
        setSize(width, height);
        setTitle("Fenster");
        createUI();
    }

    public MainView( int width, int height, String titel ){
        setSize(width, height);
        setTitle( titel );
        createUI();
    }

    private void createUI(){
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new BorderLayout() );

        //2 Panel erzeugen, in die später Button und Textfelder rein kommen
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        //Layout für Toppanel festlegen
        topPanel.setLayout( new GridLayout(3,2));
        topPanel.setBorder( new EmptyBorder( 5,5,5,5 ));

        //hinzufügen der Panel
        add(topPanel, BorderLayout.NORTH );
        add(bottomPanel, BorderLayout.SOUTH);

        loadBtn = new JButton("Laden");
        saveBtn = new JButton("Speichern");

        bottomPanel.add(loadBtn);
        bottomPanel.add(saveBtn);

        JLabel idLabel = new JLabel("ID");
        idTf = new JTextField();

        JLabel nameLabel = new JLabel("Bezeichnung");
        nameTf = new JTextField();

        JLabel dateLabel = new JLabel("Anschaffungsdatum");
        dateTf = new JTextField();

        topPanel.add(idLabel);
        topPanel.add(idTf);
        topPanel.add(nameLabel);
        topPanel.add(nameTf);
        topPanel.add(dateLabel);
        topPanel.add(dateTf);



        setVisible(true);
    }

    public String getIdText(){
        return idTf.getText();
    }

    public String getNameText(){
        return nameTf.getText();
    }

    public String getDateText(){
        return dateTf.getText();
    }

    //ToDo: 3 Methoden zum zuweisen der 3 Textfelder z.b.setIdText usw.

    public void setIdText( String id ){
        idTf.setText(id);
    }

    public void setNameText( String name ){
         nameTf.setText(name);
    }

    public void setDateText( String date ){
         dateTf.setText(date);
    }

    //Eventhandler------------

    public void addSaveHandler( ActionListener listener){
        saveBtn.addActionListener( listener );
    }

    public void addLoadHandler( ActionListener listener){
        loadBtn.addActionListener( listener );
    }



}
