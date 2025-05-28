import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaManager tarefaManager = new TarefaManager();

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Alterar status da tarefa");
            System.out.println("4. Buscar tarefas por título");
            System.out.println("5. Deletar tarefa(s) por título");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("ID da tarefa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    // Verifica se o ID já existe
                    if (tarefaManager.idExiste(id)) {
                        System.out.println("Erro: Já existe uma tarefa com esse ID.");
                        break;
                    }

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Status: ");
                    String status = scanner.nextLine();

                    System.out.print("ID da categoria: ");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome da categoria: ");
                    String nomeCategoria = scanner.nextLine();

                    Categoria categoria = new Categoria(idCategoria, nomeCategoria);

                    Tarefa novaTarefa = new Tarefa(id, titulo, descricao, status, categoria);
                    tarefaManager.adicionarTarefa(novaTarefa);
                    System.out.println("Tarefa criada com sucesso!");
                    break;

                case 2:
                    tarefaManager.listarTarefas();
                    break;

                case 3:
                    System.out.print("ID da tarefa para alterar o status: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo status: ");
                    String novoStatus = scanner.nextLine();

                    boolean alterado = tarefaManager.alterarStatusDaTarefa(idAlterar, novoStatus);
                    if (alterado) {
                        System.out.println("Status alterado com sucesso.");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o título para busca: ");
                    String tituloBusca = scanner.nextLine();

                    List<Tarefa> resultados = tarefaManager.buscarTarefasPorTitulo(tituloBusca);

                    if (resultados.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada com esse título.");
                    } else {
                        System.out.println("Tarefas encontradas:");
                        for (Tarefa t : resultados) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o título da(s) tarefa(s) para deletar: ");
                    String tituloDeletar = scanner.nextLine();

                    boolean removido = tarefaManager.removerTarefasPorTitulo(tituloDeletar);
                    if (removido) {
                        System.out.println("Tarefa(s) removida(s) com sucesso.");
                    } else {
                        System.out.println("Nenhuma tarefa encontrada com esse título.");
                    }
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
