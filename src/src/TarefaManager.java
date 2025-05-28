import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TarefaManager {

    //Lista de tarefas regristradas
   private final List<Tarefa> tarefas = new ArrayList<>();


   //Adicionar tarefa a lista
   public void adicionarTarefa(Tarefa tarefa){
       tarefas.add(tarefa);
   }

   public boolean removerTarefasPorTitulo(String titulo){
       return tarefas.removeIf(t -> t.getTitulo().equalsIgnoreCase(titulo));
   }

   public boolean removerTarefasPorStatus(String status){
       return tarefas.removeIf(t -> t.getStatus().equalsIgnoreCase(status));
   }

   public void listarTarefas(){
       if (tarefas.isEmpty()){
           System.out.println("Nenhuma tarefa cadastrada");
       } else {
           for (Tarefa tarefa : tarefas){
               System.out.println(tarefa);
           }
       }
   }






}
