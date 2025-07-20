package JavaSwingADv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multiplicationtable extends JFrame {
    Container c;
    JLabel imglv,txtLv;
    JTextArea ta;
    JTextField tf;
    JButton clearbt,enterbt;
    ImageIcon img;
    Font f,f2;
    Cursor cs;


    Multiplicationtable(){
        intComponents();
    }

    private void intComponents() {
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        f=new Font("Arial",Font.BOLD,15);
        f2=new Font("Arial",Font.BOLD,20);

        img=new ImageIcon(getClass().getResource("Multi.png"));
        Image scaledImage = img.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);
        imglv=new JLabel(img);
        imglv.setBounds(70,10,img.getIconWidth(),img.getIconHeight());
        c.add(imglv);

        txtLv=new JLabel("Enter Any Number:");
        txtLv.setBounds(40,150,250,50);
        txtLv.setForeground(Color.black);
        txtLv.setFont(f);
        c.add(txtLv);

        tf=new JTextField();
        tf.setBounds(200,150,90,50);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(f);
        tf.setBackground(Color.pink);
        tf.setForeground(Color.black);
        c.add(tf);

        cs=new Cursor(Cursor.HAND_CURSOR);

        clearbt=new JButton("Clear");
        clearbt.setBounds(200,210,90,50);
        clearbt.setCursor(cs);
        clearbt.setFont(f);
        //clearbt.setBackground(Color.pink);
        c.add(clearbt);

        enterbt = new JButton("Enter"); // Added
        enterbt.setBounds(60,210,90,50); // Position
        enterbt.setCursor(cs);
        enterbt.setFont(f);
        c.add(enterbt);

        ta=new JTextArea();
        ta.setBounds(20,300,300,300);
        ta.setBackground(Color.pink);
        ta.setFont(f2);
        c.add(ta);


        ActionListener generateTable = new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=tf.getText();
                if(value.isEmpty()){
                    JOptionPane.showMessageDialog(null,"You did not put any number");
                }
                else{
                    ta.setText("");
                    int num=Integer.parseInt(tf.getText());

                    for(int i=1;i<=10;i++){

                        int rest=num*i;
                        String r=String.valueOf(rest);
                        String n=String.valueOf(num);
                        String s=String.valueOf(i);

                        ta.append(n+" x "+s+"="+r+"\n");
                    }
                }

            }
        };
        tf.addActionListener(generateTable);
        enterbt.addActionListener(generateTable);
        clearbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
            }
        });
    }



    public static void main(String[] args) {
        Multiplicationtable frame= new Multiplicationtable();
        frame.setVisible(true);
        frame.setBounds(300,30,360,700);
        frame.setTitle("Multiplication Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
