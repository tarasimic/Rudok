package view.tree.model;

import model.node.RuNode;
import model.node.RuNode_Composite;
import model.workspace.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Iterator;


public class MyTreeNode extends DefaultMutableTreeNode {

    private RuNode r;
    private String name;

    public RuNode getR() {
        return r;
    }

    public MyTreeNode(RuNode r){
        this.r = r;
        this.name = r.getIme();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.r.setIme(name);
    }

    public TreeNode getChildAt(int childIndex) {
        return this.findChildByIndex(childIndex);
    }

    public int getChildCount() {
        return this.getR() instanceof RuNode_Composite ? ((RuNode_Composite)this.getR()).getDeca().size() : 0;
    }

    public boolean getAllowsChildren() {
        return this.getR() instanceof RuNode_Composite;
    }

    public boolean isLeaf() {
        return !(this.getR() instanceof RuNode_Composite);
    }

    public Enumeration children() {
        return this.getR() instanceof RuNode_Composite ? (Enumeration)((RuNode_Composite)this.getR()).getDeca() : null;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MyTreeNode) {
            MyTreeNode otherObj = (MyTreeNode)obj;
            return this.r.equals(otherObj.r);
        } else {
            return false;
        }
    }

    private TreeNode findChildByIndex(int childIndex) {
        if (this.r instanceof RuNode_Composite) {
            MyTreeNode toLookFor = new MyTreeNode((RuNode) ((RuNode_Composite)this.r).getDeca().get(childIndex));
            Iterator childrenIterator = this.children.iterator();

            while(childrenIterator.hasNext()) {
                TreeNode current = (TreeNode)childrenIterator.next();
                if (current.equals(toLookFor)) {
                    return current;
                }
            }
        }

        return null;
    }

    private int findIndexByChild(MyTreeNode node) {
        return this.r instanceof RuNode_Composite ? ((RuNode_Composite)this.r).getDeca().indexOf(node.getR()) : -1;
    }
    @Override
    public String toString() {
        return name;
    }
}
