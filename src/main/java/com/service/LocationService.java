package com.service;

import com.pojo.MyLocation;
import com.pojo.Paper;

import java.util.List;

public interface LocationService {
    int addLocation(MyLocation location);
    int deleteLocation(int num);
    int updateLocation(MyLocation location);
    MyLocation queryByNum(int num);

}
