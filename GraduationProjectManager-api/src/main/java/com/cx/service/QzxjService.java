package com.cx.service;

import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.fluentmybatis.entity.QzxjEntity;

public interface QzxjService {

    public int addQzxj(QzxjEntity qzxj);
    public int updateQzxj(QzxjEntity qzxj);
    public int removeQzxj(Integer id);
    public QzxjEntity getQzxj(Integer id);
    public QzxjEntity getQzxjByStudentId(String studentId);
}
