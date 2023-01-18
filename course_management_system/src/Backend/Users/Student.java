package Backend.Users;

import Backend.AbstractClasses.Users;

public class Student extends Users {
    private String course;
    private String[] optionalModules;
    public Student() {
        super();
    }
    private boolean chooseCourse(String courseName){
        if(!courseName.equals("")){return false;}
        this.course = courseName;
        return true;
    }
    private boolean chooseOptionalModules(){

        return true;
    }
}
