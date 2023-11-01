package edu.hm4;

public record Animal(String name,
                     Type type,
                     Sex sex,
                     int age,
                     int height,
                     int weight,
                     boolean bites) {
    private static final int NUMBER_OF_PAWS_CAT_DOG = 4;
    private static final int NUMBER_OF_PAWS_SPIDER = 8;

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> NUMBER_OF_PAWS_CAT_DOG;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> NUMBER_OF_PAWS_SPIDER;
        };
    }


    public Type getType() {
        return type;
    }

}
