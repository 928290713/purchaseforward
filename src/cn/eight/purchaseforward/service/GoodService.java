package cn.eight.purchaseforward.service;

import cn.eight.purchaseforward.pojo.Carbean;
import cn.eight.purchaseforward.pojo.Good;

import java.util.List;

public interface GoodService {

    List<String> findAllGoodType();

    List<Good> findGoodsByType(String Type);

    List<Good> findGoodsByCarBean(Carbean carbean);

}
