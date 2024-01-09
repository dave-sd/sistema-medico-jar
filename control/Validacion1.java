package control;
import javax.swing.JOptionPane;

public class Validacion1 {
    public double leerReal(String entrada){   
        double x=0;

            try {
                x=Double.parseDouble(entrada);
            } catch(NumberFormatException ex) { }
        return x;
   }
    
    public char leerSexo(String msj){
        char x=' ';
        return x;
    }
    
    int aEntero(String edad){   
        int x=0;
        
        try {
            x=Integer.parseInt(edad);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Se esperaba numero entero.","ERROR",0);
        }
        return x;
    }
    
    boolean esCedula(String cedula) {
        boolean bandera=true;
        int i;
        
        if (cedula.length()==10)
           {
               for(i=0;i<cedula.length();i++) {
                   if(!Character.isDigit(cedula.charAt(i))) {
                       bandera=false;
                   }
               }
           } else
                bandera=false;

        if(!bandera)
                    JOptionPane.showMessageDialog(null,"Debe tener 10 digitos.","ERROR - CEDULA",0);
        return bandera;
    }

    boolean esReal(String entrada) {
        boolean bandera=true;
        double x=0;

            try {
                x=Double.parseDouble(entrada);
                bandera=true;
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Se esperaba numero real.","ERROR",0);
            }
            return bandera;
    }

    boolean dentroRango(String nombre, String peso, double limInf, double limSup) {
        boolean bandera=true;
        double x=leerReal(peso);
        
        if(x>=limInf&&x<=limSup) {
            bandera=true;
        } else
            bandera=false;
        
        if(!bandera)
            JOptionPane.showMessageDialog(null,nombre+" - Debe estar entre los rangos "+limInf+"y "+limSup,"ERROR",0);
        
        return bandera;
    }
}