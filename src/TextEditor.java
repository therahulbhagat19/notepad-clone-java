import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;




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

        //Create content pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        //Add text area to the panel
        panel.add(textarea,BorderLayout.CENTER);
        //Create Scroll pane
        JScrollPane scrollpane = new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //Add scroll pane to panel
        panel.add(scrollpane);
        //Add panel to frame
        frame.add(panel);

        //Setting dimensions of the frame           
        frame.setBounds(0,0,400,400);
        frame.setTitle("Rahul's Text Editor");
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
        if(actionevent.getSource()==openfile){
            JFileChooser filechooser = new JFileChooser("/");
            int chooseoption = filechooser.showOpenDialog(null);
            if(chooseoption==JFileChooser.APPROVE_OPTION){
               File file = filechooser.getSelectedFile();
               String filepath = file.getPath();
                try{
                    FileReader filereader = new FileReader(filepath); 
                    BufferedReader bufferedreader = new BufferedReader(filereader);
                    String inter = "", output = "";
                    while((inter=bufferedreader.readLine())!=null){
                        output+=inter+"\n";
                    }
                    textarea.setText(output);
                }
                catch(FileNotFoundException filenotfoundexception){
                    filenotfoundexception.printStackTrace();
                }
                catch(IOException ioexception){
                    ioexception.printStackTrace();

                }

            }
        }
        if(actionevent.getSource()==savefile){
            JFileChooser filechooser = new JFileChooser("/");
            int chooseoption = filechooser.showSaveDialog(null);
            if(chooseoption==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath()+".txt");
                try{
                    FileWriter filewriter = new FileWriter(file);
                    BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
                    textarea.write(bufferedwriter);
                    bufferedwriter.close();
                }
                catch(IOException ioexception){
                    ioexception.printStackTrace();
                }
            }

        }
        if(actionevent.getSource()==newfile){
            TextEditor newtexteditor = new TextEditor();
        }

    }


    public static void main(String[] args){
        TextEditor texteditor = new TextEditor();

        
    }
}
