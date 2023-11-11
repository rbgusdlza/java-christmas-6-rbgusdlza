package christmas.domain;

public enum Menu {
    MUSHROOM_SOUP("appetizer", 6_000),
    TAPAS("appetizer", 5_500),
    CAESAR_SALAD("appetizer", 8_000),
    T_BONE_STEAK("main", 55_000),
    BARBECUE_RIBS("main", 54_000),
    SEAFOOD_PASTA("main", 35_000),
    XMAS_PASTA("main", 25_000),
    CHOCOLATE_CAKE("desert", 15_000),
    ICE_CREAM("desert", 5_000),
    ZERO_COKE("beverage", 3_000),
    RED_WINE("beverage", 60_000),
    CHAMPAGNE("beverage", 25_000);

    private final String course;
    private final int price;

    private Menu(String course, int price) {
        this.course = course;
        this.price = price;
    }
}
