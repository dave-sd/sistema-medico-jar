package control;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.*;

public class AdmBebe {
    private static AdmBebe AdmB=null;
    
    private ArrayList <Bebe> listas=new ArrayList<Bebe>();
    private Bebe b=null;
    
    public static AdmBebe getAdmBebe() {
        if(AdmB==null)
            AdmB=new AdmBebe();
        return AdmB;
    }

    public AdmBebe() {
        listas=new ArrayList<Bebe>();
    }
    
    public ArrayList<Bebe> getListas() {
        return listas;
    }
    public void setListas(ArrayList<Bebe> listas) {
        this.listas = listas;
    }

    //Metodo para valorar el llenado de los campos
    public boolean noVacio(String cedula, String nombre, String sexo, String fecha, String peso,
            String estatura, String tipoSanguineo, String nombreMama){
        Validacion1 v1=new Validacion1();
        boolean x=false;
        
        if(!cedula.isEmpty()&&!nombre.isEmpty()&&!sexo.isEmpty()&&fecha!=null&&!peso.isEmpty()&&
                !estatura.isEmpty()&&!tipoSanguineo.isEmpty()&&!nombreMama.isEmpty())
            if (v1.esCedula(cedula)&&!estaCedula(cedula)&&v1.esReal(peso)&&v1.dentroRango("Peso",peso,0,200)
                    &&v1.esReal(estatura)&&v1.dentroRango("Estatura",estatura,0,2)){ 
                x=true;
            }
        return x;
    }
    
    private boolean estaCedula(String cedula) {
        boolean bandera=false; //Falso=No esta
        int i=0;
         
        for(i=0;i<listas.size()&&!bandera;i++){
            if(listas.get(i).getCedula().compareTo(cedula)==0){
                bandera=true;
            }
        } if(bandera) {
            JOptionPane.showMessageDialog(null,"Cedula existente","ERROR",0);
        }
        return bandera;
    }
    
    //INGRESAR - Guarda los valores ingresados
    public void guardar (String cedula, String nombre, String sexo, String fecha, String peso, String estatura,
           String tipoSanguineo, String nombreMama, JTextArea txtContenido, JLabel lblTotal){
        Validacion1 v1=new Validacion1();
        b = new Bebe();
        
        b.setCedula(cedula);
        b.setNombre(nombre);
        b.setSexo(sexo.charAt(0));
        b.setFechaNac(fecha);
        b.setPeso(v1.leerReal(peso));
        b.setEstatura(v1.leerReal(estatura));
        b.setTipoSanguineo(tipoSanguineo.charAt(0));
        b.setNombreMama(nombreMama);
        
        listas.add(b);
        txtContenido.append(b.toString());
        lblTotal.setText(listas.size()+"");
    }

    //PRESENTAR - Llena los datos de la tabla
    public void llenarTabla(JTable tblBebe, JLabel lblTotal) {
        int fila=0;
        
        if (listas.size()>0) {
            for (Bebe bb:listas) {
                llenarFila(tblBebe, fila, bb);
                fila++;
            }
            
            lblTotal.setText(listas.size()+"");
        }    
    }
    
    //Llena cada dato de la fila para presentar la tabla
    private void llenarFila(JTable tblBebe, int fila, Bebe bb) {
        DefaultTableModel modelo=(DefaultTableModel)tblBebe.getModel();
        modelo.addRow(new Object[1]);
        
        tblBebe.setValueAt(fila+1, fila, 0);
        tblBebe.setValueAt(bb.getCedula(), fila, 1);
        tblBebe.setValueAt(bb.getNombre(), fila, 2);
        tblBebe.setValueAt(bb.verSexo(), fila, 3);
        tblBebe.setValueAt(bb.getFechaNac(), fila, 4);
        tblBebe.setValueAt(bb.getPeso(), fila, 5);
        tblBebe.setValueAt(bb.getEstatura(), fila, 6);
        tblBebe.setValueAt(bb.verSangre(), fila, 7);
        tblBebe.setValueAt(bb.getNombreMama(), fila, 8);
    }

    //ELIMINAR - Busca y elimina la fila de datos
    public void eliminar(JTable tblBebe) {
        DefaultTableModel modelo=(DefaultTableModel)tblBebe.getModel();
        
        int posicion = tblBebe.getSelectedRow();
        
        if (posicion>=0) {
            modelo.removeRow(posicion);
            listas.remove(posicion);
        } else {
            JOptionPane.showMessageDialog(null,"No ha seleccionado ningun elemento a eliminar.","ERROR",0);
            }
    }
    
    //BUSCAR - busca por cedula
    public void buscarCedula(String cedula, JTable tblBebe, JLabel lblTotal) {
        int fila=0;
        
        if(listas.size()>0) {
            for(Bebe b:listas){
                if(b.getCedula().equals(cedula)) {
                    llenarFila(tblBebe, fila, b);
                    fila++;  
                } else {
                    JOptionPane.showMessageDialog(null,"No hay datos con esa cedula.","ERROR",0);
                    }
                }
            
            lblTotal.setText(fila+"");
        }
    }
    
    //BUSCAR - busca por sexo
    public void buscarSexo(String sexo, JTable tblBebe, JLabel lblTotal) {
        Validacion1 v1=new Validacion1();
        int fila=0;
        
        if(listas.size()>0) {
            for(Bebe b:listas){
                if(sexo.compareTo("Femenino")==0){
                    if(b.getSexo()=='F'){
                        llenarFila(tblBebe, fila, b);
                        fila++;
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay datos con ese sexo.","ERROR",0);
                        }
                } else if(sexo.compareTo("Masculino")==0) {
                    if(b.getSexo()=='M'){
                        llenarFila(tblBebe, fila, b);
                        fila++;
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay datos con ese sexo.","ERROR",0);
                        }
                }else if(sexo.compareTo("Todos")==0){
                    llenarFila(tblBebe, fila, b);
                    fila++;
                }
            }
            
            lblTotal.setText(fila+"");
        }
    }
    
    //EDITAR - Busca el dato, y retorna la posicion
    public int buscarE(String cedula, JTable tblBebe) {
        int fila=0;
        int posicion=-1;
        
        if(listas.size()>0) {
            for(Bebe b:listas){
                if(b.getCedula().equals(cedula)) {
                    posicion = tblBebe.getSelectedRow();
                    llenarFila(tblBebe, fila, b);
                    fila++;  
                } else {
                    JOptionPane.showMessageDialog(null,"No hay datos con esa cedula.","ERROR",0);
                }
            }
        }
        return posicion;
    }
    
    //EDITAR - Metodo para valorar el llenado de los campos
    public boolean noVacioEditar(String nombre, String sexo, String fecha, String peso, 
            String estatura, String tipoSanguineo, String nombreMama){
        Validacion1 v1=new Validacion1();
        boolean x=false;
        
        if(!nombre.isEmpty()&&!sexo.isEmpty()&&fecha!=null&&!peso.isEmpty()&&
                !estatura.isEmpty()&&!tipoSanguineo.isEmpty()&&!nombreMama.isEmpty())
            if (v1.esReal(peso)&&v1.dentroRango("Peso",peso,0,200)&&v1.esReal(estatura)&&v1.dentroRango("Estatura",estatura,0,2)){ 
                x=true;
            }
        return x;
    }
    
    //EDITAR - Edita los campos (Aparece en seleccion)
    public void editar(int posicion, JTextField cedula, JTextField nombre, JComboBox sexo, JTextField fecha,
            JTextField peso, JTextField estatura, JComboBox sangre, JTextField nombreMama) {
        b = listas.get(posicion);
        
        if(getListas().size() >0){
            b.getCedula();
            nombre.setText(b.getNombre());
            sexo.setSelectedItem(b.verSexo());
            fecha.setText(b.getFechaNac());    
            peso.setText(Double.toString(b.getPeso()));
            estatura.setText(Double.toString(b.getEstatura()));
            sangre.setSelectedItem(b.verSangre());
            nombreMama.setText(b.getNombreMama());
        }
    }
    
    //EDITAR - Guarda los datos editados
    public String guardarEdicion(int posicion, String cedula, String nombre, String sexo, String fecha, String peso, 
            String estatura, String tipoSanguineo, String nombreMama) {
        String x="";
        
        b=new Bebe(cedula, nombre, sexo.charAt(0), fecha, Double.parseDouble(peso), Double.parseDouble(estatura),
                tipoSanguineo.charAt(0), nombreMama);
        
        listas.set(posicion,b);
        x=b.toString();
        return x;
    }
}