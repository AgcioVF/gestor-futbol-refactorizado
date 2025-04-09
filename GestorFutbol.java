package practica_refactorizacion_casa;

import java.math.BigDecimal;
import java.util.*;

public class GestorFutbol implements Comparable<GestorFutbol> {

    // Atributos del equipo
    private String equipoNombre;       // Nombre del equipo
    private int puntos;                // Puntos acumulados por el equipo

    // Logger
    private static final Logger logger = Logger.getLogger(GestorFutbol.class.getName());

    // Variable estática para contar los partidos jugados en total

    // Constantes para los nombres de equipos conocidos

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

        // Se crea un objeto para representar el presupuesto del equipo

        // Verificación de si hay resultados y salida del programa si se cumple
        if (resultadosTemporada != null && !resultadosTemporada.isEmpty()) {
            System.exit(1);
        }

        // Se crea otro equipo para comparar con el principal
        GestorFutbol otroEquipo = new GestorFutbol("Real Madrid");

        // Comparación entre dos equipos (por nombre)
        logger.info("Comparación entre equipos: " + equipoPrincipal.compareTo(otroEquipo));
    }

    // Constructor que inicializa el equipo con su nombre y puntos en 0
    public GestorFutbol(String nombreEquipo) {
        this.equipoNombre = nombreEquipo;
        this.puntos = 0;
    }

    public GestorFutbol(GestorFutbol otro) {
        this.equipoNombre = otro.nombreEquipo;
        this.puntos = otro.puntos;
    }

    private void procesarPuntos(String resultado) {
        if (resultado.equals("victoria")) {
            puntos += 3;
            logger.info("Victoria. Puntos acumulados: " + puntos);
        } else if (resultado.equals("empate")) {
            puntos += 1;
            logger.info("Empate. Puntos acumulados: " + puntos);
        } else if (resultado.equals("derrota")) {
            logger.info("Derrota. Puntos acumulados: " + puntos);
        }
    }

    private void procesarLocalizacion(String resultado) {
        if (resultado.contains("local")) {
            logger.info("Jugado como local.");
            if (resultado.length() > 10) {
                logger.info("Detalle adicional: " + resultado);
            }
        } else if (resultado.contains("visitante")) {
            logger.info("Jugado como visitante.");
            if (resultado.length() > 8) {
                logger.info("Comentario: " + resultado);
            }
        }
    }

    private void clasificarPorLongitud(String resultado) {
        switch (resultado.length()) {
            case 7:
                logger.info("Resultado corto.");
                break;
            case 14:
                logger.info("Resultado medio.");
                break;
            default:
                logger.info("Resultado de longitud estándar.");
                break;
        }
    }

    private void detectarEnfasis(String resultado) {
        if (resultado.endsWith("!")) {
            logger.info("¡Resultado enfatizado!");
        }
    }

    // Procesa la lista de resultados y actualiza los puntos del equipo
    public void procesarTemporada(List<String> resultados) {
        for (String resultado : resultados) {
            procesarPuntos(resultado);
            procesarLocalizacion(resultado);
            clasificarPorLongitud(resultado);
            detectarEnfasis(resultado);

            logger.info("----------------------");
        }
    }


    // Método para comparar si dos objetos GestorFutbol representan el mismo equipo
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GestorFutbol)) return false;
        GestorFutbol otro = (GestorFutbol) obj;
        return this.equipoNombre.equals(otro.equipoNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipoNombre);
    }

    // Compara dos objetos GestorFutbol por su nombre de equipo
    @Override
    public int compareTo(GestorFutbol otro) {
        if (this.equipoNombre == null || otro.equipoNombre == null) {
            return -1;
        }
        return this.equipoNombre.compareTo(otro.equipoNombre);
    }
}
