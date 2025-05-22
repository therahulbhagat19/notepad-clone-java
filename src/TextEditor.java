import javax.swing.*;


public class TextEditor {
    
    JFrame frame;
    JMenuBar menubar;
    JMenu file,edit;
    JMenuItem newfile, openfile, savefile;
    JMenuItem cut, copy, paste, selectall,close;
    JTextArea textarea;

    TextEditor(){
        //Initialise a Frame for the Editor
        frame = new JFrame();
        //Initialise a menubar
        menubar = new JMenuBar();
        //Initialise text area
        textarea = new JTextArea();
        //Initialise menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        //Initialise File menu items
        newfile = new JMenuItem("New Window");
        openfile = new JMenuItem("Open File");
        savefile = new JMenuItem("Save File");
        //Add menu items to file menu
        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        //Initialise Edit memu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectall = new JMenuItem("Select All");
        close = new JMenuItem("Close");
        //Adding to edit Menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        edit.add(close);

        //Add menus to menubar
        menubar.add(file);
        menubar.add(edit);


        //set the menubar to the frame
        frame.setJMenuBar(menubar);

        //Add text area to frame
        frame.add(textarea);

        //Setting dimensions of the frame           
        frame.setBounds(0,0,400,400);
        frame.setVisible(true);
        frame.setLayout(null);
    }


    public static void main(String[] args){
        TextEditor texteditor = new TextEditor();

        
    }
}
