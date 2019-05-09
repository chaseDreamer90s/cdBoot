package com.dixn.dxboot.mongodb.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class HistoryData {

	String ip;

	JSONObject data;

	long createTime;

}
