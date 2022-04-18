package com.cx.service;

import com.cx.fluentmybatis.entity.LunwenEntity;

public interface LunwenService {
    public int addLunwen(LunwenEntity lunwen);
    public int updateLunwen(LunwenEntity lunwen);
    public int removeLunwen(Integer id);
    public LunwenEntity getLunwen(Integer id);
    public LunwenEntity getLunwenByStudentId(String studentId);
}
