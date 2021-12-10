package view.componentsView;

import com.sun.tools.javac.Main;
import model.node.RuNode;
import model.node.RuNode_Composite;
import model.workspace.Presentation;
import model.workspace.Project;
import observer.ISubscriber;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

public class ProjectView extends JInternalFrame implements ISubscriber {


    private RuNode_Composite project;

    static int count = 0;
    static final int xOffset = 30, yOffset = 30;
    private JTabbedPane tabbedPane;
    private ArrayList<PresentationView> prezentacija;
    private ArrayList<ProjectView> projectViews = new ArrayList<>();
    private Project projekat;



    ISubscriber sub;
    Project p;
    public ProjectView(RuNode_Composite project){
        super("", true, true, true, true);
        this.project = project;
        this.project.addSubscriber(this);
        this.prezentacija = getPrezentacija();
        Dimension d = MainFrame.getInstance().getRight().getSize();
        this.setSize(d);
        this.tabbedPane = new JTabbedPane();
        this.setTitle(project.getIme());
        count++;
        for(RuNode nodecomposite : project.getDeca()){
            this.tabbedPane.add(new PresentationView((RuNode_Composite) nodecomposite));

        }


        this.add(tabbedPane);
        this.setVisible(true);
    }

    @Override
    public void update(Object notification, String akcija) {
        if(akcija == "dodavanje"){
            this.add(this.tabbedPane);
            this.tabbedPane.removeAll();
            for(RuNode nodecomposite : project.getDeca()){
                this.tabbedPane.add(new PresentationView((RuNode_Composite) nodecomposite));
            }
            this.validate();
            this.updateUI();



        }
        if(akcija == "rename"){


            MyTreeNode putanja = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
            for(Component komponenta : MainFrame.getInstance().getRight().getComponents()) {
                if(((ProjectView)komponenta).equals(this)){
                    ((ProjectView)komponenta).setTitle(this.project.getIme());
                }
            }
        }

        if(akcija == "brisanje"){
            this.tabbedPane.removeAll();
            for(RuNode ruNode_composite : project.getDeca()){
                this.tabbedPane.add(new PresentationView((RuNode_Composite) ruNode_composite));

            }
            repaint();



        }



    }



    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }



    public RuNode_Composite getProject() {
        return project;
    }

    public ArrayList<PresentationView> getPrezentacija() {
        return prezentacija;
    }

    public void setPrezentacija(ArrayList<PresentationView> prezentacija) {
        this.prezentacija = prezentacija;
    }
}
