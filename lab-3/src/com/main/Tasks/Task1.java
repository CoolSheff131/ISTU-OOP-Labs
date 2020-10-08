package com.main.Tasks;

import com.main.Classes.ArrayOfInt;
import com.main.Interfaces.Tasks;
import com.main.Menu;

//a. Дан массив чисел, знак операции и операнд. Выведите на печать
//массив, полученный в результате арифметического действия, совершенного над элементами массива.
public class Task1  implements Tasks {
    @Override
    public void doTask() {
        ArrayOfInt arr=null;
        do {

        try {
            arr = new ArrayOfInt(Menu.menuVvod());
            break;
        }catch (NumberFormatException e){
            System.out.println("Ошибка ввода. вы ввели не число");
        }
        }while (true);
        arr.ChangeArrayOfNumbers('+',10);
        Menu.menuVivod(arr.toString());
    }

    @Override
    public void showTask() {
        System.out.println("Дан массив чисел, знак операции и операнд. Выведите на печать массив, полученный в результате арифметического действия, совершенного над элементами массива.");
    }
}
