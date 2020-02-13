package com.example.demo.condition;

import com.example.demo.entity.UserDO;
import org.springframework.data.domain.Pageable;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询条件
 * 
 * @author jiayu.qiu
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserCondition extends UserDO {

    private static final long serialVersionUID = -5111314038991538777L;

    private Pageable pageable;

}
