import java.util.Scanner;

public class GetterseSetters {

    public class User{
    
        private String firstname;
        private String lastname;

     // SETTER
     // O setter é um metodo usador para configurar atributos de um objeto privado, fornecendo portanto maior controle
     public void setfirstname(String firstname){
      this.firstname = firstname.toUpperCase();

    }
    // GETTER
    // O getter é um metodo de recuperação do setter
    public String getfirstname(){
        return firstname;
    }
    }
    
   
    public static void main(String[] args) {
        
    Scanner leitor = new Scanner(System.in);
   
    User novocliente = new GetterseSetters(). new User();

    System.out.println("Digite seu nome e irá aparecer em letras maiusculas");
    String nome = leitor.nextLine();

    novocliente.setfirstname(nome);
   System.out.println(novocliente.getfirstname());

  leitor.close();

    }

}
