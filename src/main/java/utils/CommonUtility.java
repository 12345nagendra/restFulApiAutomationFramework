package main.java.utils;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonUtility {
    public static int generateRandomYear(int min) {
        int max = Year.now().getValue();
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static float generateRandomPrice(float min, float max) {
        Random random = new Random();
        return min + random.nextFloat() * (max - min);
    }

    public static String generateRandomHardDiskSize() {
        String[] hardDiskSizes = {"128GB", "256GB", "512GB", "1TB", "2TB", "4TB"};
        int index = generateRandomIndex(hardDiskSizes.length);
        return hardDiskSizes[index];
    }

    public static String generateRandomCpuModels() {
        String[] cpuModels = {"Intel Core i7", "AMD Ryzen 9", "Intel Core i9", "AMD Ryzen 7", "Intel Core i5"};
        // Generate a random index to select a CPU model from the array
        int randomIndex = generateRandomIndex(cpuModels.length);

        // Get the randomly selected CPU model
        return cpuModels[randomIndex];
    }

    public static String generateRandomProductName() {
        String[] adjectives = {"Awesome", "Fantastic", "Sleek", "Powerful", "Innovative"};
        String[] nouns = {"Laptop", "Notebook", "Computer", "Chromebook", "Ultrabook"};

        int index1 = generateRandomIndex(adjectives.length);
        int index2 = generateRandomIndex(nouns.length);
        String adjective = adjectives[index1];
        String noun = nouns[index2];

        return adjective + " " + noun;
    }

    public static int generateRandomIndex(int maxIndex) {
        Random random = new Random();
        return random.nextInt(maxIndex);
    }

    // Pass the classLoader and filepath to get the inputStream and don't forget to close the resource
    public static InputStream getInputStreamForFile(ClassLoader classLoader, String filePath) {
        InputStream input = classLoader.getResourceAsStream(filePath);
        return input;
    }

    public static void readCSV(String filePath) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        br.lines().skip(1).map(line -> {
            line.split(" ");
            return new ArrayList();
        }).collect(Collectors.toList());
    }


}
