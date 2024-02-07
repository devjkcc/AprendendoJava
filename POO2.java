import java.util.Scanner;

public class POO2 {
    
// Aprendendo visibilidade


 public class Visibilidade{
   
    private String nome;
    private int idade;

 public String getnome(){
    return nome;
 }
 
 public void setnome(String novonome){
    this.nome = novonome;
 }

public int getidade(){
    return idade;
}

public void setidade(int novaidade){
    this.idade = novaidade;
}


 }


 public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    POO2 p = new POO2();
    Visibilidade vis = p.new Visibilidade();

 System.out.println("Digite o seu nome");
 vis.setnome(leitor.nextLine());
 System.out.println("Digite sua idade");
 vis.setidade(leitor.nextInt());

System.out.println("Seu nome é: " + vis.getnome());
System.out.println("Sua idade é: " + vis.getidade());

 }

}
