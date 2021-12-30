package GUI_CW;

import GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordMarks extends JFrame implements ActionListener {
    JTextField registrationNumber,mark;
    JButton record,back,viewRecorded;
    JLabel studentNo,studentMark,recordMark,status;
    String username;
    public RecordMarks(String username){
        this.username = username;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(null);

        status = new JLabel("Marks recorded");
        status.setBounds(400,350,150,50);
        //status.setFont(new Font("",Font.BOLD,20));
        status.setVisible(false);


        registrationNumber = new JTextField();
        registrationNumber.setBounds(400,200,200,40);

        mark = new JTextField();
        mark.setBounds(400,300,200,40);

        studentNo = new JLabel("Registration Number");
        studentNo.setBounds(250,200,150,40);

        studentMark = new JLabel("Student Mark");
        studentMark.setBounds(250,300,100,40);

        recordMark = new JLabel("Record Student Marks");
        recordMark.setBounds(300,100,400,100);
        recordMark.setFont(new Font("",Font.BOLD,20));

        back = new JButton("Back");
        back.setBounds(50,50,100,30);
        back.addActionListener(this);

        record = new JButton("Record Mark");
        record.setBounds(350,400,150,50);
        record.addActionListener(this);

        viewRecorded = new JButton("View Students Recorded Marks");
        viewRecorded.setBounds(280,500,300,50);
        Dimension b = new Dimension(150,100);
        viewRecorded.setMaximumSize(b);
        viewRecorded.addActionListener(this);

        this.add(studentMark);
        this.add(registrationNumber);
        this.add(studentNo);
        this.add(mark);
        this.add(recordMark);
        this.add(record);
        this.add(back);
        this.add(status);
        this.add(viewRecorded);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event.equals(back)){
            new TeacherMenu(username).setVisible(true);
            this.setVisible(false);
        }
        if (event.equals(record)){
            System.out.println("This is nexists");
            String subj="";
            String where = "Username = '"+username+"'";
            try {
            ResultSet subject = DatabaseUtil.results("teachers",where);
            while (subject.next()){
                subj = subject.getString("Subject");
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            String tableInsert = subj+" (RegistrationNumber,mark)";
            String values = "'"+registrationNumber.getText()+"','"+mark.getText()+"'";
            DatabaseUtil.record(tableInsert,values);
            status.setText("Recorded marks for "+registrationNumber.getText());
            status.setVisible(true);
            registrationNumber.setText("");
            mark.setText("");
        }
        if (event.equals(viewRecorded)){
            new TeacherResultsView(username).setVisible(true);
            this.setVisible(false);
        }else {
            status.setText("Marks not Recorded for "+registrationNumber.getText());
            status.setVisible(true);
        }
    }
}
