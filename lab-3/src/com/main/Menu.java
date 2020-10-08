package com.main;

import com.main.InpOut.IOConsole;
import com.main.InpOut.IOFile;
import com.main.Interfaces.InpOut;
import com.main.Interfaces.Tasks;
import com.main.Tasks.Task1;
import com.main.Tasks.Task2;
import com.main.Tasks.Task3;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
static private Scanner inp;
static private ArrayList<Tasks> tasks;
static private ArrayList<InpOut> io;
    static public void starts(){
        do {
        System.out.println("Выберите какую задачу выбрать");
            try {
                tasks.get(makeChoice() - 1).doTask();
                break;
            }catch (IndexOutOfBoundsException e){
                System.out.println("Ошибка ввода.Неверно введен номер задачи");
            }
        }while(true);
    }
    static public void showTasks(){
        System.out.println("список задач");
        for(int i=0;i<tasks.size();i++)
            tasks.get(i).showTask();
    }
    static public String[] menuVvod(){
        System.out.println("Выберите как вводить данные из консоли (1) или из файла (2)");
        do{
            try {
                return io.get(makeChoice() - 1).vvod();
            }catch (IndexOutOfBoundsException e){
                System.out.println("Ошибка ввода.Неверно введен номер способа ввода");
            }
        }while (true);
    }
    static public void menuVivod(String A){
        System.out.println("Выберите как выводить данные в консоль (1) или в файл (2)");
        do{
            try {
                 io.get(makeChoice()-1).vivod(A);
                 break;
            }catch (IndexOutOfBoundsException e){
                System.out.println("Ошибка ввода.Неверно введен номер способа вывода");
            }
        }while (true);
    }
    static public void setLists(){
        inp = new Scanner(System.in);
        tasks = new ArrayList<Tasks>();
        tasks.add(new Task1());
        tasks.add(new Task2());
        tasks.add(new Task3());
        io = new ArrayList<InpOut>();
        io.add(new IOConsole());
        io.add(new IOFile());
    }
    static private int makeChoice(){
        do {
            try{
            return Integer.parseInt(inp.next());
            }catch (NumberFormatException e){
                System.out.println("Ошибка ввода. вы ввели не число");
            }
        }while (true);
    }
}
