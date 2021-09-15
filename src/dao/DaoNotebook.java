/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Notebook;
/**
 *
 * @author soare
 */
public interface DaoNotebook {
    public void salvarNotebook(Notebook notebook);
    public void alterarNotebook(Notebook notebook);
    public void excluirNotebook(int id);
    public List<Notebook> getNotebooks();
    
}
