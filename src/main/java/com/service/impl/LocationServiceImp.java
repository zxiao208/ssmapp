package com.service.impl;

import com.dao.LocationDao;
import com.pojo.MyLocation;
import com.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImp implements LocationService {
    @Autowired
    LocationDao locationDao;
    @Override
    public int addLocation(MyLocation location) {

        return locationDao.addPaper(location);
    }

    @Override
    public int deleteLocation(int num) {
        return locationDao.deletePaperById(num);
    }

    @Override
    public int updateLocation(MyLocation location) {
        return locationDao.updateLocation(location);
    }

    @Override
    public MyLocation queryByNum(int num) {
        return locationDao.queryById(num);
    }
}
