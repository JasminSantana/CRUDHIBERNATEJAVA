/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.service;

import com.santana.dao.AlumnoDao;
import com.santana.model.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JASMIN-SOMA
 */
@Service("alumnoService")
@Transactional
public class AlumnoServiceImpl implements AlumnoService{
@Autowired
AlumnoDao alumnoDao;
    private boolean estadoMetodo = false;
    @Override
    public boolean update(Alumno alumno) {
    alumnoDao.update(alumno);
    return estadoMetodo=true;
    }

    @Override
    public boolean save(Alumno alumno) {
    alumnoDao.save(alumno);return estadoMetodo=true;
    }

    @Override
    public boolean delete(String cveAlu) {
    alumnoDao.delete(cveAlu); return estadoMetodo=true;
    }

    @Override
    public Alumno buscaId(String cveAlu) {
    return alumnoDao.buscaId(cveAlu);
    }

    @Override
    public List<Alumno> showAlumno() {
    return alumnoDao.showAlumno();
    }
    
}
