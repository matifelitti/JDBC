package tienda.servicios;

import java.util.Collection;
import tienda.entidades.fabricante;
import tienda.persistencia.EntidadDaoExtFabricante;

public class fabricanteServicio {

    private EntidadDaoExtFabricante dao;

    public fabricanteServicio() {
        this.dao = new EntidadDaoExtFabricante();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {

        try {
            //Validamos

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya existe un fabricante con el codigo indicado " + nombre);
            }

            //Creamos el fabricante
            fabricante fabricante = new fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }

            fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            fabricante fabricante = dao.buscarFabricantePorNombre(nombre);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    
        public void eliminarFabricante(int cod) throws Exception {

        try {

            //Validamos 
            if (cod < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarFabricante(cod);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<fabricante> listarFabricantes() throws Exception {

        try {

            Collection<fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los fabricantes
            Collection<fabricante> fabricantes = listarFabricantes();

            //Imprimimos los fabricantes
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
