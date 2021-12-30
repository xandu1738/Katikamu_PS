package GUI_CW;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSubject extends JFrame implements ActionListener {
    JButton recordMarks, back,physics,chemistry,math,english;
    //JMenu subjects;
    //JMenuItem physics,chemistry,math,english;
    JLabel selection,sub;
    public SelectSubject(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(900,600);

        recordMarks = new JButton("Start Recording");
        recordMarks.setBounds(300,450,200,100);

      //  subjects = new JMenu("Sujects");
        //subjects.setBounds(300,300,200,100);

        sub = new JLabel("Select Subject");
        sub.setBounds(100,300,150,100);

        selection = new JLabel("Subjects to register");
        selection.setBounds(100,100,300,100);

        physics = new JButton("Physics");
        physics.setBounds(300,200,200,100);
        chemistry = new JButton("Chemistry");
        chemistry.setBounds(600,200,200,100);
        math = new JButton("Math");
        math.setBounds(300,400,200,100);
        english = new JButton("English");
        english.setBounds(600,400,200,100);


        back = new JButton("Back");
        back.setBounds(500,100,200,100);


        this.add(physics);
        this.add(chemistry);
        this.add(math);
        this.add(english);
        this.add(back);
        this.add(selection);
        this.add(sub);
        //this.add(subjects);
        this.add(recordMarks);
        setVisible(false);
    }

    public static void main(String[] args) {
        new SelectSubject().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
