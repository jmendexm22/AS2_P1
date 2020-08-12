/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.dao;

import gt.edu.umg.as2p1.model.EstudianteEntity;
import gt.edu.umg.as2p1.service.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AK272DT
 */
public class EstudianteDAOImpl implements IEstudianteDAO {

    @Override
    public boolean insertarEstudiante(EstudianteEntity estudiante) {
        Connection connection = ConnectionFactory.getConnection();
        
        Date birthdate = new Date(1950, 01, 01);
        try {
            birthdate = Date.valueOf(estudiante.getBirthdate());
        } catch (Exception ex) {
            Logger.getLogger(EstudianteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO t2_student VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, estudiante.getName());
            ps.setString(2, estudiante.getSurname());
            ps.setString(3, estudiante.getEmail());
            ps.setDate(4, birthdate);
            ps.setString(5, estudiante.getStudentID());
            ps.setString(6, estudiante.getPhone1());
            ps.setString(7, estudiante.getPhone2());
            ps.setString(8, estudiante.getAddress1());
            ps.setString(9, estudiante.getAddress2());
            
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
