package com.company;
/*
12.
a. Дан массив чисел, знак операции и операнд. Выведите на печать
массив, полученный в результате арифметического действия, совершенного над элементами массива.
b. Подсчитайте количество гласных букв в заданном тексте.
c. Переставьте слова в предложении в обратном порядке.
 */
public class L1_12 {
    //главный метод
    public static void main(){
	task1();
    task2();
    task3();
    }
//-----------------------------------------------------------------------------
    public static void task1(){
    //---Вводимые данные------
        int []massive={1,2,3,4};
        char znak='/';
        int operand=0;
    //-------решение----------
        System.out.print("\nИсходные данные\n");
        for(int i=0;i<massive.length;i++)
            System.out.print(massive[i]+" ");
        System.out.print("\nЗнак \""+znak+"\" операнд = "+operand);
        System.out.print("\nРезультат\n");
        switch (znak){
            case '+':for(int i=0;i<massive.length;i++)massive[i]+=operand; break;
            case '-':for(int i=0;i<massive.length;i++)massive[i]-=operand; break;
            case '*':for(int i=0;i<massive.length;i++)massive[i]*=operand; break;
            case '/':if(operand==0){System.out.print("Деление на ноль!");return; }for(int i=0;i<massive.length;i++)massive[i]/=operand; break;
            default:System.out.print("Неверно введен знак операции!"); return;
        }
    //-------Вывод------
        for(int i=0;i<massive.length;i++)
            System.out.print(massive[i]+" ");
    }
//-----------------------------------------------------------------------------
    public static void task2(){
    //---Вводимые данные------
        String txt="ZCX";//zxc
        int kol=0;
    //-------решение----------
        System.out.print("\nИсходные данные\n"+txt);
        txt=txt.toLowerCase();
        char[] chrtxt=txt.toCharArray();
        for(int i=0;i<chrtxt.length;i++)
            switch (chrtxt[i]){
            case 'a': case'e': case'y':case'u':case'i':case'o': kol++;
            }
    //-------Вывод------
        System.out.print("\nКоличество глассных в тексте "+kol+"\n");
    }
//-----------------------------------------------------------------------------
    public static void task3(){
    //---Вводимые данные------
    String []txt={"A", "B", "C", "D" ,"E"};

        System.out.print("Исходный текст\n");
        for(int i=0;i<txt.length;i++)
            System.out.print(txt[i]+" ");
    //-------решение----------

    String word;
    for(int i=0;i<txt.length/2;i++){
        word=txt[i];
        txt[i]=txt[txt.length-i-1];
        txt[txt.length-i-1]=word;

    }
    //-------Вывод------
        System.out.print("\nПереставленный в обратном порядке текст\n");
        for(int i=0;i<txt.length;i++)
            System.out.print(txt[i]+" ");
    }
}