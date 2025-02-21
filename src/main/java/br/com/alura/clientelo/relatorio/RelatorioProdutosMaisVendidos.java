package br.com.alura.clientelo.relatorio;

import br.com.alura.clientelo.pedido.Pedido;
import br.com.alura.clientelo.utils.FormatUtils;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class RelatorioProdutosMaisVendidos {

    public static void geraRelatorio(List<Pedido> pedidos) {
        Map<String, Integer> produtosAgrupados = pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getProduto, Collectors.summingInt(Pedido::getQuantidade)));

        produtosAgrupados
            .entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
            .limit(3)
            .forEach(entry -> {
                System.out.println("PRODUTO: " + entry.getKey());
                System.out.println("QUANTIDADE: " + entry.getValue());
                System.out.println();
            });
    }
}
