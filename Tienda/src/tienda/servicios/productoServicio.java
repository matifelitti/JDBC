package tienda.servicios;

import java.util.Collection;
import tienda.entidades.producto;
import tienda.persistencia.EntidadDaoExtProducto;

public class productoServicio {

    private EntidadDaoExtProducto dao;

    public productoServicio() {
        this.dao = new EntidadDaoExtProducto();
    }

    public void crearProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }

            //Creamos el prodcuto
            producto producto = new producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(int codigo, String nombre, Double precio, int codigofabricante) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (codigofabricante < 0) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }

            //Buscamos
            producto producto = buscarProductoPorCodigo(codigo);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigofabricante);
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se encontró el producto para el código indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int cod) throws Exception {

        try {

            //Validamos 
            if (cod < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarProducto(cod);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<producto> listarNombreProductos() throws Exception {

        try {

            Collection<producto> productos = dao.listarNombreProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<producto> listarNombrePrecioProductos() throws Exception {

        try {

            Collection<producto> productos = dao.listarNombrePrecioProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<producto> listar120y202() throws Exception {

        try {

            Collection<producto> prod = dao.listar120y202();

            return prod;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<producto> listarPortatiles() throws Exception {

        try {

            Collection<producto> produc = dao.listarPortatiles();

            return produc;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<producto> listarBarato() throws Exception {

        try {

            Collection<producto> pr = dao.listarBarato();

            return pr;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los productos
            Collection<producto> productos = dao.listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (producto p : productos) {
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
