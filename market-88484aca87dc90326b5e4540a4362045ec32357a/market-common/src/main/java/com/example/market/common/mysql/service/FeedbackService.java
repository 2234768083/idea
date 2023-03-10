package com.example.market.common.mysql.service;

import com.example.market.common.base.entity.ro.RoFeedback;
import com.example.market.common.base.service.BaseService;
import com.example.market.common.mysql.entity.Feedback;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/07/12 15:14
 * description:
 */
public interface FeedbackService extends BaseService<Feedback, Long> {

    RoFeedback saveFeedback(Feedback feedback);

    void saveFeedbackImg(HttpServletRequest request, Long feedbackId);

}
