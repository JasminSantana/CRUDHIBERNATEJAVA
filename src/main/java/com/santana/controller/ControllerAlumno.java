/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santana.controller;

import com.santana.model.Alumno;
import com.santana.model.Grupo;
import com.santana.service.AlumnoService;
import com.santana.service.GrupoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JASMIN-SOMA
 */
@Controller
@RequestMapping("/")
public class ControllerAlumno {

    @Autowired
    AlumnoService alumnoService;
    @Autowired
    GrupoService grupoService;

    @RequestMapping(value = {"/", "bienvenido"}, method = RequestMethod.GET)
    public String initSistema(ModelMap model) {

        return "bienvenido";
    }

    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public String alumno(ModelMap model) {
List<Grupo> lGrupo = grupoService.showGrupo();
            model.addAttribute("lGrupo", lGrupo);
            List<Alumno> lAlumno = alumnoService.showAlumno();
            model.addAttribute("lAlumno", lAlumno);
        return "alumno";
    }

    @RequestMapping(value = "/alumno/agregarAlumno", method = RequestMethod.POST)
    public @ResponseBody
    String agregarAlumno(@RequestParam(value = "datos[]") String datos[]) {
        Alumno alumno = new Alumno();
        alumno.setCveAlu(datos[0]);
        alumno.setNomAlu(datos[1]);
        alumno.setEdaAlu(Integer.parseInt(datos[2]));
        Grupo lGrupo =grupoService.buscaId(datos[3]);
alumno.setCveGru(lGrupo);
//guarda en arreglo datos
        if (alumnoService.save(alumno)) {

            return "exito";

        } else {
            return "error";
        }
    }

    //Metodo para actualizar Delito
    @RequestMapping(value = "/alumno/actualizarAlumno", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarDelito(@RequestParam(value = "datos[]") String datos[]) {
        List<Alumno> lAlumno = alumnoService.showAlumno();
        if (!lAlumno.isEmpty()) {
            for (Alumno alumno : lAlumno) {
                //obtiene el nombre del delito
                if (alumno.getCveAlu().equals(datos[0])) {
                    alumno.setNomAlu(datos[1]);
                    alumno.setEdaAlu(Integer.parseInt(datos[2]));
Grupo lGrupo =grupoService.buscaId(datos[3]);
alumno.setCveGru(lGrupo);
                    if (alumnoService.update(alumno)) {

                        return "exito";
                    } else {
                        return "error";
                    }
                }
            }
        }
        return "alumno";
    }

    //Metodo para eliminar un  Delito
    @RequestMapping(value = "/alumno/eliminarAlumno", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarAlumno(@RequestParam(value = "datos[]") String datos[]) {
            List<Alumno> lAlumno = alumnoService.showAlumno();
            if (!lAlumno.isEmpty()) {
                for (Alumno alumno : lAlumno) {
                    //obtiene el id del delitoa a eliminar
                    String cveAlu = datos[0];
                    if (alumno.getCveAlu().equals(cveAlu)) {
                        alumno.setCveAlu(datos[0]);
                        if (alumnoService.delete(cveAlu)) {
                            return "exito";
                        } else {
                            return "error";
                        }
                    }
                }//end for
            }//si no esta vacia la lista de delitos
return "alumno";
    }

    @RequestMapping(value = "/grupo", method = RequestMethod.GET)
    public String grupo(ModelMap model) {
 List<Grupo> lGrupo = grupoService.showGrupo();
            model.addAttribute("lGrupo", lGrupo);
        return "grupo";
    }
       @RequestMapping(value = "/grupo/agregarGrupo", method = RequestMethod.POST)
    public @ResponseBody
    String agregarGrupo(@RequestParam(value = "datos[]") String datos[]) {
           Grupo grupo = new Grupo();
        grupo.setCveGru(datos[0]);
        grupo.setNomGru(datos[1]);
        if (grupoService.save(grupo)) {
            return "exito";

        } else {
            return "error";
        }
    }

    //Metodo para actualizar Delito
    @RequestMapping(value = "/grupo/actualizarGrupo", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarGrupo(@RequestParam(value = "datos[]") String datos[]) {
        List<Grupo> lGrupo = grupoService.showGrupo();
        if (!lGrupo.isEmpty()) {
            for (Grupo grupo : lGrupo) {
                //obtiene el nombre del delito
                if (grupo.getCveGru().equals(datos[0])) {
                    grupo.setNomGru(datos[1]);
                    if (grupoService.update(grupo)) {

                        return "exito";
                    } else {
                        return "error";
                    }
                }
            }
        }
        return "grupo";
    }

    //Metodo para eliminar un  Delito
    @RequestMapping(value = "/grupo/eliminarGrupo", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarGrupo(@RequestParam(value = "datos[]") String datos[]) {
            List<Grupo> lGrupo = grupoService.showGrupo();
            if (!lGrupo.isEmpty()) {
                for (Grupo grupo : lGrupo) {
                    //obtiene el id del delitoa a eliminar
                    String cveGru = datos[0];
                    if (grupo.getCveGru().equals(cveGru)) {
                        grupo.setCveGru(datos[0]);
                        if (grupoService.delete(cveGru)) {
                            return "exito";
                        } else {
                            return "error";
                        }
                    }
                }//end for
            }//si no esta vacia la lista de delitos
return "grupo";
    }
}
