package com.main.InpOut;

import com.main.Interfaces.InpOut;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOFile implements InpOut {
    @Override
    public String[] vvod() {
        StringBuilder mas = new StringBuilder();
        try (FileReader fi = new FileReader("READEHERE.txt")) {
            Scanner inp = new Scanner(fi);
            while (inp.hasNext())
                mas.append(inp.nextLine()).append(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mas.toString().replaceAll("[\\s]{2,}", " ").split(" ");
    }

    @Override
    public void vivod(String txt) {
        try (FileWriter writer = new FileWriter("WRITEHERE.txt", false)) {
            writer.write(txt);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
