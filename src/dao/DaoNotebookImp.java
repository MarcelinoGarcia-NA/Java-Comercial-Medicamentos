/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;




import conexao.Conexao;
import java.util.ArrayList;
import java.util.List;
import model.Notebook;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author soare
 */
public class DaoNotebookImp implements DaoNotebook{
   

    Connection con = null;
    PreparedStatement pstm= null;
    
    @Override
    public void salvarNotebook(Notebook notebook) {
       con= new Conexao().getConnection();
       try{
           
       pstm = con.prepareStatement("INSERT INTO db_notebook (modelo, marca, serie) VALUES ( ?, ?, ?)");
       this.pstm.setString(1,notebook.getModelo());
       this.pstm.setInt(2,notebook.getMarca());
       this.pstm.setString(3,notebook.getSerie());
              
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao inserir na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e inserir na tabela!"+errofechar);
           }
       }
      
    }

    @Override
    public void alterarNotebook(Notebook notebook) {
       con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("UPDATE db_notebook SET modelo=?, marca=?, serie=? where id=?");
       this.pstm.setString(1,notebook.getModelo());
       this.pstm.setInt(2,notebook.getMarca());
       this.pstm.setString(3,notebook.getSerie());
       this.pstm.setInt(4,notebook.getId());       
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao alterar na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e alterar na tabela!"+errofechar);
           }
       }
      
    }

    

    @Override
    public void excluirNotebook(int id) {
       con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("DELETE FROM db_notebook WHERE id=?");
        this.pstm.setInt(1,id); 
        
       this.pstm.execute();
       this.pstm.close();
       }catch(SQLException inserterro){
           JOptionPane.showMessageDialog(null,"erro ao excluir na tabela!"+inserterro);
       }finally{
           try{
                con.close();
           }catch(SQLException errofechar){
                JOptionPane.showMessageDialog(null,"erro ao fechar conexão e excluir na tabela!"+errofechar);
           }
       }
    }

    @Override
    public List<Notebook> getNotebooks() {
         ResultSet rs= null;
         List<Notebook> lista = new ArrayList<Notebook>();
         con= new Conexao().getConnection();
       
       try{
           
       pstm = con.prepareStatement("SELECT * FROM db_notebook");
       
       
       rs=this.pstm.executeQuery();
       if(rs.first()){
           do{
               Notebook n= new Notebook();
               n.setId(rs.getInt("id"));
               n.setModelo(rs.getString("modelo"));
               n.setMarca(rs.getInt("marca"));
               n.setSerie(rs.getString("serie"));
               
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
