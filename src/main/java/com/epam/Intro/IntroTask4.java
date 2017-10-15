package com.epam.Intro;

public class IntroTask4 {
    private int[] masInt;

    public IntroTask4(int... masInt) {
        this.masInt = masInt;
    }
   void SearchMaxValue(){
int midle=masInt.length/2;
long MaxValue=0;
for(int i=0;i<masInt.length/2;i++){
    MaxValue+=(long)masInt[i]+masInt[midle];

    midle++;
}
       System.out.println("MaxValue: " + MaxValue);
    }
}
