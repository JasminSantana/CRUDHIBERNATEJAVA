/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.dao;

import com.santana.model.Alumno;
import java.util.List;

/**
 *
 * @author JASMIN-SOMA
 */
public interface AlumnoDao {

    void update(Alumno alumno);

    void save(Alumno alumno);

    void delete(String cveAlu);

    Alumno buscaId(String cveAlu);

    List<Alumno> showAlumno();
}
