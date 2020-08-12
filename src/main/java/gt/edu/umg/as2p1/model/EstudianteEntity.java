/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.model;

import java.time.LocalDateTime;

/**
 *
 * @author AK272DT
 */
public class EstudianteEntity {
    private Integer id_student;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime birthdate;
    private String student_id;
    private String phone1;
    private String phone2;
    private String address1;
    private String address2;
    
    public EstudianteEntity() {}
    
    public EstudianteEntity(String name, String surname, String email, LocalDateTime birthdate, String student_id, String phone1, String phone2, String address1, String address2){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.student_id = student_id;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address1 = address1; 
        this.address2 = address2;
    }
    
    public EstudianteEntity(Integer id_student, String name, String surname, String email, LocalDateTime birthdate, String student_id, String phone1, String phone2, String address1, String address2){
        this.id_student = id_student;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.student_id = student_id;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address1 = address1; 
        this.address2 = address2;
    }
    
    public Integer getId(){
        return id_student;
    }
    
    public void setId(Integer id){
        this.id_student = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public LocalDateTime getBirthdate(){
        return birthdate;
    }
    
    public void setBirthdate(LocalDateTime birthdate){
        this.birthdate = birthdate;
    }
    
    public String getStudentID(){
        return student_id;
    }
    
    public void setStudentID(String student_id){
        this.student_id  = student_id;
    }
    
    public String getPhone1(){
        return phone1;
    }
    
    public void setPhone1(String phone1){
        this.phone1 = phone1;
    }
    
    public String getPhone2(){
        return phone2;
    }
    
    public void setPhone2(String phone2){
        this.phone2 = phone2;
    }
    
    public String getAddress1(){
        return address1;
    }
    
    public void setAddress1(String address1){
        this.address1 = address1;
    }
    
    public String getAddress2(){
        return address2;
    }
    
    public void setAddress2(String address2){
        this.address2 = address2;
    }
}
