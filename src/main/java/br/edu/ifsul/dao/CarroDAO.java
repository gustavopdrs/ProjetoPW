/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;

/**
 *
 * @author gugag
 */
public class CarroDAO<TIPO> extends DAOGenerico<Carro> implements Serializable {

    public CarroDAO() {
        super();
        classePersistente = Carro.class;
    }

}
