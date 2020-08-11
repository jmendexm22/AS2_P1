/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.controller;

import gt.edu.umg.as2p1.dao.CursoDAO;
import gt.edu.umg.as2p1.dao.CursoDAOImpl;
import gt.edu.umg.as2p1.model.CursoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author AK272DT
 */
@Controller
public class CursoController {

    @GetMapping("/getCurso")
    public String getCurso(Model model) {
        model.addAttribute("curso", new CursoEntity());
        return "cursos";
    }

    @PostMapping("/postCurso")
    public String postCurso(@ModelAttribute CursoEntity curso, Model model) {

        CursoDAOImpl cursoDAO = new CursoDAOImpl();
        boolean status = cursoDAO.insertarCurso(curso);

        String mensaje = (status) ? "Insertado correctamente!" : "No se pudo insertar el registro...";

        model.addAttribute("mensaje", mensaje);

        return "index";
    }

}
