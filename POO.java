import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class POO {
    // Aprendendo orientação a objeto
    // Testando conceitos de POO(Aula 1)

  public class Pessoa{
    String nome;
    int idade;
    long cpf;

  void cadastro(Scanner leitor, List<Pessoa> listaCliente){
    System.out.println("Digite seu nome");
    nome = leitor.nextLine();
    System.out.println("Digite sua idade");
    idade = leitor.nextInt();
    System.out.println("Digite seu cpf");
    cpf = leitor.nextLong();
    Pessoa pessoa = new Pessoa();

    pessoa.nome = nome;
    pessoa.idade = idade;
    pessoa.cpf =  cpf;

    listaCliente.add(pessoa);
    
  }

  void realizarbusca(Scanner leitor, List<Pessoa> listaCliente){
    long cpfconsulta;
    System.out.println("Digite o cpf da pessoa que deseja encontrar");
    cpfconsulta = leitor.nextLong();

    for(Pessoa cliente: listaCliente){
        if(cpfconsulta == cliente.cpf){
            System.out.println("Cliente encontrado");
            System.out.println(" Nome: " + cliente.nome);
            System.out.println("cpf: " + cliente.cpf);
            System.out.println("idade: " + cliente.idade);
        }
    }

  }


 public void setnome(String novonome){
    this.nome = novonome;
  }

  public String getnome(){
   return nome;
  }
  
   void alterarnome(Scanner leitor){
    System.out.println("Digite seu novo nome");
    setnome(leitor.next());
   }

  }
    


  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    List<Pessoa> listaCliente = new ArrayList<>();
    POO p = new POO();
    Pessoa cad = p.new Pessoa();
    
    cad.cadastro(leitor, listaCliente);
    cad.realizarbusca(leitor, listaCliente);

  }
}
    
