package com.app.replace.mapper;

import com.app.replace.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberVO> selectAll();

    public void insert(MemberVO memberVO);
}
