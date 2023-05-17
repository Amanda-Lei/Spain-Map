import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.ArrayList;

public class PopUp extends JDialog{
    int scale = 10;

    public PopUp(String inputFile, Region region){
        StdIn.setFile(inputFile);
        JFrame frame = new JFrame();
        JPanel c = new JPanel(new BorderLayout());

        //title
        JLabel name = new JLabel("Region Name");
        name.setText(region.getName().toUpperCase());
        name.setFont(new Font("Verdana", Font.BOLD, 25));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setBorder(new EmptyBorder(scale, 0, scale, 0));
        c.add(name, BorderLayout.PAGE_START);

        //body
        JTextArea textArea = new JTextArea(5, 40);
        for(String info : getText(region.getName())){
            textArea.append("\n" + info);
        }
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        c.add(scrollPane, BorderLayout.CENTER);

        //bottom
        JButton b = new JButton("Completed");
        b.setBounds(50,100,95,30);  
        b.addActionListener(new ActionListener(){ 

            public void actionPerformed(ActionEvent e){  
                System.out.println("completed");
                region.setSolved(true);
                frame.dispose();
            }

        });
        c.add(b, BorderLayout.PAGE_END);

        frame.add(c);
        frame.setTitle("Region");
        frame.setSize(70*scale, 100*scale);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public ArrayList<String> getText(String name) {
        boolean found = false;
        while (!StdIn.isEmpty()) {
            if(name.equalsIgnoreCase(StdIn.readLine())){
                found = true;
                System.out.println("found");
                break;
            }
        }
        ArrayList<String> text = new ArrayList<>();
        int spaceCount = 0;
        if (found) { while (!StdIn.isEmpty()){
            String t = StdIn.readLine();
            if (t == "") { spaceCount++; }
            else { spaceCount = 0; }
            if (spaceCount > 1) { break; }
            text.add(t);
        } }

        return text;
    }

}
