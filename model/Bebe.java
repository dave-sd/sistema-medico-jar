package model;

public final class Bebe extends Persona {
    
    protected int edad;
    protected double peso;
    protected double estatura;
    protected char tipoSanguineo; //Solo positivos
    protected String nombreMama;

    public Bebe(String cedula, String nombre, char sexo, String fechaNac,
            double peso, double estatura, char tipoSanguineo,String nombreMama) {
        super(cedula, nombre, sexo, fechaNac);
        this.peso = peso;
        this.estatura = estatura;
        this.tipoSanguineo = tipoSanguineo;
        this.nombreMama = nombreMama;
    }

    public Bebe(){ }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public char getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(char tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getNombreMama() {
        return nombreMama;
    }
    public void setNombreMama(String nombreMama) {
        this.nombreMama = nombreMama;
    }
    
    public String verSangre() {
        String x="";
        if(tipoSanguineo=='A'|| tipoSanguineo=='a')
            x="A+";
        else if(tipoSanguineo=='O'|| tipoSanguineo=='o')
            x="O+";
        else if(tipoSanguineo=='B'|| tipoSanguineo=='b')
            x="B+";
        return x;
    }
    
    @Override
    public String toString() 
    {
        return super.toString()+"\nPeso: "+peso+
                " Kg.\nEstatura: "+estatura+" m \nTipo Sanguineo: "+verSangre();
    }
}