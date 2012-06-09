package br.cesjf.lp3;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.*;

@Entity
public class Filial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade;
    private String bairro;
    @OneToMany(mappedBy = "filial", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Collection<Produto> produto;

    public Filial() {
        this(null, null);
    }

    public Filial(String cidade, String bairro) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.produto = new HashSet<Produto>();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Collection<Produto> produto) {
        this.produto = produto;
    }
}
