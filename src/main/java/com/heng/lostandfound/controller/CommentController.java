package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.*;
import com.heng.lostandfound.service.CommentService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/15/19:24
 * title：评论controller
 */

@RestController
@RequestMapping({"app/comment"})
public class CommentController {

    @Autowired
    CommentService commentService;


    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(@RequestBody String mHashMapStr) {
        System.out.println("addComment requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            Comment comment = JSON.parseObject(mHashMap.get("comment").toString(), Comment.class);
            System.out.println("addComment goods: " + comment);

            boolean addCommentFlag = commentService.addComment(comment);
            MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"),
                    addCommentFlag, "");
            myResponseStr = JSONObject.toJSONString(myResponse);
            System.out.println("addComment request" + myResponseStr);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        return myResponseStr;
    }


    @RequestMapping(value = "/getCommentListById", method = RequestMethod.POST)
    public String getCommentListById(@RequestBody String mHashMapStr) {
        System.out.println("getCommentListById requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String goodsName = (String) mHashMap.get("goodsName");
        String uAccount = (String) mHashMap.get("authorName");
        String myResponseStr = null;
        boolean getCommentByIdFlag = false;
        List<CommentItem> allComments = null;
        String msg = "";

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            allComments = commentService.getAllComments(goodsName, uAccount);
            if (allComments != null) {
                getCommentByIdFlag = true;
                msg = JSON.toJSON(allComments).toString();
                System.out.println("getCommentListById msg: " + msg);
            }

        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"),
                (String) mHashMap.get("front"), getCommentByIdFlag, msg);
        myResponseStr = JSONObject.toJSONString(myResponse);
        System.out.println("getCommentListById request" + myResponseStr);
        return myResponseStr;
    }
}
