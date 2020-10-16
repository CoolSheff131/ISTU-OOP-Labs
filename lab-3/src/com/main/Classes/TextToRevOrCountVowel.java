package com.main.Classes;

import com.main.Interfaces.Tasks;

import java.io.Serializable;

public class TextToRevOrCountVowel implements Serializable {

    //-------------поля-----------------
    private String []words;
    //------------------------------------------------------------------------
    //----конструктор без аргументов-----------
    public TextToRevOrCountVowel(){
        this.words=new String[]{"qasd","asfd","zxcvcb","1234","65ehet"};
    }
    //----конструктор копирования--------------
    public TextToRevOrCountVowel(TextToRevOrCountVowel A){
        this.words=new String[A.words.length];
        for (int i=0;i<A.words.length;i++) {this.words[i]=A.words[i];}
    }
    //---конструктор с входными данными---------
    public TextToRevOrCountVowel(String []words){
        this.words=words;
    }
    public TextToRevOrCountVowel(String words){
        words.split(" ");
    }
    //--------------------------------------
    public void setWords(String[] words) {
        this.words = words;
    }
    public String[] getWords() {
        return words;
    }
    public void setWord(int index,String word){
        if(index> words.length-1)
            index= words.length-1;
        this.words[index]=word;
   }
    public String getWord(int index){
       if(index> words.length-1)
           index= words.length-1;
        return words[index];
   }
    //----------задание 3---------------------
    public void ReverseArrayOfWords(){
        String word;
        for(int i=0;i<words.length/2;i++){
            word=words[i];
            words[i]=words[words.length-i-1];
            words[words.length-i-1]=word;
        }
        return ;
    }
    //----------задание 2---------------------
    public int GetCountVowelInText(){
        String txt=toString();
        int kol=0;
        txt=txt.toLowerCase();
        char[] chrtxt=txt.toCharArray();
        for(int i=0;i<chrtxt.length;i++)
            switch (chrtxt[i]){
                case 'a': case'e': case'y':case'u':case'i':case'o': kol++;
            }
        return kol;
    }
    public String toString(){
        String word=new String();
        for (String i:words)
            word+=i+" ";
        return word;
    }
}
