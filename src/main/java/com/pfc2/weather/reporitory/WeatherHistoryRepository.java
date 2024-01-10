package com.pfc2.weather.reporitory;

import com.pfc2.weather.domain.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, UUID> {
    Optional<WeatherHistory> findByLatAndLon(Double lat, Double lon);
}
