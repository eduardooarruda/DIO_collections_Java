/*
        Faça um programa que receba a temperatura média dos 6
        primeiros meses do ano e armazene-as em uma lista.

        Após isto, calcule a média semestral das temperaturas e
        mostre todas as temperaturas acima desta média, e em que
        mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2
        – Fevereiro e etc).
*/

package list.exercicios;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class exercicio01 {
    public static void main(String[] args) {
        List<TemperaturaMes> temperaturaMes = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        double somaTemperaturas = 0.0;

        for (Meses mes : Meses.values()) {
            double temperatura = sc.nextDouble();
            somaTemperaturas += temperatura;
            temperaturaMes.add(new TemperaturaMes(mes.name(), temperatura));
        }

        double mediaTemperatura = somaTemperaturas/temperaturaMes.size();
        System.out.printf("Média das temperaturas: %.2f%n", mediaTemperatura);

        for (TemperaturaMes TM : temperaturaMes){
            if(TM.getTempetura() > mediaTemperatura){
                System.out.println(TM.getMes() + ": " + TM.getTempetura());
            }
        }

    }

}

class TemperaturaMes {
    private String mes;
    private Double tempetura;

    public TemperaturaMes(String mes, Double tempetura) {
        this.mes = mes;
        this.tempetura = tempetura;
    }

    public String getMes() {
        return mes;
    }

    public Double getTempetura() {
        return tempetura;
    }


}

enum Meses {
    JANEIRO,
    FERVEREIRO,
    MARCO,
    ABRIL,
    MAIO,
    JUNHO,
    JULHO
}