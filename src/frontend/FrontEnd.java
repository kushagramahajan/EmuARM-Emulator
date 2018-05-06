/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import backend.FirstPass;
import backend.Memory;
import backend.Register_spec;
import backend.ScanFile;
import frontend.Test.PopupTriggerListener;

/**
 *
 * @author win-7
 */
public class FrontEnd extends javax.swing.JFrame implements WindowListener,WindowFocusListener,WindowStateListener {
	public static Highlighter.HighlightPainter redPainter;
   public static String filepath;
    public static Clipboard clip;
    public static int build_flag=0;
    public static int bflag=0;
    public static int exceptionraised = 0;
    
    public FrontEnd() {
    	
    	//addWindowListener(this);
        addWindowFocusListener(this);
        //addWindowStateListener(this);
        
    	//activepane.addMouseListener(new PopupTriggerListener());
    	
        redPainter = new DefaultHighlighter.DefaultHighlightPainter(
                Color.red);
    	
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        h = new handlers();
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("emuArm 2.0");
        filepath = null;
        clip = getToolkit().getSystemClipboard();
        initializeScreen();

        Test a = new Test();
        
        setDividerLocation(registerPaneAndEditor, 0.4);
        //setDividerLocation( EditorAndTreeView, 0.2);
        EditorAndTreeView.resetToPreferredSizes();
        checkpoints.resetToPreferredSizes();
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                setDividerLocation(registerPaneAndEditor, 0.4);
                //setDividerLocation( EditorAndTreeView, 0.2);
                EditorAndTreeView.resetToPreferredSizes();
                checkpoints.resetToPreferredSizes();
                //   setDividerLocation( OutputAndPanels, 0.6);
//         TreeContainer.setMaximumSize(new Dimension(dimension.width/4,dimension.height/6));
                OutputAndPanels.resetToPreferredSizes();
//registerPaneAndEditor.resetToPreferredSizes();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                setDividerLocation(registerPaneAndEditor, 0.50);
                //setDividerLocation( EditorAndTreeView, 0.2);
                EditorAndTreeView.resetToPreferredSizes();
                checkpoints.resetToPreferredSizes();
                //    setDividerLocation( OutputAndPanels, 0.6);
//         TreeContainer.setMaximumSize(new Dimension(dimension.width/4,dimension.height/6));
                OutputAndPanels.resetToPreferredSizes();
//registerPaneAndEditor.resetToPreferredSizes();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                setDividerLocation(registerPaneAndEditor, 0.50);
                //setDividerLocation( EditorAndTreeView, 0.2);
                EditorAndTreeView.resetToPreferredSizes();
                //  setDividerLocation( OutputAndPanels, 0.6);
                OutputAndPanels.resetToPreferredSizes();
//registerPaneAndEditor.resetToPreferredSizes();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                setDividerLocation(registerPaneAndEditor, 0.50);
                //        setDividerLocation( EditorAndTreeView, 0.2);
                EditorAndTreeView.resetToPreferredSizes();
                checkpoints.resetToPreferredSizes();
                //setDividerLocation( OutputAndPanels, 0.6);
                OutputAndPanels.resetToPreferredSizes();
//registerPaneAndEditor.resetToPreferredSizes();
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("emuARM 1.0");
        // TreeContainer.setMaximumSize(new Dimension(dimension.width/4,dimension.height/6));
        //         TreeContainer.setMaximumSize(new Dimension(dimension.width/4,dimension.height/6));
        TreeContainer.setPreferredSize(new Dimension(dimension.width / 10, (5 * dimension.height) / 8));
        StatusContainer.setPreferredSize(new Dimension(dimension.width, (dimension.height) / 8));
        EditorContainer.setPreferredSize(new Dimension(dimension.width / 3, (5 * dimension.height) / 8));
        checkpointsContainer.setPreferredSize(new Dimension(dimension.width / 30, dimension.height / 3));
        OutputAndPanels.resetToPreferredSizes();
        //registerPaneAndEditor.resetToPreferredSizes();
        EditorAndTreeView.resetToPreferredSizes();
        //  setDividerLocation( OutputAndPanels, 0.6);

    }
    Dimension dimension;

    private void StepIntoToolBar() {
    }

    private void initializeScreen() {

        SidePane = new JTabbedPane();

        SidePane.setMinimumSize(new Dimension(0, 0));
        SidePane.setPreferredSize(new Dimension(2*dimension.width/9,dimension.height/2));
        
//        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
//        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
//        Border compound = BorderFactory.createCompoundBorder(
//                raisedbevel, loweredbevel);

        //SidePane.setBorder(new EmptyBorder(0, 0, 0, 20));
        check = new JTabbedPane();

        check.setMinimumSize(new Dimension(0, 0));
        check.setMaximumSize(new Dimension(1, 1));
        EditorPane = new JTabbedPane();
        EditorPane.setMinimumSize(new Dimension(0, 0));

        EditorPane.addChangeListener(new javax.swing.event.ChangeListener() {

            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                h.EditorStateChanged(evt);
            }
        });
        //EditorPane.setPreferredSize(new Dimension(dimension.width/2,(2*dimension.height)/3));
        TreePane = new FileTree();
        TreePane.setMinimumSize(new Dimension(0, 0));
        //TreePane.setBorder(new EmptyBorder(0, 0, 0, 20));
        //TreePane.setPreferredSize(new Dimension(dimension.width/4,(2*dimension.height)/3));
        statuswindow = new JTextArea();
        statuswindow.setEditable(false);
        frontend.FrontEnd.statuswindow.addKeyListener(new KeyAdapter() {

            private StringBuffer line = new StringBuffer();

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // line.append(c);
                if (c == KeyEvent.VK_ENTER) {

                    backend.ScanFile.ob.setinput(line);
                    line.setLength(0);
                } else if (c == KeyEvent.VK_BACK_SPACE) {
                    line.setLength(line.length() - 1);

                } else if (!Character.isISOControl(c)) {
                    line.append(e.getKeyChar());
                }
            }
        });

        //OutputPane.setPreferredSize(new Dimension(dimension.width,(dimension.height)/3));
        EditorContainer = new JScrollPane(EditorPane);
        EditorContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        EditorContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        EditorContainer.setPreferredSize(new Dimension(3*dimension.width/9, (2 * dimension.height) / 3));
        
        
        checkpointsContainer = new JScrollPane(check);
        checkpointsContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        checkpointsContainer.setPreferredSize(new Dimension(dimension.width / 30, dimension.height / 3));

        RegisterContainer = new JScrollPane(SidePane);
        RegisterContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        RegisterContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        RegisterContainer.setPreferredSize(new Dimension(2*dimension.width / 9, (2 * dimension.height) / 3));
        
        TreeContainer = new JScrollPane(TreePane);
        TreeContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        TreeContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        TreeContainer.setMaximumSize(new Dimension(dimension.width / 4, dimension.height / 6));
        //TreeContainer.setBounds(0, 0, dimension.width/4, (2*dimension.height)/3);
        TreeContainer.setPreferredSize(new Dimension(dimension.width/10,dimension.height/30));
        
        StatusContainer = new JScrollPane(statuswindow);
        StatusContainer.setPreferredSize(new Dimension(dimension.width, (dimension.height) / 1000));
        StatusContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        StatusContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);



        registerPaneAndEditor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, EditorContainer, RegisterContainer);
        registerPaneAndEditor.setResizeWeight(0.4);
        registerPaneAndEditor.setOneTouchExpandable(true);
        registerPaneAndEditor.setPreferredSize(new Dimension(5*dimension.width/9,dimension.height));
        
        checkpoints = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  TreeContainer,checkpointsContainer);
        checkpoints.setResizeWeight(0.5);
        checkpoints.setOneTouchExpandable(false);
        checkpoints.setMinimumSize(new Dimension(1, 10));
        checkpoints.setMaximumSize(new Dimension(1, 10));
        
        EditorAndTreeView = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, checkpoints, registerPaneAndEditor);
        EditorAndTreeView.setResizeWeight(0.4);
        EditorAndTreeView.setOneTouchExpandable(true);
        EditorAndTreeView.setPreferredSize(new Dimension(dimension.width,3*dimension.height/5));


        OutputAndPanels = new JSplitPane(JSplitPane.VERTICAL_SPLIT, EditorAndTreeView, StatusContainer);
        OutputAndPanels.setResizeWeight(0.8);
        OutputAndPanels.setOneTouchExpandable(true);
        OutputAndPanels.setPreferredSize(new Dimension(dimension.width-dimension.width/13,dimension.height-dimension.height/7));


        container = new JScrollPane(OutputAndPanels);
        container.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        container.setPreferredSize(new Dimension(dimension.width,dimension.height));
        //container.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        /*
         * JButton button = new JButton("Button 1 (PAGE_START)");
         * this.add(button, BorderLayout.PAGE_START);
         */

        initializeToolBar();
        initializecheckpoints();
        intializeSidePane();
        initializeEditorPane();
//JButton button2 = new JButton("Button 7 (PAGE_START)");
//this.add(button2, BorderLayout.PAGE_START);
        this.add(container, BorderLayout.CENTER);
        initializeMenuBar();
        //  this.setSize(dimension);
        Toolkit tk = Toolkit.getDefaultToolkit();

        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
//this.setSize(xSize,ySize);  

        this.pack();
    }

    void initializeMenuBar() {

        menu = new JMenuBar();
        menu.setBorder(new BevelBorder(BevelBorder.RAISED));

        file = new JMenu("File");

        file_new = new JMenuItem();
        file_new.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        file_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new.png"))); // NOI18N
        file_new.setText("New");
        file_new.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.newFile();
            }
        });
        file.add(file_new);



        file_open = new javax.swing.JMenuItem();
        file_open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        file_open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349523_folder_add.png"))); // NOI18N
        file_open.setText("Open");
        file_open.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.openfile();
            }
        });
        file.add(file_open);


        file_save = new javax.swing.JMenuItem();
        file_save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        file_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349552_diskette.png"))); // NOI18N
        file_save.setText("Save");
        file_save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.savefile();
            }
        });
        file.add(file_save);


        file_exit = new javax.swing.JMenuItem();
        file_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        file_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit.png"))); // NOI18N
        file_exit.setText("Exit");
        file_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.exit();
            }
        });
        file.add(file_exit);

        menu.add(file);

        edit = new JMenu("Edit");

        edit_cut = new javax.swing.JMenuItem();
        edit_cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        edit_cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349801_Cut.png"))); // NOI18N
        
        edit_cut.setText("Cut");
        edit_cut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.cut();
            }
        });
        edit.add(edit_cut);

        edit_copy = new javax.swing.JMenuItem();
        edit_copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        edit_copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349791_Copy.png"))); // NOI18N
        edit_copy.setText("Copy");
        edit_copy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.copy();
            }
        });
        edit.add(edit_copy);


        edit_paste = new javax.swing.JMenuItem();
        edit_paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        edit_paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349865_edit-paste.png"))); // NOI18N
        edit_paste.setMnemonic('V');
        edit_paste.setText("Paste");
        edit_paste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.paste();
            }
        });
        edit.add(edit_paste);

        menu.add(edit);

        run = new JMenu("Run");

        build_file = new javax.swing.JMenuItem();
       // build_file.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        build_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/build.png"))); // NOI18N
        build_file.setText("Build Code");
        build_file.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	bflag=1;
//            	//h=new handlers();
//            	h.run();
            	
//            	
//            	//backend.Register.resetRegisters();
//            	//h.update(0);
//            	//new Memory();
//            	handlers.clean_memtable();
//            	handlers.clean_branchtable();
            	//h.update(0);
            	compile();
               
            }
            
        });
        run.add(build_file);

        
        run_runFile = new javax.swing.JMenuItem();
        run_runFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        run_runFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349207_player_play.png"))); // NOI18N
        run_runFile.setText("Run Code");
        run_runFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(enab==false){
            		bflag=0;
            		compile();
            	}
                   else{
                	  // handlers.counter=0;
                	   h.counter_track=1;
                	   
                	   if(h.counter_track<h.counter){
                		   continue_bp.setEnabled(true);
                	   }
                	   else{
                		   continue_bp.setEnabled(false);
                	   }
                	   h.bp1(handlers.counter_track-1);
                	   //handlers.counter++;
                   	}
            	 int start=0;
                 int ending=0;
                 int cn=0;
                try{
                 String text=FrontEnd.activepane.getText();
                 //while(curr<end){
                 for(int i=0;i<ScanFile.a_end.size();i++){
                 	start=0;
                 	ending=0;cn=0;
                 	
                 	while ((ending = text.indexOf('\n', start)) >= 0) {
                 		cn++;
                 		if(cn==ScanFile.a_end.get(i))
                 			frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,redPainter);
                 		start = ending+1;
                 	}
                 
                 }
                 
                }catch(BadLocationException e2){e2.printStackTrace();}
              
            
            
            }
        });

        checkFile = new javax.swing.JMenuItem();
      //  checkFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        checkFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle_red.png"))); // NOI18N
        checkFile.setText("Add/Remove Breakpoint");
        checkFile.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
//            	caretpos = frontend.FrontEnd.activepane.getCaretPosition();
//                end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
//                
//                int x=0;
//                int y=0;
//                Long tr=new Long(0);
//                
//                FrontEnd.activepane.setHighlighter(new frontend.MyHighlighter());
//                FrontEnd.activepane.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
//                
//                
//                FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
//                int curr = ScanFile.getLineNumber(frontend.FrontEnd.activepane, x);
//                
//                File fin=new File(filepath);
//                x=tr.intValue();
//                
//                int end_pos=0;
//                
//                try{
//                	
//                RandomAccessFile b = new RandomAccessFile(fin, "r");
//                String str=b.readLine();
//                int start=0;
//                int ending=0;
//                int cn=0;
//                String text=FrontEnd.activepane.getText();
//                //while(curr<end){
//                while ((ending = text.indexOf('\n', start)) >= 0) {
//                	cn++;
//                	if(cn==end)
//                	frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,redPainter);
//                	start = ending+1;
//                }
//                
//                b.close();
//                
//                }catch(Exception ef){
//                	ef.printStackTrace();
//                }
//                  
//                enab=true;
//                //Test.rem_flag=0;
//                h.counter++; 
//                 if(h.counter_track<h.counter){
//                 	continue_bp.setEnabled(true);
//                 }
//                 h.helper();
            	Test.rem_flag=1;
            	trial();
            	Test.rem_flag=0;
            }
        });

        
        run.add(run_runFile);
        run.add(checkFile);
        run_stepInto = new javax.swing.JMenuItem();
        run_stepInto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        run_stepInto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/StepInto.png"))); // NOI18N
        run_stepInto.setText("Step Into");
        //run_stepInto.setEnabled(false);
        run_stepInto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.stepinto();
            }
        });


        run.add(run_stepInto);

        run_stepOut = new javax.swing.JMenuItem();
        run_stepOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        run_stepOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/stepout.png"))); // NOI18N
        run_stepOut.setText("Step Out");
        run_stepOut.setEnabled(false);
        run_stepOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.stepout();
            }
        });
        
        run.add(run_stepOut);

        run_stepOver = new javax.swing.JMenuItem();
        run_stepOver.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        run_stepOver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/stepover.png"))); // NOI18N
        run_stepOver.setText("Step Over");
        run_stepOver.setEnabled(false);
        run_stepOver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.stepover();
            }
        });
        run.add(run_stepOver);

        reset = new javax.swing.JMenuItem();
        reset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        reset.setText("Reset");
        reset.setEnabled(true);
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.reset();
            }
        });
        //run.add(reset);

        continue_bp= new javax.swing.JMenuItem();
        continue_bp.setText("Continue");
        continue_bp.setEnabled(false);
        continue_bp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.bp1(h.counter_track);
                h.counter_track++;
                if(h.counter_track==h.counter){
                	continue_bp.setEnabled(false);
                }
                int start=0;
                int ending=0;
                int cn=0;
               try{
                String text=FrontEnd.activepane.getText();
                //while(curr<end){
                for(int i=0;i<ScanFile.a_end.size();i++){
                	start=0;
                	ending=0;cn=0;
                	
                	while ((ending = text.indexOf('\n', start)) >= 0) {
                		cn++;
                		if(cn==ScanFile.a_end.get(i))
                			frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,redPainter);
                		start = ending+1;
                	}
                
                }
                
               }catch(BadLocationException e2){e2.printStackTrace();}
                
            }
        });

        
        
        run.add(continue_bp);
        menu.add(run);

        help = new JMenu("Help");


        help_about = new javax.swing.JMenuItem();
        help_about.setText("About Us");
        help_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/about.png"))); // NOI18N
        help_about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new javax.swing.JFrame(), "This is a Java based ARM emulator developed at IIT Delhi.\n Version 2.0\nDevelopers: \nGeetika Malhotra\nNamita Atri\nKushagra Mahajan");
            }
        });
        help.add(help_about);

        help_contact = new javax.swing.JMenuItem();
        help_contact.setText("Contact Us");
        help_contact.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        help_contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/contact.png")));
        help_contact.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Feel free to contact me at emuarmqueries@gmail.com");
            }
        });
        help.add(help_contact);

        help_report = new javax.swing.JMenuItem();
        help_report.setText("Report a bug");
        help_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bug.png")));
        help_report.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new javax.swing.JFrame(), "Thank you for your report. please mail the details to emuarmqueries@gmail.com");
            }
        });
        help.add(help_report);



        menu.add(help);

        this.setJMenuBar(menu);


    }
    static void trial(){
        caretpos = frontend.FrontEnd.activepane.getCaretPosition();
        end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
        
        int x=0;
        int y=0;
        Long tr=new Long(0);
        
        FrontEnd.activepane.setHighlighter(new frontend.MyHighlighter());
        FrontEnd.activepane.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        
        
        FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
        int curr = ScanFile.getLineNumber(frontend.FrontEnd.activepane, x);
        
        File fin=new File(filepath);
        x=tr.intValue();
        
        int end_pos=0;
        
        try{
        	
        RandomAccessFile b = new RandomAccessFile(fin, "r");
        String str=b.readLine();
        int start=0;
        int ending=0;
        int cn=0;
        String text=FrontEnd.activepane.getText();
        
        while ((ending = text.indexOf('\n', start)) >= 0) {
        	
        	cn++;
        	if(cn==end){
        	frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,redPainter);
        	}
        	
        	start = ending+1;
        
        }
        
        b.close();
        
        }catch(Exception ef){
        	ef.printStackTrace();
        }                
        
        enab=true;
        h.counter++; 
        
        if(h.counter_track<h.counter){
        	continue_bp.setEnabled(true);
        }                
        h.helper();
    }

    void compile(){

    	h.run();
    	
    }
    void initializeToolBar() {
        toolbar = new JToolBar();



        f_new = new JButton();
        f_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/new.png"))); // NOI18N
        f_new.setToolTipText("New File");
        f_new.setBorderPainted(false);
        f_new.setFocusable(false);
        
        f_new.addActionListener(new ActionListener() {

        	
            @Override
            public void actionPerformed(ActionEvent e) {
                h.newFile();
            }
            
        });
        
        toolbar.add(f_new);

        f_open = new JButton();
        f_open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349523_folder_add.png"))); // NOI18N
        f_open.setToolTipText("Open File");
        f_open.setFocusable(false);
        f_open.setBorderPainted(false);
        f_open.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.openfile();
            }
        });
        toolbar.add(f_open);

        f_save = new JButton();
        f_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349552_diskette.png"))); // NOI18N
        f_save.setToolTipText("Save File");
        f_save.setFocusable(false);
        f_save.setBorderPainted(false);
        f_save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.savefile();
            }
        });
        toolbar.add(f_save);

        f_exit = new JButton();
        f_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/exit.png"))); // NOI18N
        f_exit.setToolTipText("Exit");
        f_exit.setFocusable(false);
        f_exit.setBorderPainted(false);
        f_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.exit();
            }
        });
        toolbar.add(f_exit);


        e_cut = new JButton();
        e_cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349801_Cut.png"))); // NOI18N
        e_cut.setToolTipText("Cut");
        e_cut.setFocusable(false);
        e_cut.setBorderPainted(false);
        e_cut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.cut();
            }
        });
        toolbar.add(e_cut);

        e_copy = new JButton();
        e_copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349791_Copy.png"))); // NOI18N
        e_copy.setToolTipText("Copy");
        e_copy.setFocusable(false);
        e_copy.setBorderPainted(false);
        e_copy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.copy();
            }
        });
        toolbar.add(e_copy);

        e_paste = new JButton();
        e_paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349865_edit-paste.png"))); // NOI18N
        e_paste.setToolTipText("Paste");
        e_paste.setFocusable(false);
        e_paste.setBorderPainted(false);
        e_paste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.paste();
            }
        });
        toolbar.add(e_paste);

        build = new JButton();
        build.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/build.png"))); // NOI18N
        build.setToolTipText("Build File");
        build.setFocusable(false);
        build.setBorderPainted(false);
        
        build.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	bflag=1;
            	compile();
               
            }
        });

       toolbar.add(build);
       
        
        r_runFile = new JButton();
        r_runFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1309349207_player_play.png"))); // NOI18N
        r_runFile.setToolTipText("Run File");
        r_runFile.setFocusable(false);
        r_runFile.setBorderPainted(false);
        r_runFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(enab==false){
                	bflag=0;
            		compile();
//                	if(frontend.FrontEnd.exceptionraised==0){
//                			h.run();
//                			
//                	}
                		
            	}
                   else{
                	  // handlers.counter=0;
                	   h.counter_track=1;
                	   
                	   if(h.counter_track<h.counter){
                		   continue_bp.setEnabled(true);
                	   }
                	   else{
                		   continue_bp.setEnabled(false);
                	   }
                	   h.bp1(handlers.counter_track-1);
                	   //handlers.counter++;
                   	}
                 }
        });
        toolbar.add(r_runFile);

        r_stepInto = new JButton();
        r_stepInto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/StepInto.png"))); // NOI18N
        r_stepInto.setToolTipText("Step Into");
        r_stepInto.setFocusable(false);
        r_stepInto.setEnabled(true);
        r_stepInto.setBorderPainted(false);
        r_stepInto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.stepinto();
            }
        });
        toolbar.add(r_stepInto);
        r_stepOut = new JButton();
        r_stepOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/stepout.png"))); // NOI18N
        r_stepOut.setToolTipText("Step Out (F8)");
        r_stepOut.setFocusable(false);
        r_stepOut.setBorderPainted(false);
        r_stepOut.setEnabled(false);
        r_stepOut.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.stepout();
            }
        });
        toolbar.add(r_stepOut);

        r_stepover = new JButton();
        r_stepover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/stepover.png"))); // NOI18N
        r_stepover.setToolTipText("Step Over (F9)");
        r_stepover.setFocusable(false);
        r_stepover.setBorderPainted(false);
        r_stepover.setEnabled(false);
        r_stepover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                h.stepover();
            }
        });
        toolbar.add(r_stepover);

        
        r_break = new JButton();
        r_break.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/circle_red.png"))); // NOI18N
        r_break.setToolTipText("Add/Remove Breakpoint");
        r_break.setFocusable(false);
        r_break.setBorderPainted(false);
        r_break.setEnabled(true);
        r_break.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
//                caretpos = frontend.FrontEnd.activepane.getCaretPosition();
//                end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
//                
//                int x=0;
//                int y=0;
//                Long tr=new Long(0);
//                
//                FrontEnd.activepane.setHighlighter(new frontend.MyHighlighter());
//                FrontEnd.activepane.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
//                
//                
//                FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
//                int curr = ScanFile.getLineNumber(frontend.FrontEnd.activepane, x);
//                
//                File fin=new File(filepath);
//                x=tr.intValue();
//                
//                int end_pos=0;
//                
//                try{
//                	
//                RandomAccessFile b = new RandomAccessFile(fin, "r");
//                String str=b.readLine();
//                int start=0;
//                int ending=0;
//                int cn=0;
//                String text=FrontEnd.activepane.getText();
//                //while(curr<end){
//                while ((ending = text.indexOf('\n', start)) >= 0) {
//                	cn++;
//                	if(cn==end){
//                	frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,redPainter);
//                	}
//                	start = ending+1;
//                }
//                
//                b.close();
//                
//                }catch(Exception ef){
//                	ef.printStackTrace();
//                }                
//                
//                enab=true;
//               h.counter++; 
//                
//                if(h.counter_track<h.counter){
//                	continue_bp.setEnabled(true);
//                }                
//                h.helper();
//           	
            	//Test.rem_flag=0;
            	trial();
            }
        });
        toolbar.add(r_break);

        clean = new JButton();
        clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/scr.png"))); // NOI18N
        clean.setToolTipText("Clear the Console");
        clean.setFocusable(false);
        clean.setEnabled(true);
        clean.setBorderPainted(false);
        clean.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	 FrontEnd.statuswindow.setText("");
                 
            }
        });
        toolbar.add(clean);

        
        
        
        /*
         *
         *
         * h_about= new JButton(); h_about.setIcon(new
         * javax.swing.ImageIcon(getClass().getResource("/resources/about.png")));
         * // NOI18N h_about.setToolTipText("About Us");
         * h_about.setFocusable(false); h_about.setBorderPainted(false);
         * h_about.addActionListener(new ActionListener() {
         *
         * @Override public void actionPerformed(ActionEvent e) {
         * JOptionPane.showMessageDialog(new javax.swing.JFrame(),"This is a
         * Java based ARM emulator machine.\n Version 2.0");
         *
         * }
         * }); toolbar.add(h_about);
         *
         * h_contact= new JButton(); h_contact.setIcon(new
         * javax.swing.ImageIcon(getClass().getResource("/resources/contact.png")));
         * // NOI18N h_contact.setToolTipText("Contact Us");
         * h_contact.setFocusable(false); h_contact.setBorderPainted(false);
         * h_contact.addActionListener(new ActionListener() {
         *
         * @Override public void actionPerformed(ActionEvent e) {
         * JOptionPane.showMessageDialog(new javax.swing.JFrame(),"Feel free to
         * contact me at emuarmqueries@gmail.com"); } });
         * toolbar.add(h_contact);
         *
         * h_report= new JButton(); h_report.setIcon(new
         * javax.swing.ImageIcon(getClass().getResource("/resources/bug.png")));
         * // NOI18N h_report.setToolTipText("Report a Bug");
         * h_report.setFocusable(false); h_report.setBorderPainted(false);
         * h_report.addActionListener(new ActionListener() {
         *
         * @Override public void actionPerformed(ActionEvent e) {
         * JOptionPane.showMessageDialog(new javax.swing.JFrame(),"Thank you for
         * your report. please mail the details to emuarmqueries@gmail.com"); }
         * }); toolbar.add(h_report);
         *
         */
        JLabel junk = new JLabel("                ");
        toolbar.add(junk);
        steprun = new JButton();
        steprun.setText("Next");
        steprun.setVisible(false);
        steprun.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    h.steprunActionPerformed(evt);
                } catch (IOException ex) {
                }
            }
        });
        toolbar.add(steprun);
        
        warning = new JLabel();
        warning.setForeground(new java.awt.Color(255, 0, 0));
        warning.setText("**End of File Reached");
        warning.setVisible(false);
        toolbar.add(warning);

        cross = new JButton();
        cross.setText("X");
        cross.setVisible(false);
        cross.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steprun.setEnabled(true);
                steprun.setVisible(false);
                warning.setVisible(false);
                cross.setVisible(false);
            }
        });
        toolbar.add(cross);

// Code adding the component to the parent container - not shown here


        this.add(toolbar, BorderLayout.PAGE_START);

    }

    public static JSplitPane setDividerLocation(final JSplitPane splitter, final double proportion) {
        if (splitter.isShowing()) {
            if (splitter.getWidth() > 0 && splitter.getHeight() > 0) {
                splitter.setDividerLocation(proportion);
            } else {
                splitter.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentResized(ComponentEvent ce) {
                        splitter.removeComponentListener(this);
                        setDividerLocation(splitter, proportion);
                    }
                });
            }
        } else {
            splitter.addHierarchyListener(new HierarchyListener() {

                @Override
                public void hierarchyChanged(HierarchyEvent e) {
                    if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0
                            && splitter.isShowing()) {
                        splitter.removeHierarchyListener(this);
                        setDividerLocation(splitter, proportion);
                    }
                }
            });
        }
        return splitter;
    }

    public static void main() {
        FrontEnd fe = new FrontEnd();

    }
    
    public JTabbedPane SidePane;
    public static JTabbedPane EditorPane;
    public FileTree TreePane;
    public static JTabbedPane check;
    public JScrollPane RegisterContainer;
    public JScrollPane EditorContainer;
    public JScrollPane TreeContainer;
    public JScrollPane StatusContainer;
    public static JTextArea statuswindow;
    public JScrollPane checkpointsContainer;
    public JSplitPane registerPaneAndEditor;
    public JSplitPane OutputAndPanels;
    public JSplitPane EditorAndTreeView;
    public JSplitPane checkpoints;
    public JScrollPane container;
    //*********menu bar variables***************
    JMenuBar menu;
    JMenu file;
    JMenu edit;
    JMenu run;
    JMenu help;
    JMenuItem file_new;
    JMenuItem file_open;
    JMenuItem file_save;
    JMenuItem file_exit;
    JMenuItem edit_cut;
    JMenuItem edit_copy;
    JMenuItem edit_paste;
    JMenuItem run_runFile;
    JMenuItem build_file;
    
    
    public static int end;
    public static int caretpos;
    
    JMenuItem checkFile;
    public static boolean enab=false;
    
    JMenuItem run_stepInto;
    public static JMenuItem run_stepOut;
    
    public static JMenuItem run_stepOver;
    public static JMenuItem reset;
    public static JMenuItem continue_bp;
    
    JMenuItem help_about;
    JMenuItem help_contact;
    JMenuItem help_report;
    //*************toolbar variables
    JToolBar toolbar;
    JButton f_new;
    JButton f_open;
    JButton f_save;
    JButton f_exit;
    JButton e_cut;
    JButton e_copy;
    JButton e_paste;
    public static JButton r_runFile;
    public static JButton r_stepInto;
    public static JButton r_stepOut;
    public static JButton r_stepover;
    public static JButton r_break;
    public static JButton clean;
    public static JButton build;
   
    
    
    
    JButton h_about;
    JButton h_contact;
    JButton h_report;
    public static handlers h;
    checkpoint c;
    //****************************
    public static JEditorPane activepane;
    //*********** stepinto toolbar variables
    public static JButton cross;
    public static javax.swing.JButton steprun;
    public static javax.swing.JLabel warning;
    //**************************************

    private void initializeEditorPane() {
        /*
         * JPanel welcome=new JPanel(); JLabel photo=new JLabel();
         *
         * photo.setBackground(new java.awt.Color(255, 255, 255));
         *
         * photo.setIcon(new
         * javax.swing.ImageIcon(getClass().getResource("/resources/backgrnd.jpg")));
         * // NOI18N
         *
         * welcome.add(photo); FrontEnd_new.EditorPane.add("Welcome", welcome);
         * FrontEnd_new.EditorPane.setTabComponentAt(0, new
         * ButtonTabComponent(FrontEnd_new.EditorPane));
         */

        h.newFile();
        h.update(0);
    }

    private void intializeSidePane() {
        registerPane rp = new registerPane();
        //rp.setPreferredSize(new Dimension(dimension.width/4,(5*dimension.height)/8));
        //rp.setMinimumSize(new Dimension(dimension.width/4,(5*dimension.height)/8));
        //rp.setBorder(new EmptyBorder(0,0,0,10));
        ImageIcon icon1=new ImageIcon(getClass().getResource("/resources/Integrated-circuit1.png"));
        
        SidePane.addTab("Register Set",icon1, rp,"Register Set");
        
        memorytable mt = new memorytable();
         mt.setPreferredSize(new Dimension(2*dimension.width/9,(5*dimension.height)/8));
        //mt.setMinimumSize(new Dimension(dimension.width/4,(5*dimension.height)/8));
       // mt.setMaximumSize(new Dimension(2*dimension.width/9,(5*dimension.height)/8));
        
        ImageIcon icon2=new ImageIcon(getClass().getResource("/resources/14009262271.png"));
       // ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon2.getImage(), 32, 32));

        SidePane.addTab("Memory Table",icon2 ,mt,"Memory Table");
        
        
        JumpTable jt = new JumpTable();
        jt.setPreferredSize(new Dimension(2*dimension.width/9,(5*dimension.height)/8));
        //jt.setMinimumSize(new Dimension(dimension.width/4,(5*dimension.height)/8));
        ImageIcon icon3=new ImageIcon(getClass().getResource("/resources/PrinterKiller-Paper1.png"));
        
        SidePane.addTab("Jump Table",icon3, jt,"Jump Table");
        SidePane.setSelectedIndex(0);
        

    }

    private void initializecheckpoints() {
//        checkpoints c=new checkpoints();
//        button.add("button",c);
    }

    public static void addTab(checkpoint b) {
        if (check.getTabCount() == 1) {
            check.removeTabAt(0);
        }
       
        ImageIcon icon4=new ImageIcon(FrontEnd.class.getResource("/resources/check-list21.png"));
        
        check.addTab("check",icon4, b,"check");
    
    }

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	int focus_fl=0;
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		if(focus_fl==1){
			int start=0;
            int ending=0;
            int cn=0;
            
           try{
            String text=FrontEnd.activepane.getText();

            for(int i=0;i<handlers.a_end.size();i++){
            	start=0;
            	ending=0;cn=0;
            	
            	while ((ending = text.indexOf('\n', start)) >= 0) {
            		cn++;
            		if(cn==handlers.a_end.get(i)){
            			frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,redPainter);
            			break;
            		}
            		start = ending+1;
            	}
            
            }
            
           }catch(BadLocationException e2){e2.printStackTrace();}
         
		}
		focus_fl=0;
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		focus_fl=1;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}

class Test {
	  JPopupMenu menu = new JPopupMenu("Popup");
	  JMenuItem item1,item2;
	 // public static handlers h=new handlers();
	  public static int rem_flag=0;
	  //	  class MyLabel extends JLabel {
//	    public MyLabel(String text) {
//	    
//	      super(text);
//	      addMouseListener(new PopupTriggerListener());
//	    
//	    }

	    class PopupTriggerListener extends MouseAdapter {
	    	
	    	public void mousePressed(MouseEvent ev) {
	    	  int caretpos = frontend.FrontEnd.activepane.getCaretPosition();
              
              int end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
            
              	FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
                File fin=new File(FrontEnd.filepath);
               
        	
	    	  if (ev.isPopupTrigger()) {
	        	   if(handlers.a_end.contains(end)){
		    		  int x=menu.getComponentIndex(item1);
	        		  menu.remove(x);
		    		  menu.show(ev.getComponent(), ev.getX(), ev.getY());
		    		  menu.add(item1);
		    		  }
		    	  else{
		    		  int y=menu.getComponentIndex(item2);
		    		  menu.remove(y);
		    		  menu.show(ev.getComponent(), ev.getX(), ev.getY());
		    		  menu.add(item2);
		    		  }

	        
	        }
	      }

	      public void mouseReleased(MouseEvent ev) {
	        if (ev.isPopupTrigger()) {
	        
	        
	        
	        }
	      }

	      public void mouseClicked(MouseEvent ev) {
	    	  
	     }
	    }
	  //}

	 // JLabel label = new MyLabel("right-click");

	  public Test() {
	   // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    FrontEnd.activepane.addMouseListener(new PopupTriggerListener());
		item1 = new JMenuItem("Add Breakpoint");
	    item1.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
//  int caretpos = frontend.FrontEnd.activepane.getCaretPosition();
//              
//              int end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
//            
//              	FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
//                File fin=new File(FrontEnd.filepath);
//               
//        	
//	    	  try{
//	    		  RandomAccessFile b = new RandomAccessFile(fin, "r");
//	                String str=b.readLine();
//	                int start=0;
//	                int ending=0;
//	                int cn=0;
//	                String text=FrontEnd.activepane.getText();
//	                //while(curr<end){
//	                while ((ending = text.indexOf('\n', start)) >= 0) {
//	                	cn++;
//	                	if(cn==end)
//	                	frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,FrontEnd.redPainter);
//	                	start = ending+1;
//	                }
//	                
//	                b.close();
//	                
//	                }
//        	 		catch(Exception ef){
//	                	ef.printStackTrace();
//	                }
//	             rem_flag=1;  
//    		  FrontEnd.enab=true;
//                FrontEnd.h.counter++; 
//                 if(FrontEnd.h.counter_track<FrontEnd.h.counter){
//                 	FrontEnd.continue_bp.setEnabled(true);
//                 }
              
    		 // FrontEnd.h.helper();
    			//rem_flag=1;
	    	  FrontEnd.trial();    		  
	      }
	    });
	    menu.add(item1);

	    item2 = new JMenuItem("Remove Breakpoint");
	    item2.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  
//	    	  int caretpos = frontend.FrontEnd.activepane.getCaretPosition();
//              
//              int end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
//            
//              	FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
//                File fin=new File(FrontEnd.filepath);
//               
//        	
//	    	  try{
//	    		  RandomAccessFile b = new RandomAccessFile(fin, "r");
//	                String str=b.readLine();
//	                int start=0;
//	                int ending=0;
//	                int cn=0;
//	                String text=FrontEnd.activepane.getText();
//	                //while(curr<end){
//	                while ((ending = text.indexOf('\n', start)) >= 0) {
//	                	cn++;
//	                	if(cn==end)
//	                	frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1,FrontEnd.redPainter);
//	                	start = ending+1;
//	                }
//	                
//	                b.close();
//	                
//	                }
//        	 		catch(Exception ef){
//	                	ef.printStackTrace();
//	                }
//	             rem_flag=1;  
//    		  FrontEnd.enab=true;
//                FrontEnd.h.counter++; 
//                 if(FrontEnd.h.counter_track<FrontEnd.h.counter){
//                 	FrontEnd.continue_bp.setEnabled(true);
//                 }
              
    		  //FrontEnd.h.helper();
	    	  rem_flag=1;
	    	  FrontEnd.trial();
	    	  rem_flag=0;
	      }
	    });
	    menu.add(item2);

//	    getContentPane().add(label);
//	    pack();
//	    setSize(300, 100);
	  }
	}
