package com.app.replace.dao;

import com.app.replace.dto.MemberDTO;
import com.app.replace.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerDAO {
    private final CustomerMapper customerMapper;

    public void insert(MemberDTO memberDTO){
        customerMapper.insert(memberDTO);
    }

    public void updateById(MemberDTO memberDTO){
        customerMapper.updateById(memberDTO);
    }

}
