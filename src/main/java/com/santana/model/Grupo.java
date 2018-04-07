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
import javax.persistence.Table;

/**
 *
 * @author JASMIN-SOMA
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable{
    @Id
    @Column(name = "cveGru")
    private String cveGru;
    @Column(name = "nomGru")
    private String nomGru;

    public String getCveGru() {
        return cveGru;
    }

    public void setCveGru(String cveGru) {
        this.cveGru = cveGru;
    }

    public String getNomGru() {
        return nomGru;
    }

    public void setNomGru(String nomGru) {
        this.nomGru = nomGru;
    }

    @Override
    public String toString() {
        return "Grupo{" + "cveGru=" + cveGru + ", nomGru=" + nomGru + '}';
    }
    
}
