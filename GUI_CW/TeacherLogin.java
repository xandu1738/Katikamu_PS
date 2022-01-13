package GUI_CW;

import GUI_CW.GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherLogin extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JLabel teacher,usern,pass,logInfo;
    JButton clear, login,back;
    public TeacherLogin(){
        super("Katikamu primary school");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(null);
        this.setBounds(0,0,900,600);

        usern = new JLabel("Username ");
        usern.setBounds(250,200,100,40);
        username = new JTextField();
        username.setBounds(400,200,200,40);

        pass = new JLabel("Password ");
        pass.setBounds(250,300,100,40);
        password = new JPasswordField();
        password.setBounds(400,300,200,40);

        teacher = new JLabel("Teacher Login");
        teacher.setBounds(400,100,150,100);
        teacher.setFont(new Font("",Font.BOLD,20));

        clear = new JButton("Clear");
        clear.setBounds(300,450,100,50);
        clear.addActionListener(this);

        login = new JButton("Login");
        login.setBounds(450,450,100,50);
        login.addActionListener(this);

        logInfo = new JLabel("Incorrect Details");
        logInfo.setBounds(400,380,200,40);
        logInfo.setBackground(Color.red);
        logInfo.setBackground(Color.red);
        logInfo.setVisible(false);

        back = new JButton("Back");
        back.setBounds(50,50,100,30);
        back.addActionListener(this);


        this.add(username);
        this.add(usern);
        this.add(teacher);
        this.add(password);
        this.add(pass);
        this.add(back);
        this.add(clear);
        this.add(login);
        this.add(logInfo);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event.equals(clear)){
            username.setText("");
            password.setText("");
        }
        if (event.equals(back)){
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(login)){
            char[] pass = password.getPassword();
            String myPass ="";
            for (int i =0;i<pass.length;i++){
                myPass += pass[i];
            }
            System.out.println(pass);
            String where = "Username ='"+username.getText()+"' AND Password = '"+myPass+"'";
            if(DatabaseUtil.check("teachers",where)){
                TeacherMenu teacherMenu = new TeacherMenu(username.getText().trim());
                teacherMenu.setVisible(true);
                this.setVisible(false);
            }else{
                logInfo.setVisible(true);
            }
        }

    }
}
