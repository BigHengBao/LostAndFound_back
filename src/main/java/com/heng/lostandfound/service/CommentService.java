package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.Comment;
import com.heng.lostandfound.entity.CommentItem;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/15/19:15
 * title：评论service
 */

public interface CommentService {
    boolean addComment(Comment comment);

    List<CommentItem> getAllComments(String goodsName, String uAccount);
}
