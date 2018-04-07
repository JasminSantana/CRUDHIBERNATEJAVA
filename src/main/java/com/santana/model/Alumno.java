/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author JASMIN-SOMA
 */
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable{
    @Id
    @Column(name = "cveAlu")
    private String cveAlu;
    @Column(name = "nomAlu")
    private String nomAlu;
    @Column(name = "edaAlu")
    private Integer edaAlu;
      @ManyToOne
    @ForeignKey(name = "cveGru_fk")
    private Grupo cveGru;
    //getter and setter

    public String getCveAlu() {
        return cveAlu;
    }

    public void setCveAlu(String cveAlu) {
        this.cveAlu = cveAlu;
    }

    public String getNomAlu() {
        return nomAlu;
    }

    public void setNomAlu(String nomAlu) {
        this.nomAlu = nomAlu;
    }

    public Integer getEdaAlu() {
        return edaAlu;
    }

    public void setEdaAlu(Integer edaAlu) {
        this.edaAlu = edaAlu;
    }

    public Grupo getCveGru() {
        return cveGru;
    }

    public void setCveGru(Grupo cveGru) {
        this.cveGru = cveGru;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cveAlu=" + cveAlu + ", nomAlu=" + nomAlu + ", edaAlu=" + edaAlu + ", cveGru=" + cveGru + '}';
    }
      
      

}
