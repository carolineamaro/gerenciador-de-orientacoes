package br.com.orientacoes.modelo;

/**
 *
 * @author Caroline
 */
public class Orientacao {

    private int id;
    private String tema;
    private Professor professor;
    private String aluno;

    public Orientacao(String tema, Professor professor, String aluno) {
        this.tema = tema;
        this.professor = professor;
        this.aluno = aluno;
    }

    public Orientacao(int id, String tema, Professor professor, String aluno) {
        this.id = id;
        this.tema = tema;
        this.professor = professor;
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}
