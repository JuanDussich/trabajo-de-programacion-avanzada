public class HistoriaClinica {

import java.util.ArrayList;

	public class HistoriaClinica {
	    private ArrayList<String> notasMedicas;
	    private ArrayList<String> recetas;

	    public HistoriaClinica() {
	        this.notasMedicas = new ArrayList<>();
	        this.recetas = new ArrayList<>();
	    }

	    public void agregarNotaMedica(String nota) {
	        notasMedicas.add(nota);
	    }

	    public void agregarReceta(String receta) {
	        recetas.add(receta);
	    }

	    public ArrayList<String> getNotasMedicas() {
	        return notasMedicas;
	    }

	    public ArrayList<String> getRecetas() {
	        return recetas;
	    }

	    public void setNotasMedicas(ArrayList<String> notasMedicas) {
	        this.notasMedicas = notasMedicas;
	    }

	    public void setRecetas(ArrayList<String> recetas) {
	        this.recetas = recetas;
	    }
	}

}
