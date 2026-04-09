package app;

import models.Registro;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class app {
    static void main() {
        List<Registro> registros = new ArrayList<>();
        double max = 100, min = -10 ;
        for(int i = 0; i <100; i++){
           registros.add(new Registro(LocalDateTime.now().minusMinutes(i),(Math.random()*100),
                   (Math.random() * ( max - min + 1))+ (min)));

        }
        for (Registro registro: registros){
            IO.println(registro);
        }
        IO.println("EJERCICIO 1--------------------------------------------------------------------------------");

        //Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70 y la
        //fecha sea anterior a la fecha actual, y mostrarlos.
        List<Registro> registroListM = registros.stream()
                .filter(r-> r.getTemperatura() > 25 && r.getHumedad()<70
                        && r.getFechaHora().isBefore(LocalDateTime.now()))
                .toList();
        registroListM.forEach(IO::println);

        IO.println("EJERCICIO 2--------------------------------------------------------------------------------");


        //Encontrar el registro con la temperatura más alta y mostrar el registro completo.
        registros.stream()
                .max(Comparator.comparingDouble(Registro::getTemperatura))
                .ifPresent(IO::println);

        IO.println("EJERCICIO 3--------------------------------------------------------------------------------");

        //Obtener una lista con las fechas/horas de todas las tomas de datos

        List<LocalDateTime> fechasDatos = registros.stream()
                .map(Registro::getFechaHora)
                .toList();
        fechasDatos.forEach(IO::println);



        IO.println("EJERCICIO 4--------------------------------------------------------------------------------");

        //Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
        //humedades y fechas/horas actualizadas

        List<Registro> incrementarUnidades = registros.stream()
                .map(r -> new Registro(r.getFechaHora(),r.getTemperatura(),r.getHumedad()+5))
                .toList();
        incrementarUnidades.forEach(IO::println);
        IO.println("EJERCICIO 5--------------------------------------------------------------------------------");

        //Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y mostrar la
        //temperatura, humedad y fecha.

        registros.stream()
                .filter(r-> r.getHumedad() > 80)
                .min(Comparator.comparingDouble(Registro::getTemperatura))
                .ifPresent(IO::println);

        IO.println("EJERCICIO 6--------------------------------------------------------------------------------");

        //Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y la fecha
        //es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta condición o no.

        Boolean registroListHoy = registros.stream()
                .anyMatch(r-> r.getTemperatura() > 30 && r.getHumedad()<90
                        && r.getFechaHora().isBefore(LocalDateTime.now()));
        if (registroListHoy) {
            IO.println("Se cumple la condicion?: ");
            IO.println(registroListHoy);
        }else {
            IO.println("Se cumple la condicion?: ");
            IO.println(registroListHoy);
        }

        IO.println("EJERCICIO 7--------------------------------------------------------------------------------");

        //Muestra 10 registros saltándote los 5 primeros.
        List<Registro> registroList2 = registros.stream()
                .skip(5)
                .limit(15)
                .toList();
        registroList2.forEach(IO::println);


        IO.println("EJERCICIO 8--------------------------------------------------------------------------------");
        //Muestra los registros ordenados por fecha (sorted(Comparator)
        registros.stream()
                .sorted(Comparator.comparing(Registro::getFechaHora))
                .forEach(IO::println);

        IO.println("EJERCICIO 9--------------------------------------------------------------------------------");
        //Cuenta los registros que tengan temperatura mayor a 35 grados (count()).
        Long registroList3 =registros.stream()
                .filter(r -> r.getTemperatura() > 35)
                .count();
        IO.println(registroList3);

        IO.println("EJERCICIO 10--------------------------------------------------------------------------------");
        //Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double> y
        //llamar a average()).
        Double temperutaMedia = registros.stream()
                .collect(Collectors.averagingDouble(Registro::getTemperatura));
        IO.println(temperutaMedia);










    }






}
