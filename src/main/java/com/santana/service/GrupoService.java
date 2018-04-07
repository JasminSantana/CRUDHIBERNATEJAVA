/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.service;

import com.santana.model.Grupo;
import java.util.List;

/**
 *
 * @author JASMIN-SOMA
 */
public interface GrupoService {
    boolean update(Grupo grupo);

    boolean save(Grupo grupo);

    boolean delete(String cveGru);

    Grupo buscaId(String cveGru);

    List<Grupo> showGrupo();   
}
