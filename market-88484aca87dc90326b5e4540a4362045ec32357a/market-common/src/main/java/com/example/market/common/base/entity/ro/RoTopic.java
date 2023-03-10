package com.example.market.common.base.entity.ro;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class RoTopic implements Serializable {

    /**
     * 用户信息
     */
    private RoUser user;
    /**
     * 商品状态
     */
    @ApiModelProperty(value = "商品状态")
    private String state;
    /**
     * 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    private boolean userState;
    /**
     * 当前用户赞状态
     */
    @ApiModelProperty(value = "当前用户赞状态")
    private boolean zanState;

    /**
     * 赞数量
     */
    @ApiModelProperty(value = "赞数量")
    private Long zanNum;

    /**
     * 点赞人集合
     */
    @ApiModelProperty(value = "点赞人集合")
    private List<RoUser> zanUsers;

    /**
     * 收藏状态
     */
    @ApiModelProperty(value = "收藏状态")
    private boolean collectionState;

    /**
     * 评论数量
     */
    @ApiModelProperty(value = "评论数量")
    private Long commentNum;

    /**
     * 浏览量
     */
    @ApiModelProperty(value = "浏览量")
    private Long browsingVolume;

    /**
     * 图片集合
     */
    @ApiModelProperty(value = "图片集合")
    private List<RoImagePath> topicImgList;

    RoTopic(RoUser user, String state, boolean userState, boolean zanState, Long zanNum) {
        this.user = user;
        this.state = state;
        this.userState = userState;
        this.zanState = zanState;
        this.zanNum = zanNum;
    }
}

