/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.service;

import com.santana.dao.GrupoDao;
import com.santana.model.Grupo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JASMIN-SOMA
 */
@Service("grupoService")
@Transactional
public class GrupoServiceImpl implements GrupoService{
@Autowired
GrupoDao grupoDao;
    private boolean estadoMetodo = false;
    @Override
    public boolean update(Grupo grupo) {
    grupoDao.update(grupo); 
    return estadoMetodo=true;
    }

    @Override
    public boolean save(Grupo grupo) {
    grupoDao.save(grupo); 
    return estadoMetodo=true;
    }

    @Override
    public boolean delete(String cveGru) {
    grupoDao.delete(cveGru); 
    return estadoMetodo=true;
    }

    @Override
    public Grupo buscaId(String cveGru) {
    return grupoDao.buscaId(cveGru);
    }

    @Override
    public List<Grupo> showGrupo() {
   return grupoDao.showGrupo();
    }
    
}
