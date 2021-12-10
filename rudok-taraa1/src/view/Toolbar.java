package view;

import controller.action.InfoAction;

import javax.swing.*;

public class Toolbar extends JToolBar {
    private JButton jb;
    private JButton info;
    private JButton rename;
    private JButton delete;
    private JButton renameAuthoor;
    private JButton addBackground;


    public Toolbar(){
        jb = new JButton();
        jb.setToolTipText("New");
        jb.setIcon(new ImageIcon("images/new-document.png"));
        jb.setFocusable(true);
        jb.addActionListener(MainFrame.getInstance().getAm().getNova());
        add(jb);

        addSeparator();

        info = new JButton();
        info.setToolTipText("Info");
        info.setIcon(new ImageIcon("images/info.png"));
        info.setFocusable(true);
        info.addActionListener(MainFrame.getInstance().getAm().getIa());

        add(info);

        rename = new JButton();
        rename.setToolTipText("Rename");
        rename.setIcon(new ImageIcon("images/edit.png"));
        rename.setFocusable(true);
        rename.addActionListener(MainFrame.getInstance().getAm().getRename());
        addSeparator();
        add(rename);

        delete = new JButton();
        delete.setToolTipText("Delete");
        delete.setIcon(new ImageIcon("images/bin.png"));
        delete.setFocusable(true);
        delete.addActionListener(MainFrame.getInstance().getAm().getDelete());
        addSeparator();
        add(delete);

        renameAuthoor = new JButton();
        renameAuthoor.setToolTipText("Add/Rename author");
        renameAuthoor.setIcon(new ImageIcon("images/author (1).png"));
        renameAuthoor.setFocusable(true);
        renameAuthoor.addActionListener(MainFrame.getInstance().getAm().getRenameAuthor());
        addSeparator();
        add(renameAuthoor);

        addBackground = new JButton();
        addBackground.setToolTipText("Choose background");
        addBackground.setIcon(new ImageIcon("images/open.png"));
        addBackground.setFocusable(true);
        addBackground.addActionListener(MainFrame.getInstance().getAm().getBackgroundAction());
        addSeparator();
        add(addBackground);


    }

    public JButton getJb() {
        return jb;
    }

    public void setJb(JButton jb) {
        this.jb = jb;
    }

    public JButton getInfo() {
        return info;
    }

    public void setInfo(JButton info) {
        this.info = info;
    }
}

