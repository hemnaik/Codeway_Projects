import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.DriverAction;
import java.time.*;
class resetpassword extends JPanel implements ActionListener
{
    ImageIcon adhar = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a.jpg");
    ImageIcon w = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\pa.jpg");
    ImageIcon i3 = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\u.jpg");
    ImageIcon a1 = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a1.jpg");
    ImageIcon a2 = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_refresh.jpg");
    ImageIcon m = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\close.jpg");
    ImageIcon b = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\r.jpg");

    JPasswordField t2 = new JPasswordField();
    JTextField t3 = new JTextField();
    JPasswordField t4 = new JPasswordField();
    JLabel l1 = new JLabel("RESET PASSWORD");
    JLabel l3 = new JLabel("Account No", adhar, SwingConstants.HORIZONTAL);
    JLabel l2 = new JLabel("Password", w, SwingConstants.HORIZONTAL);
    JLabel l4 = new JLabel("Retype", b, SwingConstants.HORIZONTAL);
    JButton x1 = new JButton("Update", i3);
    JButton x2 = new JButton("Refresh", a2);
    JButton x3 = new JButton("Close", m);

    Font f = new Font("arial", Font.BOLD, 15);

    resetpassword()
    {
        l1.setBounds(150, 50, 200, 30);
        l2.setBounds(30, 100, 250, 30);
        l3.setBounds(50, 160, 200, 30);
        t2.setBounds(250, 100, 150, 30);
        t3.setBounds(250, 160, 150, 30);
        l4.setBounds(50, 220, 200, 30);
        t4.setBounds(250, 220, 150, 30);

        this.setLayout(null);
        this.setBounds(300, 0, 600, 550);
        this.setOpaque(false);
        this.setVisible(true);
        t4.setEditable(true);
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        t2.setFont(f);
        t2.setVerifyInputWhenFocusTarget(true);
        t3.setFont(f);
        t4.setFont(f);
        l4.setFont(f);
        x1.setBounds(70, 280, 150, 30);
        x2.setBounds(250, 280, 150, 30);
        x3.setBounds(150, 340, 150, 30);
        x1.setFont(f);
        x2.setFont(f);
        x3.setFont(f);

        add(l1);
        add(l2);
        add(l3);
        add(t2);
        add(t4);
        add(l4);
        add(t3);
        add(x1);
        add(x2);
        add(x3);
        x1.addActionListener(this);
        x2.addActionListener(this);
        x3.addActionListener(this);

    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==x2)
        {
            t2.setText(null);t3.setText(null);t4.setText(null);
            JOptionPane.showMessageDialog(null,"Fields refreshed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }
        if(k.getSource()==x3)
        {
            this.setVisible(false);
            repaint();
        }

        if(k.getSource()==x1)
        {
            int flag=0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");

                try {
                    int pass=Integer.parseInt(t2.getText());
                    int temp_pass=Integer.parseInt(t4.getText());
                    long account=Long.parseLong(t3.getText());
                    String sqlretrieve="SELECT * FROM internship_bank WHERE accountno="+'"'+account+'"';

                    Statement s=con.createStatement();
                    s.execute(sqlretrieve);
                    ResultSet r=s.executeQuery(sqlretrieve);
                    while(r.next())
                    {
                        if(account==(r.getLong(2))&&temp_pass==pass)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1) {
                        System.out.println(pass+temp_pass);

                        String sqlupdate="UPDATE internship_bank SET password=? WHERE accountno LIKE ?";
                        PreparedStatement p= con.prepareStatement(sqlupdate);
                        p.setInt(1,pass);
                        p.setLong(2,account);
                        p.executeUpdate();
                        p.close();
                        con.close();

                        JOptionPane.showMessageDialog(this, "Password Updated Successfully", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(this, "User not verified or Mismatch password", "WARNING", JOptionPane.WARNING_MESSAGE);
                        repaint();
                    }

                } catch (Exception k1) {

                    JOptionPane.showMessageDialog(null,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
                    repaint();
                }
            }
            catch(Exception p)
            {
                JOptionPane.showMessageDialog(null,p,"WARNING",JOptionPane.WARNING_MESSAGE);
                repaint();
            }
        }

    }
}
class check_balance extends JPanel implements ActionListener {
    ImageIcon adhar = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a.jpg");
    ImageIcon w = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\pa.jpg");
    ImageIcon i3 = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\s.jpg");
    ImageIcon a1 = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a1.jpg");
    ImageIcon a2 = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_refresh.jpg");
    ImageIcon m = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\close.jpg");
    ImageIcon b = new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\b.jpg");

    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JLabel l1 = new JLabel("CHECK BALANCE");
    JLabel l3 = new JLabel("Account No", adhar, SwingConstants.HORIZONTAL);
    JLabel l2 = new JLabel("Password", w, SwingConstants.HORIZONTAL);
    JLabel l4 = new JLabel("Cur Balance", b, SwingConstants.HORIZONTAL);
    JButton x1 = new JButton("Show", i3);
    JButton x2 = new JButton("Refresh", a2);
    JButton x3 = new JButton("Close", m);

    Font f = new Font("arial", Font.BOLD, 15);

    check_balance() {
        l1.setBounds(150, 50, 200, 30);
        l2.setBounds(30, 100, 250, 30);
        l3.setBounds(50, 160, 200, 30);
        t2.setBounds(250, 100, 150, 30);
        t3.setBounds(250, 160, 150, 30);
        l4.setBounds(50, 220, 200, 30);
        t4.setBounds(250, 220, 150, 30);
        this.setLayout(null);
        this.setBounds(300, 0, 600, 550);
        this.setOpaque(false);
        this.setVisible(true);
        t4.setEditable(false);
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        l4.setFont(f);
        x1.setBounds(70, 280, 150, 30);
        x2.setBounds(250, 280, 150, 30);
        x3.setBounds(150, 340, 150, 30);
        x1.setFont(f);
        x2.setFont(f);
        x3.setFont(f);

        add(l1);
        add(l2);
        add(l3);
        add(t2);
        add(t4);
        add(l4);
        add(t3);
        add(x1);
        add(x2);
        add(x3);
        x1.addActionListener(this);
        x2.addActionListener(this);
        x3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent k) {

        if(k.getSource()==x2)
        {
            t2.setText(null);t3.setText(null);t4.setText(null);
            JOptionPane.showMessageDialog(null,"Fields refreshed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }
        if(k.getSource()==x3)
        {
            this.setVisible(false);
            repaint();
        }
        if(k.getSource()==x1)
        {
            int flag=0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");

                try {
                    long account=Long.parseLong(t3.getText());
                    int password1=Integer.parseInt(t2.getText());

                    long temp_balance=0;
                    String sqlretrieve="SELECT * FROM internship_bank WHERE accountno="+'"'+account+'"'+" AND password="+'"'+password1+'"';

                    Statement s=con.createStatement();
                    s.execute(sqlretrieve);
                    ResultSet r=s.executeQuery(sqlretrieve);
                    while(r.next())
                    {
                        if(account==(r.getLong(2))&&password1==(r.getInt(7))) {
                            temp_balance = r.getLong(6);
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1) {
                        t4.setText("" + temp_balance);
                        con.close();

                        JOptionPane.showMessageDialog(this, "Current Balance Displayed", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(this, "User not verified", "WARNING", JOptionPane.WARNING_MESSAGE);
                        repaint();
                    }

                } catch (Exception k1) {

                    JOptionPane.showMessageDialog(null,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
                    repaint();
                }
            }
            catch(Exception p)
            {
                JOptionPane.showMessageDialog(null,p,"WARNING",JOptionPane.WARNING_MESSAGE);
                repaint();
            }
        }

    }
}
class withdrawal extends JPanel implements ActionListener
{
    ImageIcon adhar=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a.jpg");
    ImageIcon w=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\w.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\withdraw.jpg");
    ImageIcon a1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a1.jpg");
    ImageIcon a2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_refresh.jpg");
    ImageIcon m=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\close.jpg");
    ImageIcon b=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\b.jpg");
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JLabel l1=new JLabel("WITHDRAWAL AMOUNT");
    JLabel l3=new JLabel("Account No",adhar,SwingConstants.HORIZONTAL);
    JLabel l2=new JLabel("Withdrawal Amt",w,SwingConstants.HORIZONTAL);
    JLabel l4=new JLabel("Cur Balance",b,SwingConstants.HORIZONTAL);
    JButton x1=new JButton("Withdrawal",i3);
    JButton x2=new JButton("Refresh",a2);
    JButton x3=new JButton("Close",m);

    Font f=new Font("arial",Font.BOLD,15);
    withdrawal()
    {
        l1.setBounds(150,50,200,30);
        l2.setBounds(30,100,250,30);
        l3.setBounds(50,160,200,30);
        t2.setBounds(250,100,150,30);
        t3.setBounds(250,160,150,30);
        l4.setBounds(50,220,200,30);
        t4.setBounds(250,220,150,30);
        this.setLayout(null);
        this.setBounds(300,0,600,550);
        this.setOpaque(false);
        this.setVisible(true);
        t4.setEditable(false);
        l1.setFont(f);l2.setFont(f);l3.setFont(f);t2.setFont(f);t3.setFont(f);t4.setFont(f);l4.setFont(f);
        x1.setBounds(70,280,150,30);
        x2.setBounds(250,280,150,30);
        x3.setBounds(150,340,150,30);
        x1.setFont(f);x2.setFont(f);x3.setFont(f);

        add(l1);add(l2);add(l3);add(t2);add(t4);add(l4);
        add(t3);add(x1);add(x2);add(x3);
        x1.addActionListener(this);x2.addActionListener(this);x3.addActionListener(this);


    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==x1)
        {
            int flag=0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");

                try {
                    long account=Long.parseLong(t3.getText());
                    long withdrawalamt=Long.parseLong(t2.getText());

                    long temp_balance=0;
                    String sqlretrieve="SELECT * FROM internship_bank WHERE accountno="+'"'+account+'"';

                    Statement s=con.createStatement();
                    s.execute(sqlretrieve);
                    ResultSet r=s.executeQuery(sqlretrieve);
                    while(r.next())
                    {
                        if(account==(r.getLong(2))) {
                            temp_balance = r.getLong(6);
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1) {
                        if (temp_balance >= withdrawalamt) {
                            temp_balance = temp_balance - withdrawalamt;

                            String sqlretrieve1 = "UPDATE internship_bank SET balance=? WHERE accountno LIKE ?";
                            System.out.println(temp_balance);

                            PreparedStatement p = con.prepareStatement(sqlretrieve1);
                            p.setLong(1, temp_balance);
                            p.setLong(2, account);
                            p.executeUpdate();
                            t4.setText("" + temp_balance);
                            p.close();
                            con.close();

                            JOptionPane.showMessageDialog(this, "Amount Withdrawal Successfully", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(this, "Insufficient Balance", "WARNING", JOptionPane.WARNING_MESSAGE);
                            repaint();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Create Account or User not Verified", "WARNING", JOptionPane.WARNING_MESSAGE);
                        repaint();
                    }
                } catch (Exception k1) {

                    JOptionPane.showMessageDialog(null,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
                    repaint();
                }
            }
            catch(Exception p)
            {
                JOptionPane.showMessageDialog(null,p,"WARNING",JOptionPane.WARNING_MESSAGE);
                repaint();
            }
        }

        if(k.getSource()==x2)
        {
            t2.setText(null);t3.setText(null);t4.setText(null);
            JOptionPane.showMessageDialog(null,"Fields refreshed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }
        if(k.getSource()==x3)
        {
            this.setVisible(false);
            repaint();
        }
    }
}
class deposit extends JPanel implements ActionListener
{
    ImageIcon adhar=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a.jpg");
    ImageIcon w=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\w.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\d.jpg");
    ImageIcon a1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a1.jpg");
    ImageIcon a2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_refresh.jpg");
    ImageIcon m=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\close.jpg");
    ImageIcon b=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\b.jpg");
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JLabel l1=new JLabel("DEPOSIT AMOUNT");
    JLabel l3=new JLabel("Account No",adhar,SwingConstants.HORIZONTAL);
    JLabel l2=new JLabel("Deposit Amt",w,SwingConstants.HORIZONTAL);
    JLabel l4=new JLabel("Cur Balance",b,SwingConstants.HORIZONTAL);
    JButton x1=new JButton("Deposit",i3);
    JButton x2=new JButton("Refresh",a2);
    JButton x3=new JButton("Close",m);

    Font f=new Font("arial",Font.BOLD,15);
    deposit()
    {
        l1.setBounds(170,50,200,30);
        l2.setBounds(30,100,250,30);
        l3.setBounds(50,160,200,30);
        t2.setBounds(250,100,150,30);
        t3.setBounds(250,160,150,30);
        l4.setBounds(50,220,200,30);
        t4.setBounds(250,220,150,30);
        this.setLayout(null);
        this.setBounds(300,0,600,550);
        this.setOpaque(false);
        this.setVisible(true);
        l1.setFont(f);l2.setFont(f);l3.setFont(f);t2.setFont(f);t3.setFont(f);t4.setFont(f);l4.setFont(f);
        x1.setBounds(70,280,150,30);
        x2.setBounds(250,280,150,30);
        x3.setBounds(150,340,150,30);
        x1.setFont(f);x2.setFont(f);x3.setFont(f);

        add(l1);add(l2);add(l3);add(t2);add(t4);add(l4);
        add(t3);add(x1);add(x2);add(x3);t4.setEditable(false);
        x1.addActionListener(this);x2.addActionListener(this);x3.addActionListener(this);


    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==x1)
        {
            int flag=0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");

                try {
                    long account=Long.parseLong(t3.getText());
                    long deposit=Long.parseLong(t2.getText());

                    long temp_balance=0;
                    String sqlretrieve="SELECT * FROM internship_bank WHERE accountno="+'"'+account+'"';

                    Statement s=con.createStatement();
                    s.execute(sqlretrieve);
                    ResultSet r=s.executeQuery(sqlretrieve);
                    while(r.next())
                    {
                        if(account==(r.getLong(2))) {
                            temp_balance = r.getLong(6);
                            flag=1;
                            break;
                        }
                        if(flag==1) {
                            temp_balance = temp_balance + deposit;

                            String sqlretrieve1 = "UPDATE internship_bank SET balance=? WHERE accountno LIKE ?";
                            System.out.println(temp_balance);

                            PreparedStatement p = con.prepareStatement(sqlretrieve1);
                            p.setLong(1, temp_balance);
                            p.setLong(2, account);
                            p.executeUpdate();
                            t4.setText("" + temp_balance);
                            p.close();
                            con.close();

                            JOptionPane.showMessageDialog(this, "Amount Deposited Successfully", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                            repaint();
                        }else{
                            JOptionPane.showMessageDialog(this, "Create Account or User not Verified", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                            repaint();

                        }
                    }

                } catch (Exception k1) {

                    JOptionPane.showMessageDialog(null,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
                    repaint();
                }
            }

            catch(Exception p)
            {
                JOptionPane.showMessageDialog(null,p,"WARNING",JOptionPane.WARNING_MESSAGE);
                repaint();
            }
        }

        if(k.getSource()==x2)
        {
            t2.setText(null);t3.setText(null);t4.setText(null);
            JOptionPane.showMessageDialog(null,"Fields refreshed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }
        if(k.getSource()==x3)
        {
            this.setVisible(false);
            repaint();
        }
    }
}

class authenticating extends JPanel implements ActionListener
{
    ImageIcon c_name=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_customer.jpg");
    ImageIcon g=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_gender.jpg");
    ImageIcon adhar=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a.jpg");
    ImageIcon pan=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\pan.jpg");
    ImageIcon a1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a1.jpg");
    ImageIcon a2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_refresh.jpg");
    ImageIcon m=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\close.jpg");

    Font f=new Font("arial",Font.BOLD,15);
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JLabel l1=new JLabel("USER VERIFICATION");
    JLabel l2=new JLabel("Customer Name",c_name,SwingConstants.HORIZONTAL);
    JLabel l3=new JLabel("Account No",adhar,SwingConstants.HORIZONTAL);
    JLabel l4=new JLabel("PanCard No",pan,SwingConstants.HORIZONTAL);
    JButton x1=new JButton("Verify",a1);
    JButton x2=new JButton("Refresh",a2);
    JButton x3=new JButton("Close",m);

    authenticating()
    {
        this.setLayout(null);
        this.setBounds(300,0,600,550);
        this.setOpaque(false);
        this.setVisible(true);
        l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);
        t2.setFont(f);t3.setFont(f);t4.setFont(f);

        l1.setBounds(150,50,200,30);
        l2.setBounds(30,100,250,30);
        t2.setBounds(250,100,150,30);
        l3.setBounds(50,160,200,30);
        t3.setBounds(250,160,150,30);
        l4.setBounds(50,220,200,30);
        t4.setBounds(250,220,150,30);
        x1.setBounds(70,280,150,30);
        x2.setBounds(250,280,150,30);
        x3.setBounds(150,340,150,30);
        x1.setFont(f);x2.setFont(f);x3.setFont(f);

        add(l1);add(l2);add(l3);add(l4);add(t2);
        add(t3);add(t4);add(x1);add(x2);add(x3);
        x1.addActionListener(this);x2.addActionListener(this);x3.addActionListener(this);

    }
    public void actionPerformed(ActionEvent k1)
    {
        if(k1.getSource()==x1) {
            int flag=0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");

                try {

                    long account=Long.parseLong(t3.getText());
                    String pan=t4.getText().toString();
                    String cname=t2.getText().toString();

                    String sqlretrieve="SELECT * FROM internship_bank WHERE accountno="+'"'+account+'"'+"AND pancard_no LIKE"+'"'+pan+'"';
                    Statement s=con.createStatement();
                    s.execute(sqlretrieve);
                    ResultSet rs=s.executeQuery(sqlretrieve);
                    while(rs.next()) {
                        if ((rs.getString(1).equals(cname) && rs.getLong(2) == account && rs.getString(3).equals(pan))) {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        JOptionPane.showMessageDialog(null, "User is Authenticated", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Create Account","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                    }

                }
                catch(Exception k)
                {
                    JOptionPane.showMessageDialog(null,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
                    repaint();
                }
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null,e1,"WARNING",JOptionPane.WARNING_MESSAGE);
                repaint();
            }

        }

        if(k1.getSource()==x2)
        {
            t2.setText(null);t3.setText(null);t4.setText(null);
            JOptionPane.showMessageDialog(null,"Fields refreshed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

            repaint();
        }
        if(k1.getSource()==x3)
        {
            this.setVisible(false);
            repaint();
        }
    }
}
class user_account extends JPanel implements ActionListener
{
    ImageIcon c_name=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_customer.jpg");
    ImageIcon g=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_gender.jpg");
    ImageIcon adhar=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\a.jpg");
    ImageIcon pan=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\pan.jpg");
    ImageIcon c=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_city.jpg");
    ImageIcon l=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_create.jpg");
    ImageIcon r=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\internship3_refresh.jpg");
    ImageIcon m=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\close.jpg");
    Font f=new Font("arial",Font.BOLD,15);
    JLabel l1=new JLabel("ACCOUNT OPENING");
    JLabel l2=new JLabel("Customer Name",c_name,SwingConstants.HORIZONTAL);
    JLabel l3=new JLabel("Account No",adhar,SwingConstants.HORIZONTAL);
    JLabel l4=new JLabel("PanCard No",pan,SwingConstants.HORIZONTAL);
    JLabel l5=new JLabel("Gender",g,SwingConstants.HORIZONTAL);
    JLabel l6=new JLabel("Branch City",c,SwingConstants.HORIZONTAL);

    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    ButtonGroup group=new ButtonGroup();
    JRadioButton b1=new JRadioButton("Male");
    JRadioButton b2=new JRadioButton("Female");
    JRadioButton b3=new JRadioButton("Others");
    JButton x1=new JButton("Create",l);
    JButton x2=new JButton("Refresh",r);
    JButton x3=new JButton("Close",m);
    JComboBox c1=new JComboBox();

    user_account()
    {
        this.setLayout(null);
        this.setSize(600,550);
        this.setOpaque(false);
        this.setVisible(true);
        l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);
        l5.setFont(f);b1.setFont(f);b2.setFont(f);b3.setFont(f);
        t2.setFont(f);t3.setFont(f);t4.setFont(f);l6.setFont(f);

        group.add(b1);group.add(b2);group.add(b3);

        c1.addItem("Ahmedabad");c1.addItem("Baroda");c1.addItem("Rajkot");c1.addItem("Surat");c1.addItem("Vapi");
        l1.setBounds(150,50,150,30);

        l2.setBounds(30,100,250,30);
        t2.setBounds(250,100,150,30);
        l3.setBounds(50,160,200,30);
        t3.setBounds(250,160,150,30);
        l4.setBounds(50,220,200,30);
        t4.setBounds(250,220,150,30);
        l5.setBounds(50,280,150,30);
        b1.setBounds(180,280,80,30);
        b2.setBounds(270,280,80,30);
        b3.setBounds(360,280,80,30);
        l6.setBounds(50,340,200,30);
        c1.setBounds(250,340,160,30);
        x1.setBounds(70,400,150,30);
        x2.setBounds(260,400,150,30);
        x3.setBounds(160,460,150,30);
        x1.setFont(f);x2.setFont(f);x3.setFont(f);
        c1.setFont(f);
        add(l1);add(l2);add(l3);add(l4);add(t2);
        add(t3);add(t4);add(l5);add(b1);add(b2);
        add(b3);add(l6);add(c1);add(x1);add(x2);add(x3);
        x1.addActionListener(this);x2.addActionListener(this);x3.addActionListener(this);

    }
    public void actionPerformed(ActionEvent k)
    {
        if(k.getSource()==x1)
        {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
                try
                {
                    String name=t2.getText();
                    long accno=Long.parseLong(t3.getText());
                    String panno=t4.getText().toString();
                    String gender="";
                    if(b1.isSelected()==true)
                    {
                        gender="Male";
                    }
                    if(b2.isSelected()==true)
                    {
                        gender="Female";
                    }
                    if(b3.isSelected()==true)
                    {
                        gender="Others";
                    }
                    String city=c1.getSelectedItem().toString();

                    System.out.println(name+accno+panno+gender+city);
                    String sqlinsert="INSERT INTO internship_bank(customername,accountno,pancard_no,gender,city) VALUES(?,?,?,?,?)";
                    PreparedStatement statement=con.prepareStatement(sqlinsert);
                    statement.setString(0,name);
                    statement.setLong(1,accno);
                    statement.setString(2,panno);
                    statement.setString(3,gender);
                    statement.setString(4,city);
                    statement.executeUpdate();
                    statement.close();
                    con.close();
                    JOptionPane.showMessageDialog(null,"Account created successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                    repaint();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"All details are required","WARNING",JOptionPane.WARNING_MESSAGE);
                    repaint();
                }
            }
            catch(Exception k1)
            {
                JOptionPane.showMessageDialog(null,k1,"WARNING",JOptionPane.WARNING_MESSAGE);
                repaint();
            }
        }
        if(k.getSource()==x2)
        {
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            c1.setSelectedIndex(0);
            group.clearSelection();
            repaint();
            JOptionPane.showMessageDialog(null,"Fields are refreshed","INFORMATION",1);
        }
        if(k.getSource()==x3)
        {
            this.setVisible(false);
            repaint();
        }
    }
}
class atm extends JFrame implements ActionListener
{
    boolean flag=false;
    ImageIcon i1=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\add.jpg");
    ImageIcon i2=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\autthenticate.jpg");
    ImageIcon i3=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\withdraw.jpg");
    ImageIcon i4=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\deposti.jpg");
    ImageIcon i5=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\reset.jpg");
    ImageIcon i6=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\check.jpg");
    ImageIcon m=new ImageIcon("C:\\Users\\hem viraj naik\\Desktop\\internship3_icons\\b1.jpg");
    JLabel l1=new JLabel(m,SwingConstants.CENTER);
    JButton b1=new JButton("Authenticate",i2);
    JButton b2=new JButton("Add User",i1);
    JButton b3=new JButton("Withdrawal",i3);
    JButton b4=new JButton("Deposit",i4);
    JButton b5=new JButton("Reset Password",i5);
    JButton b6=new JButton("Check Balance",i6);
    Font f=new Font("arial",Font.BOLD,13);
    Font f1=new Font("arial",Font.BOLD,15);
    JPanel p=new JPanel();

    atm()
    {
        setLayout(null);
        setSize(900,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ATM MANAGEMENT SYSTEM");
        setVisible(true);
        setResizable(false);
        l1.setBounds(100,50,60,60);
        l1.setFont(f1);
        b1.setBounds(50,150,180,32);
        b2.setBounds(50,200,180,32);
        b3.setBounds(50,250,180,32);
        b4.setBounds(50,300,180,32);
        b5.setBounds(50,350,180,32);
        b6.setBounds(50,400,180,32);
        l1.setFont(f);
        b1.setFont(f);b5.setFont(f);b4.setFont(f);b3.setFont(f);b2.setFont(f);b6.setFont(f);
        p.setBackground(Color.lightGray);
        p.setLayout(null);
        p.setBounds(0,0,300,550);
        p.setVisible(true);
        p.add(l1);p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);
        add(p);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
        b4.addActionListener(this);b6.addActionListener(this);b5.addActionListener(this);

    }
    public void actionPerformed(ActionEvent k1)
    {
        if(k1.getSource()==b2)
        {
            user_account u1=new user_account();
            u1.setBounds(300,0,600,550);
            add(u1);
            repaint();
        }
        if(k1.getSource()==b5)
        {
            resetpassword r=new resetpassword();
            r.setBounds(300,0,600,550);
            add(r);
            repaint();
        }

        if(k1.getSource()==b6)
        {
            check_balance cb=new check_balance();
            cb.setBounds(300,0,600,550);
            add(cb);
            repaint();
        }

        if(k1.getSource()==b3)
        {
            withdrawal w1=new withdrawal();
            w1.setBounds(300,0,600,500);
            add(w1);
            repaint();
        }
        if(k1.getSource()==b4)
        {
            deposit d1=new deposit();
            d1.setBounds(300,0,600,500);
            add(d1);
            repaint();
        }

        if(k1.getSource()==b1)
        {
            authenticating a1=new authenticating();
            a1.setBounds(300,0,600,550);
            add(a1);
            repaint();
        }
    }
}
public class Main
{
    public static void main(String args[])
    {
        atm u=new atm();
    }
}
