package utils;

import entities.Vuelo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class FiltrarVuelos {
    public static List<Vuelo> filtrarPorFecha(List<Vuelo> vuelos, LocalDate fechaInicio, LocalDate fechaFin) {
        ///Si fechaInicio es null, devolvemos todos los vuelos hasta la fechaFin
        if (fechaInicio == null && fechaFin != null) {
            return vuelos.stream()
                    .filter(v -> v.getFechaSalida() != null) //filtramos: solo dejamos los vuelos que tienen fecha de salida
                    .filter(v -> !v.getFechaSalida().isAfter(fechaFin)) //filtramos: solo dejamos los vuelos con fecha de salida anterior a fechaFin
                    .sorted(Comparator.comparing(Vuelo::getFechaSalida)) //ordenamos los vuelos de mas antiguos a mas recientes
                    .toList(); //convertimos el stream a lista y lo devolvemos
            ///Si no se envia fechaFin, devolvemos todos los vuelos desde la fechaInicio
        } else if (fechaFin == null && fechaInicio != null) {
            return vuelos.stream()
                    .filter(v -> v.getFechaSalida() != null) //filtramos: solo dejamos los vuelos que tengna fecha de salida
                    .filter(v -> !v.getFechaSalida().isBefore(fechaInicio)) //filtramos: los vuelos que tienen fechaInicio proporcionada hacia delante
                    .sorted(Comparator.comparing(Vuelo::getFechaSalida)) //ordenamos los vuelos filtrados
                    .toList(); //convertimos el stream a lista y lo devolvemos
            /// Si se envian ambas fechas, devolvemos los vuelos en ese rango de fechas
        } else if (fechaInicio != null) {
            return vuelos.stream()
                    .filter(v -> v.getFechaSalida() != null) //filtramos: fecha de salida valida
                    .filter(v -> !v.getFechaSalida().isBefore(fechaInicio) && !v.getFechaSalida().isAfter(fechaFin)) //filtramos: fecha vuelo no es anterior a fechaInicio
                    //&& la fecha del vuelo no es despues a fechaFin y añadimos ! para que sea no antes de la fecha, así, si coincide la fecha a filtrar con la fecha de salida, lo imprimirá
                    .sorted(Comparator.comparing(Vuelo::getFechaSalida)) //ordenamos por fechaSalida
                    .toList(); //convertimos el stream a lista y lo devolvemos
        }
        /// Si no se envía ninguna fecha, devolvemos todos los vuelos ordenador por fecha de salida
        return vuelos.stream()
                .filter(v -> v.getFechaSalida() != null) //filtramos: dejamos los vuelos con fechaSalida valida
                .sorted(Comparator.comparing(Vuelo::getFechaSalida)) //ordenamos los vuelos filtrados
                .toList(); //convertimos el stream a lista y lo devolvemos
    }
}
