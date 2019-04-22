package com.liuzhe.shop.service.impl;

import com.liuzhe.shop.mapper.CommentMapper;
import com.liuzhe.shop.pojo.Comment;
import com.liuzhe.shop.pojo.CommentPojo;
import com.liuzhe.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentPojo> getCommentPojosByPid(final int pid) {
        return this.commentMapper.selectCommentPojoByPid(pid);
    }

    //添加商品评论
    @Override
    public int add(final Comment comment) {
        final int result = this.commentMapper.insert(comment);
        return result;
    }

    @Override
    public CommentPojo getCount(final Integer pid) {

        return this.commentMapper.selectCommentCountByPid(pid);
    }

}
