package estancias.persistencia;

import estancias.entidades.familias;
import java.util.ArrayList;
import java.util.Collection;

public class EntidadDaoExtFamilias extends DAO {

    public familias buscarFamiliaPorId(int id_familia) throws Exception {
        try {
            String sql = "SELECT * FROM casas WHERE id_casa = " + id_familia + "";
            consultarBase(sql);
            familias f = null;
            while (resultado.next()) {
                f = new familias();
                f.setId_familia(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
                f.setEdad_minima(resultado.getInt(3));
                f.setEdad_maxima(resultado.getInt(4));
                f.setNum_hijos(resultado.getInt(5));
                f.setEmail(resultado.getString(6));
                f.setId_casa_familia(resultado.getInt(7));
            }
            desconectarBase();
            return f;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<familias> listarFamilias() throws Exception {
        try {
            String sql = "SELECT * FROM familias ";
            consultarBase(sql);
            familias fa = null;
            Collection<familias> fam = new ArrayList();
            while (resultado.next()) {
                fa = new familias();
                fa.setId_familia(resultado.getInt(1));
                fa.setNombre(resultado.getString(2));
                fa.setEdad_minima(resultado.getInt(3));
                fa.setEdad_maxima(resultado.getInt(4));
                fa.setNum_hijos(resultado.getInt(5));
                fa.setEmail(resultado.getString(6));
                fa.setId_casa_familia(resultado.getInt(7));
                fam.add(fa);
            }
            desconectarBase();
            return fam;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }

    }

    public Collection<familias> listarFamilias3hijos() throws Exception {
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos >= 3 and edad_maxima < 10 ";
            consultarBase(sql);
            familias fa = null;
            Collection<familias> fam = new ArrayList();
            while (resultado.next()) {
                fa = new familias();
                fa.setId_familia(resultado.getInt(1));
                fa.setNombre(resultado.getString(2));
                fa.setEdad_minima(resultado.getInt(3));
                fa.setEdad_maxima(resultado.getInt(4));
                fa.setNum_hijos(resultado.getInt(5));
                fa.setEmail(resultado.getString(6));
                fa.setId_casa_familia(resultado.getInt(7));
                fam.add(fa);
            }
            desconectarBase();
            return fam;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }

    }

}
