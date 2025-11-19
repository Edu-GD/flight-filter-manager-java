import entities.Vuelo;
import utils.FiltrarVuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //Fechas que queremos filtrar
    private static final LocalDate fechaInicio = LocalDate.of(2025, 11, 22);
    private static final LocalDate fechaFin = LocalDate.of(2026, 1, 21);

    public static void main(String[] args) {
        List<Vuelo> listaVuelos = new ArrayList<>();
        listaVuelos.add(new Vuelo(1, "IB101", "Iberia", "Madrid", "Londres", LocalDate.of(2025, 11, 22), LocalDate.of(2025, 11, 22)));
        listaVuelos.add(new Vuelo(2, "VY204", "Vueling", "Barcelona", "París", LocalDate.of(2025, 12, 3), LocalDate.of(2025, 12, 3)));
        listaVuelos.add(new Vuelo(3, "AZ331", "ITA Airways", "Roma", "Berlín", LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 10)));
        listaVuelos.add(new Vuelo(4, "UX515", "Air Europa", "Madrid", "Ámsterdam", LocalDate.of(2026, 2, 15), LocalDate.of(2026, 2, 15)));
        listaVuelos.add(new Vuelo(5, "AZ420", "ITA Airways", "Milán", "Bruselas", LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 1)));
        listaVuelos.add(new Vuelo(6, "IB312", "Iberia", "Barcelona", "Zúrich", LocalDate.of(2026, 4, 7), LocalDate.of(2026, 4, 7)));
        listaVuelos.add(new Vuelo(7, "VY990", "Vueling", "Madrid", "Copenhague", LocalDate.of(2026, 5, 12), LocalDate.of(2026, 5, 12)));
        listaVuelos.add(new Vuelo(8, "AZ558", "ITA Airways", "Roma", "Estocolmo", LocalDate.of(2025, 12, 20), LocalDate.of(2025, 12, 20)));
        listaVuelos.add(new Vuelo(9, "UX708", "Air Europa", "Madrid", "Múnich", LocalDate.of(2026, 6, 10), LocalDate.of(2026, 6, 10)));
        listaVuelos.add(new Vuelo(10, "VY441", "Vueling", "Barcelona", "Dublín", LocalDate.of(2025, 11, 28), LocalDate.of(2025, 11, 28)));

        List<Vuelo> vuelosFiltrados = FiltrarVuelos.filtrarPorFecha(listaVuelos, fechaInicio, fechaFin);
        //System.out.println("\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB");
        System.out.println("=================================================================");
        System.out.println("                      VUELOS FILTRADOS ");
        System.out.println("       \uD83D\uDCC5 Fecha inicio: " + fechaInicio + " | Fecha fin: " + fechaFin);
        System.out.println("=================================================================");

        //System.out.println("\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB\uD83D\uDEEB");

        if (vuelosFiltrados.isEmpty()) { //Si la lista está vacía, imprimiremos el warning
            System.out.println();
            System.out.println("⚠️ No hay vuelos en las fechas seleccionadas.");
        }
        for (Vuelo v : vuelosFiltrados) { //Si hay vuelos, imprimimos la lista
            System.out.println(v.toString());
        }

    }
}