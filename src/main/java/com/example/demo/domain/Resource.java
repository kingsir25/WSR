package com.example.demo.domain;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id = (int)(Math.random()*1000);
    //private String id = UUID.randomUUID().toString().replace("-", "");

    @NotBlank(message ="name not is blank")
    private String name;

    @NotNull(message ="sex not is null")
    private String sex;
    
    @NotNull(message ="level not is null")
    private String level;
    
    @NotNull(message ="come date not is null")
    private Integer comeDate;
    
    public Resource() {}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getComeDate() {
        return comeDate;
    }

    public void setComeDate(Integer comeDate) {
        this.comeDate = comeDate;
    }
}
