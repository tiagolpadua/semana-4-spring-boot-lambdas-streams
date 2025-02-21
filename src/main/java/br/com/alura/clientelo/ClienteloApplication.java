package br.com.alura.clientelo;

import br.com.alura.clientelo.pedido.RepositorioDePedidos;
import br.com.alura.clientelo.relatorio.RelatorioProdutosMaisVendidos;
import br.com.alura.clientelo.relatorio.RelatorioSintetico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

@SpringBootApplication
public class ClienteloApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ClienteloApplication.class);

    @Autowired
    private Scanner scanner;
//    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private RepositorioDePedidos repositorioDePedidos;
//    private RepositorioDePedidos repositorioDePedidos = new RepositorioDePedidos();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClienteloApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String banner = """
                   ██████╗██╗     ██╗███████╗███╗   ██╗████████╗███████╗██╗      ██████╗
                  ██╔════╝██║     ██║██╔════╝████╗  ██║╚══██╔══╝██╔════╝██║     ██╔═══██╗
                  ██║     ██║     ██║█████╗  ██╔██╗ ██║   ██║   █████╗  ██║     ██║   ██║
                  ██║     ██║     ██║██╔══╝  ██║╚██╗██║   ██║   ██╔══╝  ██║     ██║   ██║
                  ╚██████╗███████╗██║███████╗██║ ╚████║   ██║   ███████╗███████╗╚██████╔╝
                   ╚═════╝╚══════╝╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝╚══════╝ ╚═════╝
                
                --------------------------------------------------------
                🚀 Clientelo - Gerenciamento de Pedidos 🚀
                --------------------------------------------------------
                📦 Consulte pedidos, gere relatórios e analise dados!
                🛠 Desenvolvido com Spring Boot
                --------------------------------------------------------
                """;

        System.out.println(banner);

        String menu = """
                1 - Relatório sintético
                2 - Produtos mais vendidos
                3 - Vendas por categoria
                4 - Produtos mais caros por categoria
                5 - Clientes mais fiéis
                6 - Clientes mais lucrativos
                7 - Cadastrar pedido
                8 - Excluir pedido
                0 - SAIR
                """;

        int opcaoDoMenu = -1;
        while (opcaoDoMenu != 0) {
            System.out.println(menu);
            System.out.print("Digite a opção desejada: ");
            opcaoDoMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoDoMenu) {
                case 1 -> exibeRelatorioSintetico();
                case 2 -> exibeProdutosMaisVendidos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println("========");
            System.out.println();
        }
    }

    private void exibeRelatorioSintetico() {
        RelatorioSintetico relatorioSintetico = RelatorioSintetico.geraRelatorio(repositorioDePedidos.listaTodos());
        relatorioSintetico.exibir();
    }

    private void exibeProdutosMaisVendidos() {
        RelatorioProdutosMaisVendidos.geraRelatorio(repositorioDePedidos.listaTodos());
    }

    private void exibeVendasPorCategoria() {

    }

    private void exibeProdutosMaisCarosPorCategoria() {

    }

    private void exibeClientesMaisFieis() {

    }

    private void exibeClientesMaisLucrativos() {

    }

    private void cadastrarPedido() {

    }

    private void excluirPedido() {

    }
}

