package atividade_01;

import java.util.ArrayList;
import java.util.Collections;

public class Atividade_01 {

    public static void main(String[] args) {
        ArrayList<Integer> valores = new ArrayList<Integer>();
        int i = 1;
        
        valores.add(8);
        valores.add(5);
        valores.add(10);
        valores.add(5);
        valores.add(2);
        valores.add(4);
        valores.add(4);
        valores.add(3);
        //ordena os valores
        Collections.sort(valores);
        //System.out.println(valores);
        
        //remove os duplicados
        for (int x = 0; x < valores.size(); x++) {
            if (valores.get(x).equals(valores.get(i))) {
                valores.remove(x);                                                
            }else{
                i++;
            }
        }
        System.out.println(valores);
    }
}
