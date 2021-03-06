package br.com.kahoot.entidade;

import java.io.Serializable;

/**
 * Classe de Entidade Assunto que implementa Serializable para comunicacao via
 * Socket
 *
 * @author William Bigas Mauro
 * @since 25/11/2018
 */
public class Assunto implements Serializable {

    private Integer id;
    private String nome;
    private Disciplina disciplina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Assunto{" + "id=" + id + ", nome=" + nome + ", disciplina=" + disciplina + '}';
    }

}
