public class biblioteca {
    private livro[] livros;
    private int quantidadeLivros;

    public biblioteca() {
        livros = new livro[10];
        quantidadeLivros = 0;
    }

    public void adicionarLivro(livro l) {
        if (quantidadeLivros < livros.length) {
            livros[quantidadeLivros++] = l;
            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("A biblioteca está cheia!");
        }
    }

    public livro buscarLivroPorTitulo(String titulo) {
        for (int i = 0; i < quantidadeLivros; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return livros[i];
            }
        }
        return null;
    }

    public void listarLivrosDisponiveis() {
        System.out.println("📚 Livros disponíveis:");
        boolean encontrou = false;
        for (int i = 0; i < quantidadeLivros; i++) {
            if (livros[i].isDisponivel()) {
                System.out.println(" - " + livros[i]);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum livro disponível.");
    }

    public void listarTodos() {
        System.out.println("📖 Todos os livros:");
        if (quantidadeLivros == 0) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (int i = 0; i < quantidadeLivros; i++) {
            System.out.println(" - " + livros[i]);
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < quantidadeLivros; i++) {
            total += livros[i].getPreco();
        }
        return total;
    }
}
