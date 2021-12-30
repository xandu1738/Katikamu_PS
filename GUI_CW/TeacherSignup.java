package GUI_CW;

import GUI_CW.GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.*;

public class TeacherSignup extends JFrame{
    private JTextField identity;
    private JTextField password;
    private JButton signup;
    private JPanel panel;
    private JLabel heading;
    private JLabel sID;
    private JLabel pwd;
    private JButton clear;

    Font font = new Font("SansSerif",Font.BOLD,40);//Declaring font style for heading
    Font font1 = new Font("Calibri",Font.PLAIN,20);
    public TeacherSignup(){
        this.setContentPane(panel);
        this.setSize(500,500);
        this.setTitle("Sign Up");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,500);

        identity = new JTextField();
        identity.setPreferredSize(new Dimension(400,30));
        password = new JTextField();
        password.setPreferredSize(new Dimension(400,30));
        signup.setPreferredSize(new Dimension(400,30));

        heading.setFont(font);
        sID.setFont(font1);
        pwd.setFont(font1);

        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        this.setVisible(true);
        signup.addActionListener(e -> {
            Object event = e.getSource();
            if(event.equals(signup)){
                String table = "teachers";
                String where = " id = '"+identity.getText()+"'";
                boolean exists = DatabaseUtil.check(table,where);
                if (exists == true){
                    System.out.println("This id exists in the Database");


                }else{
                    System.out.println("New Value");
                    String id, pass;
                    id = identity.getText();
                    pass = password.getText();

                    String tableInsert = "teachers(id,pass)";
                    String values = "'"+id+"','"+pass+"','";
                    DatabaseUtil.record(tableInsert,values);

                    identity.setText("");
                    password.setText("");
                }
            }
            if (event.equals(clear)){
                identity.setText("");
                password.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new TeacherSignup();
    }
}
