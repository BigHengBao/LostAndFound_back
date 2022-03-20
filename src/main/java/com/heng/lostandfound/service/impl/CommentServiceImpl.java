package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.*;
import com.heng.lostandfound.mapper.CommentMapper;
import com.heng.lostandfound.mapper.GoodsMapper;
import com.heng.lostandfound.mapper.OrderMapper;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.CommentService;
import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.utils.Constant;
import com.heng.lostandfound.utils.ImageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ImageService imageService;

    @Override
    public boolean addComment(Comment comment) {
        commentMapper.insertComment(comment);
        return true;
    }

    @Override
    public List<CommentItem> getAllComments(String goodsName, String authorName) throws IOException {
        List<CommentItem> comments = new ArrayList<>();
//        User user = userMapper.queryUserByuName(authorName);
//        System.out.println("getAllComments author:-->" + user);
        List<Comment> allUserComments = commentMapper.getAllCommentsById(goodsName, authorName);

        if (allUserComments != null) {
            for (Comment comment : allUserComments) {
                CommentItem commentItem = new CommentItem();

                String name = userMapper.queryUserByUid(comment.getuAccount()).getrName();
                commentItem.setUsername(name);
                commentItem.setContent(comment.getContent());
                commentItem.setAddTime(comment.getAddTime());
                commentItem.setUserImg(null);
                comments.add(commentItem);
//                System.out.println("getUserComments:---------------------->" + commentItem);
            }
            return comments;
        }

        return null;
    }
}
