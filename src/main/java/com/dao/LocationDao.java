package com.dao;

import com.pojo.MyLocation;
import java.util.List;

public interface LocationDao {
        int addPaper(MyLocation location);
        int deletePaperById(int num);
        int updateLocation(MyLocation location);
        MyLocation queryById(int num);
}
