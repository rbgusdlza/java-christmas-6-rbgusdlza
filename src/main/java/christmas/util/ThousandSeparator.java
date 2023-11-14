package christmas.util;

public class ThousandSeparator {
    private static final String MINUS = "-";
    private static final String THOUSAND_SEPARATOR = ",";
    private static final String CURRENCY = "원";

    private ThousandSeparator() {
    }

    public static String addThousandsSeparator(int money) {
        String numbers = String.valueOf(money);
        StringBuilder formattedNumbers = new StringBuilder();
        int count = 0;
        for (int i = numbers.length() - 1; i >= 0; i--) {
            formattedNumbers.insert(0, numbers.charAt(i));
            count++;
            if (count % 3 == 0 && i > 0) {
                formattedNumbers.insert(0, THOUSAND_SEPARATOR);
            }
        }
        return formattedNumbers + CURRENCY;
    }

    public static String addThousandsSeparatorWithMinus(int money) {
        String separatedMoney = addThousandsSeparator(money);
        if (money != 0) {
            return MINUS + separatedMoney;
        }
        return separatedMoney;
    }
}
