import java.awt.*;
import javax.swing.*;

public class Region extends JFrame {
    boolean locked;
    int x;
    int y;
    int w;
    int h;
    String name;
    String description;
    boolean solved;

    public Region( int x, int y, int w, int h, String name ){//temporary until further information is filled
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.name = name;
    }
    public Region( int x, int y, int w, int h, String name, String description, boolean solved ){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.name = name;
        this.description = description;
        this.solved = solved;
    }

    public void drawRectangle(){}

    public Rectangle getRectangle(){ return new Rectangle(x, y, w, h); }
}
