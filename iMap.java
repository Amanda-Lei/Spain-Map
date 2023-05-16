import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//where mouse interactions trigger other classes
public class iMap extends Canvas implements MouseListener {
    RegionController model = new RegionController("MyMapInfo.txt");
    String imageFile = "SpainMap.png";

    public iMap(){
        //image = ImageIO.read(newFile("SpainMap.png"));
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

    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage(imageFile);  
        g.drawImage(i, 120,100,this);  
          
    }  
    public static void main(String[] args) {  
        iMap m = new iMap();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(400,400);  
        f.setVisible(true);  
    }  

}