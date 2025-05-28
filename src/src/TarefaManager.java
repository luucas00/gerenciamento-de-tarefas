import java.util.ArrayList;
import java.util.List;

public class TarefaManager {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public boolean idExiste(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean removerTarefasPorTitulo(String titulo) {
        return tarefas.removeIf(t -> t.getTitulo().equalsIgnoreCase(titulo));
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public boolean alterarStatusDaTarefa(int id, String novoStatus) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                t.setStatus(novoStatus);
                return true;
            }
        }
        return false;
    }

    public List<Tarefa> buscarTarefasPorTitulo(String termo) {
        List<Tarefa> resultados = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(tarefa);
            }
        }
        return resultados;
    }
}
