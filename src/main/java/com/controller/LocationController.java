package com.controller;

import com.pojo.MyLocation;
import com.pojo.Paper;
import com.service.LocationService;
import com.service.PaperService;
import com.util.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @RequestMapping(value = "/saveloc")
    public String saveLocation(HttpServletRequest rq, HttpServletResponse response) {
        int num = Integer.parseInt(rq.getParameter("num"));
        String latitude = rq.getParameter("latitude");
        String longitude = rq.getParameter("longitude");
        String altitude = rq.getParameter("altitude");
        String accuracy = rq.getParameter("accuracy");
        String altitudeAccuracy = rq.getParameter("altitudeAccuracy");
        MyLocation myLocation = new MyLocation();
        myLocation.setNum(num);
        myLocation.setLatitude(latitude);
        myLocation.setLongitude(longitude);
        myLocation.setAltitude(altitude);
        myLocation.setAccuracy(accuracy);
        myLocation.setAltitudeAccuracy(altitudeAccuracy);
        MyLocation location = locationService.queryByNum(num);
        if(location!=null){
            locationService.updateLocation(myLocation);
        }else{
            locationService.addLocation(myLocation);
        }
        return "";
    }


    @RequestMapping(value = "/selectloc",method = RequestMethod.POST)
    public void selectLocation(HttpServletRequest rq, HttpServletResponse response) {
        int num = Integer.parseInt(rq.getParameter("num"));
        MyLocation location = locationService.queryByNum(num);
        String jsonStr = FastJsonUtils.toJSONString(location);
        try {
            System.out.println(jsonStr);
            response.getWriter().write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
