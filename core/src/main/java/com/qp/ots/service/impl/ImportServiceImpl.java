package com.qp.ots.service.impl;

import com.alibaba.fastjson.JSON;
import com.qp.ots.dao.OrderDao;
import com.qp.ots.entity.Order;
import com.qp.ots.service.ImportService;
import com.qp.ots.utils.HttpClient;
import com.qp.ots.utils.LogUtil;
import com.qp.ots.vo.IdCardsDto;
import com.qp.ots.vo.UsrBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

/**
 * @author Listen.Li
 */
@Service
public class ImportServiceImpl implements ImportService {

    public static final String GET_IDCARDS_URL = "http://192.168.18.33:8871/rm/idCards";

    @Autowired
    private OrderDao orderDao;

    public UsrBean loadUsrBeanFormDB(String idCard){
        Order order = orderDao.queryOrder();
        LogUtil.log("DBTest==>"+order);
        return null;
    }

    public IdCardsDto loadIdCardsFormDB(){
        return null;
    }

    @Override
    public UsrBean loadUsrBeanFromProxy(String idCard){
        LogUtil.log("loadUsrBeanFromProxy==>"+idCard);
        UsrBean usr = new UsrBean();
        usr.setIdCard(idCard);
        return usr;
    }

    @Override
    public IdCardsDto loadIdCardsFormProxy(){
        String result = HttpClient.doGet(GET_IDCARDS_URL);
        IdCardsDto idCards = null;
        try {
            idCards = JSON.parseObject(result, IdCardsDto.class);
            /**
             * 去重
             */
            TreeSet set = new TreeSet(idCards.getIdCards());
            idCards.getIdCards().clear();
            idCards.getIdCards().addAll(set);
        }catch (Exception e){
            LogUtil.log(e.getMessage());
        }
        return idCards;
    }
}
