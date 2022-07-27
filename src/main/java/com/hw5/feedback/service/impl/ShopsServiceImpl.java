package com.hw5.feedback.service.impl;

import com.hw5.feedback.config.DataConfig;
import com.hw5.feedback.dao.ShopsRepository;
import com.hw5.feedback.entity.Shops;
import com.hw5.feedback.exceptions.FoundationDateIsExpiredException;
import com.hw5.feedback.exceptions.RestaurantNotFoundException;
import com.hw5.feedback.service.ShopsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.hw5.feedback.config.DataConfig.url;

@Service
public class ShopsServiceImpl implements ShopsService {

    private static final Logger log = LoggerFactory.getLogger(ShopsServiceImpl.class);

    private static Connection connection;
    private final DataConfig dataConfig;

    public ShopsServiceImpl(DataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }

    @PostConstruct
    public void initialize() {
        try {
            connection = DriverManager.getConnection(url, DataConfig.getConnectionProps());
        } catch (SQLException e) {
            log.debug("Incorrect database URL '{}' or connection props '{}'", url, DataConfig.getConnectionProps());
        }
    }

    @Autowired
    private ShopsRepository shopsRepository;

    @Override
    public Shops getResponseFromShops(String response) {
        return shopsRepository.getResponseFromShops(response);
    }

    @Override
    public Shops getDescriptionFromShops(String description) {
        return shopsRepository.getDescriptionFromShops(description);
    }

    @Override
    public Shops getRatingFromShops(String rating) {
        return shopsRepository.getRatingFromShops(rating);
    }

    @Override
    public long createShopByNameAndDate(String establishment, LocalDate creation_date) throws FoundationDateIsExpiredException {
        if(creation_date == null || LocalDate.now().isBefore(creation_date)) {
            throw new FoundationDateIsExpiredException(establishment, creation_date);
        }
        Shops shops = new Shops();
        shops.setEstablishment(establishment);
        shops.setCreation_date(creation_date);
        Shops save = shopsRepository.save(shops);
        return save.getId();
    }

    @Override
    public LocalDate getCreation_date(Long id) throws RestaurantNotFoundException {
        Shops shopsId = shopsRepository.getReferenceById(id);
        return shopsId.getCreation_date();
    }
}
