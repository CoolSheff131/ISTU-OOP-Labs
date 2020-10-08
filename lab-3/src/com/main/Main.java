package com.main;
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
        Menu.setLists();
        Menu.showTasks();
        Menu.starts();
    }
//public static  String[] VvodWordsFromConsole() {
//    int kol;
//    Scanner inp = new Scanner(System.in);
//    kol = inp.nextInt();
//    String[] mas = new String[kol];
//    for (int i = 0; i < mas.length; i++) {
//        System.out.println("Введите элемент" + (i + 1) + " массива");
//        mas[i] = inp.next();
//    }
//    return mas;
//}



//public static  String[] VvodFromFi(String file){
//    String mas="";
//    try(FileReader fi=new FileReader(file);
//        BufferedReader bi=new BufferedReader(fi)) {
//
//        String buf;
//
//
//            buf=bi.readLine();
//
//            while(buf!=null){
//                mas+=buf+" ";
//                buf=bi.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    return mas.split(" ");
//}


//public static int[] VvodmassFromFile(String file){
//
//    int[] mas=new int[10000];
//
//    try(FileReader fi=new FileReader(file);
//        Scanner inp =new Scanner(fi);
//        BufferedReader bi=new BufferedReader(fi)) {
//        int kol=0;
//
//        while(inp.hasNextInt()){
//        mas[kol] = inp.nextInt();
//            System.out.println(mas[kol]);
//        kol++;
//        }
//
//        int [] buf=new int[kol];
//        for (int i=0;i<buf.length;i++) {
//            buf[i]=mas[i];
//        }
//
//        mas=buf;
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//        return mas;
//
//}
}
