package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.fabricante;

public final class EntidadDaoExtFabricante extends DAO {

    public void guardarFabricante(fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }

            String sql = "INSERT INTO Fabricante (codigo, nombre)"
                    + "VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public fabricante buscarFabricantePorCodigo(int codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void eliminarFabricante(int cod) throws Exception {
        try {
            String sql = "DELETE FROM Fabricante WHERE codigo = " + cod + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";
            consultarBase(sql);
            fabricante fabricante = null;
            Collection<fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
