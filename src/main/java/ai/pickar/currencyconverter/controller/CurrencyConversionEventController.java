package ai.pickar.currencyconverter.controller;

import ai.pickar.currencyconverter.dto.CurrencyConversionEventDto;
import ai.pickar.currencyconverter.dto.CurrencyConversionHistoryItemDto;
import ai.pickar.currencyconverter.service.CurrencyConversionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurrencyConversionEventController {

    private final CurrencyConversionEventService service;

    @Autowired
    public CurrencyConversionEventController(CurrencyConversionEventService service) {
        this.service = service;
    }

    @GetMapping("/api/history")
    public List<CurrencyConversionHistoryItemDto> getCurrencyConversionHistory() {
        return service.getCurrencyConversionHistory();
    }

    @PostMapping("/api/history")
    public void addCurrencyConversionEventDto(@RequestBody CurrencyConversionEventDto eventDto) {
        service.addCurrencyConversion(eventDto);
    }
}
