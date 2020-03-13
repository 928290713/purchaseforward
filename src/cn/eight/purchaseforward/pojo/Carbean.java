package cn.eight.purchaseforward.pojo;

import cn.eight.purchaseforward.service.GoodService;
import cn.eight.purchaseforward.service.serviceImpl.GoodServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carbean {

    Map<Integer,Integer> car;

    public Map<Integer, Integer> getCar() {
        return car;
    }

    public void setCar(Map<Integer, Integer> car) {
        this.car = car;
    }

    //添加商品
    public void addGood(Integer id){
        if (car == null){
            car = new HashMap<>();
        }
        car.put(id,1);//默认购买一件
    }
    //删除商品
    public void removeGood(Integer id){
        if (car!=null){
            car.remove(id);
        }
    }

    //修改商品数量
    public void modGood(Integer[] id,Integer[] amounts){
        for (int i = 0; i < id.length; i++) {
            car.put(id[i],amounts[i]);
        }
    }

    //清空
    public void cleanCar(){
        if (car!=null){
            car.clear();
        }
    }

    //得到商品总数量
    public int getAmounts(){
        int amounts = 0;
        if (car!=null){
            for (Map.Entry<Integer,Integer> entry:car.entrySet()) {
                amounts+=entry.getValue();
            }
        }
        return amounts;
    }

    //得到商品总金额
    public double getBalance(){
        double balance = 0;
        GoodService service = new GoodServiceImpl();
        List<Good> cars = service.findGoodsByCarBean(this);
        for (int i = 0; i < cars.size(); i++) {
            balance+=cars.get(i).getPrice()*cars.get(i).getAmount();
        }
        return balance;
    }
}
