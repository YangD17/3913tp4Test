package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyConverterTest {

    @Test
    public void testConvert() {
        Double amount = 100.0;
        Double exchangeValue = 0.93;

        Double result = Currency.convert(amount, exchangeValue);

        assertEquals(93.0, result, 0.01);
    }

    @Test
    public void testConvertZero() {
        Double amount = 0.0;
        Double exchangeValue = 0.93;

        Double result = Currency.convert(amount, exchangeValue);

        assertEquals(0.0, result, 0.01);
    }

    @Test
    public void testConvertNegative() {
        Double amount = -100.0;
        Double exchangeValue = 0.93;

        Double result = Currency.convert(amount, exchangeValue);

        assertEquals(-93.0, result, 0.01);
    }

    @Test
    public void testConvertRounding() {
        Double amount = 100.123;
        Double exchangeValue = 0.935;

        Double result = Currency.convert(amount, exchangeValue);

        assertEquals(93.62, result, 0.01);
    }
}
