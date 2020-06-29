package ai.pickar.currencyconverter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class CurrencyConversionEventDto {
    private Double amount;
    private Double result;
    private Double exchangeRate;
    private String fromCurrency;
    private String toCurrency;
}
