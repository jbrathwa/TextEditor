
import java.awt.*;
import java.awt.event.*;
public class MyWindowAdapter extends WindowAdapter {
    private Frame fm;
    public MyWindowAdapter(Frame fm)
    {
        this.fm = fm;
    }
    public void windowClosing(WindowEvent we)
    {
        fm.dispose();
    }
}
