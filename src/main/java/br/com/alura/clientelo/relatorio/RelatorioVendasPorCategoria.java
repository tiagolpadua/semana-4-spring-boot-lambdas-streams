package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class RelatorioVendasPorCategoria {

    public static void geraRelatorio(List<Pedido> pedidos) {
        var mapaPedidosPorCategoria = pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getCategoria));

        mapaPedidosPorCategoria.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(pedidosPorCategoria -> {
                    var categoria = pedidosPorCategoria.getKey();
                    var quantidadeVendas = (Integer) pedidosPorCategoria.getValue()
                            .stream()
                            .mapToInt(Pedido::getQuantidade)
                            .sum();

                    var valorVendas = pedidosPorCategoria.getValue()
                            .stream()
                            .map(Pedido::getValorTotal)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    System.out.println("CATEGORIA: " + categoria);
                    System.out.println("QUANTIDADE VENDIDA: " + quantidadeVendas);
                    System.out.println("MONTANTE: " + FormatUtils.formataParaReal(valorVendas));
                    System.out.println();
                });
    }
}
