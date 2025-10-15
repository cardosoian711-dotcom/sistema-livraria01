import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
        Livro l1 = new Livro(1, "O Poder do Hábito", "Charles Duhigg", true, LocalDate.now(), LocalDateTime.now());
        Livro l2 = new Livro(2, "Clean Code", "Robert Martin", true, LocalDate.now(), LocalDateTime.now());
        Livro l3 = new Livro(3, "Effective Java", "Joshua Bloch", true, LocalDate.now(), LocalDateTime.now());
        Livro l4 = new Livro(4, "Java: Como Programar", "Deitel", true, LocalDate.now(), LocalDateTime.now());
        livros.add(l1);
        livros.add(l2);
        livros.add(l3);
        livros.add(l4);

        Autor a1 = new Autor(1, "Charles Duhigg", LocalDate.of(1980, 8, 26));
        Autor a2 = new Autor(2, "Robert Martin", LocalDate.of(1952, 12, 5));
        Autor a3 = new Autor(3, "Joshua Bloch", LocalDate.of(1961, 8, 28));
        Autor a4 = new Autor(4, "Deitel", LocalDate.of(1960, 6, 15));
        autores.add(a1);
        autores.add(a2);
        autores.add(a3);
        autores.add(a4);
    }//constructor

    public void listarLivrosDisponiveis(){
        for (Livro livro : livros){
          if (livro.isDisponivel()){
    System.out.println(livro.getId()+ " - " +livro.getTitulo()+" (" +livro.getAutor()+ ")");
          }//if
        }//foreach
    }//method

    public void emprestimoLivro(int id, String nomeCliente){
        boolean encontrado = false;
        for (Livro livro : livros){
            if (livro.getId() == id){
               if(livro.isDisponivel()) {
                   Emprestimo e1 = new Emprestimo(emprestimos.size() + 1, livro, nomeCliente, LocalDate.now(), null);
                   emprestimos.add(e1);
                   livro.setDisponivel(false);
                   System.out.println("✅ Empréstimo realizado com sucesso!");
               } else {
                   System.out.println("❌ Livro indisponível.");
               }
                   return;
            }
        }
        if (!encontrado){
            System.out.println("❌ Livro não encontrado.");
        }
    }

}