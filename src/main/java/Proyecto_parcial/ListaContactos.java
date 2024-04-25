/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Proyecto_parcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaContactos {
    private static ArrayList<Contacto> listaContactos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("*** Zona Virtual S.A. ****");
            System.out.println("*** Aplicación de Lista de Contactos ****");
            System.out.println("1. Agregar un Nuevo Contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja a partir de los nombres");
            System.out.println("5. Ordenar por Inserción a partir de los números Telefónicos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    
                    agregarContacto();
                    break;
                case 2:
                    mostrarListaContactos();
                    break;
                case 3:
                    buscarContactoPorNombre();
                    break;
                case 4:
                    ordenarPorBurbuja();
                    break;
                case 5:
                    ordenarPorInsercion();
                    break;
                case 6:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 6);
        sc.close();
    }

    private static void agregarContacto() {
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el número de teléfono del contacto: ");
        int numeroTelefono = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea después de nextInt()

        Contacto nuevoContacto = new Contacto(nombre, numeroTelefono);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado exitosamente.");
    }

    private static void mostrarListaContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía.");
        } else {
            System.out.println("Lista de Contactos:\n");
            for (int i = 0; i < listaContactos.size(); i++) {
                Contacto contacto = listaContactos.get(i);
                System.out.println((i + 1) + ". Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getNumeroTelefono());
            }
        }
    }

             private static void buscarContactoPorNombre() {
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombreABuscar = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listaContactos.size(); i++) {
            if (listaContactos.get(i).getNombre().equalsIgnoreCase(nombreABuscar)) {
                System.out.println("Contacto encontrado en la posición " + (i + 1) + ".");
                System.out.println("Nombre: " + listaContactos.get(i).getNombre() + ", Teléfono: " + listaContactos.get(i).getNumeroTelefono());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se encuentra en la lista.");
        }
    }
             private static void ordenarPorBurbuja() {
        Collections.sort(listaContactos, Comparator.comparing(Contacto::getNombre));
        System.out.println("Lista de contactos ordenada por nombre:");
        mostrarListaContactos();
    }
       
       
            
        
    
    
        private static void ordenarPorInsercion() {
       
        for (int i = 1; i < listaContactos.size(); i++) {
            Contacto clave = listaContactos.get(i);
            int j = i - 1;
            while (j >= 0 && listaContactos.get(j).getNumeroTelefono() > clave.getNumeroTelefono()) {
                listaContactos.set(j + 1, listaContactos.get(j));
                j = j - 1;
            }
            listaContactos.set(j + 1, clave);
        }
        System.out.println("Lista de contactos ordenada por número de teléfono:");
        mostrarListaContactos();
    }
}




              
              
              
              
            
            
             
              


        
