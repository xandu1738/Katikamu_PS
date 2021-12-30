package GUI_CW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame  implements ActionListener {

    JButton student, teacher;
    JLabel login;

    public Welcome(){
        super("Katikamt primary school");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(null);
        student = new JButton("Student");
        student.addActionListener(this);
        student.setBounds(350,250,200,50);
        student.setBackground(Color.CYAN);
        student.setBorder(null);


        teacher = new JButton("Teacher");
        teacher.setBounds(350,350,200,50);
        teacher.setBackground(Color.CYAN);
        teacher.addActionListener(this);
        teacher.setBorder(null);

        login = new JLabel("Login");
        login.setBounds(400,100,150,100);
        login.setFont(new Font("",Font.BOLD,20));
        login.setBorder(null);

        this.setLayout(null);
        this.setBounds(0,0,900,600);
        this.add(login);
        this.add(student);
        this.add(teacher);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Welcome();
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ev = e.getSource();
            if (ev.equals(student)){
                login.setText("Student clicked");

                StudentLogin studentLogin = new StudentLogin();
                studentLogin.setVisible(true);
                this.setVisible(false);
            }
            if (ev.equals(teacher)){
                login.setText("Teacher clicked");
                TeacherLogin teacherLogin = new TeacherLogin();
                teacherLogin.setVisible(true);
                this.setVisible(false);
            }
        }

}
