import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.ArrayList;

public class PopUp extends JDialog{
    int scale = 10;

    public PopUp(String inputFile, Region region){
        StdIn.setFile(inputFile);

        JLabel name = new JLabel("Region Name");
        name.setText(region.getName().toUpperCase());
        name.setFont(new Font("Verdana", Font.BOLD, 25));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setBorder(new EmptyBorder(scale, 0, scale, 0));
        this.add(name, BorderLayout.PAGE_START);

        JTextArea textArea = new JTextArea(5, 40);

        String text = "The quick brown fox jumps over the lazy dog.\n";

        textArea.setText(text);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        text = "The quick brown fox jumps over the lazy dog.";
        textArea.append(text);

        // Wrap the lines of the JTextArea if it does not fit in the
        // current allocated with of the JTextArea.
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER);

        setTitle("Region");
        setSize(70*scale, 100*scale);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public ArrayList<String> getText(String name) {

        boolean found = false;
        while (!StdIn.isEmpty()) {
            if(name == StdIn.readLine()){
                found = true;
                break;
            }
        }

        ArrayList<String> text = new ArrayList<>();

        if (found){
            while (!StdIn.isEmpty()){
                text.add(StdIn.readLine());
            }
        }

        return text;
    }

}
