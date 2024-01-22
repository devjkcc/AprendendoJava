public class Variaveis {
   
   public static void main(String[] args) {
    

// Java possui 8 tipos de variáveis diferentes: int, byte, short, long, float, double, boolen, string e char

    // Declarando variáveis

    // Somador simples
    int nota1 = 8;
    int nota2 = 7;
    int somador = nota1 + nota2;

    float valor1 = 75.6f;
    float valor2 = 78.9f;

    System.out.println(somador);
    // O resultado no terminal apresentará 15

    System.out.println(valor1+valor2);
    //  O resultado apresentará 154.5

    char letra = 'J'; // Em java, char guarda apenas um caractere, equanto string guarda uma cadeia de palavras
    String nome = "Jefferson";

    System.out.println(letra);
    System.out.println(nome);

    // Em java, o short significa valores inteiros curtos que ocupa 2bytes na memória
    short a = 20;
    short b = 30;
   System.out.println(a);
   System.out.println(b);

   // O long são inteiro longos que ocupam 8 bytes em memória. Valores long devem ter o sufixo l que representa long
   long c = 10000l;
   long d = 20000l;

   System.out.println(c);
   System.out.println(d);
 
   // O  double representa valores de dupla precisão float, como o numero pi
   double pi = 3.14;

   System.out.println(pi);
  // Valores bytes são inteiros menores que shorts, ocupando 2 bytes de memoria
   byte pequeno = 18;
   System.out.println(pequeno);

  // O Boolean trabalha com false ou true

   boolean verdade = true;

}
    
}
