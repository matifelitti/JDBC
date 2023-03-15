package estancias;

import estancias.entidades.casas;
import estancias.servicios.casasServicio;
import estancias.servicios.familiasServicio;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        casasServicio cs = new casasServicio();
        familiasServicio fs = new familiasServicio();

        System.out.println("Seleccione una opcion");
        System.out.println("1) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
        System.out.println("2) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.");
        System.out.println("3) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail");
        System.out.println("4) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico");
        System.out.println("5) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron");
        System.out.println("6) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior");
        System.out.println("7) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.");
        System.out.println("8) Obtener el número de casas que existen para cada uno de los países diferentes");
        System.out.println("9) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.");
        System.out.println("10) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.");


        
        
        // 8
        // for (casas c : (ArrayList<casas>) cs.listarCasas()) {
        //    System.out.println("id_casa = " + c.getId_casa() + " calle = " + c.getCalle() + " número = " + c.getNumero() + " codigo_postal = " + c.getCodigo_postal()
        //    + " ciudad = " + c.getCiudad() + " pais = " + c.getPais() + " fecha_desde = " + c.getFecha_desde() + " fecha_hasta = " + c.getFecha_hasta() + " tiempo_mínimo = " + c.getTiempo_minimo()
        //    + " tiempo_máximo = " + c.getTiempo_maximo() + " precio_habitacion = " + c.getPrecio_habitacion() + " tipo_vivienda = " + c.getTipo_vivienda());
        // }
        // System.out.println(cs.listarCasas());

    }

}
