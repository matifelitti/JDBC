
package estancias.entidades;

public class clientes {
    
    private int id_cliente;
    private String nombre;
    private String calle;
    private int numero;
    private String codigo_postal;
    private String ciudad;
    private String pais;
    private String email;

    public clientes() {
    }

    public clientes(int id_cliente, String nombre, String calle, int numero, String codigo_postal, String ciudad, String pais, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getEmail() {
        return email;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "clientes{" + "id_cliente = " + id_cliente + ", nombre = " + nombre + ", calle = " + calle + ", numero = " + numero + ", codigo_postal = " + codigo_postal + ", ciudad = " + ciudad + ", pais = " + pais + ", email = " + email + '}';
    }
    
    
    
    
}
