import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

class Student {
    public String name;
    public String roll;
    public String grade;
    public String gender;
    public String dob;
    public String email;
    public String address;

    public String toString() {
        return name + "," + roll + "," + grade + "," + gender + "," + dob + "," + email + "," + address;
    }

    public static Student fromString(String str) {
        String[] parts = str.split(",");
        if (parts.length != 7) return null;

        Student student = new Student();
        student.name = parts[0];
        student.roll = parts[1];
        student.grade = parts[2];
        student.gender = parts[3];
        student.dob = parts[4];
        student.email = parts[5];
        student.address = parts[6];

        return student;
    }
}

class StudentManagementSystem {

    static JLabel l1, l2, l3, l4, l5, l6, l7;
    static JTextField t1, t2, t3, t4, t5, t6, t7;
    static JButton b1, b2, b3, b4, b5;
    static JTextArea TxtArea;
    

    static ArrayList<Student> studentList = new ArrayList<>();
    static final String FILE_PATH = "students.txt";

    public void addStudent() {
        Student newStudent = new Student();
        newStudent.name = t1.getText();
        newStudent.roll = t2.getText();
        newStudent.grade = t3.getText();
        newStudent.gender = t4.getText();
        newStudent.email = t5.getText();
        newStudent.dob = t6.getText();
        newStudent.address = t7.getText();

        if (newStudent.name.equals("") || newStudent.roll.equals("") || newStudent.grade.equals("")) {
            JOptionPane.showMessageDialog(null, "Fill in the missing values", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            studentList.add(newStudent);
            saveToFile();
        }
    }

    public void removeStudent() {
        String rollToRemove = JOptionPane.showInputDialog("Enter the Roll Number of the student to remove:");
        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.roll.equals(rollToRemove)) {
                studentList.remove(i);
                found = true;
                JOptionPane.showMessageDialog(null, "Student removed successfully.");
                saveToFile();
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Student not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            displayStudent();
        }
    }

    public void searchStudent() {
        String rollToSearch = JOptionPane.showInputDialog("Enter the Roll Number of the student to search:");
        boolean found = false;

        TxtArea.setText("");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.roll.equals(rollToSearch)) {
                TxtArea.append(student.toString() + "\n");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Student not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayStudent() {
        TxtArea.setText("");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            TxtArea.append(student.toString() + "\n");
        }
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            PrintWriter writer = new PrintWriter(fw);
            for (int i = 0; i < studentList.size(); i++) {
                Student student = studentList.get(i);
                writer.println(student.toString());
            }
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving student data.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadFromFile() {
        studentList.clear();
        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromString(line);
                if (student != null) {
                    studentList.add(student);
                }
            }
            reader.close();
            displayStudent();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading student data.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }

    public void showMainFrame() {
        JFrame F = new JFrame("Student Management System");
        
        F.getContentPane().setBackground(new Color(41, 50, 65));

        l1 = new JLabel("Student Name");
        l1.setBounds(20, 30, 100, 30);
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("Student Roll Number");
        l2.setBounds(20, 80, 150, 30);
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Student Grade");
        l3.setBounds(20, 130, 100, 30);
        l3.setForeground(Color.WHITE);

        l4 = new JLabel("Gender");
        l4.setBounds(20, 180, 100, 30);
        l4.setForeground(Color.WHITE);

        l5 = new JLabel("Contact");
        l5.setBounds(20, 230, 100, 30);
        l5.setForeground(Color.WHITE);

        l6 = new JLabel("Address");
        l6.setBounds(20, 280, 100, 30);
        l6.setForeground(Color.WHITE);

        l7 = new JLabel("D.O.B");
        l7.setBounds(20, 330, 100, 30);
        l7.setForeground(Color.WHITE);

        t1 = new JTextField();
        t1.setBounds(180, 30, 230, 30);

        t2 = new JTextField();
        t2.setBounds(180, 80, 230, 30);

        t3 = new JTextField();
        t3.setBounds(180, 130, 230, 30);

        t4 = new JTextField();
        t4.setBounds(180, 180, 230, 30);

        t5 = new JTextField();
        t5.setBounds(180, 230, 230, 30);

        t6 = new JTextField();
        t6.setBounds(180, 280, 230, 30);

        t7 = new JTextField();
        t7.setBounds(180, 330, 230, 30);

        b1 = new JButton("Add Students");
        b1.setBounds(20, 480, 190, 30);
        b1.setBackground(new Color(57, 62, 70));
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Remove Students");
        b2.setBounds(220, 480, 190, 30);
        b2.setBackground(new Color(57, 62, 70));
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Search Students");
        b3.setBounds(20, 400, 190, 30);
        b3.setBackground(new Color(57, 62, 70));
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Display Students");
        b4.setBounds(220, 400, 190, 30);
        b4.setBackground(new Color(57, 62, 70));
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("EXIT");
        b5.setBounds(20, 550, 190, 30);
        b5.setBackground(new Color(57, 62, 70));
        b5.setForeground(Color.WHITE);

        TxtArea = new JTextArea();
        TxtArea.setBounds(450, 30, 600, 550);
        TxtArea.setFont(new Font("SansSerif", Font.PLAIN, 14));

        F.setSize(1100, 650);
        F.setLayout(null);
        F.add(l1);
        F.add(l2);
        F.add(l3);
        F.add(l4);
        F.add(l5);
        F.add(l6);
        F.add(l7);
        F.add(t1);
        F.add(t2);
        F.add(t3);
        F.add(t4);
        F.add(t5);
        F.add(t6);
        F.add(t7);
        F.add(b1);
        F.add(b2);
        F.add(b3);
        F.add(b4);
        F.add(b5);
        F.add(TxtArea);

        F.setVisible(true);

        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadFromFile();

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStudent();
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JCheckBox rememberMeCheckBox;
    private JLabel forgotPasswordLabel;

    public LoginFrame() {
        setTitle("Login Form");
        setSize(500, 300);
        setLayout(null);
        getContentPane().setBackground(new Color(41, 50, 65));

        usernameField = new JTextField("Username");
        usernameField.setBounds(90, 80, 250, 30);
        add(usernameField);

        passwordField = new JPasswordField("Password");
        passwordField.setBounds(90, 120, 250, 30);
        add(passwordField);

        rememberMeCheckBox = new JCheckBox("Remember me");
        rememberMeCheckBox.setBounds(90, 160, 120, 30);
        rememberMeCheckBox.setBackground(new Color(41, 50, 65));
        rememberMeCheckBox.setForeground(Color.WHITE);
        add(rememberMeCheckBox);

        forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setBounds(220, 160, 120, 30);
        forgotPasswordLabel.setForeground(Color.LIGHT_GRAY);
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(forgotPasswordLabel);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 200, 100, 30);
        loginButton.setBackground(new Color(57, 62, 70));
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("Lunga") && password.equals("123hello")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose();
                    new StudentManagementSystem().showMainFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}