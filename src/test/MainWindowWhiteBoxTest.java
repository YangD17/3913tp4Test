//WHITE BOX TESTS for currencyConverter.MainWindow.convert(String, String, ArrayList<Currency>, Double):
//        Coverage Instruction Cases:
//        Valid input currencies (USD to EUR), positive amount.
//        Valid input currencies (EUR to USD), negative amount.
//        Invalid input currencies, positive amount.
//        Valid input currencies (USD to EUR), zero amount.
//        Valid input currencies (USD to EUR), large amount.
//        Null or empty input currencies, positive amount.
//        Null ArrayList<Currency>, positive amount.
//        Valid input currencies (USD to EUR), null amount.


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.ArrayList;

public class MainWindowWhiteBoxTest {

    @Test
    public void testConvertValidCurrenciesPositiveAmount() {
        ArrayList<Currency> currencies = Currency.init();
        Double result = MainWindow.convert("USD", "EUR", currencies, 100.0);
        assertEquals(93.0, result, 0.01);
    }

    @Test
    public void testConvertValidCurrenciesNegativeAmount() {
        ArrayList<Currency> currencies = Currency.init();
        Double result = MainWindow.convert("EUR", "USD", currencies, -50.0);
        assertEquals(-53.65, result, 0.01);
    }

    @Test
    public void testConvertInvalidCurrenciesPositiveAmount() {
        ArrayList<Currency> currencies = Currency.init();
        try {
            Double result = MainWindow.convert("XYZ", "USD", currencies, 75.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testConvertValidCurrenciesZeroAmount() {
        ArrayList<Currency> currencies = Currency.init();
        Double result = MainWindow.convert("USD", "EUR", currencies, 0.0);
        assertEquals(0.0, result, 0.01);
    }

    @Test
    public void testConvertValidCurrenciesLargeAmount() {
        ArrayList<Currency> currencies = Currency.init();
        Double result = MainWindow.convert("USD", "EUR", currencies, 1000000.0);
        assertEquals(930000.0, result, 0.01);
    }

    @Test
    public void testConvertNullOrEmptyInputCurrencies() {
        ArrayList<Currency> currencies = Currency.init();
        try {
            Double result = MainWindow.convert(null, "USD", currencies, 50.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            Double result = MainWindow.convert("", "USD", currencies, 50.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testConvertNullArrayListPositiveAmount() {
        try {
            Double result = MainWindow.convert("USD", "EUR", null, 50.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testConvertValidCurrenciesNullAmount() {
        ArrayList<Currency> currencies = Currency.init();
        try {
            Double result = MainWindow.convert("USD", "EUR", currencies, null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}

