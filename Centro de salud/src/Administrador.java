import javax.swing.*;

public class Administrador {

    //ATRIBUTOS
    // CONSTRUCTOR
    // METODOS
    public void MenuAdministrador() {
        int opcion;
        do{
            opcion = JOptionPane.showOptionDialog(null, "menu", "menu principal", JOptionPane.DEFAULT_OPTION, 0,  null,OpcionesAdministrador.values(), OpcionesAdministrador.values());
            switch (opcion){
                case 0:

                    break;
                case 1:
                    break;
                case 2:

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "a bueno adios master");
                    break;
            }
        }while (opcion != 3);
    }
    // GETTERS Y SETTERS

}
