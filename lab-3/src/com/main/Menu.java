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
static private ArrayList<InpOut> inpOuts;
    static public void starts(){
        setLists();
        showTasks();
        do {
        System.out.println("Выберите какую задачу делать");
            try {
                tasks.get(makeChoice()).doTask();
                break;
            }catch (IndexOutOfBoundsException e){
                System.out.println("Ошибка ввода.Неверно введен номер задачи");
            }
        }while(true);
    }

    static public void showTasks(){
        System.out.println("список задач:");
        for(int i=0;i<tasks.size();i++)
            tasks.get(i).showTask(i+1);
    }
    static public String[] menuVvod(){
        return menuVvod(false);
    }

    static public String[] menuVvod(boolean numb){
        System.out.println("Выберите как вводить данные из консоли (1) или из файла (2)");
        do{
            try {
                return inpOuts.get(makeChoice()).vvod(numb);
            }catch (IndexOutOfBoundsException e){
                System.out.println("Ошибка ввода.Неверно введен номер способа ввода");
            }
        }while (true);
    }
    static public void menuVivod(String A){
        menuVivod(A,false);
    }
    static public void menuVivod(String A,boolean numb){
        System.out.println("Выберите как выводить данные в консоль (1) или в файл (2)");
        do{
            try {
                 inpOuts.get(makeChoice()).vivod(A,numb);
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
        inpOuts = new ArrayList<InpOut>();
        inpOuts.add(new IOConsole());
        inpOuts.add(new IOFile());
    }

    static private int makeChoice(){
        do {
            try{
            return Integer.parseInt(inp.next())-1;
            }catch (NumberFormatException  e){
                System.out.println("Ошибка ввода. вы ввели не число");
            }
        }while (true);
    }
}
