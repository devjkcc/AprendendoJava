import java.util.Scanner;

public class leituraDeDados {
    
public static void main(String[] args) {
    
// Em java, para obter leitura de dados é necessário importar uma biblioteca: import java.util.Scanner;

// Vamos fazer um exemplo simples de somatório

int a, b, somatorio;

// a estrutura básica para leitura  é : Scanner scanner = new Scanner(System.in), porém o segundo scanner é o nome da variável, então pode ser alteravel

Scanner leitor = new Scanner(System.in);

System.out.println("Digite um valor ");
a = leitor.nextInt();
System.out.println("Digite outro valor");
b = leitor.nextInt();

somatorio = a + b;

// A estrutura nextInt() significa que ele vai fazer a leitura do inteiro

System.out.println(somatorio);

// Em java, diferentemente de outras linguagens, é possivel ler strings com mais facilidade

String nome;

System.out.println("Digite seu nome");
nome= leitor.next(); // Com essa propriedade, é lida todo o conteudo da linha, o que facilita a leitura de strings
leitor.nextLine();
System.out.println("ola "+ nome); // o simbolo + nesse caso funciona como concatenação

leitor.close(); // É  necessário fechar o scanner após ser utilizado

}

}
