package ai.pickar.currencyconverter.service;

import ai.pickar.currencyconverter.dto.CurrencyConversionEventDto;
import ai.pickar.currencyconverter.dto.CurrencyConversionHistoryItemDto;
import ai.pickar.currencyconverter.model.CurrencyConversionEvent;
import ai.pickar.currencyconverter.repository.CurrencyConversionEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyConversionEventService {

    private final CurrencyConversionEventRepository repository;

    @Autowired
    public CurrencyConversionEventService(CurrencyConversionEventRepository repository) {
        this.repository = repository;
    }

    public List<CurrencyConversionHistoryItemDto> getCurrencyConversionHistory() {
        return repository.findAll()
                .stream()
                .map(item ->
                        new CurrencyConversionHistoryItemDto(
                                item.getCreatedAt(),
                                item.getAmount() + " " + item.getFromCurrency(),
                                item.getResult() + " " + item.getToCurrency()
                        )
                )
                .collect(Collectors.toList());
    }

    public void addCurrencyConversion(CurrencyConversionEventDto currencyConversionEventDto) {
        CurrencyConversionEvent currencyConversionEventEntity = new CurrencyConversionEvent(
                currencyConversionEventDto.getAmount(),
                currencyConversionEventDto.getExchangeRate(),
                currencyConversionEventDto.getResult(),
                currencyConversionEventDto.getFromCurrency(),
                currencyConversionEventDto.getToCurrency()
        );
        repository.save(currencyConversionEventEntity);
    }
}
