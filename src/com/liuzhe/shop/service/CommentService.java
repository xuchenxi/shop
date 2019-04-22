package com.liuzhe.shop.service;

import com.liuzhe.shop.pojo.Comment;
import com.liuzhe.shop.pojo.CommentPojo;

import java.util.List;

public interface CommentService {
    List<CommentPojo> getCommentPojosByPid(int pid);


    //添加商品评论
    public int add(Comment comment);

    public CommentPojo getCount(Integer pid);
}
