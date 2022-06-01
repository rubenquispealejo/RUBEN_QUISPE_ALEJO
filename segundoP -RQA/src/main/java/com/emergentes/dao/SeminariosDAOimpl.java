
package com.emergentes.dao;

import com.emergentes.modelo.Seminarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminariosDAOimpl extends ConexionDB implements SeminariosDAO{

    @Override
    public void insert(Seminarios seminarios) throws Exception {
        String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminarios.getTitulo());
        ps.setString(2, seminarios.getFecha());
        ps.setInt(3, seminarios.getCupo());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Seminarios seminarios) throws Exception {
        String sql = "update seminarios set titulo=?,fecha=?,cupo=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminarios.getTitulo());
        ps.setString(2, seminarios.getFecha());
        ps.setInt(3, seminarios.getCupo());
        ps.setInt(4, seminarios.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
         String sql = "delete from seminarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Seminarios getById(int id) throws Exception {
        Seminarios se = new Seminarios();
        String sql = "select * from seminarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            se.setId(rs.getInt("id"));
            se.setTitulo(rs.getString("titulo"));
            se.setFecha(rs.getString("fecha"));
            se.setCupo(rs.getInt("cupo"));
        }
        this.desconectar();
        return se;
    }

    @Override
    public List<Seminarios> getAll() throws Exception {
         List<Seminarios> lista = null;
        String sql = "select * from seminarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Seminarios>();
        while (rs.next()) {            
            Seminarios se = new Seminarios();
            se.setId(rs.getInt("id"));
            se.setTitulo(rs.getString("titulo"));
            se.setFecha(rs.getString("fecha"));
            se.setCupo(rs.getInt("cupo"));
            lista.add(se);
        }
        this.desconectar();
        return lista;
    }
    
}
