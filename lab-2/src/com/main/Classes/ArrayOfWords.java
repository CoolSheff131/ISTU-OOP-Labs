package com.main.Classes;

import java.io.Serializable;

public class ArrayOfWords implements Serializable {
    //-------------поля-----------------
    private String []words;
//------------------------------------------------------------------------
    //----конструктор без аргументов-----------
    public ArrayOfWords(){
        this.words=new String[]{"qasd","asfd","zxcvcb","1234","65ehet"};
    }
    //----конструктор копирования--------------
    public ArrayOfWords(ArrayOfWords A){
        this.words=new String[A.words.length];
        for (int i=0;i<A.words.length;i++) {this.words[i]=A.words[i];}
    }
    //---конструктор с входными данными---------
    public ArrayOfWords(String []words){
          this.words=words;
    }
    //--------------------------------------
    public void setWords(String[] words) {
        this.words = words;
    }
    public String[] getWords() {
        return words;
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
    public String toString(){
        String word=new String();
        for (String i:words)
         word+=i+" ";
        return word;
    }
}
