package ai.pickar.currencyconverter.dto;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor @Getter
public class CurrencyConversionHistoryItemDto {
    private LocalDate createdAt;
    private String from;
    private Double fromAmount;
    private String to;
    private Double toAmount;
}
