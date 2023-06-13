package com.qp.ots.service;

import com.qp.ots.vo.IdCardsDto;
import com.qp.ots.vo.UsrBean;

public interface ImportService {
    UsrBean loadUsrBeanFromProxy(String idCard);
    IdCardsDto loadIdCardsFormProxy();
}
