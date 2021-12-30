package GUI_CW;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherMenu extends JFrame implements ActionListener {
    JButton registerStudent,recordMarks,viewStudents;
    String username;
    public TeacherMenu(String username){
        super("Katikamu primary school");
        this.username = username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(null);
        this.setBounds(0,0,900,600);

        recordMarks = new JButton("Record Student Marks");
        recordMarks.setBounds(150,250,450,100);
        recordMarks.addActionListener(this);

        registerStudent = new JButton("Register Student");
        registerStudent.setBounds(150,100,450,100);
        registerStudent.addActionListener(this);

        viewStudents = new JButton("View Registered Students");
        viewStudents.setBounds(150,400,450,100);
        viewStudents.addActionListener(this);

        this.add(recordMarks);
        this.add(registerStudent);
        this.add(viewStudents);
        this.setVisible(false);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(registerStudent)){
            RegisterStudent registerStudent = new RegisterStudent(username);
            registerStudent.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(viewStudents)){
            new ViewStudents(username).setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(recordMarks)){
            new RecordMarks(username).setVisible(true);
            this.setVisible(false);
        }
    }
}
