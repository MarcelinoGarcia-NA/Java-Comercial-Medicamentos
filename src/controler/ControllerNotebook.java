/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DaoNotebook;
import dao.DaoNotebookImp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.swing.JOptionPane;
import model.Notebook;

/**
 *
 * @author Garcia
 */
public class ControllerNotebook {
         List<Notebook> lista = new ArrayList<Notebook>();
         DaoNotebook dao= new DaoNotebookImp();
    
    public void salvarNotebook(Notebook n){
        if(n!=null && !n.getModelo().equals("") && n.getMarca()>0 && !n.getSerie().equals("")){
            dao.salvarNotebook(n);
            JOptionPane.showMessageDialog(null,"Notebook salvo com sucesso");
        }else{
             JOptionPane.showMessageDialog(null,"Existem campos vazios");
        }
    }
    
     public void alterarNotebook(Notebook n){
        if(n!=null && !n.getModelo().equals("") && n.getMarca()>0 && !n.getSerie().equals("") && n.getId()>0){
            dao.alterarNotebook(n);
            JOptionPane.showMessageDialog(null,"Notebook alterardo com sucesso");
        }else{
             JOptionPane.showMessageDialog(null,"Existem campos vazios");
        }
    }
    public void excluirNotebook(int id){
        int opcao = JOptionPane.showConfirmDialog(null,"Excluir o notebook de id "+id,"excluir", JOptionPane.YES_NO_OPTION);
    if (opcao ==0){
        JOptionPane.showMessageDialog(null,"Exclusão efetivada");
        dao.excluirNotebook(id);
    }else{
        JOptionPane.showMessageDialog(null,"Exclusão não efetivada");
    }
    }
    
    public List<Notebook> recarregaLista(){
        lista.clear();
        lista=dao.getNotebooks();
        return lista;
    }
}
