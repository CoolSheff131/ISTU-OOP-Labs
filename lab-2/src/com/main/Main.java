package com.main;
import com.main.Classes.*;
import java.io.*;

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
        String txt="ZCX";
        int[] massive=new int[]{1,2,3,4};
        String[] wordz=new String[]{"A","B","C","D","E"};
        char znak='/';
        int operand=0;
        //-----задаем данные------------
        TextToCountVowel Test = new TextToCountVowel(txt);
        ArrayOfInt numbers = new ArrayOfInt(massive);
        ArrayOfWords words = new ArrayOfWords(wordz);
          //---Не задаем данные-----------
        TextToCountVowel Test2 = new TextToCountVowel();
        ArrayOfInt numbers2 = new ArrayOfInt();
        ArrayOfWords words2 = new ArrayOfWords();
        //---копируем данные через конструктор------------
        TextToCountVowel Test3 = new TextToCountVowel(Test2);
        ArrayOfInt numbers3 = new ArrayOfInt(numbers2);
        ArrayOfWords words3 = new ArrayOfWords(words2);
        //---копируем данные через сериализацию------------
        TextToCountVowel Test4 = CloneOb(Test);
        ArrayOfInt numbers4 = CloneOb(numbers);
        ArrayOfWords words4 = CloneOb(words);
        //----------------------------------------
        System.out.print("\n--------------НАЧАЛО--------------");
        System.out.print("\nКоличество гласных в тексте "+Test.getTxt()+ " = " + Test.GetCountVowelInText());
        System.out.print("\nКоличество гласных в тексте "+Test2.getTxt()+" = " + Test2.GetCountVowelInText());
        System.out.print("\nКоличество гласных в тексте "+Test3.getTxt()+" = " + Test3.GetCountVowelInText());
        System.out.print("\nКоличество гласных в тексте "+Test4.getTxt()+" = " + Test4.GetCountVowelInText());
        seeMass(numbers,1,znak,operand);
        seeMass(numbers2,2,znak,operand);
        seeMass(numbers3,3,znak,operand);
        seeMass(numbers4,4,znak,operand);
        seeWords(words,1);
        seeWords(words2,2);
        seeWords(words3,3);
        seeWords(words4,4);
        System.out.print("\n--------------КОНЕЦ--------------");
    }
    private static void seeMass(ArrayOfInt A, int num, char znak, int operand){
    System.out.println("\nИсходный "+num+" массив чисел знак "+znak+" операнд "+operand);
    System.out.print(A);
    System.out.println("\nИзмененный "+num+" массив чисел");
    A.ChangeArrayOfNumbers(znak,operand);
    System.out.print(A);
}
    private static void seeWords(ArrayOfWords A,int num){
        System.out.println("\nИсходный 1 массив слов");
        System.out.print(A);
        System.out.println("\nПереставленный 1 массив слов");
        A.ReverseArrayOfWords();
        System.out.print(A);
    }
    //-----Клонирование объкта методом сериализации
    private static <T> T CloneOb(T A) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);

        ous.writeObject(A);
        ous.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        T B = (T)ois.readObject();
        return B;
        }
}