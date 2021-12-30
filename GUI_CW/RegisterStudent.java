package GUI_CW;

import GUI_CW_DB.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterStudent extends JFrame implements ActionListener {
    JLabel fname,lname,regNumber,gender,subject,age,classLevel,regStatusY,regStatusN;
    JTextField firstName,lastName,registrationNumber,genderStatus,subjectRegistered,ageOfStudent,classLevelSelected;
    JButton register,clear,back;
    String username;
    public RegisterStudent(String username){
        super("Katikamu primary school");
        this.username = username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLayout(null);
        this.setBounds(0,0,900,600);

        //this.setLayout(new BorderLayout());
        JLabel title = new JLabel("Register Student");
        title.setBounds(400,20,200,100);
        title.setFont(new Font("",Font.BOLD,20));


        regStatusY = new JLabel("Registered Successfully, Register next Student");
        regStatusY.setBounds(250,400,600,50);
        regStatusY.setVisible(false);

        regStatusN = new JLabel("Student not registered or already exists, try different details");
        regStatusN.setBounds(250,400,600,50);
        regStatusN.setVisible(false);

        fname = new JLabel("First Name:");
        fname.setBounds(200,100,200,40);

        firstName = new JTextField(50);
        firstName.setBounds(450,100,200,40);

        lname = new JLabel("Last Name:");
        lname.setBounds(200,150,200,40);

        lastName = new JTextField(50);
        lastName.setBounds(450,150,200,40);

        regNumber = new JLabel("Registration Number:");
        regNumber.setBounds(200,200,200,40);

        registrationNumber = new JTextField(40);
        registrationNumber.setBounds(450,200,200,40);

        gender = new JLabel("Gender:");
        gender.setBounds(200,250,200,40);

        genderStatus = new JTextField(50);
        genderStatus.setBounds(450,250,200,40);

        subject = new JLabel("Subject:");
        subject.setBounds(200,300,200,40);

        subjectRegistered = new JTextField(50);
        subjectRegistered.setBounds(450,500,200,40);

        age = new JLabel("Age:");
        age.setBounds(200,300,200,40);

        ageOfStudent = new JTextField(50);
        ageOfStudent.setBounds(450,300,200,40);

        classLevel = new JLabel("Class:");
        classLevel.setBounds(200,350,200,40);

        classLevelSelected = new JTextField(50);
        classLevelSelected.setBounds(450,350,200,40);

        register = new JButton("Register");
        register.setBounds(450,450,100,50);
        register.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBounds(300,450,100,50);
        clear.addActionListener(this);


        back = new JButton("Back");
        back.setBounds(50,50,100,30);
        back.addActionListener(this);

        this.add(classLevel);
        this.add(classLevelSelected);
        this.add(clear);
        this.add(firstName);
        this.add(fname);
        this.add(lname);
        this.add(lastName);
        this.add(register);
        this.add(registrationNumber);
        this.add(regNumber);
        this.add(age);
        this.add(ageOfStudent);
        this.add(regStatusY);
        this.add(regStatusN);
        //this.add(subject);
        //this.add(subjectRegistered);
        this.add(title);
        this.add(gender);
        this.add(genderStatus);
        this.add(back);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event.equals(register)){
            String table = "Students";
            String where = " RegistrationNumber = '"+registrationNumber.getText()+"'";
            boolean exists = DatabaseUtil.check(table,where);
            if (exists == true){
                System.out.println("This is true value exists");
                regStatusN.setText("Student not registered or already exists, try different details");
                regStatusN.setVisible(true);
                regStatusY.setVisible(false);

            }else{
                System.out.println("This is not true value exists");
                String fname,lname,reg,ageS,gender,classLevel,subject;
                fname = firstName.getText();
                lname = lastName.getText();
                reg = registrationNumber.getText();
                ageS = ageOfStudent.getText();
                gender = genderStatus.getText();
                classLevel = classLevelSelected.getText();
                subject = subjectRegistered.getText();
                String tableInsert = "Students(RegistrationNumber,age,ClassLevel,Gender,Subject,FirstName,LastName)";
                String values = "'"+reg+"','"+ageS+"','"+classLevel+"','"+gender+"','"+username+"','"+fname+"','"+lname+"'";
                DatabaseUtil.record(tableInsert,values);

                    regStatusY.setVisible(true);
                    regStatusN.setVisible(false);
                    firstName.setText("");
                    lastName.setText("");
                    genderStatus.setText("");
                    subjectRegistered.setText("");
                    classLevelSelected.setText("");
                    registrationNumber.setText("");
                    ageOfStudent.setText("");
            }
        }
        if (event.equals(clear)){
            firstName.setText("");
            lastName.setText("");
            genderStatus.setText("");
            subjectRegistered.setText("");
            classLevelSelected.setText("");
            registrationNumber.setText("");
            ageOfStudent.setText("");
        }
        if (event.equals(back)){
            new TeacherMenu(username).setVisible(true);
            this.setVisible(false);
        }
    }
}
