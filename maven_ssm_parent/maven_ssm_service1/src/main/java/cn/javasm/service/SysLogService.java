package cn.javasm.service;

import cn.javasm.entity.SySLog;

import java.util.List;

public interface SysLogService {
    public void save(SySLog sysLog) throws Exception;

    List<SySLog> findAll() throws Exception;


}
