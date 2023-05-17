import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.ArrayList;

public class PopUp extends JDialog{
    int scale = 10;

    public PopUp(String inputFile, Region region){
        StdIn.setFile(inputFile);

        //title
        JLabel name = new JLabel("Region Name");
        name.setText(region.getName().toUpperCase());
        name.setFont(new Font("Verdana", Font.BOLD, 25));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setBorder(new EmptyBorder(scale, 0, scale, 0));
        this.add(name, BorderLayout.PAGE_START);

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

        this.add(scrollPane, BorderLayout.CENTER);

        //bottom
        JButton b = new JButton("Completed");
        b.setBounds(50,100,95,30);  
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                System.out.println("completed");
                region.setSolved(true);
            }  
        });
        this.add(b, BorderLayout.PAGE_END);

        setTitle("Region");
        setSize(70*scale, 100*scale);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
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
        if (found){ while (!StdIn.isEmpty()){
                text.add(StdIn.readLine());
        } }

        // if (found){ while (!StdIn.isEmpty()){
        //     System.out.println("1");
        //     String t = StdIn.readLine();
        //     System.out.println("2");
        //     if (t == " "){ spaceCount++; System.out.println("3"); }
        //     if (spaceCount > 1) {break;}
        //     else{spaceCount = 0; }
        //     System.out.println("4");
        //     text.add(t);
        // } }

        return text;
    }

}
