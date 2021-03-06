package br.cesjf.lppo;

public class Contato {
    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;

    public Contato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setId(Long aLong) {
        this.id = aLong;
    }
    
    public Long getId(){
        return this.id;
    }
}
