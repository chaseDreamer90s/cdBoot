package com.dixn.dxboot.jpa.dao;

import com.dixn.dxboot.jpa.entity.Fcs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @create 2019-02-20 13:25
 **/
@Repository
public interface FcsDao extends JpaRepository<Fcs, String> {

}
