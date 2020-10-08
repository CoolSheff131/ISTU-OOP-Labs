package com.main;
import com.main.Classes.*;
import java.io.*;
import java.util.Scanner;

/*
12.
a. Дан массив чисел, знак операции и операнд. Выведите на печать
массив, полученный в результате арифметического действия, совершенного над элементами массива.
b. Подсчитайте количество гласных букв в заданном тексте.
c. Переставьте слова в предложении в обратном порядке.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//--------инициализируем классы----------------
        //-----входные данные------------

        int[] massive=new int[]{1,2,3,4};
        int kolI;
        int kolWords;
        String[] wordz=new String[]{"A","B","C","D","E"};
        char znak='+';
        int operand=10;
        int Ch=0;
        Scanner inp = new Scanner(System.in);
       // System.out.print("Вводить данные с консоли? (1=yes)\n");
       // Ch=inp.nextInt();
        if(Ch==1) {
            System.out.print("Введите знак операции\n");
            String ui = inp.next();
            znak=ui.charAt(0);
            System.out.print("Введите операнд\n");
            operand = inp.nextInt();
            System.out.print("Введите количество элементов в массиве чисел\n");
            kolI = inp.nextInt();
            massive=new int[kolI];
            for (int i = 0; i < kolI; i++) {
                System.out.print("Введите "+(i+1)+" элемент массива чисел"+"\n");
                massive[i] = inp.nextInt();
            }
            System.out.print("Введите количество элементов в массиве слов\n");
            kolWords = inp.nextInt();
            wordz=new String[kolWords];
            for (int i = 0; i < kolWords; i++) {
                System.out.print("Введите "+(i+1)+" элемент массива слов"+"\n");
                wordz[i] = inp.next();
            }
        }


        //-----задаем данные------------
        //   TextToRevOrCountVowel words=new TextToRevOrCountVowel(wordz);
        //   ArrayOfInt numbers = new ArrayOfInt(massive);


        //---Не задаем данные-----------
        ArrayOfInt numbers2 = new ArrayOfInt();
        TextToRevOrCountVowel words2=new TextToRevOrCountVowel();


        //---копируем данные через конструктор------------
        //  ArrayOfInt numbers3 = new ArrayOfInt(numbers);
        //  TextToRevOrCountVowel words3=new TextToRevOrCountVowel(words);

        // numbers2.setElementMassive(200,1);

        //---копируем данные через сериализацию------------
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObwriteToByteArrayOS(numbers2,baos);
        ArrayOfInt numbers4 = ObReadFromByteArray(baos.toByteArray());

        ObwriteToByteArrayOS(words2,baos);
        TextToRevOrCountVowel words4= ObReadFromByteArray(baos.toByteArray());


        //System.out.print("\nКоличество гласных в тексте 1 (С задаными значениями) "+words+ " = " + words.GetCountVowelInText());
        System.out.print("\nКоличество гласных в тексте 2 (С не задаными значениями) "+words2+" = " + words2.GetCountVowelInText());
        //System.out.print("\nКоличество гласных в тексте 3 (копироваными значениями из 1 массива) "+words3+" = " + words3.GetCountVowelInText());
        System.out.print("\nКоличество гласных в тексте 4 (С копироваными значениями из 2 массива методом сериализации) "+words4+" = " + words4.GetCountVowelInText());

        System.out.print("\n");

        //seeWords(words,"1 (С задаными значениями) ");
        seeWords(words2,"2 (С не задаными значениями) ");
        //seeWords(words3,"3 (копироваными значениями из 1 массива) ");
        seeWords(words4,"4 (копироваными значениями из 2 массива методом сериализации) ");

        System.out.print("\n");

        //seeMass(numbers,"1 (С задаными значениями) ",znak,operand);
        seeMass(numbers2,"2 (С не задаными значениями) ",znak,operand);
        //seeMass(numbers3,"3 (С копироваными значениями из 1 массива) ",znak,operand);
        seeMass(numbers4,"4 (С копироваными значениями из 2 массива методом сериализации) ",znak,operand);

    }

    private static void seeMass(ArrayOfInt A, String num, char znak, int operand){
    System.out.print("\nИсходный "+num+" массив чисел знак "+znak+" операнд "+operand+"\n"+A);
    A.ChangeArrayOfNumbers(znak,operand);
    System.out.print("\n Измененный "+num+"массив чисел"+"\n "+A);
}
    private static void seeWords(TextToRevOrCountVowel A,String num){
        System.out.print("\nИсходный "+num+" массив слов "+"\n"+A);
        A.ReverseArrayOfWords();
        System.out.print("\n Переставленный "+num+"массив слов"+"\n "+A);
    }



    //-----Клонирование объкта методом сериализации


    private static <T> void ObwriteToByteArrayOS(T A, ByteArrayOutputStream baos) throws IOException{
        //сбросить байты
        baos.reset();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(A);
        ous.close();
    }

    private static <T> T ObReadFromByteArray(byte[] baos) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(baos);//считать из массива байтов buf
        ObjectInputStream ois = new ObjectInputStream(bais);
        T B = (T)ois.readObject();
        ois.close();
        return B;
    }

}