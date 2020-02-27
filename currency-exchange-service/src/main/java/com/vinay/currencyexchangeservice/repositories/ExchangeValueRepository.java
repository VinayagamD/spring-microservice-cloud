package com.vinay.currencyexchangeservice.repositories;

import com.vinay.currencyexchangeservice.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
