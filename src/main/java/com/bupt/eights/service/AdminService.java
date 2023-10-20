package com.bupt.eights.service;

import com.bupt.eights.dto.Result;
import com.bupt.eights.utils.RegexUtils;

public interface AdminService {
    int createUser();//创建新用户
    void lockUser();//锁定用户账户
    void unlockUser();//解锁用户账户

    Result viewAppointments(int usrId);

}
