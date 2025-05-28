public class Tarefa {

    private final int id;
    private final String titulo;
    private final String descricao;

    private String status;

    //tarefa que pertence a uma categoria
    private final Categoria categoria;


    //tarefa pode ser atribuida a um responsavel
    private Colaborador responsavel;

public Tarefa(int id, String titulo, String descricao, String status, Categoria categoria){
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.status =  status;
    this.categoria = categoria;
}

public int getId(){
    return id;
}

public String getTitulo(){
    return titulo;
}

public String getDescricao(){
    return descricao;
}

public String getStatus(){
    return status;
}

public void setStatus(String status){
    this.status = status;
}

public Categoria getCategoria(){
    return categoria;
}

public Colaborador getColaborador(){
    return responsavel;
}

public void setResponsavel(Colaborador responsavel){
    this.responsavel = responsavel;
}

// representação em texto

    @Override
public String toString(){
    String nomeResponsavel = (responsavel != null) ? responsavel.getNome() : "Nenhum responsavel atribuido";

    return "Tarefa ID: " + id +
            "\nTítulo: " + titulo +
            "\nDescrição: " + descricao +
            "\nStatus: " + status +
            "\nCategoria: " + categoria +
            "\nResponsavel: " + responsavel + "\n";
    }



}
