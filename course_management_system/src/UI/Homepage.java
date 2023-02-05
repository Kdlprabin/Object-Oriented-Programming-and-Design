package UI;

import Backend.Courses;
import Backend.Users.Admin;
import Backend.Users.Student;
import Backend.Users.Teacher;
import UI.Helpers.Effects;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Homepage extends JFrame {

    private JPanel sideBar, mainBoard, Dashboard;
    private JButton logoutButton,dashboardButton,studentsButton,studentsReportButton,instructorsButton,coursesButton;
    private JLabel welcomeMessage;
    private JLabel totalInstructorsCount;
    private JLabel totalStudentsCount;
    private JLabel totalCoursesCount;
    private JLabel totalModulesCount;
    private JPanel Home;
    private JPanel StudentReport;
    private JList ID;
    private JList studentName;
    private JList CourseName;
    private JList moduleName;
    private JButton StudentReportAddB;
    private JButton StudentReportDeleteB;
    private JTextField StudentsReportNameTF;
    private JTextField textField2;
    private JPanel Teacher;
    private JTable studentReportTable;
    private JButton StudentReportEditB;
    private JTable teacherTable;
    private JPanel Course;
    private JTable courseTable;
    private JPanel Student;
    private JTable studentTable;
    private JTextField StudentsNameTF;
    private JComboBox StudentsCourseTF;
    private JButton StudentsAddB;
    private JTextField StudentsReportModuleTF;
    private JButton StudentsDeleteB;
    private JTextField StudentsReportMarksTF;
    private JPanel StudentNav;
    private JPanel CourseNav;
    private JPanel TeacherNav;
    private JButton CourseAddB;
    private JButton CourseDeleteB;
    private JButton CourseEditB;
    private JTextField CourseNameTF;
    private JTextField CourseCostTF;
    private JButton StudentsEditB;
    private JTextField InstructorsNameTF;
    private JComboBox InstructorsCourseTF;
    private JComboBox InstructorsModuleTF;
    private JButton InstructorsAddB;
    private JButton InstructorsDeleteB;
    private JButton InstructorsEditB;
    private JLabel FullName;
    private JLabel Email;
    private JPanel studentReportHeaders;
    private JPanel studentsReportCRUD;
    private JPanel InstructorsHeaders;
    private JPanel InstructorsCRUD;
    private JPanel CourseHeaders;
    private JPanel CourseCRUD;
    private JPanel StudentsHeaders;
    private JPanel StudentsCRUD;
    private JTable enrollmentTable;
    private JPanel Enrollment;
    private JButton enrollmentButton;
    private JPanel Modules;
    private JButton modulesButton;
    private JTable moduleTable;
    private JTextField ModuleNameTF;
    private JComboBox ModuleTypeTF;
    private JButton ModuleAddB;
    private JButton ModuleDeleteB;
    private JButton ModuleEditB;
    private JComboBox ModuleCourseName;
    private JList marks;

    private final String username;
    private final String email;

    //for student editor
    private boolean hasClickedEditStudents = false;
    private String studentEditID = "";
    private boolean hasClickedEditCourse = false;
    private String courseEditID = "";
    private boolean hasClickedEditStudentReport = false;
    private String studentReportEditID = "";
    private boolean hasClickedEditTeacher = false;
    private String teacherEditID = "";
    private boolean hasClickedEditModule = false;
    private String moduleEditID="";
    //lists
    JButton[] buttons = {dashboardButton,coursesButton,instructorsButton, studentsReportButton,studentsButton,enrollmentButton,modulesButton};

    //utility classes
    Effects effects = new Effects();

    //welcome message for the user
    void welcomeMessage(){
        welcomeMessage.setText("Welcome "+username.split(" ")[0]+"!");
        FullName.setText(username);
        Email.setText(email);
    }

    void logout(){
        logoutButton.addActionListener(e->{
                setVisible(false);
                new LoginPage();
        }
        );
    }
    void studentsCRUD(Admin admin){
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        StudentsDeleteB.addActionListener(e->{
            int row =studentTable.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this,"Please select a row to Delete.");
            }else{
                admin.deleteStudent(model.getValueAt(row,0).toString());
                admin.fetchStudentTableData(studentTable);
                setCountValues(admin);
            }
        });
        StudentsAddB.addActionListener(e ->{
            if(StudentsNameTF.getText().equals("") || StudentsCourseTF.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(this,"Empty input fields");
            }else{
                admin.addStudent(StudentsNameTF.getText(),(String) StudentsCourseTF.getSelectedItem());
                admin.fetchStudentTableData(studentTable);
                StudentsNameTF.setText("");
                setCountValues(admin);
            }
        });
        StudentsEditB.addActionListener(e->{
            int row =studentTable.getSelectedRow();
            if(row==-1 &&!hasClickedEditStudents){
                JOptionPane.showMessageDialog(this,"Please select a row to Edit.");
            }else {
                if(!hasClickedEditStudents){
                    StudentsNameTF.setText(model.getValueAt(row, 1).toString());
                    StudentsCourseTF.setSelectedItem(model.getValueAt(row, 2).toString());
                    this.studentEditID = model.getValueAt(row,0).toString();
                    StudentsEditB.setText("Change");
                    StudentsEditB.setBackground(Color.yellow);
                    StudentsEditB.setForeground(Color.black);
                }
                if (hasClickedEditStudents) {
                    admin.editStudent(studentEditID, StudentsNameTF.getText(), (String) StudentsCourseTF.getSelectedItem());
                    admin.fetchStudentTableData(studentTable);
                    StudentsEditB.setText("Edit");
                    StudentsEditB.setBackground(new Color(38, 140, 242));
                    StudentsEditB.setForeground(Color.white);
                    StudentsNameTF.setText("");
                }
                if(hasClickedEditStudents){
                    hasClickedEditStudents = false;
                }else{
                    hasClickedEditStudents = true;
                }
            }

        });
    }
    void studentsReportButtonCRUD(Teacher teacher){
        studentReportTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) studentReportTable.getModel();
        StudentReportAddB.addActionListener(e->{
            if(StudentsReportNameTF.getText().equals("") || StudentsReportMarksTF.getText().equals("") || StudentsReportMarksTF.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Empty input fields");
            }else{
                teacher.addMarks(StudentsReportNameTF.getText(),StudentsReportModuleTF.getText(),StudentsReportMarksTF.getText());
                teacher.fetchStudentReportTableData(studentReportTable);
            }
        });
        StudentReportDeleteB.addActionListener(e->{
            int row =studentReportTable.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this,"Please select a row to Delete.");
            }else{
                teacher.deleteMarks(model.getValueAt(row,0).toString());
                teacher.fetchStudentReportTableData(studentReportTable);
            }
        });
        StudentReportEditB.addActionListener(e->{
            int row =studentReportTable.getSelectedRow();
            if(row==-1 &&!hasClickedEditStudentReport){
                JOptionPane.showMessageDialog(this,"Please select a row to Edit.");
            }else {
                if(!hasClickedEditStudentReport){
                    StudentsReportNameTF.setText(model.getValueAt(row, 1).toString());
                    StudentsReportModuleTF.setText(model.getValueAt(row, 3).toString());
                    StudentsReportMarksTF.setText(model.getValueAt(row,4).toString());
                    this.studentReportEditID = model.getValueAt(row,0).toString();
                    StudentReportEditB.setText("Change");
                    StudentReportEditB.setBackground(Color.yellow);
                    StudentReportEditB.setForeground(Color.black);
                }
                if (hasClickedEditStudentReport) {
                    teacher.editMarks(studentReportEditID, StudentsReportNameTF.getText(), StudentsReportModuleTF.getText(),StudentsReportMarksTF.getText());
                    teacher.fetchStudentReportTableData(studentReportTable);
                    StudentReportEditB.setText("Edit");
                    StudentReportEditB.setBackground(new Color(38, 140, 242));
                    StudentReportEditB.setForeground(Color.white);
                    StudentsReportMarksTF.setText("");
                    StudentsNameTF.setText("");
                    StudentsReportModuleTF.setText("");
                }
                if(hasClickedEditStudentReport){
                    hasClickedEditStudentReport = false;
                }else{
                    hasClickedEditStudentReport = true;
                }
            }

        });
    }
    void coursesCRUD(Admin admin){
        courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        CourseDeleteB.addActionListener(e->{
            int row =courseTable.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this,"Please select a row to Delete.");
            }else{
                admin.deleteCourse(model.getValueAt(row,0).toString());
                admin.fetchCourseData(courseTable);
                setAdminOptionBox(admin);
                setCountValues(admin);
            }
        });
        CourseAddB.addActionListener(e ->{
            if(CourseNameTF.getText().equals("") || CourseCostTF.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Empty input fields");
            }else{
                if(admin.addCourse(CourseNameTF.getText(),CourseCostTF.getText())){
                    JOptionPane.showMessageDialog(this,"Please Enter valid values");
                }
                admin.fetchCourseData(courseTable);
                CourseNameTF.setText("");
                CourseCostTF.setText("");
                setAdminOptionBox(admin);
                setCountValues(admin);
            }
        });
        CourseEditB.addActionListener(e->{
            int row =courseTable.getSelectedRow();
            if(row==-1 &&!hasClickedEditCourse){
                JOptionPane.showMessageDialog(this,"Please select a row to Edit.");
            }else {
                if(!hasClickedEditCourse){
                    CourseNameTF.setText(model.getValueAt(row, 1).toString());
                    CourseCostTF.setText(model.getValueAt(row, 2).toString());
                    this.courseEditID = model.getValueAt(row,0).toString();
                    CourseEditB.setText("Change");
                    CourseEditB.setBackground(Color.yellow);
                    CourseEditB.setForeground(Color.black);
                }
                if (hasClickedEditCourse) {
                    admin.editCourse(courseEditID, CourseNameTF.getText(), CourseCostTF.getText());
                    admin.fetchCourseData(courseTable);
                    CourseEditB.setText("Edit");
                    CourseEditB.setBackground(new Color(38, 140, 242));
                    CourseEditB.setForeground(Color.white);
                    CourseCostTF.setText("");
                    CourseCostTF.setText("");
                    setAdminOptionBox(admin);
                }
                if(hasClickedEditCourse){
                    hasClickedEditCourse = false;
                }else{
                    hasClickedEditCourse = true;
                }
            }

        });
    }
    void coursesCRUD(Teacher teacher){
        courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        CourseDeleteB.addActionListener(e->{
            int row =courseTable.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this,"Please select a row to Delete.");
            }else{
                teacher.deleteCourse(model.getValueAt(row,0).toString());
                teacher.fetchCourseData(courseTable);
                setTeacherOptionBox(teacher);
                setCountValues(teacher);
            }
        });
        CourseAddB.addActionListener(e ->{
            if(CourseNameTF.getText().equals("") || CourseCostTF.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Empty input fields");
            }else{
                if(teacher.addCourse(CourseNameTF.getText(),CourseCostTF.getText())){
                    JOptionPane.showMessageDialog(this,"Please Enter valid values");
                }
                teacher.fetchCourseData(courseTable);
                CourseNameTF.setText("");
                CourseCostTF.setText("");
                setTeacherOptionBox(teacher);
                setCountValues(teacher);
            }
        });
        CourseEditB.addActionListener(e->{
            int row =courseTable.getSelectedRow();
            if(row==-1 &&!hasClickedEditCourse){
                JOptionPane.showMessageDialog(this,"Please select a row to Edit.");
            }else {
                if(!hasClickedEditCourse){
                    CourseNameTF.setText(model.getValueAt(row, 1).toString());
                    CourseCostTF.setText(model.getValueAt(row, 2).toString());
                    this.courseEditID = model.getValueAt(row,0).toString();
                    CourseEditB.setText("Change");
                    CourseEditB.setBackground(Color.yellow);
                    CourseEditB.setForeground(Color.black);
                }
                if (hasClickedEditCourse) {
                    teacher.editCourse(courseEditID, CourseNameTF.getText(), CourseCostTF.getText());
                    teacher.fetchCourseData(courseTable);
                    CourseEditB.setText("Edit");
                    CourseEditB.setBackground(new Color(38, 140, 242));
                    CourseEditB.setForeground(Color.white);
                    CourseCostTF.setText("");
                    CourseCostTF.setText("");
                    setTeacherOptionBox(teacher);
                }
                if(hasClickedEditCourse){
                    hasClickedEditCourse = false;
                }else{
                    hasClickedEditCourse = true;
                }
            }

        });
    }

    void modulesCRUD(Admin admin){
        setAdminOptionBox(admin);
        moduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) moduleTable.getModel();
        ModuleDeleteB.addActionListener(e->{
            int row =moduleTable.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this,"Please select a row to Delete.");
            }else{
                admin.deleteModule(model.getValueAt(row,0).toString(),model.getValueAt(row,2).toString());
                admin.fetchCourseData(moduleTable);
                setCountValues(admin);
            }
        });
        ModuleAddB.addActionListener(e ->{
            if(ModuleCourseName.getSelectedItem().equals("")||ModuleNameTF.getText().equals("") || ModuleTypeTF.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(this,"Empty input fields");
            }else{
                admin.addModule((String) ModuleCourseName.getSelectedItem(),ModuleNameTF.getText(),(String)ModuleTypeTF.getSelectedItem());
                admin.fetchModuleTableData(moduleTable);
                ModuleNameTF.setText("");
                setCountValues(admin);
            }
        });
        ModuleEditB.addActionListener(e->{
            int row =moduleTable.getSelectedRow();
            if(row==-1 &&!hasClickedEditModule){
                JOptionPane.showMessageDialog(this,"Please select a row to Edit.");
            }else {
                if(!hasClickedEditModule){
                    ModuleCourseName.setSelectedItem(model.getValueAt(row, 1).toString());
                    ModuleNameTF.setText(model.getValueAt(row, 2).toString());
                    ModuleTypeTF.setSelectedItem(model.getValueAt(row,3).toString());
                    this.moduleEditID = model.getValueAt(row,0).toString();
                    ModuleEditB.setText("Change");
                    ModuleEditB.setBackground(Color.yellow);
                    ModuleEditB.setForeground(Color.black);
                }
                if (hasClickedEditModule) {
                    admin.editModule(moduleEditID, ModuleNameTF.getText(), (String)ModuleCourseName.getSelectedItem(),(String)ModuleTypeTF.getSelectedItem());
                    admin.fetchModuleTableData(moduleTable);
                    ModuleEditB.setText("Edit");
                    ModuleEditB.setBackground(new Color(38, 140, 242));
                    ModuleEditB.setForeground(Color.white);
                    ModuleNameTF.setText("");
                }
                if(hasClickedEditModule){
                    hasClickedEditModule = false;
                }else{
                    hasClickedEditModule = true;
                }
            }

        });
    }

    void setAdminOptionBox(Admin admin){
        ArrayList<String> Courses = admin.getCourseList();
        ModuleCourseName.removeAllItems();
        StudentsCourseTF.removeAllItems();
        InstructorsCourseTF.removeAllItems();
        for(String s:Courses){
            ModuleCourseName.addItem(s);
            StudentsCourseTF.addItem(s);
            InstructorsCourseTF.addItem(s);
        }
        InstructorsCourseTF.addActionListener(e->{
            System.out.println(InstructorsCourseTF.getSelectedItem());
            String selectCourse =(String)InstructorsCourseTF.getSelectedItem();
            ArrayList<String> modules = admin.getModuleList(selectCourse);
            InstructorsModuleTF.removeAllItems();
            for(String s:modules){
                InstructorsModuleTF.addItem(s);
            }
        });
    }
    void setTeacherOptionBox(Teacher teacher){
        String course = teacher.getCourseName();
        ModuleCourseName.removeAllItems();
        StudentsCourseTF.removeAllItems();
        ModuleCourseName.addItem(course);
        StudentsCourseTF.addItem(course);
        InstructorsCourseTF.addItem(course);
        ArrayList<String> modules = teacher.getModuleList();
        InstructorsModuleTF.removeAllItems();
        for(String s:modules){
            InstructorsModuleTF.addItem(s);
        }
    }
    void setStudentOptionBox(Student student){
        ArrayList<String> Courses = new ArrayList<>();
        for(String s:Courses){
        }
    }
    void instructorCRUD(Admin admin){
        teacherTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) teacherTable.getModel();
        InstructorsDeleteB.addActionListener(e->{
            int row =teacherTable.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this,"Please select a row to Delete.");
            }else{
                admin.deleteTeacher(model.getValueAt(row,0).toString(),model.getValueAt(row,1).toString(),model.getValueAt(row,3).toString());
                admin.fetchTeacherData(teacherTable);
                setCountValues(admin);
            }
        });
        InstructorsAddB.addActionListener(e ->{
            if(InstructorsNameTF.getText().equals("") || InstructorsCourseTF.getSelectedItem().equals("") || InstructorsModuleTF.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(this,"Empty input fields");
            }else{
                admin.addTeacher(InstructorsNameTF.getText(),(String)InstructorsCourseTF.getSelectedItem(),(String) InstructorsModuleTF.getSelectedItem());
                admin.fetchTeacherData(teacherTable);
                InstructorsNameTF.setText("");
                setCountValues(admin);
            }
        });
        InstructorsEditB.addActionListener(e->{
            int row =teacherTable.getSelectedRow();
            if(row==-1 &&!hasClickedEditTeacher){
                JOptionPane.showMessageDialog(this,"Please select a row to Edit.");
            }else {
                if(!hasClickedEditTeacher){
                    InstructorsNameTF.setText(model.getValueAt(row, 1).toString());
                    InstructorsCourseTF.setSelectedItem(model.getValueAt(row, 2).toString());
                    InstructorsModuleTF.setSelectedItem(model.getValueAt(row,3).toString());
                    this.teacherEditID = model.getValueAt(row,0).toString();
                    InstructorsEditB.setText("Change");
                    InstructorsEditB.setBackground(Color.yellow);
                    InstructorsEditB.setForeground(Color.black);
                }
                if (hasClickedEditTeacher) {
                    admin.editTeacher(teacherEditID, InstructorsNameTF.getText(), (String)InstructorsCourseTF.getSelectedItem(),(String)InstructorsModuleTF.getSelectedItem());
                    admin.fetchTeacherData(teacherTable);
                    InstructorsEditB.setText("Edit");
                    InstructorsEditB.setBackground(new Color(38, 140, 242));
                    InstructorsEditB.setForeground(Color.white);
                    InstructorsNameTF.setText("");
                }
                hasClickedEditTeacher = !hasClickedEditTeacher;
            }

        });
    }
        //setting the counts in dashboard
    void setCountValues(Admin admin){
        HashMap<String,Integer> data = admin.getCounts();
        if(data !=null){
            totalStudentsCount.setText(data.get("student").toString());
            totalInstructorsCount.setText(data.get("teacher").toString());
            totalCoursesCount.setText(data.get("course").toString());
            totalModulesCount.setText(data.get("module").toString());
        }
    }
    void setCountValues(Teacher teacher){
        HashMap<String,Integer> data = teacher.getCounts();
        if(data !=null){
            totalStudentsCount.setText(data.get("student").toString());
            totalInstructorsCount.setText(data.get("teacher").toString());
            totalCoursesCount.setText(data.get("course").toString());
            totalModulesCount.setText(data.get("module").toString());
        }
    }
    void setCountValues(Student student){
        HashMap<String,Integer> data = student.getCounts();
        if(data !=null){
            totalStudentsCount.setText(data.get("student").toString());
            totalInstructorsCount.setText(data.get("teacher").toString());
            totalCoursesCount.setText(data.get("course").toString());
            totalModulesCount.setText(data.get("module").toString());
        }
    }

    //admin features
    void adminFeatures(Admin admin){
        modulesButton.setVisible(true);
        coursesCRUD(admin);
        modulesCRUD(admin);
        admin.fetchCourseData(courseTable);
        enrollmentButton.setVisible(false);
        admin.fetchStudentTableData(studentTable);
        admin.fetchTeacherData(teacherTable);
        admin.fetchModuleTableData(moduleTable);
        setCountValues(admin);
        studentsCRUD(admin);
        instructorCRUD(admin);
        studentsReportButton.setVisible(false);
        StudentNav.setVisible(true);
        TeacherNav.setVisible(true);
        CourseNav.setVisible(true);
    }

    //teacher features
    void teacherFeatures(Teacher teacher){
        modulesButton.setVisible(true);
        studentsReportButton.setVisible(true);
        studentsButton.setVisible(false);
        enrollmentButton.setVisible(false);
        teacher.fetchModuleTableData(moduleTable,this.username);
        teacher.fetchStudentReportTableData(studentReportTable);
        teacher.fetchCourseData(courseTable);
        studentsReportButtonCRUD(teacher);
        setTeacherOptionBox(teacher);
        CourseCRUD.setVisible(false);
        CourseHeaders.setVisible(false);
        StudentNav.setVisible(true);
        TeacherNav.setVisible(false);
        CourseNav.setVisible(true);
        setCountValues(teacher);
    }
    void commonSetUp(){
        welcomeMessage();
        navigation();
        setContentPane(Dashboard);
        setSize(1280,720);
        effects.activateEffect(buttons);
        setVisible(true);
        logout();
    }

    void studentFeatures(Student student){
        modulesButton.setVisible(false);
        studentsReportButton.setVisible(true);
        studentsButton.setVisible(false);
        enrollmentButton.setVisible(true);
        studentReportHeaders.setVisible(false);
        studentsReportCRUD.setVisible(false);
        InstructorsHeaders.setVisible(false);
        InstructorsCRUD.setVisible(false);
        CourseHeaders.setVisible(false);
        CourseCRUD.setVisible(false);
        student.fetchEnrollmentTableData(enrollmentTable);
        student.fetchStudentReportTableData(studentReportTable);
        student.fetchCourseData(courseTable);
        student.fetchTeacherData(teacherTable,student.getCourseName());
        setCountValues(student);
    }
    //navigation
    void navigation(){
        //the panels and buttons associated with it should be kept in order
        JPanel[] panels = {Course,Home, StudentReport,Teacher,Student,Enrollment,Modules};
        JButton[] buttons = {coursesButton,dashboardButton,studentsReportButton,instructorsButton,studentsButton,enrollmentButton,modulesButton};
        for(int i=0;i<panels.length;i++){
            associateButtonAndPanel(panels,buttons[i],panels[i]);
        }
    }
    void associateButtonAndPanel(JPanel[] panelList,JButton b,JPanel p){
            b.addActionListener(e->{
                for(JPanel panel:panelList){
                    panel.setVisible(false);
                }
                p.setVisible(true);
            });
    }
    public Homepage(Admin admin){
        this.email = admin.getEmail();
        this.username=admin.getUsername();
        commonSetUp();
        adminFeatures(admin);
    }
    public Homepage(Student student){
        this.email = student.getEmail();
        this.username = student.getUsername();
        studentFeatures(student);
        commonSetUp();
    }
    public Homepage(Teacher teacher){
        this.email = teacher.getEmail();
        this.username = teacher.getUsername();
        commonSetUp();
        teacherFeatures(teacher);
    }
}
