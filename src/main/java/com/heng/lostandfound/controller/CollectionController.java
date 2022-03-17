package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.Comment;
import com.heng.lostandfound.entity.CommentItem;
import com.heng.lostandfound.entity.MyResponse;
import com.heng.lostandfound.entity.UserCollection;
import com.heng.lostandfound.service.CollectionService;
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
 * date: 2022/3/17/10:38
 * title：收藏controller
 */
@RestController
@RequestMapping({"app/Collection"})
public class CollectionController {
    @Autowired
    CollectionService collectionService;


    @RequestMapping(value = "/addCollection", method = RequestMethod.POST)
    public String addCollection(@RequestBody String mHashMapStr) {
        System.out.println("addCollection requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            UserCollection collection = JSON.parseObject(mHashMap.get("collection").toString(), UserCollection.class);
            System.out.println("addCollection collection: " + collection);

            boolean addCommentFlag = collectionService.addCollection(collection);
            MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"),
                    addCommentFlag, "");
            myResponseStr = JSONObject.toJSONString(myResponse);
            System.out.println("addCollection request" + myResponseStr);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        return myResponseStr;
    }

    @RequestMapping(value = "/getCollectionListById", method = RequestMethod.POST)
    public String getCollectionListById(@RequestBody String mHashMapStr) {
        System.out.println("getCollectionListById requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String uAccount = (String) mHashMap.get("uAccount");
        String myResponseStr = null;
        boolean getCollectionListById = false;
        List<UserCollection> allCollection = null;
        String msg = "";

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            allCollection = collectionService.getAllCollections(uAccount);
            if (allCollection != null) {
                getCollectionListById = true;
                msg = JSON.toJSON(allCollection).toString();
                System.out.println("getCollectionListById msg: " + msg);
            }

        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"),
                (String) mHashMap.get("front"), getCollectionListById, msg);
        myResponseStr = JSONObject.toJSONString(myResponse);
        System.out.println("getCollectionListById request" + myResponseStr);
        return myResponseStr;
    }
}
