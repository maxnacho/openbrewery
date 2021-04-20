package utilities;

import java.util.Random;

public class Randomizer {

    private Randomizer() {
    }

    public static String generateString(int length, Mode mode) {
        StringBuilder buffer = new StringBuilder();
        String characters = "";

        switch (mode) {
            case ALPHA:
                characters = "abcdefghijklmnopqrstuvwxyz";
                break;

            case ALPHANUMERIC:
                characters = "abcdefghijklmnopqrstuvwxyz1234567890";
                break;

            case CYRILLIC:
                characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
                break;

            case NUMERIC:
                characters = "1234567890";
                break;
        }

        int charactersLength = characters.length();

        for (int i = 0; i < length; i++) {
            double index = Math.random() * charactersLength;
            buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }

    public static Integer generateInteger(int min, int max) {
        return min + (int) (new Random().nextFloat() * (max - min));
    }

    public enum Mode {
        ALPHA, ALPHANUMERIC, CYRILLIC, NUMERIC
    }

}
