package com.clothes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clothes.model.Clothes;

@Service @Transactional
public class ClothesDao {
	@Resource SessionFactory factory;
	 /*ÿҳ��ʾ��¼��Ŀ*/
    private final int PAGE_SIZE = 10;

    /*�����ѯ���ܵ�ҳ��*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*�����ѯ�����ܼ�¼��*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*添加衣服*/
    public void AddClothes(Clothes clothes) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(clothes);
    }

    /*查询所有衣服信息*/
    public ArrayList<Clothes> QueryAllClothes(){
    	Session s=factory.getCurrentSession();
    	String hql="From Clothes";
    	Query q=s.createQuery(hql);
    	List clothesList=q.list();
    	return (ArrayList<Clothes>) clothesList;
    }

    /*根据查询条件查询*/
    public ArrayList<Clothes> QueryClothesInfo(String clothestype){
    	Session s=factory.getCurrentSession();
    	String hql="From Clothes clothes where 1=1";
    	if(!clothestype.equals("")) 
    		hql = hql + " and clothes.clothestype like '%"+clothestype+"%'";
    	Query q=s.createQuery(hql);
    	List clothesList = q.list();
    	return (ArrayList<Clothes>) clothesList;
    }
    /*根据主键获取对象*/
    public Clothes GetClothesById(Integer clothesid) {
        Session s = factory.getCurrentSession();
        Clothes clothes = (Clothes)s.get(Clothes.class, clothesid);
        return clothes;
    }

    /*更新衣服信息*/
    public void UpdateClothes(Clothes clothes) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(clothes);
    }

    /*删除衣服信息*/
    public void DeleteClothes (Integer clothesId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object clothes = s.load(Clothes.class, clothesId);
        s.delete(clothes);
    }
   
	
}
