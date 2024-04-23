package com.app.replace.mapper;

import com.app.replace.dto.ProductDTO;
import com.app.replace.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductDTO> selectAll();
    public void insert(ProductVO productVO);
}
