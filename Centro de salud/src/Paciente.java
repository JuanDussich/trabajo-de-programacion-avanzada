import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.LinkedList;


public class Paciente extends Usuario{
    //ATRIBUTOS
    private int id;
    private int dni;
    private Date fechaNacimiento;
//    private HistoriaClinica historiaClinica;

    // CONSTRUCTOR
    public Paciente() {
    }
    
    public Paciente(int id, String nombre,String apellido,int dni,Date fechaNacimiento,String email,String contrasenia) {
        super(nombre,apellido,email,contrasenia);
        this.id = id;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
    // METODOS

    @Override
    public void Login() {
        String email = JOptionPane.showInputDialog("ingresa tu mail");
        String contrasenia = JOptionPane.showInputDialog("ingresa tu contrasenia");

        try {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM paciente WHERE email = ? AND contrasenia = ?"
            );
            stmt.setString(1, email);
            stmt.setString(2, contrasenia);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                this.id = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                this.dni = rs.getInt("dni");
                this.fechaNacimiento = rs.getDate("fecha_De_nacimiento");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void AgregarPaciente(){
//
//    }

    @Override
    public void Registro() {

    }
private static Connection con = Conexion.getInstance().getConnection();


    public static Paciente login(String email, String contrasenia) {
        Paciente paciente = new Paciente();
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM paciente WHERE email = ? AND contrasenia = ?"
            );
            stmt.setString(1, email);
            stmt.setString(2, contrasenia);
//            stmt.setString(2,usuario.encriptar(contrasenia));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                Date fechaNacimiento = rs.getDate("fecha_De_nacimiento");

                paciente =  new Paciente(id,nombre,apellido,dni, fechaNacimiento, email,contrasenia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public static void agregarUsuario(Paciente usuario) {
        try {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO `paciente`( `nombre`, `apellido`, `dni`, `fecha_De_Nacimiento`, `email`, `contrasenia`) VALUES (?,?,?,?,?,?)"
            );
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setInt(3,usuario.getDni());
            statement.setDate(4, usuario.getFechaNacimiento());
            statement.setString(5, usuario.getEmail());
//            statement.setString(6, usuario.encriptar(usuario.getContrasenia()));
            statement.setString(6, usuario.getContrasenia());

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario agregado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RegistrarUsuario() {

        String nombre = JOptionPane.showInputDialog("ingresa tu nombre");
        String apellido = JOptionPane.showInputDialog("ingresa tu apellido");
        int  dni = Integer.parseInt(JOptionPane.showInputDialog("ingresa tu dni"));

        int anio = Integer.parseInt(JOptionPane.showInputDialog("ingresa el año que naciste"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("ingresa el mes que naciste"));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("ingresa el dia que naciste"));
        Date fechaNacimiento = new Date(anio,mes,dia) ;

        String email = JOptionPane.showInputDialog("ingresa tu email");
        String contrasenia = JOptionPane.showInputDialog("ingresa tu contrasenia");
        Paciente nuevo = new Paciente(0,nombre,apellido,dni,fechaNacimiento,email,contrasenia);

        LinkedList<Paciente> existentes = mostrarPaciente();
        boolean flag = true;
        for (Usuario existente : existentes) {
            if (existente.getEmail().equals(nuevo.getEmail())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            agregarUsuario(nuevo);
        }else {
            JOptionPane.showMessageDialog(null, "Usuario ya creado");
        }


    }
    public static LinkedList<Paciente> mostrarPaciente() {
        LinkedList<Paciente> usuarios = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM paciente");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                Date fechaDeNacimiento = rs.getDate("fecha de nacimiento");
                String email = rs.getString("email");
                String contrasenia = rs.getString("password");

                usuarios.add(new Paciente(id, nombre,apellido,dni ,fechaDeNacimiento, email,contrasenia));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void MenuPaciente() {

        int menu;
        String mail;
        String contrasenia;
        Paciente paciente = new Paciente();

        do{
            menu = JOptionPane.showOptionDialog(null, "menu", "Menu Paciente", JOptionPane.DEFAULT_OPTION, 0,  null,OpcionesPaciente.values(), OpcionesPaciente.values());
            switch (menu){
                case 0:

                    // Ver datos personales se va a poder hacer el login y registro en esta parte
                    String[] accionesUsuario = { "Login", "Registro","Ver mi usuario", "Salir" };
                    int opcion;
                    opcion = JOptionPane.showOptionDialog(null,"elija una de las opciones","menu Paciente",0,0,null,accionesUsuario,accionesUsuario[0]);
                    switch (opcion){
                        case 0:
                            mail = JOptionPane.showInputDialog("ingresa tu mail para poder logearte");
                            contrasenia = JOptionPane.showInputDialog("ingresa tu contrasenia");
                            paciente = Paciente.login(mail,contrasenia);
                            paciente.Login();
                            JOptionPane.showMessageDialog(null,"hola");
                            break;
                        case 1:
                            Paciente.RegistrarUsuario();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, paciente);
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 1:
                    // Ver Medicos
                    break;
                case 2:
                    // Ver turnos
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del menu Paciente");
                    break;
            }
        }while (menu != 3);
    }

    // GETTERS Y SETTERS
    // dni
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    // fechaNacimiento
    public  Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento( Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + "} " + super.toString();
    }
}
