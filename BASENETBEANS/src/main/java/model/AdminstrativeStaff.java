/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author loukas
 */
public class AdminstrativeStaff {
    private int PID = 0;
    private String First_Name = "";
    private String Last_Name = "";
    private String Address = "";
    private String Birthdate = "";
    private String Sex = "";
    private String Phone = "";
    private int Years_of_service = 0;

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getYears_of_service() {
        return Years_of_service;
    }

    public void setYears_of_service(int Years_of_service) {
        this.Years_of_service = Years_of_service;
    }
}
