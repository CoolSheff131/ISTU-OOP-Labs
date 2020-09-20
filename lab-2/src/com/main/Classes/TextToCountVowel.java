package com.main.Classes;

import java.io.Serializable;

public class TextToCountVowel implements Serializable {
//-------------поля-----------------
    private String txt;
//----------------СЕТЕРЫ И ГЕТЕРЫ--------------------------------------------------------
    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
//------------------------------------------------------------------------
    //----конструктор без аргументов-----------
    public TextToCountVowel(){
        this.txt="QWERTY";
    }
    //----конструктор копирования--------------
    public TextToCountVowel(TextToCountVowel A){
        this.txt=A.txt;
    }
    //---конструктор с входными данными---------
    public TextToCountVowel(String txt){
        this.txt=txt;
    }
    //----------задание 2---------------------
    public int GetCountVowelInText(){
        txt=txt.toLowerCase();
        int kol=0;
        char[] chrtxt=txt.toCharArray();
        for(int i=0;i<chrtxt.length;i++)
            switch (chrtxt[i]){
                case 'a': case'e': case'y':case'u':case'i':case'o': kol++;
            }
        return kol;
    }
}
