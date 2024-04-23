package com.app.replace.mapper;

import com.app.replace.dto.MemberDTO;
import com.app.replace.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberDTO> selectAll();

    public void insert(MemberVO memberVO);

    public MemberDTO selectById(long id);
    public long memberCount();
    public void updateById(MemberVO memberVO);

}
