package view.componentsView;

import model.node.RuNode;
import model.node.RuNode_Composite;
import model.workspace.Presentation;
import model.workspace.Slide;
import observer.ISubscriber;
import view.MainFrame;
import view.tree.model.MyTreeNode;
import view.tree.view.MyTree;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class PresentationView extends JPanel  implements ISubscriber {

    private RuNode_Composite prezentacija;
    private JTabbedPane jtab;
    private ProjectView view;
    private String name;
    private JPanel scrollPanel;
    private JScrollPane jScrollPane;
    private JPanel jPanel;
    private JPanel navigator;

    private ArrayList<Slide> slideArrayList = new ArrayList<>();

    private JLabel label;


    public PresentationView(RuNode_Composite prezentacija){
        this.prezentacija = prezentacija;
        this.prezentacija.addSubscriber(this);
        label = new JLabel("Autor: " + "IME AUTORA");
        this.view = view;
        this.setName(prezentacija.getIme());
        this.jtab = jtab;
        this.add(label, BorderLayout.NORTH);
        BoxLayout box = new BoxLayout(this,3);

        this.setLayout(box);
        this.setPreferredSize(new Dimension(800,800));
        for(RuNode ruNode : this.prezentacija.getDeca()){
            SlideView s = (new SlideView((Slide) ruNode));
            s.setPreferredSize(new Dimension(400, 400));
            s.setMaximumSize(new Dimension(400, 400));
            s.setMinimumSize(new Dimension(400, 400));
            s.setVisible(true);
            this.add(Box.createVerticalStrut(15));
            this.add(s);


        }



        jPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
        jPanel.setLayout(boxLayout);
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        this.add(jScrollPane);

        navigator = new JPanel();
        navigator.setLayout(new BorderLayout());


        //this.add(navigator);
        //JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigator, this);


        setVisible(true);

    }


    public RuNode_Composite getPrezentacija() {
        return prezentacija;
    }

    public JTabbedPane getJtab() {
        return jtab;
    }

    @Override
    public void update(Object notification, String akcija) {

        if(akcija == "rename"){

            this.view.getTabbedPane().removeAll();
            for(PresentationView presentationView : this.view.getPrezentacija()){
                this.view.getTabbedPane().addTab(((Presentation)presentationView.getPrezentacija()).getName(), presentationView);
            }
        }

        if(akcija == "editAuthor"){

            JTabbedPane tabs = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class,this);
            if(tabs == null){
                return;
            }
            try {
                for (int i = 0; i < tabs.getTabCount(); i++) {
                    if (tabs.getComponentAt(i).equals(this)) {

                        String autor = JOptionPane.showInputDialog("Autor");
                        label.setText("Autor: " + autor);

                    }

                }
                this.repaint();
            }catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        if(akcija == "dodavanje"){
            jPanel.removeAll();
            for(RuNode ruNode : this.prezentacija.getDeca()){
                SlideView s = (new SlideView((Slide) ruNode));
                System.out.println((Slide)ruNode);
                s.setPreferredSize(new Dimension(400, 400));
                s.setMaximumSize(new Dimension(400, 400));
                s.setMinimumSize(new Dimension(400, 400));
                s.add(new JLabel(((Slide)ruNode).getName()));
                s.setVisible(true);
                jPanel.add(Box.createVerticalStrut(15));
                jPanel.add(s);


            }
            this.validate();
            this.updateUI();
        }
        if(akcija == "background"){
            JTabbedPane tabs = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class,this);
            try {
                for (int i = 0; i < tabs.getTabCount(); i++) {
                    if (tabs.getComponentAt(i).equals(this)) {
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.showSaveDialog(null);
                        ((Presentation)prezentacija).setUrl(jFileChooser.getSelectedFile().getAbsolutePath());
                    }

                }
                this.repaint();
            }catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        if(akcija == "brisanje"){
            jPanel.removeAll();
            for(RuNode ruNode : prezentacija.getDeca()){
                SlideView s = (new SlideView((Slide) ruNode));

                s.setPreferredSize(new Dimension(400, 400));
                s.setMaximumSize(new Dimension(400, 400));
                s.setMinimumSize(new Dimension(400, 400));
                s.add(new JLabel(((Slide)ruNode).getName()));
                s.setVisible(true);
                jPanel.add(Box.createVerticalStrut(15));
                jPanel.add(s);
            }
            revalidate();
            repaint();
        }




    }

    public void setPrezentacija(RuNode_Composite prezentacija) {
        this.prezentacija = prezentacija;
    }

    public void setJtab(JTabbedPane jtab) {
        this.jtab = jtab;
    }

    public ProjectView getView() {
        return view;
    }

    public void setView(ProjectView view) {
        this.view = view;
    }

    @Override
    public String getName() {
        return name;


    }

}
