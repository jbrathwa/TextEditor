import java.awt.*;
import java.awt.event.*;
public class MyDialog extends Dialog implements ActionListener
{
    static final int TWOBUTTON = 2;
    static final int ONEBUTTON = 1;
    private Label str;
    private Button yes,no,close;
    private Panel p;
    private Frame fm;
    public MyDialog(Frame fm,String title,String text,int how)
    {

        super(fm,title,false);
        this.fm = fm;
        setLayout(new BorderLayout());
        setSize(200,150);
        str = new Label(text);
        add(str);

        if(how == TWOBUTTON)
        {
            p = new Panel();
            yes = new Button("Yes");
            no = new Button("No");
            p.add(yes);
            p.add(no);
            add(p,BorderLayout.SOUTH);
            yes.addActionListener(this);
            no.addActionListener(this);
        }

        if(how == ONEBUTTON)
        {
            close = new Button("Close");
            p = new Panel();
            p.add(close)
            add(p,BorderLayout.SOUTH);
            close.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==close)
        {
            dispose();
        }

        if(ae.getSource()==yes)
        {
           fm.dispose();
        }

        if(ae.getSource()==no)
        {
            dispose();
        }
    }
}
