package ai.pickar.currencyconverter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor @Getter @Setter
public class CurrencyConversionEvent {
    @Id @GeneratedValue
    private UUID id;
    private LocalDate createdAt;
    private Double amount;
    private Double exchangeRate;
    private Double result;
    private String fromCurrency;
    private String toCurrency;

    public CurrencyConversionEvent(
            Double amount,
            Double exchangeRate,
            Double result,
            String fromCurrency,
            String toCurrency
    ) {
        this.createdAt = LocalDate.now();
        this.amount = amount;
        this.exchangeRate = exchangeRate;
        this.result = result;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }
}
