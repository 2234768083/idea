package com.example.market.common.mysql.service;

import com.example.market.common.base.service.BaseService;
import com.example.market.common.mysql.entity.UserImg;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/06/24 10:16
 * description:
 */
public interface UserImgService extends BaseService<UserImg, Long> {

    UserImg saveUserImg(HttpServletRequest request, Long userId);

    UserImg findUserImgUrlByOn(Long userId);

    Map<Long, UserImg> findUserImgUrlByOn(List<Long> userIdList);

    void modifyUserImg(Long userId, Long imgId);

}
