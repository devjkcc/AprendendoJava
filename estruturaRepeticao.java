public class estruturaRepeticao {
    public static void main(String[] args) {
        // Em java, assim como em outras linguagens, existem 3 estruturas de repetição: for, while e do while



    // for
    // for(inicialização; condição; atualização){}

   
  // Contador de 0 a 10
  // é importante lembrar, que o index sempre começa do zero, por isso para ir de 1 a 10, precisa começar no 1 e ir até o 11
    for(int i = 1; i < 11; i++){
        System.out.println(i);
    }

  int i = 0;
  while( i < 10){
    i++;
    System.out.println(i);
 }

// A diferença do comando while para do while é que o do while primeirom executa a ordem e depois verifica a condição, enquanto o while primeiro verifica a condição e depois executa
 do{
    i++;
    System.out.println(i);
 } while(i <5);


    }
}
