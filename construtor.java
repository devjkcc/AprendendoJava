public class construtor {

 
    private String nome;

  public construtor(){
  // Isso é um construtor sem passagem de parametro
    this.nome="Jefferson";

  }
 // Isso é um construtor com passagem de parametro
  public construtor(String nome){
    this.nome=nome;
  }

  public String getnome(){
    return nome;
  }

    public static void main(String[] args) {
        // Construtor é um inicializador de objeto
     construtor ctr1= new construtor();
     construtor ctr2 = new construtor("Alberto");

     System.out.println(ctr1.getnome());
     System.out.println(ctr2.getnome());

    }
}
