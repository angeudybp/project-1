package Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String gender;
    private String username;
    private String password;
    private boolean isLogged;
    private double reimbursement;
    private String reimbursementStatus;
    public Employee() {
    }

    public Employee(int id, String name, String email, String gender, String username, String password, boolean isLogged) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.isLogged = isLogged;
    }

    public Employee(String name, String email, String gender, String username, String password, boolean isLogged) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.isLogged = isLogged;
    }

    public double reimbursementRequest(double amount){
        reimbursementStatus = "pending";
        return amount;
    }

    public double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(double reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
