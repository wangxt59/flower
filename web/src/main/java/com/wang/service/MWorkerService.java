package com.wang.service;

import com.wang.entity.MWorker;

import java.util.List;
import java.util.Map;

public interface MWorkerService {
    MWorker getworker(String id);
    public List<MWorker> getAllWorker(int pageNum, int pageSize, Map map);
}
