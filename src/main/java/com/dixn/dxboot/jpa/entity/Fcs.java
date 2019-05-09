package com.dixn.dxboot.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-02-20 13:22
 **/
@Entity
@Data
@Table(name = "te_fcs")
public class Fcs {
    @Id
    String id;
    String idTunnel;
    String ipFcs;
    String delFlag;
}
