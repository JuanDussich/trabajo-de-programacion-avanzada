public class ListaMedico {

	import java.util.ArrayList;

	public class ListaMedico {
	    private ArrayList<Medico> medicos;

	    public ListaMedico() {
	        this.medicos = new ArrayList<>();
	    }

	    public void agregarMedico(Medico medico) {
	        medicos.add(medico);
	    }

	    public void eliminarMedico(Medico medico) {
	        medicos.remove(medico);
	    }

	    public ArrayList<Medico> getMedicos() {
	        return medicos;
	    }

	    public void setMedicos(ArrayList<Medico> medicos) {
	        this.medicos = medicos;
	    }
	}
}
