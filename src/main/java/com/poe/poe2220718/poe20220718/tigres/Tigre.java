package com.poe.poe2220718.poe20220718.tigres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tigres")
public class Tigre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private Integer age;
    
    @Column(name="pays_origine") //snake_case
    private String paysOrigine; //camelCase
    
    //@Column(columnDefinition = "TINYINT(1)")
    private Boolean adulte;

    public Tigre() {
    }

    public Tigre(String nom, Integer age, String paysOrigine, boolean adulte) {
        this.nom = nom;
        this.age = age;
        this.paysOrigine = paysOrigine;
        this.adulte = adulte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public boolean isAdulte() {
        return adulte;
    }

    public void setAdulte(boolean adulte) {
        this.adulte = adulte;
    }

    @Override
    public String toString() {
        return "Tigre{" + "id=" + id + ", nom=" + nom + ", age=" + age + ", paysOrigine=" + paysOrigine + ", adulte=" + adulte + '}';
    }
    
    
    
}
