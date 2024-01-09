package model;

public abstract class Persona {
    protected String cedula;
    protected String nombre;
    protected char sexo; //'F' femenino, 'M' masculino
    protected String fechaNac;
    protected boolean estado;

    public Persona(String cedula, String nombre,char sexo, String fechaNac) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.estado = true;
    }
    
    public Persona() { }
    
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String verSexo() {
        String x="";
        if(sexo=='M'|| sexo=='m')
        x="Masculino";
        else if(sexo=='F'|| sexo=='f')
        x="Femenino";
        return x;
    }
    
    @Override
    public String toString() {
        return "\nCedula: "+cedula+"\nNombre: "+nombre+"\nFecha de nacimiento (aaaa-mm-dd): "
            +fechaNac+"\nSexo: "+verSexo();
    }
}