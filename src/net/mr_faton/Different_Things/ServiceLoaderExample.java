package net.mr_faton.Different_Things;

import javax.sound.sampled.spi.AudioFileReader;
import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * Created by Mr_Faton on 12.05.2015.
 */
public class ServiceLoaderExample {
    public static void main(String[] args) {
        System.out.println("Все реализации интерфейса java.sql.Driver:");
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            System.out.println(driver);
        }

        System.out.println("\nВсе реализации интерфейса javax.sound.sampled.spi.AudioFileReader:");
        ServiceLoader<AudioFileReader> audioFileReaders = ServiceLoader.load(AudioFileReader.class);
        for (AudioFileReader audioFileReader : audioFileReaders) {
            System.out.println(audioFileReader);
        }
    }
}
