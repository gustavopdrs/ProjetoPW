/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author gugag
 */
@Entity
@Table(name = "cobertura")
public class Cobertura implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_cobertura", sequenceName = "seq_cobertura_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cobertura", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "A descricao não pode ser nula")
    @Length(max = 80, message = "A descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valorTotal", nullable = false, columnDefinition = "numeric (6,3)")
    private Double valor;

    @NotNull(message="O id do seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "Seguro_id", referencedColumnName = "id", nullable = false)
    private Seguro seguro;
        
    public Cobertura() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cobertura other = (Cobertura) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
