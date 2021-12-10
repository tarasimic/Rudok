package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;


public class SecondFrame extends JFrame {

    public SecondFrame() {
        Toolkit t = Toolkit.getDefaultToolkit();
        setSize(500, 500);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/slikaa.png"));
        label.setBounds(20,20,100,100);
        label.setFocusable(true);
        JLabel labela = new JLabel("Tara Simic RN 129/2021");

        add(label, BorderLayout.WEST);
        add(labela, BorderLayout.CENTER);


        setTitle("Info");

    }


}
