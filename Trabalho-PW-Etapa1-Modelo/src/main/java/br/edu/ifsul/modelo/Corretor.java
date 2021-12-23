/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author gugag
 */
@Entity
@Table(name = "corretor")
public class Corretor extends Pessoa implements Serializable {

    @NotNull(message = "O valor da fipe deve ser informado")
    @Column(name = "valorFipe", nullable = false, columnDefinition = "numeric (6,3)")
    private Double percentualComissao;
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nomeUsuario", nullable = false, length = 20)
    private String nomeUsuario;
    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;

    public Corretor() {

    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
