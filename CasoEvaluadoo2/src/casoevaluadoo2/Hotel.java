/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluadoo2;

import javax.swing.JOptionPane;

/**
 *
 * @author milkyaakath
 */
public class Hotel {
    //crea la matriz
    private Habitacion[][] habitaciones;

    //inicializa la matriz
    public Hotel(int pisos, int habitacionesPorPiso) {
        habitaciones = new Habitacion[pisos][habitacionesPorPiso];
        precargarHabitaciones();
    }

    private void precargarHabitaciones() {
        for (int piso = 0; piso < habitaciones.length; piso++) {
            for (int num = 0; num < habitaciones[piso].length; num++) {
                String numero = (piso + 1) + "0" + (num + 1);
                String tipo = "Simple";
                double precio = 40.0;
                String estado = "Libre";
                habitaciones[piso][num] = new Habitacion(numero, tipo, precio, estado);
            }
        }
    }

    //muestra el estado de las habitaciones
    public void mostrarEstadoHotel() {
        String mensaje = "Estado actual del hotel: \n\n";
        for (int piso = 0; piso < habitaciones.length; piso++) {
            mensaje += "Piso " + (piso + 1) + ": \n";
            for (int num = 0; num < habitaciones[piso].length; num++) {
                mensaje += habitaciones[piso][num].toString() + "\n";
            }
            mensaje += "\n";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }

    //para modificar la habitación por el número
    public void modificarHabitacion() {
        String numero = JOptionPane.showInputDialog("Ingrese el número de habitación: ");
        for (int piso = 0; piso < habitaciones.length; piso++) {
            for (int num = 0; num < habitaciones[piso].length; num++) {
                Habitacion h = habitaciones[piso][num];
                if (h.getNumero().equals(numero)) {
                    String nuevoEstado = JOptionPane.showInputDialog("Nuevo estado (Libre/Ocupada/Sucia): ");
                    String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo (Simple/Doble): ");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio por noche: "));
                    h.setEstado(nuevoEstado);
                    h.setTipo(nuevoTipo);
                    h.setPrecio(nuevoPrecio);
                    JOptionPane.showMessageDialog(null, "Habitación modificada");
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Habitación no encontrada");
    }

    //hace el resumen de la ocupación y la ganancia
    public void mostrarResumen() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancia = 0;

        for (int piso = 0; piso < habitaciones.length; piso++) {
            for (int num = 0; num < habitaciones[piso].length; num++) {
                Habitacion h = habitaciones[piso][num];
                if (h.getEstado().equals("Libre")) {
                    libres++;
                } else if (h.getEstado().equals("Ocupada")) {
                    ocupadas++;
                    ganancia += h.getPrecio();
                } else if (h.getEstado().equals("Sucia")) {
                    sucias++;
                }

            }
        }

        int total = libres + ocupadas + sucias;
        
        //resumen del hotel 
        String resumen = "Resumen del Hotel: \n\n";
               resumen += "Libres: " + libres + " (" + (libres * 100 / total) + "%) \n";
               resumen += "Ocupadas: " + ocupadas + " (" + (ocupadas * 100 / total) + "%) \n";
               resumen += "Sucias: " + sucias + " (" + (sucias * 100 / total) + "%) \n";
               resumen += "Ganancia actual: $" + ganancia;


        JOptionPane.showMessageDialog(null, resumen);
    }
}

