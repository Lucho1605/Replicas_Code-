
package ejemplos_code;

import java.util.Scanner;

/**
 *
 * @author LUIS ALEJANDRO ACUÑA
 */
public class Arreglos {
    public static void main(String[] args) {
        int[] myarray=obtenerarray();
        for (int i=0;i<myarray.length;i++){
            System.out.println(myarray[i]);
        }
    }
    public static int[] obtenerarray (){
        int[] numeros={1,2,3};
        return numeros;
    }
}