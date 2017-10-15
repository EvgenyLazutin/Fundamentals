package com.epam.Intro;

import static java.lang.Math.tan;

public class IntroTask3 {
    private int x;
    private int y;
    IntroTask3(int CoordinateX,int CoordinateY){
        x=CoordinateX;
        y=CoordinateY;
    }
    void FunctionF(int Step){
        int tmpX=x;
        int tmpY=y;
        System.out.println("______________________________________________________");
        System.out.println("|_______Argument_____________|___Rezult_of_Function___|");
        while (tmpX<=tmpY){
            double F= tan(2*(double)tmpX)-3;
            System.out.format("|%08d____________________|_____%+5.3f_____________|%n",tmpX,F );
            tmpX+=Step;
        }

    }
}
