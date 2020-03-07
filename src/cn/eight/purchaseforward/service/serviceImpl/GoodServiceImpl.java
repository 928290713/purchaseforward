package cn.eight.purchaseforward.service.serviceImpl;

import cn.eight.purchaseforward.dao.GoodDao;
import cn.eight.purchaseforward.pojo.Good;
import cn.eight.purchaseforward.service.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {
    private GoodDao goodDao = new GoodDao();
    @Override
    public boolean addGood(Good good) {

        return goodDao.insertGood(good);
    }

    @Override
    public List<Good> findGoodByCriteria(Good good) {
        return goodDao.queryGoodByCriteria(good);
    }

    @Override
    public List<Good> findGoodAll(int pageNow, int pageSize) {
        return goodDao.queryGoodAll(pageNow,pageSize);
    }

    @Override
    public int findTotalRecord() {
        return goodDao.queryTotalRecord();
    }

    @Override
    public boolean updateGood(Good good) {
        return goodDao.updateGood(good);
    }

    @Override
    public boolean removeGood(int id) {
        return goodDao.deleteGood(id);
    }
}
