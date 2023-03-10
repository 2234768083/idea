package com.example.market.common.mysql.repo;

import com.example.market.common.mysql.entity.UserImg;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/06/24 10:16
 * description:
 */
public interface UserImgRepository extends CrudRepository<UserImg, Long> {

    @Modifying
    @Query(value = "update UserImg set state= :state where userId = :userId")
    @Transactional
    void updateUserImgState(Short state, Long userId);

    List<UserImg> findByUserId(Long userId);

    List<UserImg> findByUserIdInAndStateAndDeleteState(List<Long> userId, Short state, Short deleteState);

    Optional<UserImg> findByUserIdAndStateAndDeleteState(Long userId, Short state, Short deleteState);
}
