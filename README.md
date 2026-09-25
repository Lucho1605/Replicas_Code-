# 🌡️ MONITOR CLIMÁTICO REGIONAL

## 1. DESCRIPCIÓN DEL PROYECTO

Este proyecto consiste en desarrollar un programa en Java para una estación meteorológica central del departamento del Huila.

La estación recibe datos de temperatura promedio mensual de tres subestaciones:

- Rivera
- Neiva
- Campoalegre

Cada subestación registra una temperatura por cada mes del año, por lo que se utilizan tres arreglos de 12 posiciones.

El programa permite:

- Generar temperaturas de forma aleatoria o manual.
- Calcular el promedio anual.
- Comparar el comportamiento climático entre subestaciones.
- Detectar anomalías térmicas.
- Encontrar la temperatura máxima y mínima.
- Mostrar un reporte mensual.

---

## 2. ANÁLISIS DEL PROBLEMA

Antes de comenzar a programar, se debe leer el enunciado y separar el problema en partes.

Tenemos tres subestaciones:

- Rivera
- Neiva
- Campoalegre

Cada una tiene 12 temperaturas correspondientes a los 12 meses del año.

Por esta razón se necesitan tres arreglos de tipo double:

    double[] rivera = new double[12];
    double[] neiva = new double[12];
    double[] campoalegre = new double[12];

Estos arreglos deben declararse dentro del método main porque el enunciado indica específicamente que allí se deben declarar.

---

## 3. IMPORTAR SCANNER

Para recibir información del usuario mediante el teclado se utiliza Scanner.

    import java.util.Scanner;

Después se crea un objeto Scanner:

    static Scanner sc = new Scanner(System.in);

Este objeto permite leer datos introducidos por el usuario.

Para leer números enteros se utiliza:

    sc.nextInt();

Para leer números decimales se utiliza:

    sc.nextDouble();

---

## 4. CREAR LA CLASE

La clase principal debe llamarse:

    public class MonitorClimaticoRegional {

Todo el programa se encuentra dentro de esta clase.

La estructura general es:

    import java.util.Scanner;

    public class MonitorClimaticoRegional {

        // Métodos

        public static void main(String[] args) {

            // Código principal

        }
    }

---

## 5. DECLARAR LOS ARREGLOS

Dentro del método main se declaran los tres arreglos:

    double[] rivera = new double[12];
    double[] neiva = new double[12];
    double[] campoalegre = new double[12];

Por ejemplo:

    double[] rivera = new double[12];

significa:

- double[] indica que es un arreglo de números decimales.
- rivera es el nombre del arreglo.
- new double[12] crea 12 posiciones.

Los índices de un arreglo en Java comienzan en 0:

    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11

Aunque existen 12 posiciones, la última posición es la número 11 porque Java comienza a contar desde 0.

---

## 6. PEDIR TEMPERATURA MÍNIMA Y MÁXIMA

El programa debe pedir los valores mínimo y máximo permitidos.

    System.out.print("Ingrese la temperatura mínima permitida: ");
    double minimo = sc.nextDouble();

    System.out.print("Ingrese la temperatura máxima permitida: ");
    double maximo = sc.nextDouble();

Por ejemplo, el usuario podría escribir:

    Mínima: 15
    Máxima: 40

Esto significa que las temperaturas generadas aleatoriamente estarán entre 15 °C y 40 °C.

---

## 7. ELEGIR CÓMO GENERAR LAS TEMPERATURAS

El enunciado indica que las temperaturas pueden generarse de dos formas:

1. Aleatoriamente.
2. Manualmente.

Para esto se muestra un menú:

    System.out.println("¿Cómo desea ingresar las temperaturas?");
    System.out.println("1. Aleatoriamente");
    System.out.println("2. Manualmente");

    int opcion = sc.nextInt();

Después se convierte la opción en un valor booleano:

    boolean aleatorio = opcion == 1;

Si el usuario escribe 1:

    aleatorio = true;

Si el usuario escribe 2:

    aleatorio = false;

---

## 8. MÉTODO generarTemperaturas

Este método se encarga de llenar un arreglo con las 12 temperaturas.

    public static void generarTemperaturas(double[] temperaturas, boolean aleatorio, double minimo, double maximo) {

        if (aleatorio) {

            for (int i = 0; i < temperaturas.length; i++) {
                temperaturas[i] = minimo + Math.random() * (maximo - minimo);
            }

        } else {

            for (int i = 0; i < temperaturas.length; i++) {
                System.out.print("Ingrese la temperatura del mes " + (i + 1) + ": ");
                temperaturas[i] = sc.nextDouble();
            }
        }
    }

El método recibe cuatro parámetros:

double[] temperaturas:
Es el arreglo que se va a llenar.

boolean aleatorio:
Indica si los datos serán aleatorios o manuales.

double minimo:
Es la temperatura mínima permitida.

double maximo:
Es la temperatura máxima permitida.

---

## 9. GENERACIÓN ALEATORIA

Cuando:

    aleatorio == true

se ejecuta:

    for (int i = 0; i < temperaturas.length; i++) {
        temperaturas[i] = minimo + Math.random() * (maximo - minimo);
    }

El for recorre las 12 posiciones del arreglo.

La fórmula:

    minimo + Math.random() * (maximo - minimo)

genera un número aleatorio entre el mínimo y el máximo.

Por ejemplo:

    18.52
    23.74
    31.25
    27.89

---

## 10. GENERACIÓN MANUAL

Cuando:

    aleatorio == false

se ejecuta:

    for (int i = 0; i < temperaturas.length; i++) {
        System.out.print("Ingrese la temperatura del mes " + (i + 1) + ": ");
        temperaturas[i] = sc.nextDouble();
    }

El usuario debe ingresar las 12 temperaturas manualmente.

Cada temperatura queda almacenada en una posición diferente del arreglo.

---

## 11. LLENAR LOS TRES ARREGLOS

Después de elegir la forma de generación se llama al método tres veces:

    generarTemperaturas(rivera, aleatorio, minimo, maximo);
    generarTemperaturas(neiva, aleatorio, minimo, maximo);
    generarTemperaturas(campoalegre, aleatorio, minimo, maximo);

La primera llamada llena Rivera.

La segunda llamada llena Neiva.

La tercera llamada llena Campoalegre.

La estructura mental es:

    generarTemperaturas(arreglo, opción, mínimo, máximo);

---

## 12. MÉTODO calcularPromedio

Para calcular el promedio anual se utiliza:

    public static double calcularPromedio(double[] temperaturas) {

        double suma = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i];
        }

        return suma / temperaturas.length;
    }

Primero se crea una variable acumuladora:

    double suma = 0;

Después se recorren todas las posiciones:

    for (int i = 0; i < temperaturas.length; i++) {
        suma += temperaturas[i];
    }

La instrucción:

    suma += temperaturas[i];

es equivalente a:

    suma = suma + temperaturas[i];

Finalmente:

    return suma / temperaturas.length;

divide la suma entre la cantidad de temperaturas y devuelve el promedio.

La fórmula es:

    Promedio = suma de temperaturas / cantidad de temperaturas

---

## 13. MÉTODO compararSubestaciones

Este método compara dos subestaciones utilizando el promedio anual.

    public static String compararSubestaciones(double[] t1, double[] t2) {

        double promedio1 = calcularPromedio(t1);
        double promedio2 = calcularPromedio(t2);

        if (promedio1 > promedio2) {
            return "La primera subestación fue más cálida.";
        } else if (promedio2 > promedio1) {
            return "La segunda subestación fue más cálida.";
        } else {
            return "Las dos subestaciones tuvieron el mismo promedio.";
        }
    }

Primero se calcula el promedio de cada arreglo:

    double promedio1 = calcularPromedio(t1);
    double promedio2 = calcularPromedio(t2);

Después se comparan utilizando if.

Si:

    promedio1 > promedio2

la primera subestación fue más cálida.

Si:

    promedio2 > promedio1

la segunda subestación fue más cálida.

Si los dos promedios son iguales:

    return "Las dos subestaciones tuvieron el mismo promedio.";

---

## 14. MÉTODO detectarAnomalias

El enunciado establece que una anomalía térmica se presenta cuando la temperatura de un mes está +/- 20% del promedio anual.

El método es:

    public static int[] detectarAnomalias(double[] temperaturas) {

        double promedio = calcularPromedio(temperaturas);

        int cantidad = 0;

        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i] > promedio * 1.20 ||
                temperaturas[i] < promedio * 0.80) {

                cantidad++;
            }
        }

        int[] indices = new int[cantidad];

        int posicion = 0;

        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i] > promedio * 1.20 ||
                temperaturas[i] < promedio * 0.80) {

                indices[posicion] = i;
                posicion++;
            }
        }

        return indices;
    }

---

## 15. CÁLCULO DEL 20%

Supongamos que el promedio anual es:

    30 °C

Calculamos el 20%:

    30 × 0.20 = 6

Entonces:

    30 + 6 = 36

y:

    30 - 6 = 24

Por lo tanto, serían anomalías las temperaturas:

    Mayores que 36 °C

o:

    Menores que 24 °C

En Java se representa como:

    temperaturas[i] > promedio * 1.20

o:

    temperaturas[i] < promedio * 0.80

---

## 16. ¿POR QUÉ SE UTILIZAN DOS FOR EN detectarAnomalias?

El primer for cuenta cuántas anomalías existen:

    int cantidad = 0;

    for (int i = 0; i < temperaturas.length; i++) {

        if (temperaturas[i] > promedio * 1.20 ||
            temperaturas[i] < promedio * 0.80) {

            cantidad++;
        }
    }

Después se crea un arreglo con exactamente esa cantidad de posiciones:

    int[] indices = new int[cantidad];

Luego se vuelve a recorrer el arreglo para guardar los índices de las anomalías:

    indices[posicion] = i;

Finalmente:

    return indices;

devuelve el arreglo con las posiciones donde se encontraron anomalías.

---

## 17. MÉTODO reporteMensual

Este método muestra el resumen de una subestación.

    public static void reporteMensual(String nombre, double[] temperaturas) {

        System.out.println("\n===== REPORTE DE " + nombre.toUpperCase() + " =====");

        double promedio = calcularPromedio(temperaturas);

        double mayor = temperaturas[0];
        double menor = temperaturas[0];

        int mesMayor = 0;
        int mesMenor = 0;

        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturas[i] > mayor) {
                mayor = temperaturas[i];
                mesMayor = i;
            }

            if (temperaturas[i] < menor) {
                menor = temperaturas[i];
                mesMenor = i;
            }
        }

        System.out.println("Temperaturas registradas:");

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.printf("Mes %d: %.2f °C%n", i + 1, temperaturas[i]);
        }

        System.out.printf("Promedio anual: %.2f °C%n", promedio);
        System.out.printf("Temperatura máxima: %.2f °C - Mes %d%n", mayor, mesMayor + 1);
        System.out.printf("Temperatura mínima: %.2f °C - Mes %d%n", menor, mesMenor + 1);
    }

---

## 18. BUSCAR LA TEMPERATURA MÁXIMA

Primero se toma la primera temperatura como referencia:

    double mayor = temperaturas[0];

Después se recorre el arreglo:

    for (int i = 0; i < temperaturas.length; i++) {

        if (temperaturas[i] > mayor) {
            mayor = temperaturas[i];
            mesMayor = i;
        }
    }

Si encontramos una temperatura mayor, se reemplaza el valor anterior.

La variable:

    mesMayor

guarda el índice donde se encuentra la temperatura máxima.

---

## 19. BUSCAR LA TEMPERATURA MÍNIMA

Se realiza el mismo procedimiento para encontrar la temperatura menor.

Primero:

    double menor = temperaturas[0];

Después:

    if (temperaturas[i] < menor) {
        menor = temperaturas[i];
        mesMenor = i;
    }

La variable:

    mesMenor

guarda el índice donde se encuentra la temperatura mínima.

---

## 20. ¿POR QUÉ SE UTILIZA +1 PARA EL MES?

Java comienza los arreglos desde la posición 0.

Por ejemplo:

    Índice 0 → Mes 1
    Índice 1 → Mes 2
    Índice 2 → Mes 3

Por eso al mostrar el resultado se utiliza:

    mesMayor + 1

y:

    mesMenor + 1

Esto permite mostrar al usuario los meses comenzando desde 1.

---

## 21. MÉTODO MAIN

El método main es el punto donde comienza la ejecución del programa.

El orden de ejecución es:

    1. Crear los arreglos.
    2. Pedir mínimo y máximo.
    3. Preguntar si los datos serán aleatorios o manuales.
    4. Llenar los tres arreglos.
    5. Mostrar los reportes.
    6. Comparar las subestaciones.
    7. Detectar anomalías.
    8. Mostrar los resultados.

---

## 22. CÓDIGO COMPLETO

    import java.util.Scanner;

    public class MonitorClimaticoRegional {

        static Scanner sc = new Scanner(System.in);

        public static void generarTemperaturas(double[] temperaturas, boolean aleatorio, double minimo, double maximo) {

            if (aleatorio) {

                for (int i = 0; i < temperaturas.length; i++) {
                    temperaturas[i] = minimo + Math.random() * (maximo - minimo);
                }

            } else {

                for (int i = 0; i < temperaturas.length; i++) {
                    System.out.print("Ingrese la temperatura del mes " + (i + 1) + ": ");
                    temperaturas[i] = sc.nextDouble();
                }
            }
        }

        public static double calcularPromedio(double[] temperaturas) {

            double suma = 0;

            for (int i = 0; i < temperaturas.length; i++) {
                suma += temperaturas[i];
            }

            return suma / temperaturas.length;
        }

        public static String compararSubestaciones(double[] t1, double[] t2) {

            double promedio1 = calcularPromedio(t1);
            double promedio2 = calcularPromedio(t2);

            if (promedio1 > promedio2) {
                return "La primera subestación fue más cálida.";
            } else if (promedio2 > promedio1) {
                return "La segunda subestación fue más cálida.";
            } else {
                return "Las dos subestaciones tuvieron el mismo promedio.";
            }
        }

        public static int[] detectarAnomalias(double[] temperaturas) {

            double promedio = calcularPromedio(temperaturas);

            int cantidad = 0;

            for (int i = 0; i < temperaturas.length; i++) {

                if (temperaturas[i] > promedio * 1.20 ||
                    temperaturas[i] < promedio * 0.80) {

                    cantidad++;
                }
            }

            int[] indices = new int[cantidad];

            int posicion = 0;

            for (int i = 0; i < temperaturas.length; i++) {

                if (temperaturas[i] > promedio * 1.20 ||
                    temperaturas[i] < promedio * 0.80) {

                    indices[posicion] = i;
                    posicion++;
                }
            }

            return indices;
        }

        public static void reporteMensual(String nombre, double[] temperaturas) {

            System.out.println("\n===== REPORTE DE " + nombre.toUpperCase() + " =====");

            double promedio = calcularPromedio(temperaturas);

            double mayor = temperaturas[0];
            double menor = temperaturas[0];

            int mesMayor = 0;
            int mesMenor = 0;

            for (int i = 0; i < temperaturas.length; i++) {

                if (temperaturas[i] > mayor) {
                    mayor = temperaturas[i];
                    mesMayor = i;
                }

                if (temperaturas[i] < menor) {
                    menor = temperaturas[i];
                    mesMenor = i;
                }
            }

            System.out.println("Temperaturas registradas:");

            for (int i = 0; i < temperaturas.length; i++) {
                System.out.printf("Mes %d: %.2f °C%n", i + 1, temperaturas[i]);
            }

            System.out.printf("Promedio anual: %.2f °C%n", promedio);
            System.out.printf("Temperatura máxima: %.2f °C - Mes %d%n", mayor, mesMayor + 1);
            System.out.printf("Temperatura mínima: %.2f °C - Mes %d%n", menor, mesMenor + 1);
        }

        public static void main(String[] args) {

            // 1. Declarar los tres arreglos
            double[] rivera = new double[12];
            double[] neiva = new double[12];
            double[] campoalegre = new double[12];

            // 2. Pedir temperatura mínima y máxima
            System.out.print("Ingrese la temperatura mínima permitida: ");
            double minimo = sc.nextDouble();

            System.out.print("Ingrese la temperatura máxima permitida: ");
            double maximo = sc.nextDouble();

            // 3. Elegir generación de datos
            System.out.println("\n¿Cómo desea ingresar las temperaturas?");
            System.out.println("1. Aleatoriamente");
            System.out.println("2. Manualmente");

            int opcion = sc.nextInt();

            boolean aleatorio = opcion == 1;

            // 4. Llenar los tres arreglos
            generarTemperaturas(rivera, aleatorio, minimo, maximo);
            generarTemperaturas(neiva, aleatorio, minimo, maximo);
            generarTemperaturas(campoalegre, aleatorio, minimo, maximo);

            // 5. Mostrar reportes
            reporteMensual("Rivera", rivera);
            reporteMensual("Neiva", neiva);
            reporteMensual("Campoalegre", campoalegre);

            // 6. Comparar subestaciones
            System.out.println("\n===== COMPARACIONES =====");

            System.out.println("Rivera vs Neiva:");
            System.out.println(compararSubestaciones(rivera, neiva));

            System.out.println("Rivera vs Campoalegre:");
            System.out.println(compararSubestaciones(rivera, campoalegre));

            System.out.println("Neiva vs Campoalegre:");
            System.out.println(compararSubestaciones(neiva, campoalegre));

            // 7. Detectar anomalías
            System.out.println("\n===== ANOMALÍAS =====");

            int[] anomaliasRivera = detectarAnomalias(rivera);
            int[] anomaliasNeiva = detectarAnomalias(neiva);
            int[] anomaliasCampoalegre = detectarAnomalias(campoalegre);

            System.out.println("Anomalías Rivera:");

            for (int i = 0; i < anomaliasRivera.length; i++) {
                System.out.println("Mes " + (anomaliasRivera[i] + 1));
            }

            System.out.println("Anomalías Neiva:");

            for (int i = 0; i < anomaliasNeiva.length; i++) {
                System.out.println("Mes " + (anomaliasNeiva[i] + 1));
            }

            System.out.println("Anomalías Campoalegre:");

            for (int i = 0; i < anomaliasCampoalegre.length; i++) {
                System.out.println("Mes " + (anomaliasCampoalegre[i] + 1));
            }
        }
    }

---

# 23. ORDEN MENTAL PARA RESOLVER UN PARCIAL PARECIDO

Cuando el profesor entregue un ejercicio, seguir este orden:

    1. Leer el enunciado.
    2. Identificar los datos.
    3. Identificar cuántos arreglos se necesitan.
    4. Crear los arreglos dentro de main.
    5. Identificar los métodos que pide el ejercicio.
    6. Crear cada método.
    7. Utilizar for para recorrer los arreglos.
    8. Utilizar if para tomar decisiones.
    9. Realizar las operaciones.
    10. Utilizar return si el método debe devolver un resultado.
    11. Llamar los métodos desde main.
    12. Mostrar los resultados.

---

# 24. CONCEPTOS IMPORTANTES PARA RECORDAR

## Arreglo

Sirve para almacenar varios valores:

    double[] temperaturas = new double[12];

## For

Sirve para recorrer un arreglo:

    for (int i = 0; i < temperaturas.length; i++) {

    }

## If

Sirve para tomar decisiones:

    if (temperaturas[i] > mayor) {

    }

## Variable acumuladora

Sirve para ir acumulando valores:

    double suma = 0;

    suma += temperaturas[i];

## Método void

Realiza una acción pero no devuelve un resultado:

    public static void generarTemperaturas() {

    }

## Método con return

Realiza una operación y devuelve un resultado:

    public static double calcularPromedio(double[] temperaturas) {

        return resultado;
    }

## Llamar un método

Para ejecutar un método se escribe su nombre y se pasan los argumentos:

    calcularPromedio(rivera);

Si devuelve un valor:

    double promedio = calcularPromedio(rivera);

---

# 25. REGLA MENTAL PARA EL PARCIAL

La forma más sencilla de pensar un problema de este tipo es:

    ENUNCIADO
        ↓
    DATOS
        ↓
    ARREGLOS
        ↓
    FOR
        ↓
    IF
        ↓
    OPERACIÓN
        ↓
    RETURN
        ↓
    RESULTADO

Cuando leas un ejercicio, pregúntate:

    ¿Qué datos tengo?

    ¿Dónde los voy a guardar?

    ¿Necesito un arreglo?

    ¿Cuántas posiciones necesito?

    ¿Necesito recorrer el arreglo?

    ¿Entonces necesito un FOR?

    ¿Tengo que comparar valores?

    ¿Entonces necesito un IF?

    ¿Tengo que sumar o acumular?

    ¿Necesito una variable como suma?

    ¿El método tiene que devolver algo?

    ¿Entonces necesito RETURN?

    ¿Dónde debo llamar el método?

La idea principal es convertir el enunciado escrito en palabras en pequeñas operaciones de programación.
