package com.main.InpOut;

import com.main.Interfaces.InpOut;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOConsole implements InpOut {
    @Override
    public String[] vvod(boolean numb) {

        int kol=0;
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите количество элементов массива");
        do {
            try {
                kol = Integer.parseInt(inp.next());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Ошибка ввода. Вы ввели не число");
            }
        }while(true);
        String[] mas = new String[kol];
        for (int i = 0; i < mas.length; i++) {
            System.out.println("Введите элемент " + (i + 1) + " массива");
            mas[i] = inp.next();
        }
        return mas;
    }

    @Override
    public void vivod(String txt,boolean numb) {
        System.out.println(txt);
    }
}
