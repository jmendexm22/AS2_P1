/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.model;

/**
 *
 * @author AK272DT
 */
public class CursoEntity {
    private Integer id_course;
    private String name;
    private String description;
    
    public CursoEntity() {}
    
    public CursoEntity(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public CursoEntity(Integer id_course, String name, String description){
        this.id_course = id_course;
        this.name = name;
        this.description = description;
    }
    
    public Integer getId(){
        return id_course;
    }
    
    public void setId(Integer id){
        this.id_course = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
}
