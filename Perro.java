public class Perro {
    protected String nombre, duenio;

    public Perro(String nombre, String duenio){
        this.nombre = nombre;
        this.duenio = duenio;
    }

    public String ladrar(){
        return "WOOF WOOF";
    }
}
