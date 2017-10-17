package com.epam.Oop;


@ClassPreamble(
        date = "17.10.2017"
)
public class Submarine {
    private String name;
    private Engine engine;
    private int depth;

    public Submarine(String name) {
        this.name = name;
        engine=new Engine();
    }
    void diveSubmarine(int depth){
        this.depth=depth;
        engine.runEngine();
        for (int i = 0; i <= depth ; i++) {
            System.out.println("Depth is: "+i +"meters.");
        }
        engine.stopEngine();
    }
    void upSubmarine(){
        engine.runEngine();
        for (int i = depth; i >=0 ; i--) {
            System.out.println("Depth is: "+i +"meters.");
        }
        engine.stopEngine();
    }

    class Engine{

        private void runEngine(){
            System.out.println("Engine is run!");
        }
        private void stopEngine(){
            System.out.println("Engine is stop");
        }
    }
    public static void main(String[] args) {
        Submarine testSub=new Submarine("B52");
        testSub.diveSubmarine(10);
        testSub.upSubmarine();

    }
}
