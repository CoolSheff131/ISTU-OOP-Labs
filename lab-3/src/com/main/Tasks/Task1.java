package com.main.Tasks;

import com.main.Classes.ArrayOfInt;
import com.main.Interfaces.Tasks;
import com.main.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

//a. Дан массив чисел, знак операции и операнд. Выведите на печать
//массив, полученный в результате арифметического действия, совершенного над элементами массива.
public class Task1  implements Tasks {
    @Override
    public void doTask() {
        ArrayOfInt arr=null;
        do {
        try {
            arr = new ArrayOfInt(Menu.menuVvod(true));
            break;
        }catch (NumberFormatException e){
            System.out.println("Ошибка ввода. вы ввели не число");
        }
        }while (true);
        Scanner inp = new Scanner(System.in);
        do {
            try {
                System.out.println("Введите знак операции ");
                char znak = inp.next().charAt(0);

                System.out.println("Введите операнд ");

                int op = 0;
                do {
                    try {
                        op = Integer.parseInt(inp.next());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Вы ввели не число!");
                    }
                } while (true);

                arr.ChangeArrayOfNumbers(znak, op);
                break;
            } catch (ArithmeticException e) {
                System.out.println("Ошибка математической операций! Деление на нуль!");
            } catch (NoSuchMethodException e) {
                System.out.println("Ошибка ввода. Нету такого операнда!");
            }
        }while(true);

        Menu.menuVivod(arr.toString(),true);
    }

    @Override
    public void showTask(int kol) {
        System.out.println(kol+" Дан массив чисел, знак операции и операнд. Выведите на печать массив, полученный в результате арифметического действия, совершенного над элементами массива.");
    }
}
