/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author gugag
 */
@Entity
@Table(name = "seguro")
public class Seguro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_seguro", sequenceName = "seq_seguro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_seguro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de inicio de vigencia deve ser informada")
    @Column(name = "inicioVigencia", nullable = false)
    private Calendar inicioVigencia;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de fim da vigencia deve ser informada")
    @Column(name = "fimVigencia", nullable = false)
    private Calendar fimVigencia;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valorTotal", nullable = false, columnDefinition = "numeric (6,3)")
    private Double valorTotal;
    
    @NotNull(message = "O valor da fipe deve ser informado")
    @Column(name = "valorFipe", nullable = false, columnDefinition = "numeric (6,3)")
    private Double valorFipe;
    
    @NotNull(message = "O carro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "carro_id", referencedColumnName = "id", nullable = false)
    private Carro carro;
    
    @NotNull(message = "O corretor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "corretor_id", referencedColumnName = "id", nullable = false)
    private Corretor corretor;
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sinistro> sinistro = new ArrayList<>();
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Cobertura> cobertura = new ArrayList<>();

    public Seguro() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public List<Sinistro> getSinistro() {
        return sinistro;
    }

    public void setSinistro(List<Sinistro> sinistro) {
        this.sinistro = sinistro;
    }

    public List<Cobertura> getCobertura() {
        return cobertura;
    }

    public void setCobertura(List<Cobertura> cobertura) {
        this.cobertura = cobertura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Seguro other = (Seguro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
