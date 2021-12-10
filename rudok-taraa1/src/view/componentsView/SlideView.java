package view.componentsView;

import model.node.RuNode;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class SlideView extends JPanel implements ISubscriber {

    private RuNode slajd;

    public SlideView(RuNode slajd){
        this.slajd = slajd;

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLUE);

        this.setVisible(true);
    }

    @Override
    public void update(Object notification, String akcija) {

    }

    public RuNode getSlajd() {
        return slajd;
    }

    public void setSlajd(RuNode slajd) {
        this.slajd = slajd;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon image = new ImageIcon(((Presentation)slajd.getParent()).getUrl());
        g.drawImage(image.getImage(), 0, 0, this.getWidth(),this.getHeight(), null);
    }



}
