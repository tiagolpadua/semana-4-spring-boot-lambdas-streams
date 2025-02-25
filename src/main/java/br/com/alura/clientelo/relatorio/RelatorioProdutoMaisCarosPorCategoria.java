package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class RelatorioProdutoMaisCarosPorCategoria {

    public static void geraRelatorio(List<Pedido> pedidos) {

        Map<String, Optional<Pedido>> mapaPedidoMaisCaroPorCategoria = pedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::getCategoria,
                        Collectors.maxBy(Comparator.comparing(Pedido::getPreco))
                ));

        mapaPedidoMaisCaroPorCategoria.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(pedidoMaisCaroPorCategoria -> {
                    pedidoMaisCaroPorCategoria.getValue().ifPresent(pedido -> {
                        String categoria = pedidoMaisCaroPorCategoria.getKey();
                        System.out.println("CATEGORIA: " + categoria);
                        System.out.println("PRODUTO: " + pedido.getProduto());
                        System.out.println("PREÇO: " + FormatUtils.formataParaReal(pedido.getPreco()));
                        System.out.println();
                    });
                });
    }
}
