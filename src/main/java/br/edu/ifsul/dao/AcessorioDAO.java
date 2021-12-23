/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author gugag
 */
@Stateful
public class AcessorioDAO<TIPO> extends DAOGenerico<Acessorios> implements Serializable {
        public AcessorioDAO(){
        super();
        classePersistente = Acessorios.class;
    }
    
}
