package estancias.servicios;

import estancias.entidades.familias;
import estancias.persistencia.EntidadDaoExtFamilias;
import java.util.Collection;

public final class familiasServicio {

    private EntidadDaoExtFamilias dao;

    public familiasServicio() {
        this.dao = new EntidadDaoExtFamilias();
    }

    public familias buscarFamiliaPorId(int id_familia) throws Exception {

        try {

            //Validamos
            if (id_familia < 0) {
                throw new Exception("Debe indicar el id");
            }
            familias familia = dao.buscarFamiliaPorId(id_familia);
            //Verificamos
            if (familia == null) {
                throw new Exception("No se encontró la familia para el id indicado");
            }

            return familia;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<familias> listarFamilias3hijos() throws Exception {

        try {

            Collection<familias> famil = dao.listarFamilias3hijos();

            return famil;
        } catch (Exception e) {
            throw e;
        }
    }

}
