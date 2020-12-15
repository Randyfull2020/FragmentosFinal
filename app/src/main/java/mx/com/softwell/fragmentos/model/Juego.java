package mx.com.softwell.fragmentos.model;

public class Juego {
    private int idJuego;
    private String nombre;
    private String descripcion;
    private float clasificacion;
    private String imagen;
    private boolean activo;

    public Juego() {
    }

    public Juego(int idJuego, String nombre, String descripcion, float clasificacion, String imagen, boolean activo) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.clasificacion = clasificacion;
        this.imagen = imagen;
        this.activo = activo;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(float clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
