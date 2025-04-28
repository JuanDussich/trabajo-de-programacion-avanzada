public class ListaPaciente {

	import java.util.ArrayList;

	public class ListaPaciente {
	    private ArrayList<Paciente> pacientes;

	    public ListaPaciente() {
	        this.pacientes = new ArrayList<>();
	    }

	    public void agregarPaciente(Paciente paciente) {
	        pacientes.add(paciente);
	    }

	    public void eliminarPaciente(Paciente paciente) {
	        pacientes.remove(paciente);
	    }

	    public ArrayList<Paciente> getPacientes() {
	        return pacientes;
	    }

	    public void setPacientes(ArrayList<Paciente> pacientes) {
	        this.pacientes = pacientes;
	    }
	}
}
