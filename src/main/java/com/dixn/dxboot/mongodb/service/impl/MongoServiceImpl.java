package com.dixn.dxboot.mongodb.service.impl;

import com.dixn.dxboot.mongodb.pojo.HistoryData;
import com.dixn.dxboot.mongodb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description  mongo service impl
 * @projectName：FCS
 * @packageName： com.dixn.mongodb.service.impl
 * @ClassName：MongoServiceImpl
 * @author：zhaoxu
 * @createTime：2018/11/12 15:02
 * @upate：zhaoxu
 * @updateDate：2018/11/12 15:02
 * @remark：
 * @version v1.0
 */
@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(HistoryData historyData) {
        mongoTemplate.save(historyData);

        List<HistoryData> historyData1 = new ArrayList<>();
        mongoTemplate.insertAll(historyData1);

    }

}
