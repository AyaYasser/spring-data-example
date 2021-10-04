package com.springdata.lab.service.impl;

import com.springdata.lab.common.dto.MarketModel;
import com.springdata.lab.repositoriy.MarketRepository;
import com.springdata.lab.repositoriy.entity.MarketEntity;
import com.springdata.lab.service.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    MarketRepository marketRepository;

     ModelMapper modelMapper=new ModelMapper();

    @Override
    public void test(MarketModel model) {
        MarketEntity entity = modelMapper.map(model, MarketEntity.class);
        marketRepository.save(entity);

        Sort sort = Sort.by(Sort.Direction.ASC, "id").and(Sort.by(Sort.Direction.ASC, "items"));

        Example<MarketEntity> marketEntityExample=Example.of(entity);
        marketRepository.findAll( PageRequest.of(0, 10, sort));


        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("name", ExampleMatcher.
                        GenericPropertyMatchers.contains()
                        .ignoreCase());
        Example<MarketEntity> marketEntityExample2=Example.of(entity,customExampleMatcher);


    }
}
