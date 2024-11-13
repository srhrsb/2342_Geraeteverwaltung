package view;

import javax.swing.*;
import java.awt.*;

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
        setLayout( new BorderLayout() );

        //2 Panel erzeugen, in die später Button und Textfelder rein kommen
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

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



}
