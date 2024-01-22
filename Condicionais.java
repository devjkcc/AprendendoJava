import java.util.Scanner;

public class Condicionais {
    public static void main(String[] args) {
        
  // A estrutura condicional em java não se difere muito das outras linguagens, sendo composta por if e else

 // Vamos fazer uma verificação se um numero é impar ou par utilizando if

 Scanner leitor = new Scanner(System.in);

 System.out.println("Digite um valor para verificarmos se é impar ou par");
 int a = leitor.nextInt();

 if (a % 2 == 0){  // O operador % diz respeito ao resto de uma divisão, se um valor x dividido por 2 restar em zero, significa ser par
    System.out.println("É par");
 } else{
    System.out.println("É impar");
 }

// Trabalhando com médias

float nota1, nota2, media;

System.out.println("Digite sua primeira nota");
nota1=leitor.nextFloat();
System.out.println("Digite sua segunda nota");
nota2=leitor.nextFloat();

media = (nota1 + nota2)/2;

if (media >= 7.0){
    System.out.println("Aprovado");
} else if(media >= 4.0 && media < 7.0){
    System.out.println("Recuperação");
} else{
    System.out.println("Reprovado");
}

    }
}
