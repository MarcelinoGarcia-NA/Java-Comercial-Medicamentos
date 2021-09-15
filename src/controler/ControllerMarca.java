/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DaoMarcaImp;
import java.util.ArrayList;
import java.util.List;
import model.Marca;

/**
 *
 * @author Garcia
 */
public class ControllerMarca {
    DaoMarcaImp dao = new DaoMarcaImp();
     List<Marca> lista = new ArrayList<Marca>();
    public List<String> carregaCombo(){
        return dao.getNomeMarcas();
    }
    public int getIdByMarca(String marca){
        return dao.getIdByMarca(marca);
    }
    public String getMarcaById(int id){
        return dao.getMarcaById(id);
    }
     public void cadadastrarMarca(Marca marca){
        dao.salvarMarca(marca);
    }
      public List<Marca> recarregaLista(){
        lista.clear();
        lista=dao.getMarcas();
        return lista;
    } 
}
