public class Cliente{
    private String nombre;
    private String apellido;
    private String cc;
    Cuenta cuentas[];


    public Cliente(String nombre, String apellido, String cc,Cuenta[] cuentas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cc = cc;
        this.cuentas=cuentas;

    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getCc() {
        return cc;
    }


    public double consultarSaldo(Integer n){
       return cuentas[n].getSaldo();

    }

    public void ingresarDinero(Integer n,double cantidad){
        cuentas[n].ingresarDinero(cantidad);
         
 }
    public void retirarDinero(Integer n, double cantidad){
        cuentas[n].retirarDinero(cantidad);
    }


}