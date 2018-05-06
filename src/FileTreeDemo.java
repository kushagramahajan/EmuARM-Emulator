import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.File;

public class FileTreeDemo {
  public static void main(String[] args) {
    // Figure out where in the filesystem to start displaying
    File root;
    if (args.length > 0) root = new File(args[0]);
    else root = new File(System.getProperty("user.home"));

    // Create a TreeModel object to represent our tree of files
    FileTreeModel model = new FileTreeModel(root);

    // Create a JTree and tell it to display our model
    JTree tree = new JTree();
    tree.setModel(model);

    // The JTree can get big, so allow it to scroll.
    JScrollPane scrollpane = new JScrollPane(tree);
    
    // Display it all in a window and make the window appear
    JFrame frame = new JFrame("FileTreeDemo");
    frame.getContentPane().add(scrollpane, "Center");
    frame.setSize(400,600);
    frame.setVisible(true);
  }
}

/**
 * The methods in this class allow the JTree component to traverse
 * the file system tree, and display the files and directories.
 **/
class FileTreeModel implements TreeModel {
  // We specify the root directory when we create the model.
  protected File root;
  public FileTreeModel(File root) { this.root = root; }

  // The model knows how to return the root object of the tree
  public Object getRoot() { return root; }

  // Tell JTree whether an object in the tree is a leaf or not
  public boolean isLeaf(Object node) {  return ((File)node).isFile(); }

  // Tell JTree how many children a node has
  public int getChildCount(Object parent) {
    String[] children = ((File)parent).list();
    if (children == null) return 0;
    return children.length;
  }

  // Fetch any numbered child of a node for the JTree.
  // Our model returns File objects for all nodes in the tree.  The
  // JTree displays these by calling the File.toString() method.
  public Object getChild(Object parent, int index) {
    String[] children = ((File)parent).list();
    if ((children == null) || (index >= children.length)) return null;
    return new File((File) parent, children[index]);
  }

  // Figure out a child's position in its parent node.
  public int getIndexOfChild(Object parent, Object child) {
    String[] children = ((File)parent).list();
    if (children == null) return -1;
    String childname = ((File)child).getName();
    for(int i = 0; i < children.length; i++) {
      if (childname.equals(children[i])) return i;
    }
    return -1;
  }

  // This method is only invoked by the JTree for editable trees.  
  // This TreeModel does not allow editing, so we do not implement 
  // this method.  The JTree editable property is false by default.
  public void valueForPathChanged(TreePath path, Object newvalue) {}

  // Since this is not an editable tree model, we never fire any events,
  // so we don't actually have to keep track of interested listeners.
  public void addTreeModelListener(TreeModelListener l) {}
  public void removeTreeModelListener(TreeModelListener l) {}
}
