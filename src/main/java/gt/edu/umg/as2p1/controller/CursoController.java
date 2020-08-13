/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.controller;

import gt.edu.umg.as2p1.dao.CursoDAOImpl;
import gt.edu.umg.as2p1.model.CursoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import gt.edu.umg.as2p1.dao.ICursoDAO;

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

        return "redirect:/getCurso";
    }

    /////////////////////////////////////
    @PostMapping("/CargaCursos") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {

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

                CursoEntity curso = new CursoEntity();

                curso.setName(parts[0]);
                curso.setDescription(parts[1]); 

                CursoDAOImpl enviar = new CursoDAOImpl();
                enviar.insertarCurso(curso);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //List<CursoEntity> persons = new ArrayList<CursoEntity>();
        //model.addAttribute("curso", new CursoEntity());
        //return "cursos";
        return "index";
    }

    //////////////////////////////////////
    ///////////////////////////////////////////

}
