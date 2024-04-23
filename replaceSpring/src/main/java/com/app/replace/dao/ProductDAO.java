package com.app.replace.dao;


import com.app.replace.dto.ProductDTO;
import com.app.replace.mapper.ProductMapper;
import com.app.replace.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    public List<ProductDTO> selectAll(){
        return productMapper.selectAll();
    }
    public void insert(ProductVO productVO){
        productMapper.insert(productVO);
    }
}
