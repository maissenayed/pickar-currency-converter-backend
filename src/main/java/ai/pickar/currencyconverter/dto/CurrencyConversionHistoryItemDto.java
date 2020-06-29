package ai.pickar.currencyconverter.dto;

import ai.pickar.currencyconverter.model.Currency;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor @Getter
public class CurrencyConversionHistoryItemDto {
    private LocalDate createdAt;
    private String from;
    private String to;
}
