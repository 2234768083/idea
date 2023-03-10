package com.example.market.common.mysql.service.impl;

import com.example.market.common.mysql.entity.VerificationCodeLog;
import com.example.market.common.mysql.repo.VerificationCodeLogRepository;
import com.example.market.common.mysql.service.VerificationCodeLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/03/20 09:37
 * description:
 */
@AllArgsConstructor
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VerificationCodeLogServiceImpl implements VerificationCodeLogService {

    private final VerificationCodeLogRepository verificationCodeLogRepository;

    @Override
    public VerificationCodeLog save(VerificationCodeLog verificationCodeLog) {
        return verificationCodeLogRepository.save(verificationCodeLog);
    }

    @Override
    public void deleteByTimeBetween(LocalDateTime startTime, LocalDateTime endTime) {
        verificationCodeLogRepository.deleteByCreatedTimeBetween(startTime, endTime);
    }
}
