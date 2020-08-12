/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2p1.dao;

import gt.edu.umg.as2p1.model.CursoEntity;
import gt.edu.umg.as2p1.service.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author AK272DT
 */
public class CursoDAOImpl implements CursoDAO {
    @Override
    public boolean insertarCurso(CursoEntity curso){
        Connection connection = ConnectionFactory.getConnection();
        
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO t2_course VALUES (NULL, ?, ?)");
            ps.setString(1, curso.getName());
            ps.setString(2, curso.getDescription());
            int i = ps.executeUpdate();
            
            if (i == 1){
                return true;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return false;
    }
}
