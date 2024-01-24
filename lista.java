import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Trabalhando com listas
//Cadastrando pessoas
public class lista {

    public class CadastraPessoa{

        public String nome;
        public long cpf;
        public int idade;

}
public static void main(String[] args) {
    
    List<CadastraPessoa> cadastro = new ArrayList<>();
    Scanner leitor = new Scanner(System.in);
    boolean stop = true;
    String sim;
    while(stop){
    
    System.out.println("Deseja adicionar uma pessoa?");
    sim = leitor.next();
    if ("SIM".equalsIgnoreCase(sim) ){
        CadastraPessoa pessoa = new lista().new CadastraPessoa();
      System.out.println("Insira seu nome");
      pessoa.nome = leitor.next();
      System.out.println("Insira seu cpf");
      pessoa.cpf =leitor.nextLong();
      System.out.println("Digite sua idade");
      pessoa.idade= leitor.nextInt();
      cadastro.add(pessoa);
    } else{
        stop = false;
    }

    }

  System.out.println("Exibindo pessoas cadastradas");
    for(CadastraPessoa pessoa: cadastro){
    System.out.println("Nome " + pessoa.nome);
    System.out.println("CPF " + pessoa.cpf);
    System.out.println("idade " + pessoa.idade);
    System.out.println("\n");
    System.out.println();


  }

  leitor.close();

}

}
