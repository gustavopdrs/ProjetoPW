/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "carro")
public class Carro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A placa não pode ser branca")
    @Length(max = 7, message = "A placa não pode ter mais que {max} caracteres")
    @Column(name = "placa", nullable = false, length = 7)
    private String placa;
    
    @NotBlank(message = "O renavam não pode ser em branco")
    @Length(max = 11, message = "O renavam não pode ter mais que {max} caracteres")
    @Column(name = "renavam", nullable = false, length = 11)
    private String renavam;
    
    @NotBlank(message = "O modelo não pode ser em branco")
    @Length(max = 20, message = "O modelo não pode ter mais que {max} caracteres")
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    
    @NotBlank(message = "O fabricante não pode ser em branco")
    @Length(max = 20, message = "O fabricante não pode ter mais que {max} caracteres")
    @Column(name = "fabricante", nullable = false, length = 20)
    private String fabricante;
    
    @NotNull(message = "O ano de fabricacao deve ser informada")
    @Column(name = "anoFabricacao", nullable = false)
    private Integer anoFabricacao;
    
    @NotNull(message = "O ano do modelo deve ser informada")
    @Column(name = "anoModelo", nullable = false)
    private Integer anoModelo;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "acessorios", joinColumns = @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "acessorio", referencedColumnName = "id", nullable = false))
    private Set<Acessorios> acessorios = new HashSet<>();
    
        @NotNull(message="A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
        
    public Carro() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Set<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
