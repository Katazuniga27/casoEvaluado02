/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoevaluadoo2;

import javax.swing.JOptionPane;

/**
 *
 * @author milkyaakath
 */
public class CasoEvaluadoo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hotel hotel = new Hotel(5, 5);
        
        int opcion;
        do {
            String menu = "Sistema de Gestión Hotelera \n\n";
            menu += "1- Ver el estado de las habitaciones \n";
            menu += "2- Modificar habitación \n";
            menu += "3- Ver el resumen del hotel \n";
            menu += "4- Salir \n\n";
            menu += "Seleccione una de las opciones:";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    hotel.mostrarEstadoHotel();
                    break;
                    
                case 2:
                    hotel.modificarHabitacion();
                    break;
                    
                case 3:
                    hotel.mostrarResumen();
                    break;
                    
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 4);
    }
}
