import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends Frame implements ActionListener {

    private File fileObj;
    private MenuBar mbr;
    private Menu file,help;
    private MenuItem nw,open,saveas,save,close;
    private Panel p;
    private FileDialog op,sv,newfile;
    private TextArea txt;
    private String text="";
    private String dir,fil;
    public TextEditor()
    {
        setTitle("TextEditor");
        setSize(800,600);
        setVisible(true);
        p = new Panel();
        mbr = new MenuBar();

        file = new Menu("File");

        nw = new MenuItem("New");
        nw.addActionListener(this);
        file.add(nw);
        open = new MenuItem("Open");
        open.addActionListener(this);
        file.add(open);
        save = new MenuItem("Save");
        save.addActionListener(this);
        file.add(save);
        saveas = new MenuItem("Save As");
        saveas.addActionListener(this);
        file.add(saveas);
        close = new MenuItem("Close");
        close.addActionListener(this);
        file.add(close);
        mbr.add(file);

        help = new Menu("Help");
        MenuItem about;
        about = new MenuItem("About");
        help.add(about);
        mbr.add(help);

        setMenuBar(mbr);

        txt = new TextArea();
        add(txt,BorderLayout.CENTER);


        MyWindowAdapter win = new MyWindowAdapter(this);
        addWindowListener(win);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==open)
        {
            op = new FileDialog(this,"Open File",FileDialog.LOAD);
            op.setVisible(true);
            op.setSize(500,500);
            dir = op.getDirectory();
            fil = op.getFile();
            fileObj = new File(dir,fil);
            FileOperations fread = new FileOperations(dir,fil);
            text = fread.readFile();
            txt.setText(text);
        }

        if(ae.getSource()==save)
        {
            FileOperations save = new FileOperations(fileObj);
            String write = txt.getText();
            save.writeFile(write);
        }

        if(ae.getSource()==saveas)
        {
            sv = new FileDialog(this,"Save File As",FileDialog.SAVE);
            sv.setSize(500,500);
            sv.setVisible(true);
            dir = sv.getDirectory();
            fil = sv.getFile();
            String write = txt.getText();
            fileObj = new File(dir,fil);
            FileOperations fwrite = new FileOperations(dir,fil);
            fwrite.writeFile(write);
        }

        if(ae.getSource()==nw)
        {
            newfile =new FileDialog(this,"New File",FileDialog.SAVE);
            newfile.setSize(500,500);
            newfile.setVisible(true);
            dir = newfile.getDirectory();
            fil = newfile.getFile();
            fileObj = new File(dir,fil);
        }

        if(ae.getSource() == close)
        {
            dispose();
        }
    }

    public static void main(String[] args){
        new TextEditor();
    }
}
