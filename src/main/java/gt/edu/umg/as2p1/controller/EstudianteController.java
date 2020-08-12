/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.controller;

import gt.edu.umg.as2p1.dao.EstudianteDAOImpl;
import gt.edu.umg.as2p1.model.EstudianteEntity;
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
public class EstudianteController {
    
    @GetMapping("/getEstudiante")
    public String getEstudiante(Model model) {
        model.addAttribute("estudiante", new EstudianteEntity());
        return "estudiantes";
    } 
    
    @PostMapping("/postEstudiante")
    public String postEstudiante(@ModelAttribute EstudianteEntity estudiante, Model model) {     
        
        EstudianteDAOImpl estudianteDAO = new EstudianteDAOImpl();
        boolean status = estudianteDAO.insertarEstudiante(estudiante);
        
        String mensaje = (status) ? "Insertado correctamente!" : "No se pudo insertar el registro...";

        model.addAttribute("mensaje", mensaje);
        
        return "redirect:/getEstudiante";
    }
    
}
