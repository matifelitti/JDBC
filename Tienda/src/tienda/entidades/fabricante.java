package tienda.entidades;

public class fabricante {

    private int codigo;
    private String nombre;

    public fabricante() {
    }

    public fabricante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "fabricante{" + "codigo = " + codigo + ", nombre = " + nombre + '}';
    }

}
