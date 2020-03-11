package cn.eight.purchaseforward.service.serviceImpl;

import cn.eight.purchaseforward.dao.GoodDao;
import cn.eight.purchaseforward.pojo.Carbean;
import cn.eight.purchaseforward.pojo.Good;
import cn.eight.purchaseforward.service.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {
    private GoodDao goodDao = new GoodDao();

    @Override
    public List<String> findAllGoodType() {
        return goodDao.queryGoodType();
    }

    @Override
    public List<Good> findGoodsByType(String Type) {
        return goodDao.queryGoodsByType(Type);
    }

    @Override
    public List<Good> findGoodsByCarBean(Carbean carbean) {
        return goodDao.findGoodsByCarBean(carbean);
    }
}
