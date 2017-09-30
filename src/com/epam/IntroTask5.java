package com.epam;

public class IntroTask5 {
private int matrica[][];
IntroTask5(int hight, int wight) {
    matrica = new int[hight][wight];
    for (int i = 0,k = wight-1; i < hight; i++,k--) {
        for (int j = 0; j < wight; j++) {
           if (j == i) {
                matrica[i][j] = 1;
                continue;
            }
            if (k==j) {
                matrica[i][k] = 1;
                continue;
            }
            matrica[i][j] = 0;
        }
    }
}
void printMatrica() {
    for (int[] iter : matrica) {
        System.out.print("|");
        for (int iter2 : iter) {
            System.out.print(" "+iter2);
        }
        System.out.println(" |");
    }
}
}
