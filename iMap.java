import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//where mouse interactions trigger other classes
public class iMap extends JPanel implements MouseListener {
    RegionController model = new RegionController("MyMapInfo.txt");
    //BufferedImage image;

    public iMap(){
        //image = Util.readImage("SpainMap.png");
        addMouseListener( this );
    }

    public void mouseClicked( MouseEvent e ){
        int x = e.getX();
        int y = e.getY();
        Point clicked = new Point(x, y);
        Region rm = model.find(clicked);
    }

    public void mouseEntered( MouseEvent e ) {}
    public void mouseExited( MouseEvent e ) {}
    public void mouseMoved( MouseEvent e ) {}
    public void mousePressed( MouseEvent e ) {}
    public void mouseReleased( MouseEvent e ) {}

}