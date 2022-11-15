import java.util.Scanner;


public class Main{
    public static Integer buscarNumeroCuenta(Cuenta cuentas[], Integer n){

        Integer i=0,indice=0;
        boolean encontrado= false;
        
        //busquedad secuencial
        while((i<cuentas.length)&& (encontrado==false)){
            if(cuentas[i].getNumeroCuenta() == n){
                encontrado = true;
                indice = i;
            }
            i++;
        }
        if(encontrado== false){
            indice=-1;
        }
        return indice;
    }
        public static void main(String args[]) {

            String nombre;
            String apellido;
            String cc;
            Integer numeroCuenta,nCuentas,opcion,indiceCuenta;
            Double saldo,cantidad;
            Cuenta cuentas[];
            Cliente cliente;

            Scanner teclado = new Scanner(System.in);

            System.out.println("*****BANCO NACIONAL KATHEBYTE*****");
            System.out.print("Ingrese por favor su nombre: ");
            nombre= teclado.nextLine();
            System.out.print("Ingrese por favor su apellido: ");
            apellido= teclado.nextLine();
            System.out.print("Ingrese por favor su numero de cedula: ");
            cc=teclado.nextLine();
            System.out.print("Ahora, Digite el numero de cuentas que posee: ");
            nCuentas=teclado.nextInt();

            cuentas = new Cuenta[nCuentas];

            for(Integer i=0; i<cuentas.length; i++){
                System.out.println("\nDigite los datos para la cuenta "+(i+1)+":");
                System.out.print("Digite numero de cuenta: ");
                numeroCuenta=teclado.nextInt();
                System.out.print("Digite el saldo de la cuenta: ");
                saldo=teclado.nextDouble();

                cuentas[i]= new Cuenta(numeroCuenta,saldo);

            }
            

            cliente = new Cliente(nombre, apellido, cc, cuentas);

            do{
                System.out.println("MENU:.");
                System.out.println("1. Ingresar dinero en la cuenta");
                System.out.println("2. Retirar dinero de la cuenta");
                System.out.println("3. Consultar saldo");
                System.out.println("4. Salir");
                System.out.println("Digite la opcion del menu: ");
                opcion=teclado.nextInt();


                switch(opcion){

                    case 1: System.out.println("Digite el numero de cuenta");
                            numeroCuenta=teclado.nextInt();
                            indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);

                            if (indiceCuenta ==-1){
                                System.out.println("El numero de cuenta ingresado no existe");
                            }
                            else{
                                System.out.println("Digite la cantidad de dinero a ingresar");
                                cantidad=teclado.nextDouble();


                                cliente.ingresarDinero(indiceCuenta, cantidad);
                                System.out.println("\nINGRESO REALIZADO CORRECTAMENTE");
                                System.out.println("\nSaldo disponible: "+cliente.consultarSaldo(indiceCuenta));
                            }
                        break;
                    case 2: System.out.println("Digite el numero de cuenta");
                            numeroCuenta=teclado.nextInt();
                            indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);

                            if (indiceCuenta ==-1){
                            System.out.println("El numero de cuenta ingresado no existe");
                            }
                            else{
                            System.out.println("Cuanto Dinero desea retirar: ");
                            cantidad=teclado.nextDouble();

                            if(cantidad>cliente.consultarSaldo(indiceCuenta)){
                                System.out.println("Saldo insuficiente");
                                System.out.println("El Saldo disponible: "+cliente.consultarSaldo(indiceCuenta));
                            }

                            cliente.retirarDinero(indiceCuenta, 0);
                            System.out.println("\nRETIRO REALIZADO CORRECTAMENTE");
                                System.out.println("Saldo disponible: "+cliente.consultarSaldo(indiceCuenta));
                        }
                        break;
                    case 3:System.out.println("Digite el numero de cuenta");
                            numeroCuenta=teclado.nextInt();
                            indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);

                            if (indiceCuenta ==-1){
                            System.out.println("El numero de cuenta ingresado no existe");
                            }
                            else{
                                System.out.println("Saldo disponible: "+cliente.consultarSaldo(indiceCuenta));
                            }
                        break;
                    case 4: break;
                    default: System.out.println("ERROR");


                    
                }
                
                
                System.out.println("");


            }while(opcion !=4);

        teclado.close();    
    }

}

