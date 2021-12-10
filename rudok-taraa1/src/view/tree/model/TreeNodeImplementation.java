package view.tree.model;

import com.sun.tools.javac.Main;
import model.node.RuNode;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.tree.view.MyTree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class TreeNodeImplementation {

    private DefaultTreeModel df;
    private MyTree tree;

    public JTree generate(Workspace ws){
        MyTreeNode trn = new MyTreeNode(ws);
        this.df = new DefaultTreeModel(trn);
        this.tree = new MyTree(df);
        return this.tree;
    }

    public DefaultTreeModel getDf() {
        return df;
    }

    public void setDf(DefaultTreeModel df) {
        this.df = df;
    }

    public MyTree getTree() {
        return tree;
    }

    public void setTree(MyTree tree) {
        this.tree = tree;
    }

    public void addProject(Project p){
        RuNode rn = ((MyTreeNode)df.getRoot()).getR();
        ((MyTreeNode) df.getRoot()).add(new MyTreeNode(p));
        ((Workspace)rn).addChild(p);
        SwingUtilities.updateComponentTreeUI(tree);
    }

    public void addPresentation(Presentation p, MyTreeNode treeNode){
        treeNode.add(new MyTreeNode(p));
        ((Project)treeNode.getR()).addChild(p);
        SwingUtilities.updateComponentTreeUI(tree);
    }

    public void addSlide(Slide slide, MyTreeNode treeNode){
        treeNode.add(new MyTreeNode(slide));
        ((Presentation)treeNode.getR()).addChild(slide);
        SwingUtilities.updateComponentTreeUI(tree);

    }

}
