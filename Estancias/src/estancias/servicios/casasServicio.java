package estancias.servicios;

import estancias.entidades.casas;
import estancias.persistencia.EntidadDaoExtCasas;
import java.util.Collection;

public final class casasServicio {

    private EntidadDaoExtCasas dao;

    public casasServicio() {
        this.dao = new EntidadDaoExtCasas();
    }

    public casas buscarCasasPorId(int id_casa) throws Exception {

        try {

            //Validamos
            if (id_casa < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            casas casa = dao.buscarCasaPorId(id_casa);
            //Verificamos
            if (casa == null) {
                throw new Exception("No se encontró el producto para el código indicado");
            }

            return casa;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<casas> listarCasas() throws Exception {

        try {

            Collection<casas> c = dao.listarCasas();

            return c;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<casas> listarCasasPorPais() throws Exception {

        try {

            Collection<casas> c = dao.listarCasasPorPais();

            return c;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirCasas() throws Exception {

        try {

            //Listamos las casas
            Collection<casas> c = dao.listarCasas();

            //Imprimimos las casas
            if (c.isEmpty()) {
                throw new Exception("No existen casas para imprimir");
            } else {
                for (casas casa : c) {
                    System.out.println(casa.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
