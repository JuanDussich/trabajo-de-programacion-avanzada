import javax.swing.*;
import java.time.LocalDate;


public class Paciente extends Usuario{
    //ATRIBUTOS
    private String dni;
    private  LocalDate fechaNacimiento;
    private HistoriaClinica historiaClinica;

    // CONSTRUCTOR
    public Paciente() {
    }
    
    public Paciente(String nombre,String apellido,String mail,String contrasenia,String dni,LocalDate fechaNacimiento,HistoriaClinica historialClinica) {
        super(nombre,apellido,mail,contrasenia);
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.historiaClinica = historialClinica;
    }
    // METODOS

    @Override
    public void Login() {
        super.Login();
    }
    @Override
    public void Registro() {
        super.Registro();
    }

    public void MenuPaciente() {
        int opcion;
        do{
            opcion = JOptionPane.showOptionDialog(null, "menu", "Menu Paciente", JOptionPane.DEFAULT_OPTION, 0,  null,OpcionesPaciente.values(), OpcionesPaciente.values());
            switch (opcion){
                case 0:
                    // Ver datos personales
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
        }while (opcion != 3);
    }

    // GETTERS Y SETTERS
    // dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // fechaNacimiento
    public  LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento( LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // historiaClinica
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Paciente{" +
                "DNI='" + dni + '\'' +
                ", FechaNacimiento=" + fechaNacimiento +
                ", HistoriaClinica=" + (historiaClinica != null ? historiaClinica.toString() : "Sin historia clínica") +
                '}';
    }

}
