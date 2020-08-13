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

                //String[] parts = line.split(";");
                //CursoEntity curso = new CursoEntity();
                    //curso.setName(parts[0]);
                //curso.setDescription(parts[1]);

                //CursoDAOImpl enviar = new CursoDAOImpl();
                //enviar.insertarCurs o(curso);
                                
                                String[] parts =line.split(";");
                                 EstudianteEntity curso = new  EstudianteEntity();
                                curso.setName(parts[0]);
                                curso.setSurname(parts[1]);
                                curso.setEmail(parts[2]);
                                curso.setBirthdate(parts[3]);
                                curso.setStudentID(parts[4]);
                                curso.setPhone1(parts[5]);
                                curso.setPhone2(parts[6]);
                                curso.setAddress1(parts[7]);
                                curso.setAddress2(parts[8]);
                                
                                EstudianteDAOImpl enviar = new EstudianteDAOImpl();
                                enviar.insertarEstudiante(curso);
                               
                                if(enviar.insertarEstudiante(curso) == false) {
                                    
                                    System.out.print("cierto");
                                }else {
                                    System.out.print("nooooo");
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
