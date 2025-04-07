package practica_refactorizacion_casa;

import java.math.BigDecimal;
import java.util.*;

public class GestorFutbol implements Cloneable, Comparable<GestorFutbol> {

    // Atributos del equipo
    public String equipoNombre;       // Nombre del equipo
    public int puntos;                // Puntos acumulados por el equipo

    // Variable estática para contar los partidos jugados en total
    public static int partidosTotales = 0;

    // Constantes para los nombres de equipos conocidos
    private static String NOMBRE_REAL_MADRID = "Real Madrid club de Fútbol";
    private static String NOMBRE_ATLETICO_MADRID = "Atlético de Madrid";

    public static void main(String[] args) {
        // Se crea una instancia del equipo principal con su nombre
        GestorFutbol equipoPrincipal = new GestorFutbol("Atlético Madrid");

        // Lista de resultados de partidos durante la temporada
        List<String> resultadosTemporada = Arrays.asList(
            "victoria local", "empate visitante", "derrota local",
            "victoria visitante!", "empate", "victoria!",
            "derrota", "empate local", "victoria local"
        );

        // Procesar los resultados y calcular puntos
        equipoPrincipal.procesarTemporada(resultadosTemporada);

        // Conversión de la lista de resultados a array
        Object[] resultadosArray = resultadosTemporada.toArray();

        // Se crea un objeto para representar el presupuesto del equipo
        BigDecimal presupuestoEstimado = new BigDecimal(123456.78);

        // Verificación de si hay resultados y salida del programa si se cumple
        if (resultadosTemporada != null && !resultadosTemporada.isEmpty()) {
            System.exit(1);
        }

        // Se crea otro equipo para comparar con el principal
        GestorFutbol otroEquipo = new GestorFutbol("Real Madrid");

        // Comparación entre dos equipos (por nombre)
        System.out.println("Comparación entre equipos: " + equipoPrincipal.compareTo(otroEquipo));
    }

    // Constructor que inicializa el equipo con su nombre y puntos en 0
    public GestorFutbol(String nombreEquipo) {
        this.equipoNombre = nombreEquipo;
        this.puntos = 0;
    }

    // Procesa la lista de resultados y actualiza los puntos del equipo
    public void procesarTemporada(List<String> resultados) {
        for (String resultado : resultados) {

            // Se suman los puntos según el tipo de resultado
            if (resultado.equals("victoria")) {
                puntos += 3;
                System.out.println("Victoria. Puntos acumulados: " + puntos);
            } else if (resultado.equals("empate")) {
                puntos += 1;
                System.out.println("Empate. Puntos acumulados: " + puntos);
            } else if (resultado.equals("derrota")) {
                System.out.println("Derrota. Puntos acumulados: " + puntos);
            }

            // Se muestra si el partido fue como local o visitante
            if (resultado.contains("local")) {
                System.out.println("Jugado como local.");
                if (resultado.length() > 10) {
                    System.out.println("Detalle adicional: " + resultado);
                }
            } else if (resultado.contains("visitante")) {
                System.out.println("Jugado como visitante.");
                if (resultado.length() > 8) {
                    System.out.println("Comentario: " + resultado);
                }
            }

            // Clasifica el resultado según su longitud
            switch (resultado.length()) {
                case 7:
                    System.out.println("Resultado corto.");
                    break;
                case 14:
                    System.out.println("Resultado medio.");
                    break;
                default:
                    System.out.println("Resultado de longitud estándar.");
                    break;
            }

            // Detecta si el resultado tiene un signo de énfasis (!)
            if (resultado.endsWith("!")) {
                System.out.println("¡Resultado enfatizado!");
            }

            // Separador visual entre partidos
            System.out.println("----------------------");
        }
    }

    // Método para comparar si dos objetos GestorFutbol representan el mismo equipo
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GestorFutbol)) return false;
        GestorFutbol otro = (GestorFutbol) obj;
        return this.equipoNombre.equals(otro.equipoNombre);
    }

    // Crea una copia del objeto actual
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Compara dos objetos GestorFutbol por su nombre de equipo
    @Override
    public int compareTo(GestorFutbol otro) {
        if (this.equipoNombre == null || otro.equipoNombre == null) {
            return Integer.MIN_VALUE;
        }
        return this.equipoNombre.compareTo(otro.equipoNombre);
    }
}
