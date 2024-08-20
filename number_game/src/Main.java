import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class numbergame_level3 extends JFrame implements ActionListener
{
    ImageIcon i1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p1.jpg");
    ImageIcon i2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p2.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p3.jpg");
    ImageIcon i4=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p4.jpg");
    ImageIcon i5=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p5.jpg"); 
    ImageIcon i6=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p6.jpg");
    ImageIcon i7=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p7.jpg");
    Font f=new Font("arial",Font.BOLD,15);
    JLabel l1=new JLabel("Enter Guess Number",i6,SwingConstants.HORIZONTAL);
    JLabel l2=new JLabel("Score",i1,SwingConstants.HORIZONTAL);
    JLabel l3=new JLabel("Attempts",i2,SwingConstants.HORIZONTAL);
    JLabel l4=new JLabel("Actual Number",i7,SwingConstants.HORIZONTAL);
    JLabel l5=new JLabel("Level",i5,SwingConstants.HORIZONTAL);
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JButton b1=new JButton("Test",i3);
    JButton b2=new JButton("Refresh",i4);
    static int score=0,attempts=0,level=2;

    numbergame_level3()
    {
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Number Game");
        setResizable(false);
        t2.setBackground(Color.lightGray);
        t3.setBackground(Color.lightGray);
        t5.setBackground(Color.lightGray);

        l2.setBounds(20,20,100,30);
        l3.setBounds(190,20,100,30);
        l1.setBounds(20,100,200,30);
        l4.setBounds(20,150,200,30);
        l5.setBounds(20,200,200,30);
        t1.setBounds(240,100,100,30);
        t4.setBounds(240,150,100,30);
        t5.setBounds(240,200,100,30);
        t2.setBounds(110,20,50,30);
        t3.setBounds(290,20,50,30);

        b1.setBounds(20,280,130,30);
        b2.setBounds(240,280,130,30);
        l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);t1.setFont(f);
        t2.setFont(f);t3.setFont(f);t4.setFont(f);t5.setFont(f);l5.setFont(f);
        add(l1);add(l2);add(l3);add(l4);add(t1);add(l5);
        add(t2);add(t3);add(t4);add(b1);add(b2);add(t5);
        t2.setEditable(false);t3.setEditable(false);t4.setEditable(false);t5.setEditable(false);
        b1.addActionListener(this);b2.addActionListener(this);
        t5.setText(""+this.level);t2.setText(""+this.score);t3.setText(""+this.attempts);
        JOptionPane.showMessageDialog(null, "Level: 2\n Number of Attempts:10 \n Guessing Range: 1 to 20", "Instruction", JOptionPane.INFORMATION_MESSAGE);

    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==b1)
        {

            repaint();
            try {
                if (this.attempts == 20&&this.score<4) {
                    JOptionPane.showMessageDialog(null, "Game Over", "Message", JOptionPane.INFORMATION_MESSAGE);
                    int x=JOptionPane.showConfirmDialog(this,"Do you want play again?","Play Again",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(x==0)
                    {
                        this.attempts = 0;
                        this.score = 0;
                        t1.setText(null);
                        t2.setText(null);
                        t3.setText(null);
                        t4.setText(null);
                    }
                    else
                    {
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                }
                else if(this.attempts==20&&this.score>=4)
                {
                    JOptionPane.showMessageDialog(null, "Congratulations!!! You win the Game", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    int original_number = Integer.parseInt(t1.getText());

                    int random_number = (int) Math.floor(Math.random() * 100);

                    if (random_number == original_number) {
                        t4.setText("" + random_number + "");
                        this.score = this.score + 1;
                        this.attempts = this.attempts + 1;
                        JOptionPane.showMessageDialog(null, "Your Guess is appropriate", "Message", JOptionPane.INFORMATION_MESSAGE);
                        t2.setText("" + this.score + "");
                        t3.setText("" + this.attempts + "");
                        repaint();
                    } else {
                        this.attempts = this.attempts + 1;
                        t2.setText("" + this.score + "");
                        t3.setText("" + this.attempts + "");
                        t4.setText("" + random_number + "");
                        JOptionPane.showMessageDialog(null, "Your Guess is not matching", "Message", JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                    }
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Number is necessary "+e, "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(k.getSource()==b2)
        {
            t1.setText(null);
            t4.setText(null);
            repaint();
        }
    }
}

class numbergame_level2 extends JFrame implements ActionListener
{
    ImageIcon i1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p1.jpg");
    ImageIcon i2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p2.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p3.jpg");
    ImageIcon i4=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p4.jpg");
    ImageIcon i5=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p5.jpg");
    ImageIcon i6=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p6.jpg");
    ImageIcon i7=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p7.jpg");
    Font f=new Font("arial",Font.BOLD,15);
    JLabel l1=new JLabel("Enter Guess Number",i6,SwingConstants.HORIZONTAL);
    JLabel l2=new JLabel("Score",i1,SwingConstants.HORIZONTAL);
    JLabel l3=new JLabel("Attempts",i2,SwingConstants.HORIZONTAL);
    JLabel l4=new JLabel("Actual Number",i7,SwingConstants.HORIZONTAL);
    JLabel l5=new JLabel("Level",i5,SwingConstants.HORIZONTAL);
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JButton b1=new JButton("Test",i3);
    JButton b2=new JButton("Refresh",i4);
    static int score=0,attempts=0,level=2;

    numbergame_level2()
    {
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Number Game");
        setResizable(false);
        t2.setBackground(Color.lightGray);
        t3.setBackground(Color.lightGray);
        t5.setBackground(Color.lightGray);

        l2.setBounds(20,20,100,30);
        l3.setBounds(190,20,100,30);
        l1.setBounds(20,100,200,30);
        l4.setBounds(20,150,200,30);
        l5.setBounds(20,200,200,30);
        t1.setBounds(240,100,100,30);
        t4.setBounds(240,150,100,30);
        t5.setBounds(240,200,100,30);
        t2.setBounds(110,20,50,30);
        t3.setBounds(290,20,50,30);

        b1.setBounds(20,280,130,30);
        b2.setBounds(240,280,130,30);
        l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);t1.setFont(f);
        t2.setFont(f);t3.setFont(f);t4.setFont(f);t5.setFont(f);l5.setFont(f);
        add(l1);add(l2);add(l3);add(l4);add(t1);add(l5);
        add(t2);add(t3);add(t4);add(b1);add(b2);add(t5);
        t2.setEditable(false);t3.setEditable(false);t4.setEditable(false);t5.setEditable(false);
        b1.addActionListener(this);b2.addActionListener(this);
        t5.setText(""+this.level);t2.setText(""+this.score);t3.setText(""+this.attempts);
        JOptionPane.showMessageDialog(null, "Level: 2\nNumber of Attempts:10 \nGuessing Range: 1 to 20", "Instruction", JOptionPane.INFORMATION_MESSAGE);


    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==b1)
        {

            repaint();
            try {
                if (this.attempts == 10&&this.score<3) {
                    JOptionPane.showMessageDialog(null, "Game Over", "Message", JOptionPane.INFORMATION_MESSAGE);
                    int x=JOptionPane.showConfirmDialog(this,"Do you want play again?","Play Again",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(x==0)
                    {
                        this.attempts = 0;
                        this.score = 0;
                        t1.setText(null);
                        t2.setText(null);
                        t3.setText(null);
                        t4.setText(null);
                    }
                    else
                    {
                        this.setVisible(false);
                    }
                }
                else if(this.attempts==10&&this.score>=3)
                {
                    JOptionPane.showMessageDialog(null, "Level 3 unlocked", "Message", JOptionPane.INFORMATION_MESSAGE);
                    int x=JOptionPane.showConfirmDialog(this,"Do you want play Level 3 (range from 1 to 100)","Level 3 Playing",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(x==0)
                    {
                        numbergame_level2 n2=new numbergame_level2();
                        this.setEnabled(false);
                        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        repaint();
                    }
                    else
                    {
                        this.setVisible(false);
                    }
                }
                else {
                    int original_number = Integer.parseInt(t1.getText());

                    int random_number = (int) Math.floor(Math.random() * 20);

                    if (random_number == original_number) {
                        t4.setText("" + random_number + "");
                        this.score = this.score + 1;
                        this.attempts = this.attempts + 1;
                        JOptionPane.showMessageDialog(null, "Your Guess is appropriate", "Message", JOptionPane.INFORMATION_MESSAGE);
                        t2.setText("" + this.score + "");
                        t3.setText("" + this.attempts + "");
                        repaint();
                    } else {
                        this.attempts = this.attempts + 1;
                        t2.setText("" + this.score + "");
                        t3.setText("" + this.attempts + "");
                        t4.setText("" + random_number + "");
                        JOptionPane.showMessageDialog(null, "Your Guess is not matching", "Message", JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                    }
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Number is necessary "+e, "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(k.getSource()==b2)
        {
            t1.setText(null);
            t4.setText(null);
            repaint();
        }
    }
}
class numbergame_level1 extends JFrame implements ActionListener
{
      ImageIcon i1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p1.jpg");
    ImageIcon i2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p2.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p3.jpg");
    ImageIcon i4=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p4.jpg");
    ImageIcon i5=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p5.jpg");
    ImageIcon i6=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p6.jpg");
    ImageIcon i7=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship2\\p7.jpg");
      Font f=new Font("arial",Font.BOLD,15);
      JLabel l1=new JLabel("Enter Guess Number",i6,SwingConstants.HORIZONTAL);
      JLabel l2=new JLabel("Score",i1,SwingConstants.HORIZONTAL);
      JLabel l3=new JLabel("Attempts",i2,SwingConstants.HORIZONTAL);
      JLabel l4=new JLabel("Actual Number",i7,SwingConstants.HORIZONTAL);
      JLabel l5=new JLabel("Level",i5,SwingConstants.HORIZONTAL);
      JTextField t1=new JTextField();
      JTextField t2=new JTextField();
      JTextField t3=new JTextField();
      JTextField t4=new JTextField();
      JTextField t5=new JTextField();
      JButton b1=new JButton("Test",i3);
      JButton b2=new JButton("Refresh",i4);
      static int score=0,attempts=0,level=1;

      numbergame_level1()
      {
           setVisible(true);
           setSize(400,400);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLayout(null);
           setTitle("Number Game");
           setResizable(false);
           t2.setBackground(Color.lightGray);
           t3.setBackground(Color.lightGray);
           t5.setBackground(Color.lightGray);
           l2.setBounds(20,20,100,30);
           l3.setBounds(190,20,100,30);
           l1.setBounds(20,100,200,30);
           l4.setBounds(20,150,200,30);
           l5.setBounds(20,200,200,30);
           t1.setBounds(240,100,100,30);
           t4.setBounds(240,150,100,30);
           t5.setBounds(240,200,100,30);
           t2.setBounds(110,20,50,30);
           t3.setBounds(290,20,50,30);

           b1.setBounds(20,280,130,30);
           b2.setBounds(240,280,130,30);
           l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);t1.setFont(f);
           t2.setFont(f);t3.setFont(f);t4.setFont(f);t5.setFont(f);l5.setFont(f);
           add(l1);add(l2);add(l3);add(l4);add(t1);add(l5);
           add(t2);add(t3);add(t4);add(b1);add(b2);add(t5);
           t2.setEditable(false);t3.setEditable(false);t4.setEditable(false);t5.setEditable(false);
           b1.addActionListener(this);b2.addActionListener(this);
          t5.setText(""+this.level);t2.setText(""+this.score);t3.setText(""+this.attempts);
          JOptionPane.showMessageDialog(null, "Level: 1\nNumber of Attempts:5 \nGuessing Range: 1 to 10", "Instruction", JOptionPane.INFORMATION_MESSAGE);


      }
      public void actionPerformed(ActionEvent k)
      {
           if(k.getSource()==b1)
           {

               repaint();
               try {
                   if (this.attempts == 5&&this.score==0) {
                       JOptionPane.showMessageDialog(null, "Game Over", "Message", JOptionPane.INFORMATION_MESSAGE);
                       int x=JOptionPane.showConfirmDialog(this,"Do you want play again?","Play Again",JOptionPane.YES_NO_CANCEL_OPTION);
                        if(x==0)
                        {
                            this.attempts = 0;
                            this.score = 0;
                            t1.setText(null);
                            t2.setText(null);
                            t3.setText(null);
                            t4.setText(null);
                        }
                       else
                        {
                             this.setVisible(false);
                        }
                   }
                   else if(this.attempts==5&&this.score<=1)
                   {
                       JOptionPane.showMessageDialog(null, "Level 2 unlocked", "Message", JOptionPane.INFORMATION_MESSAGE);
                       int x=JOptionPane.showConfirmDialog(this,"Do you want play Level 2 (range from 1 to 20)","Level 2 Playing",JOptionPane.YES_NO_CANCEL_OPTION);
                       if(x==0)
                       {
                            numbergame_level2 n2=new numbergame_level2();
                            this.setEnabled(false);
                            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            repaint();
                       }
                       else
                       {
                           this.setVisible(false);
                       }
                   }
                   else {
                       int original_number = Integer.parseInt(t1.getText());

                       int random_number = (int) Math.floor(Math.random() * 10);

                       if (random_number == original_number) {
                           t4.setText("" + random_number + "");
                           this.score = this.score + 1;
                           this.attempts = this.attempts + 1;
                           JOptionPane.showMessageDialog(null, "Your Guess is appropriate", "Message", JOptionPane.INFORMATION_MESSAGE);
                           t2.setText("" + this.score + "");
                           t3.setText("" + this.attempts + "");
                           repaint();
                       } else {
                           this.attempts = this.attempts + 1;
                           t2.setText("" + this.score + "");
                           t3.setText("" + this.attempts + "");
                           t4.setText("" + random_number + "");
                           JOptionPane.showMessageDialog(null, "Your Guess is not matching", "Message", JOptionPane.INFORMATION_MESSAGE);
                           repaint();
                       }
                   }
               }
               catch(NumberFormatException e)
               {
                   JOptionPane.showMessageDialog(null, "Number is necessary "+e, "Warning", JOptionPane.INFORMATION_MESSAGE);
               }
           }
           if(k.getSource()==b2)
           {
                t1.setText(null);
                t4.setText(null);
                repaint();
           }
      }
}
public class Main
{
    public static void main(String args[])
    {
        numbergame_level1 n=new numbergame_level1();
    }   
}
