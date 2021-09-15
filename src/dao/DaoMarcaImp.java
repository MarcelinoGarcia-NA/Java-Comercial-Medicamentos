/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Marca;
import model.Notebook;
import model.Usuario;

/**
 *
 * @author Garcia
 */
public class DaoMarcaImp implements DaoMarca {
     Connection con = null;
     PreparedStatement pstm= null;
      public List<String> getNomeMarcas() {
         ResultSet rs= null;
         List<String> lista = new ArrayList<String>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT descricao FROM db_marca ORDER BY descricao ASC");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               lista.add(rs.getString("descricao"));
               
           }while(rs.next());
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return lista;
    }
      public int getIdByMarca(String marca) {
         ResultSet rs= null;
         int id=0;
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT id FROM db_marca WHERE descricao=?");
       pstm.setString(1,marca);
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
          id=rs.getInt("id");
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return id;
    }
       public String getMarcaById(int id) {
         ResultSet rs= null;
         String marca="";
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT descricao FROM db_marca WHERE id=?");
       pstm.setInt(1,id);
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
          marca=rs.getString("descricao");
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return marca;
       
    }
         public void salvarMarca(Marca marca) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO db_marca (descricao) VALUES ( ?)");
       this.pstm.setString(1,marca.getDescricao());
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir uma marca!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir uma marca!"+errofechar);
           }
       }
      
    } 

  
    @Override
    public void alterarMarca(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirMarca(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Marca> getMarcas() {
         ResultSet rs= null;
         List<Marca> lista = new ArrayList<Marca>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT * FROM db_marca");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               Marca n= new Marca();
               n.setId(rs.getInt("id"));
               n.setDescricao(rs.getString("descricao"));
               lista.add(n);
           }while(rs.next());
       }
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro na lista!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e lista!"+errofechar);
           }
       }return lista;
    }

}
