package estancias.persistencia;

import estancias.entidades.casas;
import java.util.ArrayList;
import java.util.Collection;

public final class EntidadDaoExtCasas extends DAO {

    public casas buscarCasaPorId(int id_casa) throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE id_casa = " + id_casa + "";
            consultarBase(sql);
            casas c = null;
            while (resultado.next()) {
                c = new casas();
                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_minimo(resultado.getInt(9));
                c.setTiempo_maximo(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
            }
            desconectarBase();
            return c;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<casas> listarCasas() throws Exception {
        try {
            String sql = "SELECT * FROM casas ";
            consultarBase(sql);
            casas ca = null;
            Collection<casas> cas = new ArrayList();
            while (resultado.next()) {
                ca = new casas();
                ca.setId_casa(resultado.getInt(1));
                ca.setCalle(resultado.getString(2));
                ca.setNumero(resultado.getInt(3));
                ca.setCodigo_postal(resultado.getString(4));
                ca.setCiudad(resultado.getString(5));
                ca.setPais(resultado.getString(6));
                ca.setFecha_desde(resultado.getDate(7));
                ca.setFecha_hasta(resultado.getDate(8));
                ca.setTiempo_minimo(resultado.getInt(9));
                ca.setTiempo_maximo(resultado.getInt(10));
                ca.setPrecio_habitacion(resultado.getDouble(11));
                ca.setTipo_vivienda(resultado.getString(12));
                cas.add(ca);
            }
            desconectarBase();
            return cas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<casas> listarCasasPorPais() throws Exception {
        try {
            String sql = "SELECT count(pais) as num_casas, pais from casas group by pais ";
            consultarBase(sql);
            casas c = null;
            Collection<casas> casa = new ArrayList();
            while (resultado.next()) {
                c = new casas();
                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_minimo(resultado.getInt(9));
                c.setTiempo_maximo(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
                casa.add(c);
            }
            desconectarBase();
            return casa;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
