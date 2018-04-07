/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.dao;

import com.santana.model.Grupo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JASMIN-SOMA
 */
@Repository
public class GrupoDaoImpl extends HibernateDao<String, Grupo> implements GrupoDao {

    @Override
    public void update(Grupo grupo) {
        actualizar(grupo);
    }

    @Override
    public void save(Grupo grupo) {
        guardar(grupo);
    }

    @Override
    public void delete(String cveGru) {
        Criteria crit = creaCriteria();
        crit.add(Restrictions.eq("cveGru", cveGru));
        Grupo grupo = (Grupo) crit.uniqueResult();
        eliminar(grupo);
    }

    @Override
    public Grupo buscaId(String cveGru) {
     Grupo grupo = getPorId(cveGru);
        return grupo;
    }

    @Override
    public List<Grupo> showGrupo() {
    Criteria criteria = creaCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Grupo> lGrupo = criteria.list();
        return lGrupo;
    }

    
    
}
