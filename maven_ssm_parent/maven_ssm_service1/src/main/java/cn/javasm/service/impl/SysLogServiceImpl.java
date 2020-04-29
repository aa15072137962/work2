package cn.javasm.service.impl;

import cn.javasm.dao.SysLogDao;
import cn.javasm.entity.SySLog;
import cn.javasm.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogDao sysLogDao;

    @Override
    public void save(SySLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SySLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
