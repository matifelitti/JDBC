package tienda;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.producto;
import tienda.servicios.fabricanteServicio;
import tienda.servicios.productoServicio;

public class main {

    public static void main(String[] args) throws Exception {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        fabricanteServicio fs = new fabricanteServicio();
        productoServicio ps = new productoServicio();

        System.out.println("Seleccione una opcion");
        System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto. ");
        System.out.println("2) Lista los nombres y los precios de todos los productos de la tabla producto. ");
        System.out.println("3) Listar aquellos productos que su precio esté entre 120 y 202. ");
        System.out.println("4) Buscar y listar todos los Portátiles de la tabla producto. ");
        System.out.println("5) Listar el nombre y el precio del producto más barato. ");
        System.out.println("6) Ingresar un producto a la base de datos.");
        System.out.println("7) Ingresar un fabricante a la base de datos");
        System.out.println("8) Editar un producto con datos a elección.");

        String opcion = leer.next();
        switch (opcion) {
            case "1":
                // Lista el nombre de todos los productos que hay en la tabla producto.
                for (producto producto1 : (ArrayList<producto>) ps.listarNombreProductos()) {
                    System.out.println(producto1.getNombre());
                }
                break;
            case "2":
                // Lista los nombres y los precios de todos los productos de la tabla producto.
                for (producto producto1 : (ArrayList<producto>) ps.listarNombrePrecioProductos()) {
                    System.out.println(producto1.getNombre());
                    System.out.println(producto1.getPrecio());
                }
                for (producto producto1 : (ArrayList<producto>) ps.listarNombrePrecioProductos()) {
                    System.out.println("nombre = " + producto1.getNombre() + " precio = " + producto1.getPrecio());
                }
                break;
            case "3":
                // 3) Listar aquellos productos que su precio esté entre 120 y 202.
                for (producto producto1 : (ArrayList<producto>) ps.listar120y202()) {
                    System.out.println("nombre = " + producto1.getNombre());
                }

                break;
            case "4":
                // 4) Buscar y listar todos los Portátiles de la tabla producto.;
                for (producto producto1 : (ArrayList<producto>) ps.listarPortatiles()) {
                    System.out.println("nombre = " + producto1.getNombre());
                }

                break;
            case "5":
                // 5) Listar el nombre y el precio del producto más barato.
                for (producto producto1 : (ArrayList<producto>) ps.listarBarato()) {
                    System.out.println("nombre = " + producto1.getNombre() + " precio = " + producto1.getPrecio());
                }

                break;
            case "6":
                // Ingresar un producto a la base de datos.
                System.out.println("Ingrese un producto a la base de datos");
                System.out.println("código, nombre, precio, codigo del fabricante");
                try {
                    ps.crearProducto(leer.nextInt(), leer.next(), leer.nextDouble(), leer.nextInt());
                    ps.imprimirProductos();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case "7":
                // Ingresar un fabricante a la base de datos.
                System.out.println("Ingrese un fabricante a la base de datos");
                System.out.println("código del fabricante, nombre del fabricante");
                try {
                    fs.crearFabricante(leer.nextInt(), leer.next());
                    fs.imprimirFabricantes();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
            case "8":
                // 8) Editar un producto con datos a elección.
                System.out.println("Ingrese código, nombre, precio, codigo del fabricante");
                try {
                    ps.modificarProducto(leer.nextInt(), leer.next(), leer.nextDouble(), leer.nextInt());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error del sistema por \n" + e.getMessage());
                }
                break;
        }

    }

}
