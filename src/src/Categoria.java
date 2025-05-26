public class Categoria {

    private final int id; // Identificador
    private String nome; // Nome da Categoria

    // Construtor
    public Categoria(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    //Getters
    public int GetId(){
        return id;
    }

    public String GetNome(){
        return nome;
    }

    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString(){
        return id + ": " + nome;
    }

}
