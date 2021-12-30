package GUI_CW;

import GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin extends JFrame implements ActionListener {
    JTextField registrationNumber;
    JPasswordField password;
    JLabel student,regNo,pass,logInfo;
    JButton clear, login,back;

    public StudentLogin(){
        super("Katikamu primary school");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(null);
        this.setBounds(0,0,900,600);

        regNo = new JLabel("Student Number ");
        regNo.setBounds(250,200,100,40);
        registrationNumber = new JTextField();
        registrationNumber.setBounds(400,200,200,40);

        pass = new JLabel("Password ");
        pass.setBounds(250,300,100,40);
        password = new JPasswordField();
        password.setBounds(400,300,200,40);

        student = new JLabel("Student Login");
        student.setBounds(400,100,150,100);
        student.setFont(new Font("",Font.BOLD,20));


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


        this.add(registrationNumber);
        this.add(student);
        this.add(regNo);
        this.add(password);
        this.add(pass);
        this.add(back);
        this.add(logInfo);
        this.add(clear);
        this.add(login);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event.equals(clear)){
            registrationNumber.setText("");
            password.setText("");
        }
        if (event.equals(back)){
            Welcome welcome = new Welcome();
            this.setVisible(false);
            welcome.setVisible(true);
        }
        if (e.getSource().equals(login)){
            String where = "RegistrationNumber = '"+registrationNumber.getText().trim()+"'";
            //student.setText("Login Called");
            if(DatabaseUtil.check("students",where)){
                StudentDash student = new StudentDash(registrationNumber.getText().trim());
                student.setVisible(true);
                this.setVisible(false);
                System.out.println("Student present exist");
            }else{
                logInfo.setVisible(true);
                System.out.println("Student not exist");
            }
        }

    }
}
