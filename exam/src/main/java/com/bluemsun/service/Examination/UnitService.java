package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.Unit;
import com.bluemsun.dao.Examination.UnitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 单元的业务层
 * @author: Dongsl161
 * @Date: 2017/8/21 16:04
 */
@Service
public class UnitService {

    @Autowired
    private UnitDao unitDao;


    /**
    * @Description: 根据册id查询出所有的单元
    * @Date: 2017/8/21 16:06
    */
    public List<Unit> selectAllUnit(String editionId) {
        List<Unit> list = unitDao.selectAllUnit(editionId);
        return list;
    }
    // 33abd121-90fc-4918-9b56-d0e34e7dd5ae
    // 14e12df5-84ee-480d-a82b-55ec8c3329c7

}
