/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author samoy
 */
public class Pacient {

    private int id;
    private String name;
    private String birthDay;
    private String bloodType;
    private String nationality;
    private String province;
    private String canton;
    private int phone;

    public Pacient(int id, String name, String birthDay, String bloodType, String nationality, String province, String canton, int phone) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.bloodType = bloodType;
        this.nationality = nationality;
        this.province = province;
        this.canton = canton;
        this.phone = phone;
    }

    //Constructor vacío de la clase
    public Pacient() {
    }

    public Pacient(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
