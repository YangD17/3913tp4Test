package test;
import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MainWindowTest {

    @Test
    void convert() {
        ArrayList<Currency> currencies = new ArrayList<>();
        Currency currency1 = new Currency("US Dollar", "USD");
        Currency currency2 = new Currency("Euro", "EUR");
        currencies.add(currency1);
        currencies.add(currency2);

        currency1.getExchangeValues().put("EUR", 0.93);

        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 100.0);

        assertEquals(93.0, result, 0.01);
    }
    @Test
    void testConvertNoCurrency1() {
        ArrayList<Currency> currencies = new ArrayList<>();
        Currency currency2 = new Currency("Euro", "EUR");
        currencies.add(currency2);

        Double result = MainWindow.convert("USD", "EUR", currencies, 100.0);

        assertEquals(0.0, result);
    }

    @Test
    void testConvertNoCurrency2() {
        ArrayList<Currency> currencies = new ArrayList<>();
        Currency currency1 = new Currency("US Dollar", "USD");
        currencies.add(currency1);

        Double result = MainWindow.convert("USD", "EUR", currencies, 100.0);

        assertEquals(0.0, result);
    }
}
