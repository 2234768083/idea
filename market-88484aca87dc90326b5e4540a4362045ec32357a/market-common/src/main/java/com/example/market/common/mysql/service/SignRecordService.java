package com.example.market.common.mysql.service;

import com.alibaba.fastjson.JSONObject;
import com.example.market.common.base.service.BaseService;
import com.example.market.common.mysql.entity.SignRecord;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/07/19 11:06
 * description:
 */
public interface SignRecordService extends BaseService<SignRecord, Long> {

    void signIn(Long userId) ;

    void complementSigned(Long userId, Integer dayOfMonth);

    List<JSONObject> signInCalendar(Long userId, LocalDate dateMonth);
}
