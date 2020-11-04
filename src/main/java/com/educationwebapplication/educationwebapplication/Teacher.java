package com.educationwebapplication.educationwebapplication;

public class Teacher {

    /******Private Variables*******/
    private String fName;
    private String lName;
    private String userName;
    private String email;
    private String password;
    private String subject;

    /******Getters*******/
    public String getfName() { return fName; }
    public String getlName() { return lName; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getSubject() { return subject; }

    /******Setters*******/
    public void setfName(String fName) { this.fName = fName; }
    public void setlName(String lName) { this.lName = lName; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String toString() {
        return "Teacher{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
