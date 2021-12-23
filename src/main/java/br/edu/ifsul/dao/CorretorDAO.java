/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import java.io.Serializable;

/**
 *
 * @author gugag
 */
public class CorretorDAO<TIPO> extends DAOGenerico<Corretor> implements Serializable  {
    
        public CorretorDAO() {
        super();
        classePersistente = Corretor.class;
    }
    
}
