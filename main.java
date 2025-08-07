import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        biblioteca b = new biblioteca();

        int opcao;
        do {
            System.out.println("\n📚 MENU DA BIBLIOTECA");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Emprestar livro");
            System.out.println("3 - Devolver livro");
            System.out.println("4 - Aplicar desconto");
            System.out.println("5 - Obter idade do livro");
            System.out.println("6 - Listar livros disponíveis");
            System.out.println("7 - Listar todos os livros");
            System.out.println("8 - Calcular valor total");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Ano de publicação: ");
                    int ano = sc.nextInt();
                    System.out.print("Preço: R$");
                    double preco = sc.nextDouble();
                    livro l = new livro(titulo, autor, ano, preco);
                    b.adicionarLivro(l);
                    break;

                case 2:
                    System.out.print("Título do livro a emprestar: ");
                    titulo = sc.nextLine();
                    l = b.buscarLivroPorTitulo(titulo);
                    if (l != null)
                        l.emprestar();
                    else
                        System.out.println("Livro não encontrado.");
                    break;

                case 3:
                    System.out.print("Título do livro a devolver: ");
                    titulo = sc.nextLine();
                    l = b.buscarLivroPorTitulo(titulo);
                    if (l != null)
                        l.devolver();
                    else
                        System.out.println("Livro não encontrado.");
                    break;

                case 4:
                    System.out.print("Título do livro: ");
                    titulo = sc.nextLine();
                    l = b.buscarLivroPorTitulo(titulo);
                    if (l != null) {
                        System.out.print("Percentual de desconto (%): ");
                        double percentual = sc.nextDouble();
                        l.aplicarDesconto(percentual);
                        System.out.println("Desconto aplicado.");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Título do livro: ");
                    titulo = sc.nextLine();
                    l = b.buscarLivroPorTitulo(titulo);
                    if (l != null) {
                        System.out.print("Ano atual: ");
                        int anoAtual = sc.nextInt();
                        int idade = l.obterIdade(anoAtual);
                        System.out.println("O livro tem " + idade + " anos.");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 6:
                    b.listarLivrosDisponiveis();
                    break;

                case 7:
                    b.listarTodos();
                    break;

                case 8:
                    double total = b.calcularValorTotal();
                    System.out.printf("💰 Valor total dos livros: R$%.2f%n", total);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
