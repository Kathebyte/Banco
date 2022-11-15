public class Cuenta {
    private Integer numeroCuenta;
    private Double saldo;
    
    
    public Cuenta(Integer numeroCuenta, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta ;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void ingresarDinero(double cantidad){
        this.saldo = this.saldo + cantidad;

    }
    
    public void retirarDinero(double cantidad){
        saldo =+    cantidad;

    }
}
