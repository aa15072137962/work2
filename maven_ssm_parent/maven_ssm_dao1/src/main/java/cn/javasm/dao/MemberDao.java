package cn.javasm.dao;

import cn.javasm.entity.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberDao {
    /**
     * 根据id进行查询
     *
     * @param id
     * @return
     */
    @Select("select * from member where id=#{id}")
    List<Member> findById(Integer id);
}
