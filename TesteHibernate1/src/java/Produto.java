

import javax.persistence.Entity; //Necessária a importação do javax.persistence
import javax.persistence.Id;
import javax.persistence.Column;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ra21550273
 */
@Entity(name = "tbProduto") //Torna a classe "gerenciavel" pelo Hibernat (Classe utilizável no banco de dos). OBS: O nome é opcional!
public class Produto {
    
    @Id //O Hibernate necessita criar um Id no banco.
    private int id;
    
    @Column(name = "nome_prod") //Apenas personalização da Coluna abaixo. (Opcional!)
    private String nome;
    private float preco;
    private String fabricante;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }


    
}
