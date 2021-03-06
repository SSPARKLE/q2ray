package cn.edu.cuit.cuitauction.service.impl;


import cn.edu.cuit.cuitauction.common.CommonCRUD;
import cn.edu.cuit.cuitauction.common.CommonResult;
import cn.edu.cuit.cuitauction.dao.CuitAuctionAttributeDao;
import cn.edu.cuit.cuitauction.model.CuitAuctionAttribute;
import cn.edu.cuit.cuitauction.service.CuitAuctionAttributeService;
import cn.edu.cuit.cuitauction.util.ServiceImplUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author sunshixiong on 2018/01/30.
 */
@Slf4j
@Service("cuitAuctionAttributeService")
public class CuitAuctionAttributeServiceImpl implements CuitAuctionAttributeService {

    @Autowired
    CuitAuctionAttributeDao attributeDao;

    @Override
    public CommonResult add(CuitAuctionAttribute entity) {
        return ServiceImplUtil.doCRUD(attributeDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitAuctionAttribute entity) {
        return ServiceImplUtil.doCRUD(attributeDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitAuctionAttribute entity) {
        return ServiceImplUtil.doCRUD(attributeDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    /**
     * 注视中表示创建一个匹配器，让字段名以属性值结束
     * @param entity
     * @return
     */
    @Override
    public List<CuitAuctionAttribute> queryList(CuitAuctionAttribute entity) {
        Example example = Example.of(entity);
        /*ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withMatcher("password",new ExampleMatcher.GenericPropertyMatcher().endsWith());*/
        return attributeDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitAuctionAttribute entity, Pageable pageable) {
        Example example = Example.of(entity);
        Optional optional =  attributeDao.findById(1);
        return attributeDao.findAll(example,pageable);
    }
}