import java.util.Scanner;


public class EscolhaCaso {
    public static void main(String[] args) {
        // O switch case funciona como uma especie de menu, onde voce tem uma opção e deseja escolher, ao inves de se utilizar vários if, se utiliza o switch case
   
     // Faremos um switch case, em que serão tres opçoes: soma, multiplicação e divisão
   
     Scanner leitor = new Scanner(System.in);

     float a, b;

     System.out.println("Digite um valor");
     a = leitor.nextFloat();
     System.out.println("Digite outro  valor");
     b = leitor.nextFloat();
     System.out.println("[1] - Multiplicar");
     System.out.println("[2] - Somar");
     System.out.println("[3] - Divisão");

     int opcao = leitor.nextInt();
     // Sempre é necessário o break em cada case para encerrar aquele caso e o leitor partir para o proximo
     // Nesse caso foi utilizado um if dentro do switch case, e dentro do switch case foi utilizado um string format para limitar o decimal a duas casas
     switch (opcao) {
        case 1:
            float resultado;
            resultado = a * b;
            System.out.println(resultado);
            break;
       case 2:
            resultado = a + b;
            System.out.println(resultado);
            break;
        case 3:
            if (a > b){
                resultado = a /b;
                String valorFormatado = String.format("%.2f", resultado);
                System.out.println(resultado);
            } else if( b > a){
                resultado = b/a;
                System.out.println(resultado);
            } else{
                resultado = 1;
                System.out.println(resultado);
            }
            break;
        default:
            break;
     }






    }
}
