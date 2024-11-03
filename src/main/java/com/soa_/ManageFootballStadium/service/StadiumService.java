package com.soa_.ManageFootballStadium.service;

import com.soa_.ManageFootballStadium.model.Stadium;
import com.soa_.ManageFootballStadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class StadiumService {
    private final StadiumRepository stadiumRepository;

    public List<Stadium> filterStadiums( Double minPrice, Double maxPrice, Double minRating) {
        Iterable<Stadium> iterableStadiums = stadiumRepository.findAll();
        List<Stadium> stadiums = StreamSupport.stream(iterableStadiums.spliterator(), false)
                .toList();
        return stadiums.stream()
                .filter(stadium ->
                        (stadium.getPrice() >= minPrice && stadium.getPrice() <= maxPrice) &&
                        (stadium.getRating() >= minRating))
                .collect(Collectors.toList());
    }


    public Stadium getStadiumDetails(Long stadiumId) {
        return stadiumRepository.findById(stadiumId).orElse(null);
    }

    public List<Stadium> getStadiums() {
        return (List<Stadium>) stadiumRepository.findAll();
    }
}
