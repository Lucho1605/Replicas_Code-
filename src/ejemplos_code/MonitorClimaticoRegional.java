/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos_code;



/**
 *
 * @author LUIS ALEJANDRO ACUÑA


    /**
     * @param args the command line arguments
     */


import java.util.Scanner;

public class MonitorClimaticoRegional {

    static Scanner entrada = new Scanner(System.in);

    // 1. Generar temperaturas anuales
    public static void generarTemperaturas(double[] temperaturas,
                                           boolean aleatorio,
                                           double minimo,
                                           double maximo) {

        if (aleatorio) {

            for (int i = 0; i < temperaturas.length; i++) {
                temperaturas[i] = minimo
                        + Math.random() * (maximo - minimo);
            }

        } else {

            for (int i = 0; i < temperaturas.length; i++) {
                System.out.print("Temperatura del mes " + (i + 1) + ": ");
                temperaturas[i] = entrada.nextDouble();
            }
        }
    }

    // 2. Calcular promedio
    public static double calcularPromedio(double[] temperaturas) {

        double suma = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i];
        }

        return suma / temperaturas.length;
    }

    // 3. Comparar dos subestaciones
    public static String compararSubestaciones(double[] t1,
                                               double[] t2) {

        double promedio1 = calcularPromedio(t1);
        double promedio2 = calcularPromedio(t2);

        if (promedio1 > promedio2) {
            return "La primera subestacion fue mas calida.";
        } else if (promedio2 > promedio1) {
            return "La segunda subestacion fue mas calida.";
        } else {
            return "Las dos subestaciones tuvieron el mismo promedio.";
        }
    }

    // 4. Detectar anomalías
    public static int[] detectarAnomalias(double[] temperaturas) {

        double promedio = calcularPromedio(temperaturas);

        double limiteInferior = promedio - (promedio * 0.20);
        double limiteSuperior = promedio + (promedio * 0.20);

        // Primero contamos cuántas anomalías existen
        int contador = 0;

        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i] < limiteInferior
                    || temperaturas[i] > limiteSuperior) {

                contador++;
            }
        }

        // Creamos el arreglo con el tamaño exacto
        int[] anomalias = new int[contador];

        int posicion = 0;

        // Guardamos los índices de las anomalías
        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i] < limiteInferior
                    || temperaturas[i] > limiteSuperior) {

                anomalias[posicion] = i;
                posicion++;
            }
        }

        return anomalias;
    }

    // 5. Reporte mensual
    public static void reporteMensual(String nombre,
                                      double[] temperaturas) {

        double promedio = calcularPromedio(temperaturas);

        double mayor = temperaturas[0];
        double menor = temperaturas[0];

        int posicionMayor = 0;
        int posicionMenor = 0;

        // Buscar mayor y menor
        for (int i = 1; i < temperaturas.length; i++) {

            if (temperaturas[i] > mayor) {
                mayor = temperaturas[i];
                posicionMayor = i;
            }

            if (temperaturas[i] < menor) {
                menor = temperaturas[i];
                posicionMenor = i;
            }
        }

        System.out.println("\n==================================");
        System.out.println("REPORTE DE " + nombre.toUpperCase());
        System.out.println("==================================");

        // Mostrar todos los meses
        for (int i = 0; i < temperaturas.length; i++) {

            System.out.printf(
                    "Mes %2d: %.2f °C%n",
                    (i + 1),
                    temperaturas[i]
            );
        }

        System.out.printf(
                "Promedio anual: %.2f °C%n",
                promedio
        );

        System.out.printf(
                "Mayor temperatura: %.2f °C - Mes %d%n",
                mayor,
                (posicionMayor + 1)
        );

        System.out.printf(
                "Menor temperatura: %.2f °C - Mes %d%n",
                menor,
                (posicionMenor + 1)
        );

        // Detectar anomalías
        int[] anomalias = detectarAnomalias(temperaturas);

        System.out.print("Meses con anomalias: ");

        if (anomalias.length == 0) {

            System.out.println("Ninguna");

        } else {

            for (int i = 0; i < anomalias.length; i++) {
                System.out.print((anomalias[i] + 1) + " ");
            }

            System.out.println();
        }
    }

    // 6. Método principal
    public static void main(String[] args) {

        // Arreglos de las tres subestaciones
        double[] rivera = new double[12];
        double[] neiva = new double[12];
        double[] campoalegre = new double[12];

        // Límites de temperatura
        double minimo = 20;
        double maximo = 40;

        // true = aleatorio
        // false = manual
        boolean aleatorio = true;

        // Generar temperaturas
        generarTemperaturas(
                rivera,
                aleatorio,
                minimo,
                maximo
        );

        generarTemperaturas(
                neiva,
                aleatorio,
                minimo,
                maximo
        );

        generarTemperaturas(
                campoalegre,
                aleatorio,
                minimo,
                maximo
        );

        // Mostrar reportes
        reporteMensual("Rivera", rivera);
        reporteMensual("Neiva", neiva);
        reporteMensual("Campoalegre", campoalegre);

        // Promedios
        double promedioRivera = calcularPromedio(rivera);
        double promedioNeiva = calcularPromedio(neiva);
        double promedioCampoalegre = calcularPromedio(campoalegre);

        System.out.println("\n==================================");
        System.out.println("COMPARACION GENERAL");
        System.out.println("==================================");

        System.out.printf(
                "Promedio Rivera: %.2f °C%n",
                promedioRivera
        );

        System.out.printf(
                "Promedio Neiva: %.2f °C%n",
                promedioNeiva
        );

        System.out.printf(
                "Promedio Campoalegre: %.2f °C%n",
                promedioCampoalegre
        );

        // Comparaciones
        System.out.println("\nComparaciones:");

        System.out.println(
                "Rivera vs Neiva: "
                + compararSubestaciones(rivera, neiva)
        );

        System.out.println(
                "Rivera vs Campoalegre: "
                + compararSubestaciones(rivera, campoalegre)
        );

        System.out.println(
                "Neiva vs Campoalegre: "
                + compararSubestaciones(neiva, campoalegre)
        );

        // Determinar la subestación con mayor promedio
        System.out.println("\nSubestacion con mayor promedio:");

        if (promedioRivera > promedioNeiva
                && promedioRivera > promedioCampoalegre) {

            System.out.println("Rivera");

        } else if (promedioNeiva > promedioRivera
                && promedioNeiva > promedioCampoalegre) {

            System.out.println("Neiva");

        } else if (promedioCampoalegre > promedioRivera
                && promedioCampoalegre > promedioNeiva) {

            System.out.println("Campoalegre");

        } else {

            System.out.println(
                    "Hay empate entre algunas subestaciones."
            );
        }
    }
}