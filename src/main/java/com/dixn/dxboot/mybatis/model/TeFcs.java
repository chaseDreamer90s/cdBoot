package com.dixn.dxboot.mybatis.model;

public class TeFcs {
    private String id;

    private String idTunnel;

    private String ipFcs;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdTunnel() {
        return idTunnel;
    }

    public void setIdTunnel(String idTunnel) {
        this.idTunnel = idTunnel == null ? null : idTunnel.trim();
    }

    public String getIpFcs() {
        return ipFcs;
    }

    public void setIpFcs(String ipFcs) {
        this.ipFcs = ipFcs == null ? null : ipFcs.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}