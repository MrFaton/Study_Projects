package net.Junior.Servlets.App07_eshop_V2.entity;

import java.util.Random;

/**
 * Created by Mr_Faton on 30.03.2015.
 */
public class JSessionIdCreator {
    private final int[] numberArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] letterArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public synchronized String generateID() {
        Random random = new Random();
        int numberOrLetter = 0;
        int symbolPosition = 0;
        int smallOrBigLetter = 0;
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            numberOrLetter = random.nextInt(2);
            switch (numberOrLetter) {
                case 0: {
                    //number
                    symbolPosition = random.nextInt(numberArr.length);
                    id.append(numberArr[symbolPosition]);
                    break;
                }
                case 1: {
                    //letter
                    symbolPosition = random.nextInt(letterArr.length);
                    smallOrBigLetter = random.nextInt(2);
                    switch (smallOrBigLetter) {
                        case 0: {
                            id.append(letterArr[symbolPosition]);
                            break;
                        }
                        case 1: {
                            id.append(letterArr[symbolPosition].toUpperCase());
                        }
                    }
                }
            }
        }
        return id.toString();
    }
}
