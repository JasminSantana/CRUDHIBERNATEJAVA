/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.dao;

import com.santana.model.Alumno;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JASMIN-SOMA
 */
@Repository
public class AlumnoDaoImpl extends HibernateDao<String, Alumno> implements AlumnoDao{

    @Override
    public void update(Alumno alumno) {
        actualizar(alumno);
        System.out.print(AlumnoDaoImpl.class + "Se ha actualizado correctamente el alumno" + alumno.toString());
    }

    @Override
    public void save(Alumno alumno) {
     guardar(alumno);
        System.out.print(AlumnoDaoImpl.class + "Se ha guardado correctamente el alumno" + alumno.toString());}

    @Override
    public void delete(String cveAlu) {
    Criteria crit = creaCriteria();
        crit.add(Restrictions.eq("cveAlu", cveAlu));
        Alumno alumno = (Alumno) crit.uniqueResult();
        eliminar(alumno);
    }

    @Override
    public Alumno buscaId(String cveAlu) {
     System.out.println(AlumnoDaoImpl.class + "\nBuscando Alumno por cveAlu: " + cveAlu);
        Alumno alumno = getPorId(cveAlu);
        return alumno;
    }

    @Override
    public List<Alumno> showAlumno() {
        Criteria criteria = creaCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Alumno> lAlumo = criteria.list();
        return lAlumo;
    }
    
}
