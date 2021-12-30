package GUI_CW;

import GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherResultsView extends JFrame implements ActionListener {
    JButton back, search;
    JTable resultsTable;
    JLabel resultsPage;
    JTextField searchValue;
    JScrollPane pane;
    String[] col = {"Registration Number","Marks"};
    String[][] data;
    String[] dataInstance;
    String username;


    public TeacherResultsView(String username){
        this.username = username;
        String table="";
        String where = "Username = '"+username+"'";
        try {
            ResultSet subject = DatabaseUtil.results("teachers",where);
            while (subject.next()){
                table = subject.getString("Subject");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String tableInsert = table+" (RegistrationNumber,mark)";
        try {
            ResultSet marks = DatabaseUtil.results(table, "none");
            data = new String[DatabaseUtil.tableLength][2];
            dataInstance = new  String[2];
            int counter = 0;
            while (marks.next()) {
                String reg = marks.getString("RegistrationNumber");
                String mark = marks.getString("mark");

                dataInstance[0] = reg;
                dataInstance[1] = mark;

                data[counter][0] = dataInstance[0];
                data[counter][1] = dataInstance[1];
                counter++;

            }
        }catch (Exception e){}

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(null);

        resultsTable = new JTable(data,col);
        resultsTable.setBounds(300,300,300,200);

        pane = new JScrollPane(resultsTable);
        pane.setBounds(300,300,300,200);

        resultsPage = new JLabel("<html><font color=blue>Students Results</font></html>");
        resultsPage.setBounds(400,20,200,100);
        resultsPage.setFont(new Font("",Font.BOLD,20));

        searchValue =new JTextField();
        searchValue.setBounds(200,210,300,70);

        search = new JButton("Search");
        search.setBounds(510,210,200,70);
        search.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(50,50,100,30);
        back.addActionListener(this);

        this.add(back);
        //this.add(search);
       // this.add(searchValue);
        this.add(pane);
        this.add(resultsPage);
        this.setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj.equals(search)){
            String[][] values = {{"tax","0000000","89"},{"max","65558","96"}};
            resultsTable = new JTable(values,col);

            resultsTable.setBounds(300,300,300,200);
            pane = new JScrollPane(resultsTable);
            pane.setBounds(300,300,300,200);
        }
        if (obj.equals(back)){
            new RecordMarks(username).setVisible(true);
            this.setVisible(false);
        }
    }
}
