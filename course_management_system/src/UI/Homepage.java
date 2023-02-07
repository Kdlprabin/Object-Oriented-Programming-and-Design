package UI;

import Backend.Users.Admin;
import Backend.Users.Student;
import Backend.Users.Teacher;
import UI.Helpers.Effects;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Homepage extends JFrame {

    private JPanel Dashboard;
    private JButton logoutButton, dashboardButton, studentsButton, studentsResultButton, instructorsButton,
            coursesButton;
    private JLabel welcomeMessage;
    private JLabel totalInstructorsCount, totalStudentsCount, totalCoursesCount, totalModulesCount;
    private JPanel Home, StudentResult, Teacher, Course, Student, StudentNav, CourseNav, TeacherNav;
    private JButton StudentResultAddB, StudentResultDeleteB, StudentResultEditB;
    private JTextField StudentsResultNameTF, StudentsNameTF, StudentsResultModuleTF, StudentsResultMarksTF,
            CourseNameTF, InstructorsNameTF;
    private JComboBox CourseCostTF;
    private JComboBox<String> StudentsCourseTF, InstructorsCourseTF, InstructorsModuleTF, ModuleTypeTF,
            ModuleCourseName;
    private JTable studentResultTable, teacherTable, courseTable, studentTable, enrollmentTable, moduleTable;
    private JLabel FullName, Email;
    private JPanel studentResultHeaders, studentsResultCRUD, InstructorsHeaders, InstructorsCRUD, CourseHeaders,
            CourseCRUD, Enrollment, Modules, ModulesCRUD, ModulesHeaders;
    private JButton enrollmentButton, modulesButton, InstructorsAddB, InstructorsDeleteB, InstructorsEditB, CourseAddB,
            CourseDeleteB, CourseEditB, StudentsAddB, StudentsDeleteB, StudentsEditB, enrollButton, ModuleAddB,
            ModuleDeleteB, ModuleEditB;
    private JTextField ModuleNameTF;
    private JPanel StudentsReport;
    private JTextField StudentsReportTF;
    private JButton GenerateReportB;
    private JTable StudentsReportTable;
    private JButton studentsReportButton;
    private JComboBox ModuleYear;
    private final String username;
    private final String email;

    // for student editor
    private boolean hasClickedEditStudents = false;
    private String studentEditID = "";
    private boolean hasClickedEditCourse = false;
    private String courseEditID = "";
    private boolean hasClickedEditStudentResult = false;
    private String studentResultEditID = "";
    private boolean hasClickedEditTeacher = false;
    private String teacherEditID = "";
    private boolean hasClickedEditModule = false;
    private String moduleEditID = "";

    // lists
    JButton[] buttons = { dashboardButton, coursesButton, instructorsButton, studentsResultButton, studentsButton,
            enrollmentButton, modulesButton,studentsReportButton };

    // utility classes
    Effects effects = new Effects();

    // welcome message for the user
    void welcomeMessage() {
        welcomeMessage.setText("Welcome " + username.split(" ")[0] + "!");
        FullName.setText(username);
        Email.setText(email);
    }

    void logout(Admin admin) {
        logoutButton.addActionListener(e -> {
            setVisible(false);
            admin.logout();
            new LoginPage();
        });
    }
    void logout(Teacher teacher) {
        logoutButton.addActionListener(e -> {
            setVisible(false);
            teacher.logout();
            new LoginPage();
        });
    }
    void logout(Student student) {
        logoutButton.addActionListener(e -> {
            setVisible(false);
            student.logout();
            new LoginPage();
        });
    }


    void studentsCRUD(Admin admin) {
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();

        // delete
        StudentsDeleteB.addActionListener(e -> {
            int row = studentTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            } else {
                admin.deleteStudent(model.getValueAt(row, 0).toString());
                admin.fetchStudentTableData(studentTable);
                setCountValues(admin);
            }
        });

        // add
        StudentsAddB.addActionListener(e -> {
            if (StudentsNameTF.getText().equals("") || Objects.equals(StudentsCourseTF.getSelectedItem(), "")) {
                JOptionPane.showMessageDialog(this, "Empty input fields");
            } else {
                admin.addStudent(StudentsNameTF.getText(), (String) StudentsCourseTF.getSelectedItem());
                admin.fetchStudentTableData(studentTable);
                StudentsNameTF.setText("");
                setCountValues(admin);
            }
        });

        // edit
        StudentsEditB.addActionListener(e -> {
            int row = studentTable.getSelectedRow();
            if (row == -1 && !hasClickedEditStudents) {
                JOptionPane.showMessageDialog(this, "Please select a row to Edit.");
            } else {
                if (!hasClickedEditStudents) {
                    StudentsNameTF.setText(model.getValueAt(row, 1).toString());
                    StudentsCourseTF.setSelectedItem(model.getValueAt(row, 2).toString());
                    this.studentEditID = model.getValueAt(row, 0).toString();
                    StudentsEditB.setText("Change");
                    StudentsEditB.setBackground(Color.yellow);
                    StudentsEditB.setForeground(Color.black);
                }
                if (hasClickedEditStudents) {
                    admin.editStudent(studentEditID, StudentsNameTF.getText(),
                            (String) StudentsCourseTF.getSelectedItem());
                    admin.fetchStudentTableData(studentTable);
                    StudentsEditB.setText("Edit");
                    StudentsEditB.setBackground(new Color(38, 140, 242));
                    StudentsEditB.setForeground(Color.white);
                    StudentsNameTF.setText("");
                }
                hasClickedEditStudents = !hasClickedEditStudents;
            }

        });
    }

    void studentsResultButtonCRUD(Teacher teacher) {
        studentResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) studentResultTable.getModel();
        StudentResultAddB.addActionListener(e -> {
            if (StudentsResultNameTF.getText().equals("") || StudentsResultMarksTF.getText().equals("")
                    || StudentsResultMarksTF.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Empty input fields");
            } else {
                teacher.addMarks(StudentsResultNameTF.getText(), StudentsResultModuleTF.getText(),
                        StudentsResultMarksTF.getText());
                teacher.fetchStudentResultTableData(studentResultTable);
            }
        });
        StudentResultDeleteB.addActionListener(e -> {
            int row = studentResultTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            } else {
                teacher.deleteMarks(model.getValueAt(row, 0).toString());
                teacher.fetchStudentResultTableData(studentResultTable);
            }
        });
        StudentResultEditB.addActionListener(e -> {
            int row = studentResultTable.getSelectedRow();
            if (row == -1 && !hasClickedEditStudentResult) {
                JOptionPane.showMessageDialog(this, "Please select a row to Edit.");
            } else {
                if (!hasClickedEditStudentResult) {
                    StudentsResultNameTF.setText(model.getValueAt(row, 1).toString());
                    StudentsResultModuleTF.setText(model.getValueAt(row, 2).toString());
                    StudentsResultMarksTF.setText(model.getValueAt(row, 3).toString());
                    this.studentResultEditID = model.getValueAt(row, 0).toString();
                    StudentResultEditB.setText("Change");
                    StudentResultEditB.setBackground(Color.yellow);
                    StudentResultEditB.setForeground(Color.black);
                }
                if (hasClickedEditStudentResult) {
                    teacher.editMarks(studentResultEditID, StudentsResultNameTF.getText(),
                            StudentsResultModuleTF.getText(), StudentsResultMarksTF.getText());
                    teacher.fetchStudentResultTableData(studentResultTable);
                    StudentResultEditB.setText("Edit");
                    StudentResultEditB.setBackground(new Color(38, 140, 242));
                    StudentResultEditB.setForeground(Color.white);
                    StudentsResultMarksTF.setText("");
                    StudentsNameTF.setText("");
                    StudentsResultModuleTF.setText("");
                }
                hasClickedEditStudentResult = !hasClickedEditStudentResult;
            }

        });
    }

    void coursesCRUD(Admin admin) {
        courseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        CourseDeleteB.addActionListener(e -> {
            int row = courseTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            } else {
                admin.deleteCourse(model.getValueAt(row, 0).toString());
                admin.fetchCourseData(courseTable);
                setAdminOptionBox(admin);
                setCountValues(admin);
            }
        });
        CourseAddB.addActionListener(e -> {
            if (CourseNameTF.getText().equals("") || CourseCostTF.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Empty input fields");
            } else {
                if (admin.addCourse(CourseNameTF.getText(),(String)CourseCostTF.getSelectedItem())) {
                    JOptionPane.showMessageDialog(this, "Please Enter valid values");
                }
                admin.fetchCourseData(courseTable);
                CourseNameTF.setText("");
                setAdminOptionBox(admin);
                setCountValues(admin);
            }
        });
        CourseEditB.addActionListener(e -> {
            int row = courseTable.getSelectedRow();
            if (row == -1 && !hasClickedEditCourse) {
                JOptionPane.showMessageDialog(this, "Please select a row to Edit.");
            } else {
                if (!hasClickedEditCourse) {
                    CourseNameTF.setText(model.getValueAt(row, 1).toString());
                    CourseCostTF.setSelectedItem(model.getValueAt(row, 2).toString());
                    this.courseEditID = model.getValueAt(row, 0).toString();
                    CourseEditB.setText("Change");
                    CourseEditB.setBackground(Color.yellow);
                    CourseEditB.setForeground(Color.black);
                }
                if (hasClickedEditCourse) {
                    admin.editCourse(courseEditID, CourseNameTF.getText(), (String)CourseCostTF.getSelectedItem());
                    admin.fetchCourseData(courseTable);
                    CourseEditB.setText("Edit");
                    CourseEditB.setBackground(new Color(38, 140, 242));
                    CourseEditB.setForeground(Color.white);
                    setAdminOptionBox(admin);
                }
                hasClickedEditCourse = !hasClickedEditCourse;
            }

        });
    }

    void modulesCRUD(Admin admin) {
        setAdminOptionBox(admin);
        moduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) moduleTable.getModel();
        ModuleYear.removeAllItems();
        for(int i =1;i<=admin.getCourseDuration((String)ModuleCourseName.getSelectedItem());i++) {
            ModuleYear.addItem(Integer.toString(i));
        }
        ModuleCourseName.addActionListener(e->{
            ModuleYear.removeAllItems();
            for(int i =1;i<=admin.getCourseDuration((String)ModuleCourseName.getSelectedItem());i++){
                ModuleYear.addItem(Integer.toString(i));
            }
        });
        ModuleDeleteB.addActionListener(e -> {
            int row = moduleTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            } else {
                admin.deleteModule(model.getValueAt(row, 0).toString(), model.getValueAt(row, 2).toString());
                admin.fetchCourseData(moduleTable);
                setCountValues(admin);
            }
        });
        ModuleAddB.addActionListener(e -> {
            if (Objects.equals(ModuleCourseName.getSelectedItem(), "") || ModuleNameTF.getText().equals("")
                    || Objects.equals(ModuleTypeTF.getSelectedItem(), "")) {
                JOptionPane.showMessageDialog(this, "Empty input fields");
            } else {
                admin.addModule((String) ModuleCourseName.getSelectedItem(), ModuleNameTF.getText(),ModuleTypeTF.getSelectedItem().toString(),(String) ModuleYear.getSelectedItem());
                admin.fetchModuleTableData(moduleTable);
                ModuleNameTF.setText("");
                setCountValues(admin);
            }
        });
        ModuleEditB.addActionListener(e -> {
            int row = moduleTable.getSelectedRow();
            if (row == -1 && !hasClickedEditModule) {
                JOptionPane.showMessageDialog(this, "Please select a row to Edit.");
            } else {
                if (!hasClickedEditModule) {
                    ModuleCourseName.setSelectedItem(model.getValueAt(row, 1).toString());
                    ModuleNameTF.setText(model.getValueAt(row, 2).toString());
                    ModuleTypeTF.setSelectedItem(model.getValueAt(row, 3).toString());
                    this.moduleEditID = model.getValueAt(row, 0).toString();
                    ModuleEditB.setText("Change");
                    ModuleEditB.setBackground(Color.yellow);
                    ModuleEditB.setForeground(Color.black);
                }
                if (hasClickedEditModule) {
                    admin.editModule(moduleEditID, ModuleNameTF.getText(), (String) ModuleCourseName.getSelectedItem(),
                            (String) ModuleTypeTF.getSelectedItem(),(String) ModuleYear.getSelectedItem());
                    admin.fetchModuleTableData(moduleTable);
                    ModuleEditB.setText("Edit");
                    ModuleEditB.setBackground(new Color(38, 140, 242));
                    ModuleEditB.setForeground(Color.white);
                    ModuleNameTF.setText("");
                }
                hasClickedEditModule = !hasClickedEditModule;
            }

        });
    }

    void setAdminOptionBox(Admin admin) {
        ArrayList<String> Courses = admin.getCourseList();
        ModuleCourseName.removeAllItems();
        StudentsCourseTF.removeAllItems();
        InstructorsCourseTF.removeAllItems();
        for (String s : Courses) {
            ModuleCourseName.addItem(s);
            StudentsCourseTF.addItem(s);
            InstructorsCourseTF.addItem(s);
        }
        String course = (String) InstructorsCourseTF.getSelectedItem();
        ArrayList<String> dModules = admin.getModuleList(course);
        InstructorsModuleTF.removeAllItems();
        for (String s : dModules) {
            InstructorsModuleTF.addItem(s);
        }
        InstructorsCourseTF.addActionListener(e -> {
            String selectCourse = (String) InstructorsCourseTF.getSelectedItem();
            ArrayList<String> modules = admin.getModuleList(selectCourse);
            InstructorsModuleTF.removeAllItems();
            for (String s : modules) {
                InstructorsModuleTF.addItem(s);
            }
        });
    }

    void enrollmentHandler(Student student) {
        enrollmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) enrollmentTable.getModel();
        enrollButton.addActionListener(e -> {
            int row = enrollmentTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            } else {
                if (!model.getValueAt(row, 2).equals("Not Enrolled")) {
                    student.enrollModules(model.getValueAt(row, 3).toString());
                    student.fetchEnrollmentTableData(enrollmentTable);
                } else {
                    JOptionPane.showMessageDialog(this, "Enrollment Failed");
                }
            }
        });
    }

    void setTeacherOptionBox(Teacher teacher) {
        String course = teacher.getCourseName();
        StudentsCourseTF.removeAllItems();
        ModuleCourseName.removeAllItems();
        StudentsCourseTF.addItem(course);
        InstructorsCourseTF.addItem(course);
        ArrayList<String> modules = teacher.getModuleList();
        InstructorsModuleTF.removeAllItems();
        ModuleCourseName.addItem(course);
        for (String s : modules) {
            InstructorsModuleTF.addItem(s);
        }
    }

    void instructorCRUD(Admin admin) {
        teacherTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = (DefaultTableModel) teacherTable.getModel();
        InstructorsDeleteB.addActionListener(e -> {
            int row = teacherTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to Delete.");
            } else {
                admin.deleteTeacher(model.getValueAt(row, 0).toString(), model.getValueAt(row, 1).toString(),
                        model.getValueAt(row, 3).toString());
                admin.fetchTeacherData(teacherTable);
                setCountValues(admin);
            }
        });
        InstructorsAddB.addActionListener(e -> {
            if (InstructorsNameTF.getText().equals("") || Objects.equals(InstructorsCourseTF.getSelectedItem(), "")
                    || Objects.equals(InstructorsModuleTF.getSelectedItem(), "")) {
                JOptionPane.showMessageDialog(this, "Empty input fields");
            } else {
                admin.addTeacher(InstructorsNameTF.getText(), (String) InstructorsCourseTF.getSelectedItem(),
                        (String) InstructorsModuleTF.getSelectedItem());
                admin.fetchTeacherData(teacherTable);
                InstructorsNameTF.setText("");
                setCountValues(admin);
            }
        });
        InstructorsEditB.addActionListener(e -> {
            int row = teacherTable.getSelectedRow();
            if (row == -1 && !hasClickedEditTeacher) {
                JOptionPane.showMessageDialog(this, "Please select a row to Edit.");
            } else {
                if (!hasClickedEditTeacher) {
                    InstructorsNameTF.setText(model.getValueAt(row, 1).toString());
                    InstructorsCourseTF.setSelectedItem(model.getValueAt(row, 2).toString());
                    InstructorsModuleTF.setSelectedItem(model.getValueAt(row, 3).toString());
                    this.teacherEditID = model.getValueAt(row, 0).toString();
                    InstructorsEditB.setText("Change");
                    InstructorsEditB.setBackground(Color.yellow);
                    InstructorsEditB.setForeground(Color.black);
                }
                if (hasClickedEditTeacher) {
                    admin.editTeacher(teacherEditID, InstructorsNameTF.getText(),
                            (String) InstructorsCourseTF.getSelectedItem(),
                            (String) InstructorsModuleTF.getSelectedItem());
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

    void studentReportTableData(Admin admin){
        GenerateReportB.addActionListener(e->{
            if(!StudentsReportTF.getText().equals("")){
                admin.fetchStudentReportData(StudentsReportTable,StudentsReportTF.getText());
            }else{
                JOptionPane.showMessageDialog(this,"Please Enter the student name.");
            }
        });
    }

    // setting the counts in dashboard
    void setCountValues(HashMap<String, Integer> data) {
        if (data != null) {
            totalStudentsCount.setText(data.get("student").toString());
            totalInstructorsCount.setText(data.get("teacher").toString());
            totalCoursesCount.setText(data.get("course").toString());
            totalModulesCount.setText(data.get("module").toString());
        }
    }

    void setCountValues(Admin admin) {
        setCountValues(admin.getCounts());
    }

    void setCountValues(Teacher teacher) {
        setCountValues(teacher.getCounts());
    }

    void setCountValues(Student student) {
        setCountValues(student.getCounts());
    }

    // admin features
    void adminFeatures(Admin admin) {

        // visible components
        Component[] visibleComponents = { CourseNav, TeacherNav, StudentNav, ModulesHeaders, ModulesCRUD,
                modulesButton ,studentsReportButton,studentsButton};
        for (Component component : visibleComponents) {
            if (component != null) {
                component.setVisible(true);
            }
        }

        // invisible components
        Component[] invisibleComponents = { enrollmentButton, studentsResultButton };
        for (Component component : invisibleComponents) {
            if (component != null) {
                component.setVisible(false);
            }
        }
        coursesCRUD(admin);
        modulesCRUD(admin);
        studentReportTableData(admin);
        admin.fetchCourseData(courseTable);
        admin.fetchStudentTableData(studentTable);
        admin.fetchTeacherData(teacherTable);
        admin.fetchModuleTableData(moduleTable);
        setCountValues(admin);
        studentsCRUD(admin);
        instructorCRUD(admin);
    }

    // teacher features
    void teacherFeatures(Teacher teacher) {

        // visible components
        Component[] visibleComponents = { modulesButton, studentsResultButton, StudentNav, CourseNav };
        for (Component component : visibleComponents) {
            if (component != null) {
                component.setVisible(true);
            }
        }

        // invisible components
        Component[] invisibleComponents = { CourseCRUD, ModulesCRUD, ModulesHeaders, CourseHeaders, TeacherNav, enrollmentButton ,studentsReportButton};
        for (Component component : invisibleComponents) {
            if (component != null) {
                component.setVisible(false);
            }
        }
        teacher.fetchModuleTableData(moduleTable);
        teacher.fetchStudentResultTableData(studentResultTable);
        teacher.fetchCourseData(courseTable);
        studentsResultButtonCRUD(teacher);
        setTeacherOptionBox(teacher);
        setCountValues(teacher);
    }

    void studentFeatures(Student student) {

        // visible components
        Component[] visibleComponents = { studentsResultButton, enrollmentButton };
        for (Component component : visibleComponents) {
            if (component != null) {
                component.setVisible(true);
            }
        }

        // invisible components
        Component[] invisibleComponents = { modulesButton, studentsButton, studentResultHeaders, studentsResultCRUD,
                InstructorsHeaders, InstructorsCRUD, CourseHeaders, CourseCRUD, ModulesCRUD, ModulesHeaders,studentsReportButton };
        for (Component component : invisibleComponents) {
            if (component != null) {
                component.setVisible(false);
            }
        }
        student.fetchEnrollmentTableData(enrollmentTable);
        student.fetchStudentResultTableData(studentResultTable);
        student.fetchCourseData(courseTable);
        student.fetchTeacherData(teacherTable, student.getCourseName());
        setCountValues(student);
        enrollmentHandler(student);
    }

    // navigation
    void navigation() {
        // the panels and buttons associated with it should be kept in order
        JPanel[] panels = { Course, Home, StudentResult, Teacher, Student, Enrollment, Modules ,StudentsReport};
        JButton[] buttons = { coursesButton, dashboardButton, studentsResultButton, instructorsButton, studentsButton,
                enrollmentButton, modulesButton, studentsReportButton };
        for (int i = 0; i < panels.length; i++) {
            associateButtonAndPanel(panels, buttons[i], panels[i]);
        }
    }

    // associate the button that opens a particular panel
    void associateButtonAndPanel(JPanel[] panelList, JButton b, JPanel p) {
        b.addActionListener(e -> {
            for (JPanel panel : panelList) {
                panel.setVisible(false);
            }
            p.setVisible(true);
        });
    }

    // components to be rendered for every user
    void commonSetUp() {
        welcomeMessage();
        navigation();
        setContentPane(Dashboard);
        setSize(1280, 720);
        effects.activateEffect(buttons);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    // admin
    public Homepage(Admin admin) {
        this.email = admin.getEmail();
        this.username = admin.getUsername();
        commonSetUp();
        adminFeatures(admin);
        logout(admin);
    }

    // student
    public Homepage(Student student) {
        this.email = student.getEmail();
        this.username = student.getUsername();
        studentFeatures(student);
        commonSetUp();
        logout(student);
    }

    // teacher
    public Homepage(Teacher teacher) {
        this.email = teacher.getEmail();
        this.username = teacher.getUsername();
        commonSetUp();
        teacherFeatures(teacher);
        logout(teacher);
    }
}
