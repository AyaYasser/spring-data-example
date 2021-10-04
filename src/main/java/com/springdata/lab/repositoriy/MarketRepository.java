package com.springdata.lab.repositoriy;

import com.springdata.lab.repositoriy.entity.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * Author Aya Yasser Esmail
 * on 03/10/2021
 **/


@RepositoryRestResource(path="market",collectionResourceRel = "market")
public interface MarketRepository extends JpaRepository<MarketEntity,Integer> {
    List<MarketEntity> findByAmount(@Param("a") Double amount);
}
