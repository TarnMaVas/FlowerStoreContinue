package ua.edu.ucu.apps.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.flower.Flower;
import ua.edu.ucu.apps.flower.FlowerBucket;
import ua.edu.ucu.apps.flower.FlowerColor;
import ua.edu.ucu.apps.flower.FlowerInfo;
import ua.edu.ucu.apps.flower.FlowerPack;
import ua.edu.ucu.apps.flower.FlowerType;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int DEFAULT_PRICE = 10;
    private static final int DEFAULT_LENGTH = 5;
    private static final int DEFAULT_COUNT = 5;
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                FlowerColor.RED, FlowerType.ROSE);
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testMatches() {

        Flower flowerA = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                FlowerColor.RED, FlowerType.ROSE);
        Flower flowerB = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfoA = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfoB = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                FlowerColor.RED, FlowerType.ROSE);
        FlowerInfo flowerInfoC = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                FlowerColor.RED, FlowerType.TULIP);
    
        List<FlowerInfo> matchingList = new ArrayList<>();
        matchingList.add(flowerInfoA);
        matchingList.add(flowerInfoB);

        List<FlowerInfo> notMatchingList = new ArrayList<>();
        notMatchingList.add(flowerInfoA);
        notMatchingList.add(flowerInfoC);
    
        FlowerPack flowerPackA = new FlowerPack(flowerA, DEFAULT_COUNT);
        FlowerPack flowerPackB = new FlowerPack(flowerB, DEFAULT_COUNT);

        flowerBucket.add(flowerPackA);
        flowerBucket.add(flowerPackB);
    
        Assertions.assertTrue(flowerBucket.matches(matchingList));
        Assertions.assertFalse(flowerBucket.matches(notMatchingList));
    }
}
