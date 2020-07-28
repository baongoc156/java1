/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch7_bai4;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Poker{
    private static String[] so = {"2","3","4","5","6","7","8","9","10","j","q","k","a"};
    private static String[] loai ={"bich","chuon","ro","co"};
    private ArrayList<String> boBai = new ArrayList<>();
    
    public void setBoBai(ArrayList<String> boBai) {
        this.boBai = boBai;
    }

    public ArrayList<String> getBoBai() {
        return boBai;
    }

    public Poker() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                boBai.add(so[i]+loai[j]);
            }
        }
    }

    public static int getValue(String laBai){
        int num = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                num++;
                if (laBai.equals(so[i]+loai[j])) {
                    return num;
                }
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                s+=boBai.get((i*4)+j)+"\t";
            }
            s+="\n";
        }
        return s;
    }
}
