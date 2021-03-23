package ru.skillbox;

public class Elevator {
    private int currentFloor;
    private int minFloor;
    private int maxFloor;

    public Elevator() {
        currentFloor = 1;
    }

    public Elevator(int minFloor, int maxFloor) {
        this();
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown(){
        currentFloor = (currentFloor > minFloor) ? currentFloor - 1 : minFloor;
    }

    public void moveUp(){
        currentFloor = (currentFloor < maxFloor) ? currentFloor + 1 : maxFloor;
    }

    public void move(int floor){
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Неверный этаж");
        } else {
            if (floor < currentFloor) {
                while (!(floor == currentFloor)){
                    moveDown();
                    System.out.println("Текущий этаж - " + currentFloor);
                }
            } else {
                while (!(floor == currentFloor)) {
                    moveUp();
                    System.out.println("Текущий этаж - " + currentFloor);
                }
            }
        }
    }
}