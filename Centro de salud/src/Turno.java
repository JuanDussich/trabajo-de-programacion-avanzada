import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Turno{

    //ATRIBUTOS
    private String motivoTurno;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;

    // CONSTRUCTOR
    public Turno() {
    }
    public Turno(String motivoTurno,LocalDate fechaTurno, LocalTime horaTurno) {
        this.motivoTurno = motivoTurno;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }

    // METODOS
    public void MenuTurno() {
        int opcion;
        do{
            opcion = JOptionPane.showOptionDialog(null, "menu", "Menu Turno", JOptionPane.DEFAULT_OPTION, 0,  null,OpcionesTurno.values(), OpcionesTurno.values());
            switch (opcion){
                case 0:
                    // VerTurnoPendiente
                    break;
                case 1:
                    // VerTurnoConfirmado
                    break;
                case 2:
                    // VerTurnoCancelado
                    break;
                case 3:
                    //VerTurnoAtendido
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Salio del menu Turno");
                    break;
            }
        }while (opcion != 4);
    }

    // GETTERS Y SETTERS

    //motivoTruno
    public String getMotivoTurno() {
        return motivoTurno;
    }

    public void setMotivoTurno(String motivoTurno) {
        this.motivoTurno = motivoTurno;
    }

    //fechaTurno
    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    //horaTurno
    public LocalTime getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(LocalTime horaTurno) {
        this.horaTurno = horaTurno;
    }

    @Override
    public String toString() {
        return "Turno{" + ", motivoTurno='" + motivoTurno + '\'' + ", fechaTurno=" + fechaTurno + ", horaTurno=" + horaTurno + '}';
    }
}
