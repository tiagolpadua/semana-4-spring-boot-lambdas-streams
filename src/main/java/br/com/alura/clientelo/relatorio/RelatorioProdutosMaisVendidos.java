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
        // chave: String / valor: Integer
        var mapaVendasPorProduto = pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getProduto, Collectors.summingInt(Pedido::getQuantidade)));

        mapaVendasPorProduto
            .entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
            .limit(3)
            .forEach(item -> {
                System.out.println("PRODUTO: " + item.getKey());
                System.out.println("QUANTIDADE: " + item.getValue());
                System.out.println();
        });
    }
}
