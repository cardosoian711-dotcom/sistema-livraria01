import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Voce gostaria de ver os livros?");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("NAO")){
            System.out.println("Obrigado!");
        }
        else if (resposta.equalsIgnoreCase("SIM")){
          biblioteca.listarLivrosDisponiveis();
          System.out.println();
          System.out.println("Qual a ID do livro que voce gostaria?");
          int respostaId = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Qual o seu nome ?");
          String respostaNome = scanner.nextLine();

          biblioteca.emprestimoLivro(respostaId,respostaNome);
        }


    }
}
