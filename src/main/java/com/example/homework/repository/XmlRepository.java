package com.example.homework.repository;

import com.example.homework.bean.XmlBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface XmlRepository extends CrudRepository<XmlBean, BigDecimal> {
    List<XmlBean> findByAmountGreaterThanAndAmountLessThan(Integer minSalary, Integer maxSalary);
}
