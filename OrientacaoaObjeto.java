import java.util.Scanner;

public class OrientacaoaObjeto {

// a criação de classes pode ser feita tanto em outro arquivo quanto dentro do mesmo arquivo, a depender do tamanho do projeto é recomendável fazer fora
// A criação de classes, permite que voce manipule objetos
// A classe public significa que ela pode ser acessada a qualquer momento
// E o static significa que ela é estatica
public static class CadastroPessoa{
    public String nome;
    public int idade;
    public long cpf;
    public String cargo;
}
    public static void main(String[] args) {
        // Vamos utilizar a orientação a objetos a partir de um cadastro de pessoa
    
        CadastroPessoa cadastro = new CadastroPessoa();
        Scanner leitor = new Scanner(System.in);

        System.out.println("Olá, vamos fazer seu cadastro");
        System.out.println("Digite seu nome");
        cadastro.nome= leitor.nextLine();
        System.out.println("Digite sua idade");
        cadastro.idade=leitor.nextInt();
        System.out.println("Digite seu cpf");
        cadastro.cpf=leitor.nextLong();
        System.out.println("Digite seu cargo");
        cadastro.cargo=leitor.next();

    // Exibir as informações do cadastro
    System.out.println("\nCadastro realizado com sucesso!");
    System.out.println("Nome: " + cadastro.nome);
    System.out.println("Idade: " + cadastro.idade);
    System.out.println("CPF: " + cadastro.cpf);
    System.out.println("Cargo: " + cadastro.cargo);
   
    leitor.close();

    }
}
