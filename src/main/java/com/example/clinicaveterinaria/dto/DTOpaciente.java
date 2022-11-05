package src.main.java.com.example.clinicaveterinaria.dto;

public class DTOpaciente {

    private int ID_mascota;
    private String nombre;
    private String raza;
    private String fechaN;
    private int ID_celda;
    private int ID_cliente;

    public int getID_mascota() {
        return ID_mascota;
    }

    public void setID_mascota(int ID_mascota) {
        this.ID_mascota = ID_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public int getID_celda() {
        return ID_celda;
    }

    public void setID_celda(int ID_celda) {
        this.ID_celda = ID_celda;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }
}
