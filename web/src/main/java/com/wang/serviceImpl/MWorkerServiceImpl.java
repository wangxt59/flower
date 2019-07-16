package com.wang.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.wang.dao.MWorkerMapper;
import com.wang.entity.MWorker;
import com.wang.service.MWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class MWorkerServiceImpl implements MWorkerService {
    @Autowired
    public MWorkerMapper mWorkerMapper;

    @Override
    public MWorker getworker(String id) {

        return mWorkerMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<MWorker> getAllWorker(int pageNum, int pageSize, Map map) {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        List<MWorker> mWorkerList=mWorkerMapper.selectByMap(map);
        return mWorkerList;
    }
}
