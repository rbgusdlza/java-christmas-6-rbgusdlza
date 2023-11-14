package christmas.domain;

public enum Menu {
    MUSHROOM_SOUP("appetizer", 6_000, "양송이수프"),
    TAPAS("appetizer", 5_500, "타파스"),
    CAESAR_SALAD("appetizer", 8_000, "시저샐러드"),
    T_BONE_STEAK("main", 55_000, "티본스테이크"),
    BARBECUE_RIBS("main", 54_000, "바비큐립"),
    SEAFOOD_PASTA("main", 35_000, "해산물파스타"),
    XMAS_PASTA("main", 25_000, "크리스마스파스타"),
    CHOCOLATE_CAKE("dessert", 15_000, "초코케이크"),
    ICE_CREAM("dessert", 5_000, "아이스크림"),
    ZERO_COKE("beverage", 3_000, "제로콜라"),
    RED_WINE("beverage", 60_000, "레드와인"),
    CHAMPAGNE("beverage", 25_000, "샴페인");

    private final String type;
    private final int price;
    private final String name;

    private Menu(String type, int price, String name) {
        this.type = type;
        this.price = price;
        this.name = name;
    }

    public static Menu getMenu(String name) {
        for (Menu menu : values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
