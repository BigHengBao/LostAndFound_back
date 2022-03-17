package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.Comment;
import com.heng.lostandfound.entity.CommentItem;
import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.mapper.CommentMapper;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/15/19:16
 * title：评论service实现类
 */
@Service(value = "commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addComment(Comment comment) {
        commentMapper.insertComment(comment);
        return true;
    }

    @Override
    public List<CommentItem> getAllComments(String goodsName, String authorName) {
        List<CommentItem> comments = new ArrayList<>();
//        User user = userMapper.queryUserByuName(authorName);
//        System.out.println("getAllComments author:-->" + user);
        List<Comment> allCommentsById = commentMapper.getAllCommentsById(goodsName, authorName);

        if (allCommentsById != null) {
            for (Comment comment : allCommentsById) {
                String name = userMapper.queryUserByUid(comment.getuAccount()).getrName();
                CommentItem commentItem = new CommentItem();
                commentItem.setUsername(name);
                commentItem.setContent(comment.getContent());
                commentItem.setAddTime(comment.getAddTime());
                commentItem.setUserImg(null);
                comments.add(commentItem);
                System.out.println("getAllComments:---------------------->" + commentItem);
            }
            return comments;
        }

        return null;
    }
}
