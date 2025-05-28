public class Tarefa {

    public enum Status {
        ABERTO,
        EM_ANDAMENTO,
        CONCLUIDA,
        CANCELADA
    }

    private final int id;
    private final String titulo;
    private final String descricao;
    private Status status;
    private final Categoria categoria;
    private Colaborador responsavel;

    public Tarefa(int id, String titulo, String descricao, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = Status.ABERTO; // status padrão
        this.responsavel = null;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Colaborador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Colaborador responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        String nomeResp = (responsavel != null) ? responsavel.getNome() : "Nenhum responsável atribuído";
        return "ID: " + id + "\nTítulo: " + titulo + "\nDescrição: " + descricao +
                "\nStatus: " + status + "\nCategoria: " + categoria.getNome() +
                "\nResponsável: " + nomeResp + "\n";
    }
}
