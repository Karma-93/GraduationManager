package com.cx.service;

import com.cx.fluentmybatis.entity.AdminEntity;

public interface AdminService {
    public AdminEntity getAdminByUserId(String userId);
}
