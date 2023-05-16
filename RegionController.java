import java.awt.*;
import javax.swing.*;

public class RegionController {
    private Region[] regions;

    public RegionController(String inputFile){
        StdIn.setFile(inputFile);
        
        int j = Integer.parseInt(StdIn.readString()); //number of regions
        regions = new Region[j];
        for (int i = 0; i < j; i++){
            int x = Integer.parseInt(StdIn.readString());
            int y = Integer.parseInt(StdIn.readString());
            int w = Integer.parseInt(StdIn.readString());
            int h = Integer.parseInt(StdIn.readString());
            String name = StdIn.readString(); //might have to adjust for names with several words
            //add description and solved param later

            regions[i] = new Region(x,y,w,h,name);
        }
    }

    public Region[] getRegions() { return regions; }

    public Region find(Point p){ //find the region that contains point
        for ( Region next : regions ){
            Rectangle r = next.getRectangle();
            boolean hasIt = r.contains(p);
            if (hasIt){ return next; }
        }
        return null;
    }
}
