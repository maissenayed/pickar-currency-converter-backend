package ai.pickar.currencyconverter.repository;

import ai.pickar.currencyconverter.model.CurrencyConversionEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyConversionEventRepository extends JpaRepository<CurrencyConversionEvent, UUID> {
}
