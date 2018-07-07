package com.htht.weather.springCloudWeather.service.impl;

import com.htht.weather.springCloudWeather.service.CityDataService;
import com.htht.weather.springCloudWeather.util.XmlBuilder;
import com.htht.weather.springCloudWeather.vo.City;
import com.htht.weather.springCloudWeather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService{
    @Override
    public List<City> listCity() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while((line = br.readLine()) != null){
                buffer.append(line);
        }
        br.close();

        //XML转换为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
