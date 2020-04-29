package cn.javasm.dao;

import cn.javasm.entity.SySLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SySLog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<SySLog> findAll() throws Exception;

}
