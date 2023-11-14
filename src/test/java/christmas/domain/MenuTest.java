package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("메뉴 이름을 주어졌을 때 메뉴를 반환하는 기능을 테스트한다.")
    @Test
    public void getMenuNameWhenGivenMenu() {
        Menu menu = Menu.getMenu("아이스크림");
        assertEquals(Menu.ICE_CREAM, menu);
    }

    @DisplayName("잘못된 메뉴 이름이 주어졌을 때 null을 반환하는 기능을 테스트한다.")
    @Test
    public void getMenuInvalidName() {
        Menu menu = Menu.getMenu("건빵");
        assertNull(menu);
    }

    @DisplayName("메뉴 이름으로 toString 처리되게 하는 기능을 테스트한다.")
    @Test
    public void getMenuNameToString() {
        String menuName = Menu.CAESAR_SALAD.toString();
        assertEquals("시저샐러드", menuName);
    }

    @DisplayName("메뉴 종류를 반환하는 기능을 테스트한다.")
    @Test
    public void getMenuValidType() {
        String type = Menu.RED_WINE.getType();
        assertEquals("beverage", type);
    }

    @DisplayName("메뉴 가격을 반환하는 기능을 테스트한다.")
    @Test
    public void getMenuValidPrice() {
        int price = Menu.T_BONE_STEAK.getPrice();
        assertEquals(55_000, price);
    }

    @DisplayName("메뉴 이름을 반환하는 기능을 테스트한다.")
    @Test
    public void getMenuValidName() {
        String name = Menu.XMAS_PASTA.getName();
        assertEquals("크리스마스파스타", name);
    }
}
