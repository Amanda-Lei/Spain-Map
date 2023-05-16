import java.awt.*;

public class Region {
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
}
