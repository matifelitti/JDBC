package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.producto;

public final class EntidadDaoExtProducto extends DAO {

    public void guardarProducto(producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el mascota");
            }
            String sql = "INSERT INTO Producto (codigo, nombre, precio, codigo_fabricante) "
                    + "VALUES ( " + producto.getCodigo() + " , '" + producto.getNombre() + "' ,"
                    + producto.getPrecio() + " , " + producto.getCodigoFabricante() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto a modificar");
            }
            String sql = "UPDATE Producto SET "
                    + " nombre = '" + producto.getNombre() + "' , precio = "
                    + producto.getPrecio() + " , codigo_fabricante = " + producto.getCodigoFabricante() 
                    + " WHERE codigo = " + producto.getCodigo();

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo + "";
            consultarBase(sql);
            producto producto = null;
            while (resultado.next()) {
                producto = new producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void eliminarProducto(int cod) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE codigo = " + cod + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";
            consultarBase(sql);
            producto producto = null;
            Collection<producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<producto> listarNombreProductos() throws Exception {
        try {
            String sql = "SELECT Nombre FROM Producto ";
            consultarBase(sql);
            producto producto = null;
            Collection<producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<producto> listarNombrePrecioProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";
            consultarBase(sql);
            producto product = null;
            Collection<producto> productos = new ArrayList();
            while (resultado.next()) {
                product = new producto();
                product.setNombre(resultado.getString(2));
                product.setPrecio(resultado.getDouble(3));
                productos.add(product);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<producto> listar120y202() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio >= 120 and precio <= 202 order by precio";
            consultarBase(sql);
            producto pro = null;
            Collection<producto> prod = new ArrayList();
            while (resultado.next()) {
                pro = new producto();
                pro.setCodigo(resultado.getInt(1));
                pro.setNombre(resultado.getString(2));
                pro.setPrecio(resultado.getDouble(3));
                pro.setCodigoFabricante(resultado.getInt(4));
                prod.add(pro);
            }
            desconectarBase();
            return prod;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre like 'portatil%'";
            consultarBase(sql);
            producto produ = null;
            Collection<producto> produc = new ArrayList();
            while (resultado.next()) {
                produ = new producto();
                produ.setCodigo(resultado.getInt(1));
                produ.setNombre(resultado.getString(2));
                produ.setPrecio(resultado.getDouble(3));
                produ.setCodigoFabricante(resultado.getInt(4));
                produc.add(produ);
            }
            desconectarBase();
            return produc;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<producto> listarBarato() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio = (select min(precio) from producto)";
            consultarBase(sql);
            producto p = null;
            Collection<producto> pr = new ArrayList();
            while (resultado.next()) {
                p = new producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                pr.add(p);
            }
            desconectarBase();
            return pr;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

}
