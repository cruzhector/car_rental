/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author kolip
 */
public class usersgetset {
 public String name;
 public String phnum;
 public String dob;
 public String gender;
 public String license;
 public String aadhar;

    public usersgetset(String name, String phnum, String dob, String gender, String license, String aadhar) {
        this.name = name;
        this.phnum = phnum;
        this.dob = dob;
        this.gender = gender;
        this.license = license;
        this.aadhar = aadhar;
    }
public usersgetset(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
 
 
 
    
}
