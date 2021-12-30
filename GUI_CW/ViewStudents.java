package GUI_CW;

import GUI_CW.GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewStudents extends JFrame implements ActionListener {
    JLabel registeredStudent;
    JButton querySearch, back;
    JTextField searchStudent;
    JTable studentTable;
    JScrollPane sp;
    String[][] data;
    String[] dataInstance;
    String username;

    public ViewStudents(String username){
        this.username = username;
        try {
            ResultSet students = DatabaseUtil.results("students", "none");
            data = new String[DatabaseUtil.tableLength][4];
            dataInstance = new  String[4];
            int counter = 0;
            while (students.next()) {
                String lname = students.getString("LastName");
                String fname = students.getString("FirstName");
                String gender = students.getString("Gender");
                String reg = students.getString("RegistrationNumber");
                String age = students.getString("age");

                dataInstance[0] = fname+" "+lname;
                dataInstance[1] = gender;
                dataInstance[2] = reg;
                dataInstance[3] = age;

                data[counter][0] = dataInstance[0];
                data[counter][1] = dataInstance[2];
                data[counter][3] = dataInstance[3];
                data[counter][2] = dataInstance[1];
                counter++;

            }
        }catch (Exception e){}

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(50,50,100,30);
        back.addActionListener(this);


        registeredStudent = new JLabel("Registered Students");
        registeredStudent.setBounds(400,100,150,100);


        searchStudent = new JTextField("Student ID");
        searchStudent.setBounds(100,70,200,79);

        querySearch = new JButton("Search");
        querySearch.setBounds(320,70,100,70);
        querySearch.addActionListener(this);

//        String [][] data = {{"Opio","23","BSE"},{"OCHEN","23","BAE"}};
        String[] colunmName = {"Name","Registration Number","Gender","Age"};
        studentTable = new JTable(data,colunmName);
       // studentTable.setBounds(200,100,500,400);
        sp = new JScrollPane(studentTable);
        sp.setBounds(200,200,500,350);
        this.add(sp);
        this.add(back);
        //this.add(querySearch);
        //this.add(searchStudent);
        this.add(registeredStudent);
        //this.add(studentTable);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
      if (event.equals(back)){
        TeacherMenu teacherMenu = new TeacherMenu(username);
        teacherMenu.setVisible(true);
        this.setVisible(false);
        }
      if (event.equals(querySearch)){

        }
    }
}
