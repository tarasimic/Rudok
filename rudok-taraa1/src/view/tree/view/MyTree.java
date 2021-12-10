package view.tree.view;

import view.tree.controller.MyTreeCellEditor;
import view.tree.controller.MyTreeSelectionListener;
import view.tree.controller.TreeCellRendered;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyTree extends JTree implements ItemListener {

    public MyTree(DefaultTreeModel treeModel){
        this.setModel(treeModel);
        this.addTreeSelectionListener(new MyTreeSelectionListener());
        this.setCellEditor(new MyTreeCellEditor(this, new DefaultTreeCellRenderer()));
        this.setCellRenderer(new TreeCellRendered());
        this.addMouseListener(new MyTreeSelectionListener());
        this.setEditable(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
