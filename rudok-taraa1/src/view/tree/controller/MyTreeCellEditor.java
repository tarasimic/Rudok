package view.tree.controller;

import errorHandler.ErrorFactory;
import errorHandler.ErrorType;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Workspace;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MyTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
    Object selected;

    public MyTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
        this.selected = value;
        JTextField edit = new JTextField(this.selected.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject event) {
        if(event instanceof MouseEvent){
            if(((MouseEvent)event).getClickCount() == 3){
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().isEmpty()) {
            if (((MyTreeNode)this.selected).getR() instanceof Project) {
                ((MyTreeNode) this.selected).setName(e.getActionCommand());
                ((Project) ((MyTreeNode) this.selected).getR()).setName(e.getActionCommand());
            }
            else if(((MyTreeNode)this.selected).getR() instanceof Workspace){
                ErrorFactory.getInstance().generateError(ErrorType.RENAME);
            }



        }
    }
}