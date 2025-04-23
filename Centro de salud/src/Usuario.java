public class Usuario {

    //ATRIBUTOS
    private String Nombre;
    private String Apellido;
    private int edad;
    private String contrasenia;
    private String mail;

    // CONSTRUCTOR
    public Usuario() {
    }

    public Usuario(String nombre,String apellido, int edad,String mail, String contrasenia) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.edad = edad;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }

    // METODOS
    
    // GETTERS Y SETTERS
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Nombre='" + Nombre + '\'' + ", Apellido='" + Apellido + '\'' + ", edad=" + edad + ", contrasenia='" + contrasenia + '\'' + ", mail='" + mail + '\'' +
                '}';
    }
}
