package GUI_CW;

import GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDash extends JFrame implements ActionListener {
    JTabbedPane mainPanel;
    JPanel results,timetable;
    JTable resTable,timTable;
    JScrollPane resPane,ttPane;
    String regNo;
    String physics,physicsMark,chemistry,chemistryMark,english,englishMark,math,mathMark;

    public StudentDash(String regNumber){
        regNo = regNumber;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        String where = "RegistrationNumber ='"+regNo+"'";
        try {
            ResultSet physicsResult = DatabaseUtil.results("physics", where);
            while (physicsResult.next()) {
                physicsMark = physicsResult.getString("mark");
            }
            ResultSet chemistryResult = DatabaseUtil.results("physics", where);
            while (chemistryResult.next()) {
                chemistryMark = chemistryResult.getString("mark");
            }
            ResultSet englishResult = DatabaseUtil.results("english", where);
            while (englishResult.next()) {
                englishMark = englishResult.getString("mark");
            }
            ResultSet mathResult = DatabaseUtil.results("math", where);
            while (mathResult.next()) {
                 mathMark = mathResult.getString("mark");
            }
        }catch (Exception e){}

        String[][] mytt = {{"Monday","phy","chem","break","math","lunch","eng"},{"Tuesday","phy","chem","break","math","lunch","eng"}};
        String[] restt = {"Day","8-9","9-10","10-11","11-1","1-2","2-4"};
        timTable = new JTable(mytt,restt);
        ttPane = new JScrollPane(timTable);
        timetable = new JPanel();

        timetable.add(ttPane);

        String[][] myRes = {{"chemistry",chemistryMark},{"physics",physicsMark},{"Math",mathMark},{"English",englishMark}};
        String[] resRes = {"Subject","marks"};

        resTable = new JTable(myRes,resRes);
        resPane = new JScrollPane(resTable);
        results = new JPanel();
        //results.setLayout(null);
        results.add(resPane);

        mainPanel = new JTabbedPane();
        mainPanel.addTab("Results",results);
        mainPanel.addTab("Time Table",timetable);
        this.add(mainPanel);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
