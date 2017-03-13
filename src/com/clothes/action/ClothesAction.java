package com.clothes.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clothes.dao.ClothesDao;
import com.clothes.model.Customer;
import com.clothes.model.Clothes;

@Controller @Scope("prototype")
public class ClothesAction {
	@Resource ClothesDao clothesDAO;
	private Clothes clothes;
	private List<Clothes> clothesList;
	private Customer customer;
	private String keywords;
	
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Clothes> getClothesList() {
		return clothesList;
	}

	public void setClothesList(List<Clothes> clothesList) {
		this.clothesList = clothesList;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	/*添加衣服*/
	public String addClothes() throws Exception{
		clothesDAO.AddClothes(clothes);
		return "message";
	}
	/*显示所有衣服*/
	public String showClothes(){
		clothesList=clothesDAO.QueryAllClothes();
		return "show_view";
	}
	//查询衣服
	public String queryClothes() throws Exception{
		clothesList=clothesDAO.QueryClothesInfo(keywords);
		return "show_view";
	}
	/*显示衣服信息*/
	public String showDetail(){
		clothes=clothesDAO.GetClothesById(clothes.getClothesid());
		return "detail_view";
	}
	/*显示修改项*/
	public String showEdit() throws Exception {
		clothes = clothesDAO.GetClothesById(clothes.getClothesid());
		return "edit_view";
	}
	//编辑衣服
	public String editClothes() throws Exception{
		clothesDAO.UpdateClothes(clothes);
		return "edit_message";
	}
	//删除衣服信息
	public String deleteClothes() throws Exception{
		clothesDAO.DeleteClothes(clothes.getClothesid());
		return "delete_message";
	}
}
