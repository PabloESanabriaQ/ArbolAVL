public class Perro {
    protected String nombre, duenio;

    public Perro(String nombre, String duenio){
        this.nombre = nombre;
        this.duenio = duenio;
    }

    public String ladrar(){
        return "WOOF WOOF";
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuenio() {
        return this.duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }
}
