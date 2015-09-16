package net.mr_faton.Different_Things.task;

/**
 * Created by root on 16.09.2015.
 */
public class HouseFloorStaircase {
    private static final int FLOORS = 9;
    private static final int ROOMS_PER_FLOOR = 4;

    public static void main(String[] args) {
        int searchedFlat = 73;
        System.out.println("ищем квартиру: " + searchedFlat);

        int resultStaircase = getResultStaircase(searchedFlat);
        int resultFloor = getResultFloor(searchedFlat);

        System.out.println("Подъезд: " + resultStaircase);
        System.out.println("Этаж: " + resultFloor);
    }

    private static int getResultStaircase(int flatNum) {
        int flatsPerStaircase = FLOORS * ROOMS_PER_FLOOR;
        int flats = flatsPerStaircase;
        int staircaseNum = 1;
        while (flats < flatNum) {
            flats = flats + flatsPerStaircase;
            staircaseNum++;
        }
        return staircaseNum;
    }

    private static int getResultFloor(int flatNum) {
        int flatsPerStaircase = FLOORS * ROOMS_PER_FLOOR;
        int staircase = getResultStaircase(flatNum);
        int minFlatsOnStaircase = (staircase * flatsPerStaircase) - flatsPerStaircase + ROOMS_PER_FLOOR;

        int floor = 1;
        while (minFlatsOnStaircase < flatNum) {
            minFlatsOnStaircase += ROOMS_PER_FLOOR;
            floor ++;
        }
        if (floor == 0) return 1;
        return floor;
    }
}
