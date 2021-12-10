package view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    private JMenuItem rename;
    private JMenuItem renameAuthor;
    private JMenuItem background;


    public Menu(){
        JMenu fajl = new JMenu("File");
        JMenuItem novo = new JMenuItem("New");
        renameAuthor = new JMenuItem("Add/Rename author");
        renameAuthor.addActionListener(MainFrame.getInstance().getAm().getRenameAuthor());
        novo.addActionListener(MainFrame.getInstance().getAm().getNova());
        background = new JMenuItem("Choose background");
        background.addActionListener(MainFrame.getInstance().getAm().getBackgroundAction());


        JMenuItem delete = new JMenuItem("Delete");
        rename = new JMenuItem("Rename");
        rename.addActionListener(MainFrame.getInstance().getAm().getRename());

        delete.addActionListener(MainFrame.getInstance().getAm().getDelete());


        JMenu help = new JMenu("Help");
        JMenuItem edit = new JMenuItem("Edit");



        MainFrame.getInstance();
        fajl.add(novo);
        fajl.add(rename);
        fajl.add(renameAuthor);
        fajl.add(background);

        fajl.add(delete);
        help.add(edit);
        add(fajl);
        add(help);
    }

    public JMenuItem getRename() {
        return rename;
    }
}
