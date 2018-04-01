package Modelo;

public class Prova {
int Proximo_Id;
int codigo;
int codigo_questao;
String disciplina;
 

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public int getCodigo_questao() {
        return codigo_questao;
    }

    public void setCodigo_questao(int codigo_questao) {
        this.codigo_questao = codigo_questao;
    }
    
      public int getProximo_Id() {
        return Proximo_Id;
    }

    public void setProximo_Id(int Proximo_Id) {
        this.Proximo_Id = Proximo_Id;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
