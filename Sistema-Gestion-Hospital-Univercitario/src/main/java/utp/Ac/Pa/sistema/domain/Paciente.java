 package utp.Ac.Pa.sistema.domain;
 public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;

    public Paciente (int id, String nombre, String apellido, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;

    }

    public int getId() {
        return id;

    }

    public String getNombre() {
        return nombre;

    }

    public String getApellido() {
        return apellido;

    }

    public String getCedula() {
        return cedula;

    }
 }
