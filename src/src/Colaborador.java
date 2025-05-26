 public class Colaborador{

    private final int id;
    private final String nome;
    private String cargo;


    public Colaborador(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return id + ": " + nome + " (" + cargo + ")";
    }
}
