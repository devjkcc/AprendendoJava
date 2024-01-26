
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Esse projeto é uma agenda telefonica que guarda: nome, telefone, cidade, rua, numero da casa e contato de emergencia
// os dados são salvos em listaClientes.csv

public class agendaTelefonica {

    public class Cadastro{

        public String nome;
        private long telefone;
        public String cidade;
        public String rua;
        public int numeroCasa;
        public long contatoEmergencia;

    public String getNome(){
      return nome;
    }

    public void setNome (String novonome){
      this.nome=novonome;
    }

    public String getCidade(){
      return cidade;
    }

    public void setCidade(String NovaCidade){
      this.cidade = NovaCidade;
    }


    public long getTelefone(){
        return telefone;
    }

    public void setTelefone(long novotelefone){
    this.telefone = novotelefone;
    }

    public void setRua(String novaRua){
      this.rua=novaRua;
    }
    
  public String getRua(){
    return rua;
  }

  public void setNumeroCasa(int novoNumeroCasa){
    this.numeroCasa = novoNumeroCasa;
  }

  public int getNumeroCasa(){
    return numeroCasa;
  }
 
  public void setContatoEmergencia(long novoContatoEmergencia){
    this.contatoEmergencia= novoContatoEmergencia;
  }

  public long getnovoContatoEmergencia(){
    return contatoEmergencia;
  }
    }

     private static void CadastraCliente(agendaTelefonica agenda,  List<Cadastro> listaTelefonica, Scanner leitor ){
      VerificaTelefone(listaTelefonica, agenda, leitor);
    }

  public static void chamarCadastroCliente(agendaTelefonica agenda,  List<Cadastro> listaTelefonica, Scanner leitor ){
    CadastraCliente(agenda, listaTelefonica, leitor);
  }

  private static void encontrarcliente(List<Cadastro> listaTelefonica, long telefone,  agendaTelefonica agenda, Scanner leitor ){
  
    System.out.println("Digite o telefone do cliente que deseja encontrar");
    long telefoneDesejado = leitor.nextLong();

    for(Cadastro cliente : listaTelefonica){

        if(cliente.getTelefone() == telefoneDesejado){
         
          System.out.println("Nome: " + cliente.nome);
          System.out.println("Telefone: " + cliente.telefone);
          System.out.println("Cidade: " + cliente.cidade);
          System.out.println("Rua: " + cliente.rua);
          System.out.println("Numero da casa: " + cliente.numeroCasa);
          System.out.println("Contato de emergencia: " + cliente.contatoEmergencia);

        } else{
            System.out.println("Usuario nao encontrado");
        }
    }
    
  }

  private static void excluircliente(List<Cadastro> listaTelefonica, long telefone, agendaTelefonica agenda, Scanner leitor){
  List<Cadastro> clientesRemover = new ArrayList<>();
    System.out.println("Digite o telefone do cliente que deseja encontrar");
    long telefoneDesejado = leitor.nextLong();

    for(Cadastro cliente : listaTelefonica){

        if(cliente.getTelefone() == telefoneDesejado){
          clientesRemover.add(cliente);
         
        } 
      }
      if(!clientesRemover.isEmpty()){
        listaTelefonica.remove(clientesRemover);
        System.out.println("Cliente removido com sucesso");
      } else{
        System.out.println("Cliente não encontrado");
      }
    


  }

  private static void alterarDados(List<Cadastro> listaTelefonica, long telefone, agendaTelefonica agenda, Scanner leitor ){
    System.out.println("Digite o seu telefone para que possamos encontrar-lo");
    long telefoneDesejado = leitor.nextLong();
    Cadastro clienteAlterado = agenda.new Cadastro();
    for(Cadastro cliente : listaTelefonica){

        if(cliente.getTelefone() == telefoneDesejado){
          boolean stop = false;
         while(!stop){

          System.out.println("[1] - Alterar nome");
         System.out.println("[2] - Alterar telefone");
         System.out.println("[3] - Alterar cidade");
         System.out.println("[4] - Alterar rua ");
         System.out.println("[5] - Alterar numero da casa");
         System.out.println("[6] - Alterar contato de emergencia");
         System.out.println("Para sair bastante digitar qualquer outro numero");

         int escolha = leitor.nextInt();
        
         switch (escolha) {
          case 1:
          System.out.println("Digite o novo nome");
          leitor.nextLine();
          cliente.setNome(leitor.nextLine());
          System.out.println("Dados alterados com sucesso");
            break;
          case 2:
          System.out.println("Digite o novo telefone");
          cliente.setTelefone(leitor.nextLong());
          System.out.println("Dados alterados com sucesso");
          break;
          case 3:
          System.out.println("Digite a nova cidade");
          cliente.setCidade(leitor.nextLine());
          System.out.println("Dados alterados com sucesso");
          break;
          case 4:
          System.out.println("Digite a nova rua");
          cliente.setRua(leitor.nextLine());
          System.out.println("Dados alterados com sucesso");
          break;
          case 5:
          System.out.println("Digite o novo numero da casa");
          cliente.setNumeroCasa(leitor.nextInt());
          System.out.println("Dados alterados com sucesso");
          break;
          case 6:
          System.out.println("Digite o novo contato de emergencia");
          cliente.setContatoEmergencia(leitor.nextLong());
          System.out.println("Dados alterados com sucesso");
          break;
          default:
          System.out.println("Saindo do programa");
          stop = true;
            break;
         }

        }
         
        } else{
            System.out.println("Usuario nao encontrado");
        }
    }
    
  }

  private static void VerificaTelefone(List<Cadastro> listaTelefonica, agendaTelefonica agenda, Scanner leitor){
   
   long telefoneconsultado;
   System.out.println("Olá, vamos fazer seu cadastro");
   System.out.println("Digite seu telefone");
   telefoneconsultado = leitor.nextLong();
   boolean telefonejacadastrado = false;

   for(Cadastro cliente2: listaTelefonica){

    if(cliente2.getTelefone() == telefoneconsultado){
      System.out.println("Telefone já cadastrado \n" + "Pertence a cliente: " + cliente2.nome);
      cliente2.setTelefone(telefoneconsultado);
      telefonejacadastrado = true;
    }

   }
    
    if(!telefonejacadastrado){
      Cadastro novoCliente = agenda.new Cadastro();
      novoCliente.setTelefone(telefoneconsultado);    
      System.out.println("Digite seu nome");
      novoCliente.nome = leitor.next();
      System.out.println("Digite sua cidade");
      leitor.nextLine();
      novoCliente.cidade = leitor.nextLine();
      System.out.println("Digite o nome da rua");
      novoCliente.rua = leitor.nextLine();
      System.out.println("Digite o numero da casa");
      novoCliente.numeroCasa = leitor.nextInt();
      System.out.println("Digite seu contato de emergencia");
      novoCliente.contatoEmergencia = leitor.nextLong();
      System.out.println("Dados cadastrados com sucesso");
  
      listaTelefonica.add(novoCliente);
    

    }
    
  }

  private static void salvadosDadosCSV(List<Cadastro> listaTelefonica ,String nomeArquivo){

     try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))){
      writer.write("Nome, Telefone, Cidade, Rua, NumeroCasa, ContatoEmergencia");
      writer.newLine();

       for(Cadastro cliente : listaTelefonica){
       writer.write(cliente.getNome() + "," + 
      cliente.getTelefone() + "," + 
      cliente.getCidade() + "," +
      cliente.getRua() + "," +
      cliente.getNumeroCasa() + "," +
      cliente.getnovoContatoEmergencia());
       writer.newLine();

       }
       
       System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados em " + nomeArquivo);
            e.printStackTrace();

     }
  }

 
  private static List<Cadastro> carregarClientesDeCsv(String nomeArquivo) {
    List<Cadastro> clientes = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
        // Ignora a primeira linha (cabeçalho)
        reader.readLine();

        // Lê os dados dos clientes do arquivo
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            if (dados.length == 6) {
                Cadastro cliente = new agendaTelefonica().new Cadastro();
                cliente.nome = dados[0];
                cliente.telefone = Long.parseLong(dados[1]);
                cliente.cidade = dados[2];
                cliente.rua = dados[3];
                cliente.numeroCasa = Integer.parseInt(dados[4]);
                cliente.contatoEmergencia = Long.parseLong(dados[5]);
                clientes.add(cliente);
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao carregar os dados do arquivo CSV: " + e.getMessage());
    }
    return clientes;
}
    

 

    public static void main(String[] args) {
   agendaTelefonica agenda = new agendaTelefonica();
  
  
   List<Cadastro> listaTelefonica = new ArrayList<>();
   listaTelefonica = carregarClientesDeCsv("listaClientes.csv");

   Scanner leitor = new Scanner(System.in);
   boolean encerrar = false;
     while (!encerrar){
       System.out.println("Digite o que deseja fazer");
       System.out.println("[1] - Cadastrar Telefone");
       System.out.println("[2] - Excluir telefone");
       System.out.println("[3] - Alterar dados");
       System.out.println("[4] - Consultar cliente");
      System.out.println("Pressione qualquer outro numero para sair");

       int opcao = leitor.nextInt();
   
       switch (opcao) {
        case 1:
         chamarCadastroCliente(agenda, listaTelefonica, leitor);
          break;
    
         case 2:
         excluircliente(listaTelefonica, opcao, agenda, leitor);
          break;
      
        case 3:
         alterarDados(listaTelefonica, opcao, agenda, leitor);
          break;
    
      
        case 4:
         encontrarcliente(listaTelefonica, opcao, agenda, leitor);
         break;
        default:
          encerrar = true;

        break;
   }

  }
   
salvadosDadosCSV(listaTelefonica, "listaClientes.csv");


}
}

 



