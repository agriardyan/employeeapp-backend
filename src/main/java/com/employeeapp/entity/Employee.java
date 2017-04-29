package com.employeeapp.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by trainee on 21/04/2017.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "empId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "dateOfBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "maritalStatus", nullable = false)
    private String maritalStatus;

    @Column(name = "phone", nullable = false)
    private String phone;

//    @Column(name = "city", nullable = false)
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @Column(name = "subDivision", nullable = false)
    private String subDivision;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "suspendDate")
    @Temporal(TemporalType.DATE)
    private Date suspendDate;

    @Column(name = "hiredDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hiredDate;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "division", nullable = false)
    private String division;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "profilePicture")
    @Type(type = "text")
    private String profilePicture;

    public Employee() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(String subDivision) {
        this.subDivision = subDivision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSuspendDate() {
        return suspendDate;
    }

    public void setSuspendDate(Date suspendDate) {
        this.suspendDate = suspendDate;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
