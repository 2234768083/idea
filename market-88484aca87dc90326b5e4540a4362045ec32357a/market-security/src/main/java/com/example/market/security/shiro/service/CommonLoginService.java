package com.example.market.security.shiro.service;

import com.example.market.common.exception.custom.OperationException;
import com.example.market.security.shiro.token.PasswordToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/1/17 17:49
 * description:
 */
public interface CommonLoginService {

    String login(PasswordToken token, String ip, String deviceInfo) throws OperationException;

    String login(PasswordToken token, Boolean rememberMe, String ip, String deviceInfo) throws OperationException;

    String login(PasswordToken token, String ip, String deviceInfo, String registrationId) throws OperationException;

    String login(PasswordToken token, Boolean rememberMe, String ip, String deviceInfo, String registrationId) throws OperationException;

    void logout(Long currentUserId, String ip, String deviceInfo);

    void logout(Long currentUserId, String ip, String deviceInfo, String registrationId);
}
