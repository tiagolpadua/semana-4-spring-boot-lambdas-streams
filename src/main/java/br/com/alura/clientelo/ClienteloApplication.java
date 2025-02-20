package br.com.alura.clientelo;

import br.com.alura.clientelo.pedido.RepositorioDePedidos;
import br.com.alura.clientelo.relatorio.RelatorioSintetico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@ComponentScan("br.com.alura.clientelo")
public class ClienteloApplication implements CommandLineRunner {

    @Autowired
    private Scanner scanner;
//    private Scanner scanner = new Scanner(System.in);

//    private RepositorioDePedidos repositorioDePedidos = new RepositorioDePedidos();

    @Autowired
    private RepositorioDePedidos repositorioDePedidos;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClienteloApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

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
