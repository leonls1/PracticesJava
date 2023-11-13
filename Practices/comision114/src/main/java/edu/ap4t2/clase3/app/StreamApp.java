package edu.ap4t2.clase3.app;

import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import edu.ap4t2.clase3.model.Cliente;
import edu.ap4t2.clase3.model.Factura;
import edu.ap4t2.clase3.model.TipoCompra;

public class StreamApp {

  private static List<Factura> initializeData() {
    List<Factura> lista = new ArrayList<>();
    Factura f1 = new Factura();
    f1.setId(1);
    f1.setConcepto("Detergente CIF Té Verde");
    f1.setMonto(1000.20d);
    f1.setTipoCompra(TipoCompra.ALMACEN);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Gauna");
    f1.getCliente().setNombre("Rodolfo");
    f1.getCliente().setCuit("20-45689652-4");
    f1.getCliente().setId(5);
    f1.getCliente().setFechaNac(LocalDate.of(1980, 10, 27));

    lista.add(f1);

    f1 = new Factura();
    f1.setId(2);
    f1.setConcepto("Omeprazol 50mg");
    f1.setMonto(1500.00d);
    f1.setTipoCompra(TipoCompra.FARMACIA);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Estevanez");
    f1.getCliente().setNombre("Lucía");
    f1.getCliente().setCuit("20-15879879-4");
    f1.getCliente().setId(7);
    f1.getCliente().setFechaNac(LocalDate.of(1975, 7, 28));

    lista.add(f1);

    f1 = new Factura();
    f1.setId(3);
    f1.setConcepto("Frutillas x kg");
    f1.setMonto(1250.99d);
    f1.setTipoCompra(TipoCompra.VERDULERIA);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Estevanez");
    f1.getCliente().setNombre("Lucía");
    f1.getCliente().setCuit("20-15879879-4");
    f1.getCliente().setId(7);
    f1.getCliente().setFechaNac(LocalDate.of(1975, 7, 28));

    lista.add(f1);

    f1 = new Factura();
    f1.setId(4);
    f1.setConcepto("Durazno Moño Azul x kg");
    f1.setMonto(1400d);
    f1.setTipoCompra(TipoCompra.VERDULERIA);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Córdoba");
    f1.getCliente().setNombre("Mauro");
    f1.getCliente().setCuit("21-04586239-7");
    f1.getCliente().setId(15);
    f1.getCliente().setFechaNac(LocalDate.of(1993, 8, 7));

    lista.add(f1);

    f1 = new Factura();
    f1.setId(5);
    f1.setConcepto("Papel Higiénico Higienol x 80 m");
    f1.setMonto(5300.00d);
    f1.setTipoCompra(TipoCompra.ALMACEN);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Martinez");
    f1.getCliente().setNombre("Guadalupe");
    f1.getCliente().setCuit("21-26745963-7");
    f1.getCliente().setId(17);
    f1.getCliente().setFechaNac(LocalDate.of(1995, 3, 27));

    lista.add(f1);

    f1 = new Factura();
    f1.setId(6);
    f1.setConcepto("Desodorante dove mujer");
    f1.setMonto(3300.00d);
    f1.setTipoCompra(TipoCompra.ALMACEN);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Martinez");
    f1.getCliente().setNombre("Guadalupe");
    f1.getCliente().setCuit("21-26745963-7");
    f1.getCliente().setId(17);
    f1.getCliente().setFechaNac(LocalDate.of(1995, 3, 27));

    lista.add(f1);

    f1 = new Factura();
    f1.setId(7);
    f1.setConcepto("Ibuprofeno 600g");
    f1.setMonto(580.50d);
    f1.setTipoCompra(TipoCompra.FARMACIA);
    f1.setCliente(new Cliente());
    f1.getCliente().setApellido("Martinez");
    f1.getCliente().setNombre("Guadalupe");
    f1.getCliente().setCuit("21-26745963-7");
    f1.getCliente().setId(17);
    f1.getCliente().setFechaNac(LocalDate.of(1995, 3, 27));

    lista.add(f1);

    return lista;
  }

  public static void main(String[] args) {

    List<Factura> facturas = initializeData();

    // facturas.stream().forEach(f -> System.out.println(f));

    boolean todosCumplen = facturas.stream()
        .allMatch(f -> f.getTipoCompra().equals(TipoCompra.FARMACIA));

    boolean algunosCumplen = facturas.stream()
        .anyMatch(f -> f.getTipoCompra().equals(TipoCompra.FARMACIA));

    boolean ningunoCumple = facturas.stream()
        .noneMatch(f -> f.getTipoCompra().equals(TipoCompra.FARMACIA));

    boolean clientesMas30 = facturas.stream().allMatch(f -> f.getCliente().getEdad() > 30);

    /*
     * Stream<Factura> facStream = facturas.stream();
     * 
     * facStream.forEach(f -> System.out.println(f));
     * facStream.count();
     */

    List<Factura> facturasMenoresA3000 = facturas.stream()
        .filter(f -> f.getMonto() < 3000d)
        .limit(2)
        .collect(Collectors.toList());

    // select * from facturas f where f.monto < 3000;

    // facturasMenoresA3000.stream().forEach(System.out::println);

    String clientes = facturas.stream()
        .map(f -> f.getCliente())
        .distinct()
        .map(x -> x.getNombre() + " " + x.getApellido() + " - " + x.getEdad())
        .collect(Collectors.joining(", "));

    // System.out.println(clientes);

    Set<Long> cuits = facturas.stream().mapToLong(f -> Long.parseLong(f.getCliente().getCuit().replace("-", "")))
        .boxed().collect(Collectors.toSet());

    // cuits.stream().forEach(System.out::println);

    List<Factura> ordenadasXMontoDesc = facturas.stream()
        .sorted((x, y) -> y.getMonto().compareTo(x.getMonto()))
        .collect(Collectors.toList());

    // ordenadasXMontoDesc.stream().forEach(System.out::println);

    List<Cliente> clientesxId = facturas.stream()
        .map(f -> f.getCliente())
        .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
        .distinct()
        .collect(Collectors.toList());

    // System.out.println(clientesxId);

    Double totalCompras = facturas.stream()
        .mapToDouble(f -> f.getMonto())
        .sum();

    // System.out.println(totalCompras);

    Map<TipoCompra, DoubleSummaryStatistics> estadisticas = facturas.stream()
        .collect(Collectors.groupingBy(f -> f.getTipoCompra(), Collectors.summarizingDouble(f -> f.getMonto())));

    System.out.println(estadisticas);

  }
}