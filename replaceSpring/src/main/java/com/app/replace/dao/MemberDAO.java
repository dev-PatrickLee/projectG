package com.app.replace.dao;

import com.app.replace.mapper.MemberMapper;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public List<MemberVO> selectAll(){
        List<MemberVO> list = memberMapper.selectAll();
        list.forEach((data)->{
            data.setMemberBirthday(data.getMemberBirthday().split(" ")[0]);
        });
        return list;
    }
    public void insert(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

}
