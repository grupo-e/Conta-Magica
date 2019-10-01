package com.TUnit10;

public class ContaMagica { 
    public static final int SILVER = 0;
    public static final int GOLD = 1; 
    public static final int PLATINUM = 2; 

    private double saldo;
    private int status;

    public ContaMagica() {

        saldo = 0.0;
        status = 0;

    }

    double getSaldo() {

        return saldo;

    } 

    int getStatus() {

        return status;

    }

    void deposito(int valor) throws INVALID_OPER_EXCEPTION {

        if (valor>=0) {

            if (status == 0) {

                saldo+=valor;
                if (saldo >=50000) {

                    status = 1;

                }

            }else if (status == 1) {

                saldo = saldo + valor + (valor*0.01);
                if (saldo>=200000) {

                    status = 2;

                }

            }else {

                saldo = saldo + valor + (valor*0.025);

            }

        } else {

            throw new INVALID_OPER_EXCEPTION("VALOR MENOR QUE ZERO! ERRO");

        }

    } 
    void retirada(int valor) throws INVALID_OPER_EXCEPTION {

        if (valor>=0) {

            saldo-=valor;
            if (status == 2 && saldo <= 100000) {

                status = 1;

            }
            
            if (status == 1 && saldo <= 25000) {

                status = 0;

            }

            if (saldo<0) {

                saldo = 0;

            }

        }else {

            throw new INVALID_OPER_EXCEPTION("VALOR MENOR QUE ZERO! ERRO");

        }

    } 

}