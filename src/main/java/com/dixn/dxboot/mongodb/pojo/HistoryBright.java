package com.dixn.dxboot.mongodb.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description：fcs collect pojo
 * @projectName：FCS
 * @packageName： com.dixn.mongodb
 * @ClassName：FcsCollectData
 * @author：zhaoxu
 * @createTime：2018/11/12 14:50
 * @upate：zhaoxu
 * @updateDate：2018/11/12 14:50
 * @remark：
 * @version v1.0
 */
@Data
@Document(collection="history_bright")
public class HistoryBright extends HistoryData{
}
