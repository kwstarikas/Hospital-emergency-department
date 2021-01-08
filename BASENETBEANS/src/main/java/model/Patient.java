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
public class Patient {

    private Integer AMKA = 0;
    private String First_Name = "";
    private String Last_Name = "";
    private String Address = "";
    private String Insurance = "";
    private String Phone = "";
    private int PID = 0;

    public Integer getAmka() {
        return AMKA;
    }

    public void setAmka(Integer amka) {
        this.AMKA = amka;
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

    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String Insurance) {
        this.Insurance = Insurance;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    /**
     * Returns a string representation of this object
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AMKA: ").append(AMKA).append("\n")
                .append("First_Name: ").append(First_Name).append("\n")
                .append("Last_Name: ").append(Last_Name).append("\n")
                .append("Address: ").append(Address).append("\n")
                .append("Insurance: ").append(Insurance).append("\n")
                .append("Phone: ").append(Phone).append("\n")
                .append("PID").append(PID).append("\n");

        return sb.toString();

    }

}
