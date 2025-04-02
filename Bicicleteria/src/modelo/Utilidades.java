/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Utilidades {

    // 1: -------- Guardar objetos en la lista -----------
    public static ArrayList<Bicicleta> agregarBicicletaALista(ArrayList<Bicicleta> listaBicicleta, Bicicleta bicicleta) {
        if (bicicleta != null) {
            listaBicicleta.add(bicicleta);
        }
        return listaBicicleta;
    }

    // 2: ------- Escribimos en archivo -------------
    public static void escribirEnArchivo(ArrayList<Bicicleta> lista) {
        try {
            FileOutputStream fos = new FileOutputStream("bicicletas.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //Escribimos en el archivo
            for (Bicicleta bicicleta : lista) {
                oos.writeObject(bicicleta);
            }

            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // 3: ------- Leer Archivo ------------------------
    public static ArrayList<Bicicleta> leerArchivo() {
        ArrayList<Bicicleta> listaBicicleta = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("bicicletas.txt");
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Bicicleta bicicleta = (Bicicleta) ois.readObject();
                    listaBicicleta.add(bicicleta);

                } catch (EOFException e) {
                    break; // Se alcanzó el final del archivo, salimos del loop
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo..");
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        return listaBicicleta;
    }

    // 4 - Eliminamos un objeto bicicleta de la lista
    public static ArrayList<Bicicleta> eliminamosUnElemento(int id){
        ArrayList<Bicicleta> listaBicicleta = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("bicicletas.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Bicicleta bicicleta = (Bicicleta) ois.readObject();
                    listaBicicleta.add(bicicleta);

                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo.");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("bicicletas.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            //Eliminamos el elmento
            listaBicicleta.removeIf(bici -> bici.getId() == id);

            //Escribimos en el archivo lamba
            for (Bicicleta bicicleta : listaBicicleta) {
                oos.writeObject(bicicleta);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo.");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return listaBicicleta;
    }

    // 5 - Actualizamos un objeto bicicleta de la lista
    public static void actualizarUnElemento(int id, Bicicleta bicicleta_Actualizada) {
        ArrayList<Bicicleta> listaBicicleta = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("bicicletas.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Bicicleta bicicleta = (Bicicleta) ois.readObject();
                    listaBicicleta.add(bicicleta);

                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo.");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("bicicletas.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            //Actualizamos un elmento
            for (int i = 0; i < listaBicicleta.size(); i++) {
                if (listaBicicleta.get(i).getId() == id) {
                    listaBicicleta.set(i, bicicleta_Actualizada);
                    break;
                }
            }

            //Escribimos en el archivo 
            for (Bicicleta bici : listaBicicleta) {
                oos.writeObject(bici);
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo");
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    

}
