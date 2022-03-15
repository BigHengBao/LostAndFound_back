package com.heng.lostandfound.mapper;

import com.heng.lostandfound.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/15/19:00
 * title：评论dao
 */
@Component(value = "commentMapper")
public interface CommentMapper {
    void insertComment(Comment comment);

    List<Comment> getAllCommentsById(String goodsName, String uAccount);

    Comment queryCommentById(String goodsName, String uAccount, String authorName);

    void updateComment(Comment comment);
}
