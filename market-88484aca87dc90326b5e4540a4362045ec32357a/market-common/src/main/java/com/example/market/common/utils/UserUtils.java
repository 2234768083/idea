package com.example.market.common.utils;

import com.example.market.common.base.entity.ro.RoImagePath;
import com.example.market.common.base.entity.ro.RoUser;
import com.example.market.common.constant.SysConst;
import com.example.market.common.mysql.entity.User;
import com.example.market.common.mysql.entity.UserImg;
import com.google.common.base.Objects;
import org.apache.commons.lang3.StringUtils;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/9/25 14:51
 * description:
 */
public class UserUtils {

    public static final String DEFAULT_USER_NAME = "市场者";

    public static String checkUserState(User user) {
        String result = StringUtils.EMPTY;
        if (UserUtils.checkUserFrozen(user)) { //冻结
            result = "账户冻结";
        } else if (Objects.equal(user.getDeleteState(), SysConst.DeleteState.DELETE.getCode())) {
            result = "账户已被删除";
        }
        return result;
    }


    /**
     * 检验用户是冻结
     *
     * @param user 用户信息
     * @return Boolean
     */
    public static Boolean checkUserFrozen(User user) {
        int accountState = user.getAccountState();
        if (accountState == SysConst.AccountState.FROZEN.getCode()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;

        }
    }

    /**
     * 检验用户是admin用户
     *
     * @param user 用户信息
     * @return Boolean
     */
    public static Boolean checkUserAccountType(User user) {
        String accountType = user.getAccountType();
        if (Objects.equal(accountType, SysConst.AccountType.ADMIN.getType())) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static String getSalt() {
        return Encodes.encodeHex(Digests.generateSalt(Digests.SALT_SIZE));
    }

    /**
     * 获取加密密码
     *
     * @param account  账户
     * @param password 未加密密码
     * @param salt     盐
     * @return String
     */
    public static String getEncryptPassword(String account, String password, String salt) {
        byte[] hashPassword = Digests.sha1((account + password).getBytes(), Encodes.decodeHex(salt), Digests.HASH_INTERATIONS);
        return Encodes.encodeHex(hashPassword);
    }


    public static RoUser getDefaultRoUser() {
        return new RoUser(0L, DEFAULT_USER_NAME, "未知", "未知", SysConst.Sex.UNKNOWN.getCode(),
                SysConst.DEFAULT_INTEGRAL, SysConst.AccountType.USER.getType(), new RoImagePath(1L));
    }

    public static User getDefaultUser() {
        return new User();
    }

    public static UserImg getDefaultUserImg() {
        return new UserImg(0L, 1L);
    }

    public static String getDefaultUserName(String phone) {
        return DEFAULT_USER_NAME + phone.substring(phone.length() - 4);
    }

    public static void main(String[] args) {
        System.out.println(getDefaultUserName("15130097582"));
    }
}
