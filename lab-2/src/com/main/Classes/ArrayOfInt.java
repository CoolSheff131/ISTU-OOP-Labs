package com.main.Classes;
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
    public void ChangeArrayOfNumbers(char znak,int operand){
        switch (znak){
            case '+':for(int i=0;i<massive.length;i++)massive[i]+=operand; break;
            case '-':for(int i=0;i<massive.length;i++)massive[i]-=operand; break;
            case '*':for(int i=0;i<massive.length;i++)massive[i]*=operand; break;
            case '/':if(operand==0){System.out.print("Деление на ноль! Массив не был изменен\n");return ; }for(int i=0;i<massive.length;i++)massive[i]/=operand; break;
            default:System.out.print("Неверно введен знак операции! Массив не был изменен\n"); return ;
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
