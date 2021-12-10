package controller.action;

import view.MainFrame;
import view.SecondFrame;
import view.Toolbar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoAction implements ActionListener{

    SecondFrame sf;

    @Override
    public void actionPerformed(ActionEvent e) {

        sf = new SecondFrame();
        sf.setVisible(true);
    }
}
