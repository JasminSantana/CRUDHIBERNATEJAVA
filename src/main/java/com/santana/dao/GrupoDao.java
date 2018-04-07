/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.dao;

import com.santana.model.Grupo;
import java.util.List;

/**
 *
 * @author JASMIN-SOMA
 */
public interface GrupoDao {
     void update(Grupo grupo);

    void save(Grupo grupo);

    void delete(String cveGru);

    Grupo buscaId(String cveGru);

    List<Grupo> showGrupo();
}
