import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Esse é um projeto de banco digital, no qual é possivel cadastrar clientes, consultar, excluir, realizar movimentações bancarias e no final é salvo em arquivo csv


public class BancoDigital {

    public class CadastradorPessoa {
        public long cpf;
        public String senha;
        public String nome;
        public float saldo;
    }

    public static void main(String[] args) {

        BancoDigital banco = new BancoDigital();
        CadastradorPessoa cadastrador = banco.new CadastradorPessoa();
        List<CadastradorPessoa> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        listaClientes = carregarClientesDeCsv("clientes.csv");
        while (!sair) {

            System.out.println("Olá, deseja seguir com qual procedimento?");
            System.out.println(" [1] - Cadastrar cliente");
            System.out.println(" [2] - Consultar cliente");
            System.out.println(" [3] - Alterar dados");
            System.out.println(" [4] - Excluir cliente");
            System.out.println(" [5] - Realizar movimentações");
            System.out.println(" [6] - Sair");

            int opcao = scanner.nextInt();
            CadastradorPessoa cliente = null;
            CadastradorPessoa remetente = null;
            switch (opcao) {

                case 1:
                    cadastrarUsuario(banco, listaClientes, scanner);
                    break;
                case 2:
                    consultaCliente(listaClientes, scanner);
                    break;
                case 3:
                    break;
                case 4:
                     excluirCliente(listaClientes, scanner);
                    break;
                case 5:
                    String sim;
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.println("Antes de fazer essa etapa, gostariamos de saber, o senhor(a) já é nosso cliente?");
                    System.out.println("Se não for cliente, vamos ter que realizar o seu cadastro ok?");
                    sim = scanner.nextLine();
                    if ("SIM".equalsIgnoreCase(sim)) {
                        cadastrarUsuario(banco, listaClientes, scanner);
                    } else {
                        cliente = escolherCliente(listaClientes, scanner);
                        if (cliente != null) {
                            sair = true;
                            System.out.println("Encerrando programa");
                        }
                    }

                    System.out.println("Deseja realizar qual movimentação?");
                    System.out.println("[1] - Depositar");
                    System.out.println("[2] - Transferir");
                    System.out.println("[3] - Sacar");
                    System.out.println("Para voltar ao menu basta digitar um numero diferente dos acima");
                    int operacao = scanner.nextInt();
                    switch (operacao) {

                        case 1:
                            System.out.println("Digite o CPF do cliente para realizar o depósito:");
                            long cpfDoCliente = scanner.nextLong();
                            cliente = encontrarClientePorCpf(listaClientes, cpfDoCliente);
                            if (cliente != null) {
                                realizarDeposito(cliente, scanner);
                            } else {
                                System.out.println("Cliente não encontrado. Voltando ao menu principal.");
                            }
                            break;
                        case 2:
                            realizarTransferencia(cliente, listaClientes, scanner);
                            break;
                        case 3:
                            cliente = escolherCliente(listaClientes, scanner);
                            if (cliente != null) {
                                realizarSaque(cliente, scanner);
                            } else {
                                System.out.println("Cliente não encontrado. Voltando ao menu principal.");
                            }
                            break;
                        default:
                            System.out.println("Voltando ao menu principal");
                    }

                    break;
                case 6:
                    sair = true;
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Opção inválida, saindo do programa");
                    break;
            }
        }
        salvarClientesEmCsv(listaClientes, "clientes.csv");
        scanner.close();

    }

    private static void cadastrarUsuario(BancoDigital banco, List<CadastradorPessoa> listaClientes, Scanner scanner) {
        CadastradorPessoa novoCliente = banco.new CadastradorPessoa();

        System.out.println("Olá, tudo bem? Vamos fazer o seu Cadastro!");
        scanner.nextLine(); // Consumir a quebra de linha pendente

        System.out.println("Digite seu nome");
        novoCliente.nome = scanner.nextLine();
        System.out.println("Digite seu cpf!");
        novoCliente.cpf = scanner.nextLong();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Digite sua nova senha");
        novoCliente.senha = scanner.nextLine();
        System.out.println("Digite o seu saldo inicial");
        novoCliente.saldo = scanner.nextFloat();
        System.out.println("Seja  bem vindo " + novoCliente.nome);
        listaClientes.add(novoCliente);
    }

    private static void consultaCliente(List<CadastradorPessoa> listaClientes, Scanner scanner) {
        System.out.println("Digite o cpf da pessoa que procura");
        long cpfconsultado = scanner.nextLong();

        boolean clienteEncontrado = false;

        for (CadastradorPessoa cliente : listaClientes) {

            if (cliente.cpf == cpfconsultado) {

                System.out.println("Cliente encontrado");
                System.out.println("Nome: " + cliente.nome);
                System.out.println("CPF: " + cliente.cpf);
                System.out.println("Senha: " + cliente.senha);
                clienteEncontrado = true;
                break;

            } else {
                System.out.println("Cliente não encontrado");

            }

        }

    }

    private static void realizarDeposito(CadastradorPessoa cliente, Scanner scanner) {

        System.out.println("Digite o valor do deposito");
        float deposito = scanner.nextFloat();

        if (deposito > 0) {
            cliente.saldo += deposito;
            System.out.println("Deposito realizado com sucesso");
            System.out.println("Seu novo saldo é " + cliente.saldo);
        } else {
            System.out.println("Valor invalido");
        }

    }

    private static void realizarTransferencia(CadastradorPessoa remetente, List<CadastradorPessoa> listaClientes,
            Scanner scanner) {
        System.out.println("Digite o CPF do destinatário:");
        long cpfDestinatario = scanner.nextLong();

        CadastradorPessoa destinatario = null;
        for (CadastradorPessoa cliente : listaClientes) {
            if (cliente.cpf == cpfDestinatario) {
                destinatario = cliente;
                break;
            }
        }

        if (destinatario != null) {
            System.out.println("Digite o valor da transferência:");
            float valorTransferencia = scanner.nextFloat();

            if (valorTransferencia > 0 && remetente.saldo >= valorTransferencia) {
                remetente.saldo -= valorTransferencia;
                destinatario.saldo += valorTransferencia;
                System.out.println("Transferência realizada com sucesso. Novo saldo: " + remetente.saldo);
            } else {
                System.out.println("Valor inválido para transferência ou saldo insuficiente.");
            }
        } else {
            System.out.println("Destinatário não encontrado.");
        }
    }

    private static void realizarSaque(CadastradorPessoa cliente, Scanner scanner) {
        System.out.println("Digite o valor do saque:");
        float valorSaque = scanner.nextFloat();

        if (valorSaque > 0 && cliente.saldo >= valorSaque) {
            cliente.saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso. Novo saldo: " + cliente.saldo);
        } else {
            System.out.println("Valor inválido para saque ou saldo insuficiente.");
        }
    }

    private static CadastradorPessoa escolherCliente(List<CadastradorPessoa> listaClientes, Scanner scanner) {
        System.out.println("Digite o CPF do cliente:");
        long cpfCliente = scanner.nextLong();

        for (CadastradorPessoa cliente : listaClientes) {
            if (cliente.cpf == cpfCliente) {
                return cliente;
            }
        }

        System.out.println("Cliente não encontrado.");
        return null;
    }

    private static CadastradorPessoa encontrarClientePorCpf(List<CadastradorPessoa> listaClientes, long cpf) {
        for (CadastradorPessoa cliente : listaClientes) {
            if (cliente.cpf == cpf) {
                return cliente;
            }
        }
        return null;
    }

    private static void excluirCliente(List<CadastradorPessoa> listaClientes, Scanner scanner) {
        System.out.println("Digite o CPF do cliente que deseja excluir:");
        long cpfExcluir = scanner.nextLong();
    
        if (removerCliente(listaClientes, cpfExcluir)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    
    private static boolean removerCliente(List<CadastradorPessoa> listaClientes, long cpf) {
        CadastradorPessoa clienteParaRemover = null;
    
        for (CadastradorPessoa cliente : listaClientes) {
            if (cliente.cpf == cpf) {
                clienteParaRemover = cliente;
                break;
            }
        }
    
        if (clienteParaRemover != null) {
            listaClientes.remove(clienteParaRemover);
            return true;
        }
    
        return false;
    }
  
    private static void salvarClientesEmCsv(List<CadastradorPessoa> listaClientes, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Escreve o cabeçalho do CSV
            writer.write("Nome,CPF,Senha,Saldo");
            writer.newLine();
    
            // Escreve os dados dos clientes
            for (CadastradorPessoa cliente : listaClientes) {
                writer.write(cliente.nome + "," + cliente.cpf + "," + cliente.senha + "," + cliente.saldo);
                writer.newLine(); // Adiciona uma quebra de linha após cada cliente
            }
    
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados em " + nomeArquivo);
            e.printStackTrace();
        }
    }
   private static List<CadastradorPessoa> carregarClientesDeCsv(String nomeArquivo) {
    List<CadastradorPessoa> clientes = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
        // Ignora a primeira linha (cabeçalho)
        reader.readLine();

        // Lê os dados dos clientes do arquivo
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            if (dados.length == 4) {
                CadastradorPessoa cliente = new BancoDigital(). new CadastradorPessoa();
                cliente.nome = dados[0];
                cliente.cpf = Long.parseLong(dados[1]);
                cliente.senha = dados[2];
                cliente.saldo = Float.parseFloat(dados[3]);
                clientes.add(cliente);
            }
        }
    } catch (IOException e) {
        System.out.println("Erro ao carregar os dados do arquivo CSV: " + e.getMessage());
    }

    return clientes;
}
}
