import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    public static void main(String[] args) {


        int opcion;
        do{
            opcion = JOptionPane.showOptionDialog(null, "menu", "menu principal", JOptionPane.DEFAULT_OPTION, 0,  null,OpcionMain.values(), OpcionMain.values());
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
}