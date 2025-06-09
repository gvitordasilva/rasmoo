package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.SubscriptionTypeDTO;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    SubscriptionServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        Optional<SubscriptionType> subscriptionType = subscriptionTypeRepository.findById(id);
        if (subscriptionType.isEmpty()) {
            throw new NotFoundException("Subscription type not found");
        }
        return subscriptionType.get();
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO subscriptionTypeDTO) {
        return subscriptionTypeRepository.save(SubscriptionType.builder()
                .id(subscriptionTypeDTO.getId())
                .name(subscriptionTypeDTO.getName())
                .accessMonth(subscriptionTypeDTO.getAccessMonth())
                .price(subscriptionTypeDTO.getPrice())
                .productKey(subscriptionTypeDTO.getProductKey())
                .build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
