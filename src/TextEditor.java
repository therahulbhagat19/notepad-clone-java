import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextEditor implements ActionListener {
    
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
        //Add action listener to file menu items
        newfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);



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
        //add action listener to edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        close.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent actionevent){
        if(actionevent.getSource()==cut){
            //perform cut
            textarea.cut();
        }
        if(actionevent.getSource()==copy){
            //perform copy
            textarea.copy();
        }
        if(actionevent.getSource()==paste){
            //perform paste
            textarea.paste();
        }
        if(actionevent.getSource()==selectall){
            //perform selectall
            textarea.selectAll();
        }
        if(actionevent.getSource()==close){
            //perform close
            System.exit(0);
        }

    }


    public static void main(String[] args){
        TextEditor texteditor = new TextEditor();

        
    }
}
