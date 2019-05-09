package com.dixn.dxboot.mongodb.service;


import com.dixn.dxboot.mongodb.pojo.HistoryData;

/**
 * @Description：mongo service
 * @projectName：FCS
 * @packageName： com.dixn.mongodb.service
 * @ClassName：MongoService
 * @author：zhaoxu
 * @createTime：2018/11/12 15:00
 * @upate：zhaoxu
 * @updateDate：2018/11/12 15:00
 * @remark：
 * @version v1.0
 */
public interface MongoService {
    void save(HistoryData historyData);
}
