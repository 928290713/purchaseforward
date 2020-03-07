package cn.eight.purchaseforward.service;

import cn.eight.purchaseforward.pojo.Good;

import java.util.List;

public interface GoodService {
    boolean addGood(Good good);
    List<Good> findGoodByCriteria(Good good);
    List<Good> findGoodAll(int pageNow,int pageSize);
    int findTotalRecord();
    boolean updateGood(Good good);
    boolean removeGood(int id);
}
