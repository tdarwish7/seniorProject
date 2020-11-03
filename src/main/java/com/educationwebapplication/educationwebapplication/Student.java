package com.educationwebapplication.educationwebapplication;

public class Student {

    /******Private Variables*******/
    private String fName;
    private String lName;
    private String userName;
    private String email;
    private String password;
    private String gradeLevel;

    /******Getters*******/
    public String getfName() { return fName; }
    public String getlName() { return lName; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getGradeLevel() { return gradeLevel; }

    /******Setters*******/
    public void setfName(String fName) { this.fName = fName; }
    public void setlName(String lName) { this.lName = lName; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setGradeLevel(String gradeLevel) { this.gradeLevel = gradeLevel; }

    @Override
    public String toString() {
        return "Student{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }
}
