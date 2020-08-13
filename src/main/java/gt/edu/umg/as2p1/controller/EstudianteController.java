/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.controller;

import gt.edu.umg.as2p1.dao.EstudianteDAOImpl;
import gt.edu.umg.as2p1.model.EstudianteEntity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    ///////////////////////////////
/////////////////////////////////////
    @PostMapping("/CargaEstudiantes") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
            Model model) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            ByteArrayInputStream inputFilestream = new ByteArrayInputStream(bytes);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFilestream));
            String line = "";

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(";");
                EstudianteEntity estudiante = new EstudianteEntity();
                estudiante.setName(parts[0]);
                estudiante.setSurname(parts[1]);
                estudiante.setEmail(parts[2]);
                estudiante.setBirthdate(parts[3]);
                estudiante.setStudentID(parts[4]);
                estudiante.setPhone1(parts[5]);
                estudiante.setPhone2(parts[6]);
                estudiante.setAddress1(parts[7]);
                estudiante.setAddress2(parts[8]);

                EstudianteDAOImpl enviar = new EstudianteDAOImpl();
                // enviar.insertarEstudiante(curso);

                int correctos = 0, incorrectos = 0;

                if (enviar.insertarEstudiante(estudiante) == false) {
                    // System.out.print("cierto");
                    correctos++;
                } else {
                    //System.out.print("nooooo");
                    incorrectos++;
                }

            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//List<CursoEntity> persons = new ArrayList<CursoEntity>();
//model.addAttribute("curso", new CursoEntity());
//return "cursos";
        return "redirect:/";
    }

    ///////////////////////////////////////////
}
