package com.cx.service;

import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.fluentmybatis.entity.LunwenEntity;

public interface KtbgService {

    public int addKtbg(KtbgEntity ktbg);
    public int updateKtbg(KtbgEntity ktbg);
    public int removeKtbg(Integer id);
    public KtbgEntity getKtbg(Integer id);
    public KtbgEntity getKtbgByStudentId(String studentId);
}
