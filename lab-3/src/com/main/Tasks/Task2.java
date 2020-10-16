package com.main.Tasks;

import com.main.Classes.TextToRevOrCountVowel;
import com.main.Interfaces.Tasks;
import com.main.Menu;

//b. Подсчитайте количество гласных букв в заданном тексте.
public class Task2 implements Tasks {
    @Override
    public void doTask() {
        TextToRevOrCountVowel txt= new TextToRevOrCountVowel(Menu.menuVvod());
        Menu.menuVivod(String.valueOf(txt.GetCountVowelInText()));
    }

    @Override
    public void showTask(int kol) {
        System.out.println(kol+" Подсчитайте количество гласных букв в заданном тексте.");
    }
}
