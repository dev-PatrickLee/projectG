package com.app.replace.dao;

import com.app.replace.dto.MemberDTO;
import com.app.replace.mapper.MemberMapper;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public List<MemberDTO> selectAll(){
        List<MemberDTO> list = memberMapper.selectAll();
        list.forEach((data)->{
            data.setMemberBirthday(data.getMemberBirthday().split(" ")[0]);
        });
        return list;
    }
    public void insert(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    public MemberDTO selectById(long id){
        return memberMapper.selectById(id);
    }

    public long memberCount(){
        return memberMapper.memberCount();
    }

    public void updateById(MemberVO memberVO){
        memberMapper.updateById(memberVO);
    }


}
