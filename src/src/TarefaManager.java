import java.util.ArrayList;
import java.util.List;

public class TarefaManager {

    private final List<Tarefa> tarefas = new ArrayList<>();
    private final List<Colaborador> colaboradores = new ArrayList<>();

    // Adicionar tarefa, checando duplicidade de id
    public boolean adicionarTarefa(Tarefa tarefa) {
        if (buscarTarefaPorId(tarefa.getId()) != null) {
            return false; // já existe id
        }
        tarefas.add(tarefa);
        return true;
    }

    // Buscar tarefa pelo id
    public Tarefa buscarTarefaPorId(int id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    // Listar todas as tarefas
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    // Remover tarefa pelo id
    public boolean removerTarefaPorId(int id) {
        Tarefa t = buscarTarefaPorId(id);
        if (t != null) {
            tarefas.remove(t);
            return true;
        }
        return false;
    }

    // Alterar status da tarefa pelo id
    public boolean alterarStatusDaTarefa(int id, Tarefa.Status novoStatus) {
        Tarefa t = buscarTarefaPorId(id);
        if (t != null) {
            t.setStatus(novoStatus);
            return true;
        }
        return false;
    }

    // Atribuir responsável a uma tarefa
    public boolean atribuirResponsavel(int idTarefa, int idColaborador) {
        Tarefa t = buscarTarefaPorId(idTarefa);
        Colaborador c = buscarColaboradorPorId(idColaborador);
        if (t != null && c != null) {
            t.setResponsavel(c);
            return true;
        }
        return false;
    }

    // Cadastrar colaborador (responsável)
    public boolean adicionarColaborador(Colaborador colaborador) {
        if (buscarColaboradorPorId(colaborador.getId()) != null) {
            return false; // id duplicado
        }
        colaboradores.add(colaborador);
        return true;
    }

    // Buscar colaborador por id
    public Colaborador buscarColaboradorPorId(int id) {
        for (Colaborador c : colaboradores) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    // Listar colaboradores
    public List<Colaborador> listarColaboradores() {
        return new ArrayList<>(colaboradores);
    }
}
