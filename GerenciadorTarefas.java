import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefas {
    private List<Tarefa> listaTarefas;
    private Scanner scanner;

    public GerenciadorTarefas() {
        listaTarefas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarTarefa() {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        listaTarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Lista de tarefas está vazia.");
        } else {
            System.out.println("Lista de Tarefas:");
            int indice = 1;
            for (Tarefa tarefa : listaTarefas) {
                System.out.println("Tarefa #" + indice++);
                System.out.println(tarefa);
            }
        }
    }

    public void removerTarefa() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Não há tarefas para remover.");
            return;
        }

        System.out.print("Digite o número da tarefa que deseja remover: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1;

        if (indice >= 0 && indice < listaTarefas.size()) {
            listaTarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Índice inválido. Tarefa não encontrada.");
        }
    }

    public void fechar() {
        scanner.close();
        System.out.println("Programa encerrado.");
    }

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    gerenciador.adicionarTarefa();
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    gerenciador.removerTarefa();
                    break;
                case 4:
                    gerenciador.fechar();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
