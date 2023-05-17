import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//where mouse interactions trigger other classes
public class iMap extends Canvas implements MouseListener {
    RegionController model = new RegionController("MapCoords.txt");
    String imageFile = "SpainMap.jpeg";
    String infoFile = "RegionInfo.txt";

    public iMap(){
        //image = ImageIO.read(newFile("SpainMap.png"));
        addMouseListener( this );
    }

    public void mouseClicked( MouseEvent e ){
        int x = e.getX();
        int y = e.getY();
        Point clicked = new Point(x, y);
        Region rm = model.find(clicked);
        PopUp popUp = new PopUp(infoFile, rm);
    }

    public void mouseEntered( MouseEvent e ) {}
    public void mouseExited( MouseEvent e ) {}
    public void mouseMoved( MouseEvent e ) {}
    public void mousePressed( MouseEvent e ) {}
    public void mouseReleased( MouseEvent e ) {}

    public void paint(Graphics g) {  
    
        Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(imageFile);
        g.drawImage(i, 0, 0, 980, 700, this);
        for (Region r : model.getRegions()){
            g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
        }
    
    }
    public static void main(String[] args) {  
        iMap m = new iMap();  
        JFrame f = new JFrame();  
        f.add(m);
        f.setSize(980,700);
        f.setVisible(true); 


        // if (model.countSolvedRooms()==model.getRegions().length){
        //     JOptionPane.showMessageDialog(f, "Please ensure compliance!",
        //        "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        // }

    }  

}