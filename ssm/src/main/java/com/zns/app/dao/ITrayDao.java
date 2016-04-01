package com.zns.app.dao;

import java.util.List;

import com.zns.app.bean.Tray;

public interface ITrayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Tray record);

    int insertSelective(Tray record);

    Tray selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tray record);

    int updateByPrimaryKey(Tray record);
    
    int insertTrayList(List<Tray> tray_list);
}