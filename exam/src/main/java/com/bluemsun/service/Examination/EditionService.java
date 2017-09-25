package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.Edition;
import com.bluemsun.dao.Examination.EditionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: Edition的service
 * @author: Dongsl161
 * @Date: 2017/8/19 20:31
 */
@Service
public class EditionService {

    @Autowired
    private EditionDao editionDao;


    /**
    * @Description:  查询出所有的册
    * @Date: 2017/8/19 20:32
    */
    public List<Edition> selectAllEdtion() {
        List<Edition> list = editionDao.selectAllEdition();
        return list;
    }



}
