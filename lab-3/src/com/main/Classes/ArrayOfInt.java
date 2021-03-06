package com.main.Classes;
import com.main.Interfaces.InpOut;
import com.main.Interfaces.Tasks;

import java.io.Serializable;
public class ArrayOfInt  implements Serializable {


    //-------------поля-----------------
    private int []massive;
//------------------------------------------------------------------------
    //----конструктор без аргументов-----------
    public ArrayOfInt(){
        this.massive=new int[]{1,2,3,4};
    }
    //----конструктор копирования--------------
    public ArrayOfInt(ArrayOfInt A){
      // massive=A.massive.clone();
        massive=new int[A.massive.length];
        for (int i=0;i<A.massive.length;i++) {this.massive[i]=A.massive[i];}
    }
    //---конструктор с входными данными---------
    public ArrayOfInt(int []massive){
        this.massive=massive;
    }
    // конструктор со строкой
    public ArrayOfInt(String[] massive){
        int[] arr = new int[massive.length];
        for (int i=0;i< massive.length;i++) {
            arr[i]= Integer.parseInt(massive[i]);
        }
        this.massive=arr;
    }

    public void setMassive(int[] massive) {
        this.massive = massive;
    }
    public void setElementMassive(int element,int index){
        if(index>massive.length-1)
            index=massive.length-1;
        this.massive[index]=element;
    }
    public int getElementMassive(int index){
        if(index>massive.length-1)
            index=massive.length-1;
        return this.massive[index];
    }
    //----------задание 1----------------------
    public int[] getMassive() {
        return massive;
    }
    public void ChangeArrayOfNumbers(char znak,int operand) throws NoSuchMethodException ,ArithmeticException{
        switch (znak){
            case '+':for(int i=0;i<massive.length;i++)massive[i]+=operand; break;
            case '-':for(int i=0;i<massive.length;i++)massive[i]-=operand; break;
            case '*':for(int i=0;i<massive.length;i++)massive[i]*=operand; break;
            case '/':if(operand==0){throw new ArithmeticException(); }for(int i=0;i<massive.length;i++)massive[i]/=operand; break;
            default:throw new NoSuchMethodException();
        }
        return;
    }
    public String toString(){
        String txt=new String();
        for(int i:massive)
            txt+=i+" ";
        return txt;
    }
}
