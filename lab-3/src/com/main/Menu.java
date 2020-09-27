package com.main;

import com.main.Classes.ArrayOfInt;
import com.main.Classes.ArrayOfWords;
import com.main.Classes.TextToCountVowel;

import java.io.*;
import java.util.Scanner;

public class Menu {

    private String txt;
    private static int[] massive;
    private static String[] wordz=new String[]{"A","B","C","D","E"};
    private static char znak='/';
    private static int operand=0;

    private static Scanner inp=new Scanner(System.in);

    public static void Inf(){
        System.out.print("Введите 1 чтобы выбрать 1 задание\n"
                +"Введите 2 чтобы выбрать 2 задание\n"
                +"Введите 3 чтобы выбрать 3 задание\n"
        );
    }
    public static void Vvod(int ch){
        System.out.print(
                "Введите 1 чтобы ввести данные через консоль\n"
                +"Введите 2 чтобы ввести данные через текстовый файл"
                );
        int Rt=inp.nextInt();
        switch (ch){
        case 1://массив чисел
            switch (Rt){
                //консоль
                case 1:
                    System.out.print("Введите кол-во элементов");
                    int n=inp.nextInt();
                    massive =new int[n];
                    for(int i=0;i<n;i++){
                        System.out.print("Введите "+(i+1)+" элемент массива");
                        massive[i]=inp.nextInt();
                    }
                    break;
                //текстовый файл
                case 2: break;
                default:break;
            }
        break;
        case 2: //строка
                switch (Rt){
                    //консоль
                    case 1:txt=inp.nextLine();
                    break;
                    //текстовый файл
                    case 2: try(BufferedReader br = new BufferedReader(new FileReader("notes3.txt")))
                    {
                        // читаем посимвольно
                        System.out.print(br.readLine());
                    }catch(IOException ex){System.out.println(ex.getMessage());}
                    break;
                    default:
                    break;
                }
        break;
        case 3:
            switch (Rt){//массив слов
                //консоль
                case 1:
                    System.out.print("Введите кол-во элементов массива");
                    int n=inp.nextInt();
                    wordz=new String[n];
                    for(int i=0;i<n;i++){
                        System.out.print("Введите "+(i+1)+" элемент массива");
                        wordz[i]=inp.toString();
                    }
                    break;
                //текстовый файл
                case 2: break;
                default:break;
            }
        break;
        }
    }
    public static void Vivod(){
        System.out.print(
                "Введите 1 чтобы выбрать способ вывода в консоль"
                 +"Введите 2 чтобы выбрать способ вывода в текстовый файл файл");

    }

    public static void Pol() throws IOException, ClassNotFoundException {
//-----входные данные-----------------------------------------
        TextToCountVowel Test = new TextToCountVowel(txt);
        ArrayOfInt numbers = new ArrayOfInt(massive);
        ArrayOfWords words = new ArrayOfWords(wordz);
//--------------------------------------------------------------------
        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            String text = "Hello Gold!";
            writer.write(text);
        }     catch(IOException ex){System.out.println(ex.getMessage());}

    int ch;
    boolean R=true;
    Inf();
    do{
        ch=inp.nextInt();
        switch (ch){
            case 1:Vvod(1); seeMass(numbers,znak,operand); break;
            case 2:Vvod(2); System.out.print("\nКоличество гласных в тексте "+Test.getTxt()+ " = " + Test.GetCountVowelInText()); break;
            case 3:Vvod(3); seeWords(words); break;
            default:System.out.print("Ошибка ввода"); break;
        }
        //System.out.print("123");
    }while(R);




        //--------инициализируем классы----------------
        //-----задаем данные------------
//        TextToCountVowel Test = new TextToCountVowel(txt);
//        ArrayOfInt numbers = new ArrayOfInt(massive);
//        ArrayOfWords words = new ArrayOfWords(wordz);
//        //---Не задаем данные-----------
//        TextToCountVowel Test2 = new TextToCountVowel();
//        ArrayOfInt numbers2 = new ArrayOfInt();
//        ArrayOfWords words2 = new ArrayOfWords();
//        //---копируем данные через конструктор------------
//        TextToCountVowel Test3 = new TextToCountVowel(Test2);
//        ArrayOfInt numbers3 = new ArrayOfInt(numbers2);
//        ArrayOfWords words3 = new ArrayOfWords(words2);
//        //---копируем данные через сериализацию------------
//        TextToCountVowel Test4 = CloneOb(Test);
//        ArrayOfInt numbers4 = CloneOb(numbers);
//        ArrayOfWords words4 = CloneOb(words);
//        //----------------------------------------
//        System.out.print("\n--------------НАЧАЛО--------------");
//        System.out.print("\nКоличество гласных в тексте "+Test.getTxt()+ " = " + Test.GetCountVowelInText());
//        System.out.print("\nКоличество гласных в тексте "+Test2.getTxt()+" = " + Test2.GetCountVowelInText());
//        System.out.print("\nКоличество гласных в тексте "+Test3.getTxt()+" = " + Test3.GetCountVowelInText());
//        System.out.print("\nКоличество гласных в тексте "+Test4.getTxt()+" = " + Test4.GetCountVowelInText());
//        seeMass(numbers,1,znak,operand);
//        seeMass(numbers2,2,znak,operand);
//        seeMass(numbers3,3,znak,operand);
//        seeMass(numbers4,4,znak,operand);
//        seeWords(words,1);
//        seeWords(words2,2);
//        seeWords(words3,3);
//        seeWords(words4,4);
//        System.out.print("\n--------------КОНЕЦ--------------");

    }
    private static void seeMass(ArrayOfInt A, char znak, int operand){
        System.out.println("\nИсходный  массив чисел знак "+znak+" операнд "+operand);
        System.out.print(A);
        System.out.println("\nИзмененный массив чисел");
        A.ChangeArrayOfNumbers(znak,operand);
        System.out.print(A);
    }
    private static void seeWords(ArrayOfWords A){
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
