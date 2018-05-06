package frontend;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class FileTree extends JPanel {

    FileTree() {

        // Figure out where in the filesystem to start displaying
        final File root = new File(System.getProperty("user.home"));



        // Create a TreeModel object to represent our tree of files
//        DefaultTreeModel model=new DefaultTreeModel(root);
        FileTreeModel model = new FileTreeModel(root);
        // Create a JTree and tell it to display our model
        JTree tree = new JTree();
        tree.setModel(model);
//        TreeModel model = (DefaultTreeModel) tree.getModel();
//DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                /*
                 * DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
                 * .getPath().getLastPathComponent();
                 */
                File node = (File) e.getPath().getLastPathComponent();
                //TreePath path=e.getPath();
                String fpath = (String) node.getAbsolutePath();
                //String fpath=root.getAbsolutePath().concat("\\").concat(fname);
                File nf = new File(fpath);
                if (nf.isFile()) {
                    (new handlers()).open(nf);
                    //System.out.println("You selected " + "" + fpath);
                }
            }
        });
        // The JTree can get big, so allow it to scroll.
        //JScrollPane scrollpane = new JScrollPane(tree);
        JPanel scrollpane = new JPanel();
        scrollpane.add(tree);
        add(scrollpane);
        // Display it all in a window and make the window appear
        //JFrame frame = new JFrame("FileTreeDemo");
        //frame.getContentPane().add(scrollpane, "Center");
        //frame.setSize(400,600);
        //frame.setVisible(true);
    }
}

/**
 * The methods in this class allow the JTree component to traverse the file
 * system tree, and display the files and directories.
 *
 */
class FileTreeModel implements TreeModel {
    // We specify the root directory when we create the model.

    protected File root;

    public FileTreeModel(File root) {
        this.root = root;
    }

    //  The model knows how to return the root object of the tree
    public Object getRoot() {
        return root;
    }

    // Tell JTree whether an object in the tree is a leaf or not
    public boolean isLeaf(Object node) {
        return ((File) node).isFile();
    }

    // Tell JTree how many children a node has
    public int getChildCount(Object parent) {

        ArrayList<String> children = new ArrayList<String>();
        String[] ch = ((File) parent).list();
        int j = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (!ch[i].startsWith(".")) {
                //  j++;
                children.add(ch[i]);
            }
        }
        if (children == null) {
            return 0;
        }

        return children.size() - 1;
//        String[] children = ((File) parent).list();
//        if (children == null) {
//            return 0;
//        }
//        return children.length;
    }

    // Fetch any numbered child of a node for the JTree.
    // Our model returns File objects for all nodes in the tree.  The
    // JTree displays these by calling the File.toString() method.
    public Object getChild(Object parent, int index) {
        ArrayList<String> children = new ArrayList<String>();
        String[] ch = ((File) parent).list();
        int j = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (!ch[i].startsWith(".")) {
                //  j++;
                children.add(ch[i]);
            }
        }
        if ((children == null || index >= children.size() - 1)) {
            return null;
        } else {
            return new File((File) parent, children.get(index));
        }





//         String[] children = ((File) parent).list();
//        if ((children == null) || (index >= children.length)) {
//            return null;
//        }
//        return new File((File) parent, children[index]);
    }

    // Figure out a child's position in its parent node.
    public int getIndexOfChild(Object parent, Object child) {
        ArrayList<String> children = new ArrayList<String>();
        String[] ch = ((File) parent).list();
        int j = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (!ch[i].startsWith(".")) {
                //    j++;
                children.add(ch[i]);
            }
        }
        
        String childname = ((File) child).getName();

        Iterator<String> itr;
        itr = children.iterator();
        int i = 0;
        // if (!childname.startsWith("ab")) {
        while (itr.hasNext()) {
            String c = itr.next();
            i++;
            if (childname.equals(c)) {
                return i;
            }
        }
        // }
        return -1;

//        
//        String[] children = ((File) parent).list();
//        if (children == null) {
//            return -1;
//        }
//
//        String childname = ((File) child).getName();
//
//        for (int i = 0; i < children.length; i++) {
//            if (childname.equals(children[i])) {
//                return i;
//            }
//        }
//        return -1;
    }

    // This method is only invoked by the JTree for editable trees.  
    // This TreeModel does not allow editing, so we do not implement 
    // this method.  The JTree editable property is false by default.
    public void valueForPathChanged(TreePath path, Object newvalue) {
    }

    // Since this is not an editable tree model, we never fire any events,
    // so we don't actually have to keep track of interested listeners.
    public void removeTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }
}
