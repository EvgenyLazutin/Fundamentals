
package com.epam;


import static java.lang.Math.E;

public class Task_2 {
//private double e= E;
static void numberOfElSmollerE(int mas[]){
for(int i=0; i<mas.length;i++){
    int tmp;
    tmp = mas[i];
    double x=1/(Math.pow((tmp+1),2));
    if(x < E) System.out.println("Number of min element is:" + i);
    else{
        System.out.println("Volume:" + x);
    }
}
}
}
