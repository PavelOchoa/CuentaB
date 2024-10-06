package Banco;


import java.util.Scanner;

class CuentaBancaria {
    protected String titular;
    protected double saldo;
    protected int numTransacciones;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.numTransacciones = 0;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numTransacciones++;
            System.out.println("Depósito realizado. Saldo actual: " + saldo);
        } else {
            System.out.println("Cantidad no válida para depósito.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numTransacciones++;
            System.out.println("Retiro realizado. Saldo actual: " + saldo);
        } else {
            System.out.println("Cantidad no válida o saldo insuficiente.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public int consultarTransacciones() {
        return numTransacciones;
    }
}

// Clase sub: CuentaAhorros
class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;

    public CuentaAhorros(String titular, double saldoInicial, double tasaInteres) {
        super(titular, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public void aplicarIntereses() {
        saldo += saldo * tasaInteres;
    }

    public void mostrarInformacion(double comisionMensual) {
        System.out.printf("Saldo = $ %.3f\n", saldo);
        System.out.printf("Comisión mensual = $ %.1f\n", comisionMensual);
        System.out.println("Número de transacciones = " + numTransacciones);
    }
}

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.println("Cuenta de ahorros");
        System.out.print("Ingrese saldo inicial= $ ");
        double saldoInicial = sc.nextDouble();

        System.out.print("Ingrese tasa de interés= ");
        double tasaInteres = sc.nextDouble();

        CuentaAhorros miCuenta = new CuentaAhorros("Juan Pérez", saldoInicial, tasaInteres);

        // Consignar dinero
        System.out.print("Ingresar cantidad a consignar: ");
        double cantidadConsignar = sc.nextDouble();
        miCuenta.depositar(cantidadConsignar);

        // Retirar dinero
        System.out.print("Ingresar cantidad a retirar: $");
        double cantidadRetirar = sc.nextDouble();
        miCuenta.retirar(cantidadRetirar);

        // Aplicar intereses
        miCuenta.aplicarIntereses();

        // Mostrar información final
        double comisionMensual = 0.0; // Suponiendo que la comisión mensual es 0
        miCuenta.mostrarInformacion(comisionMensual);

        sc.close();
    }
}