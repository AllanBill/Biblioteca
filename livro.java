public class livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private double preco;
    private boolean disponivel;

    public livro(String titulo, String autor, int anoPublicacao, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro já está emprestado.");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Livro já está disponível.");
        }
    }

    public int obterIdade(int anoAtual) {
        return anoAtual - anoPublicacao;
    }

    public void aplicarDesconto(double percentual) {
        preco -= preco * (percentual / 100);
    }

    public String toString() {
        return "\"" + titulo + "\" por " + autor + " (" + anoPublicacao + ") - R$" + String.format("%.2f", preco) + " - " + (disponivel ? "Disponível" : "Emprestado");
    }
}
