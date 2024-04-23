package com.app.replace.mapper;

import com.app.replace.dto.MemberDTO;
import com.app.replace.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    public void insert(MemberDTO memberDTO);

    public void updateById(MemberDTO memberDTO);
}
