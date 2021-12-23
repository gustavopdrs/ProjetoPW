/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AcessorioDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gugag
 */
@Named(value = "controleAcessorios")
@ViewScoped
public class ControleAcessorios implements Serializable {

    @EJB
    private AcessorioDAO<Acessorios> dao;
    private Acessorios objeto;

    public ControleAcessorios() {

    }

    public String listar() {
        return "/privado/acessorios/listar?faces-redirect=true";
    }

    public AcessorioDAO<Acessorios> getDao() {
        return dao;
    }

    public void novo() {
        objeto = new Acessorios();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.localizar(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.localizar(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }

    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void setDao(AcessorioDAO<Acessorios> dao) {
        this.dao = dao;
    }

    public Acessorios getObjeto() {
        return objeto;
    }

    public void setObjeto(Acessorios objeto) {
        this.objeto = objeto;
    }

}
