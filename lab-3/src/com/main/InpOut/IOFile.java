package com.main.InpOut;

import com.main.Interfaces.InpOut;
import java.util.Arrays;

import java.io.*;
import java.util.Scanner;

public class IOFile implements InpOut {
    @Override
    public String[] vvod(boolean numb) {
        StringBuilder mas = new StringBuilder();

        System.out.println("Введите название файла откуда вводить данные");
        Scanner inp =new Scanner(System.in);
        File file;

        do {
            if(numb)
            file = new File(inp.next()+".bin");
            else
            file = new File(inp.next()+".txt");
            if (!file.exists())
                System.out.println("Файл не существует");
            else break;
        }while (true);

            if (numb) {
                try(InputStream is =  new FileInputStream(file);DataInputStream dis =  new DataInputStream(is)){

                    while(dis.available()>0) {
                    String k = String.valueOf(dis.readInt());
                    mas.append(k).append(" ");
                    }

                }catch (Exception e){
                    System.out.println("Ошибка ввода");
                }
            } else
                try (FileReader fi = new FileReader(file);BufferedReader bf = new BufferedReader(fi)){

                        mas.append(bf.readLine()).append(" ");

                } catch (IOException e) {
                    System.out.println("Ошибка ввода");
                }

        System.out.println(mas);
        return mas.toString().replaceAll("[\\s]{2,}", " ").split(" ");
    }

    @Override
    public void vivod(String txt,boolean numb) {
        System.out.println("Введите название файла куда выводить результат");
        Scanner inp =new Scanner(System.in);
        File file;
        do {
            if(numb)
            file = new File(inp.next()+".bin");
            else
            file = new File(inp.next()+".txt");
            if (!file.exists())
                System.out.println("Файл не существует");
            else break;
        }while (true);

        if(numb) {
            try(FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos)) {

                String[]numbers=txt.split(" ");
                for (String i:numbers) {
                dos.writeInt(Integer.parseInt(i));
                }

            }catch (IOException e){
                System.out.println("Ошибка вывода");
            }
        }else
        try (FileWriter writer = new FileWriter(file, false)) {

            writer.write(txt);

        } catch (IOException ex) {
            System.out.println("Ошибка вывода");
        }
    }
}
