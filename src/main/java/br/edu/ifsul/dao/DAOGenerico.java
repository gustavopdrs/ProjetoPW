/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gugag
 */
public class DAOGenerico<TIPO> implements Serializable{
    
    private List<TIPO> listaObjetos;
    private List<TIPO> listatodos;
    @PersistenceContext(unitName = "pw-trabalhoPU")
    protected EntityManager em;
    protected Class classePersistente;

    public List<TIPO> getListaObjetos() {
        String jpql = "from "+classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public List<TIPO> getListatodos() {
                String jpql = "from "+classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public void persist(TIPO obj) throws Exception{
        em.persist(obj);
    }
    
   public void merge(TIPO obj) throws Exception{
        em.persist(obj);
    }
   
   public TIPO localizar(Object id) throws Exception{
       return (TIPO) em.find(classePersistente, id);
   }
   
   public void remover(TIPO obj) throws Exception{
       obj = em.merge(obj);
       em.remove(obj);
   }

    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public void setListatodos(List<TIPO> listatodos) {
        this.listatodos = listatodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class getClassePersistente() {
        return classePersistente;
    }

    public void setClassePersistente(Class classePersistente) {
        this.classePersistente = classePersistente;
    }
    
    
    
}
