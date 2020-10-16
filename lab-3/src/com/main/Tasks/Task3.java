package com.main.Tasks;

import com.main.Classes.TextToRevOrCountVowel;
import com.main.Interfaces.Tasks;
import com.main.Menu;

//c. Переставьте слова в предложении в обратном порядке.
public class Task3 implements Tasks {
    @Override
    public void doTask() {
        TextToRevOrCountVowel txt =new TextToRevOrCountVowel(Menu.menuVvod());
        txt.ReverseArrayOfWords();
        Menu.menuVivod(txt.toString());
    }

    @Override
    public void showTask(int kol) {
        System.out.println(kol+" Переставьте слова в предложении в обратном порядке.");
    }
}
