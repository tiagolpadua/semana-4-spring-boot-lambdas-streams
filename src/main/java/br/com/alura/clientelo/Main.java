package br.com.alura.clientelo;

import br.com.alura.clientelo.arquivo.*;
import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.pedido.RepositorioDePedidos;
import br.com.alura.clientelo.relatorio.RelatorioSintetico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private Scanner scanner = new Scanner(System.in);
    private RepositorioDePedidos repositorioDePedidos = new RepositorioDePedidos();

    public static void xmain(String[] args) throws Exception {
        Main main = new Main();
        main.executa();
    }

    private void executa() {
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

