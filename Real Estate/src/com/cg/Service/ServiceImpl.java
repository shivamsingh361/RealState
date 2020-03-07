package com.cg.Service;

import java.util.List;

import com.cg.DAO.Dao;
import com.cg.DAO.DaoBuyer;
import com.cg.DAO.DaoBuyerImpl;
import com.cg.DAO.DaoImpl;
import com.cg.DAO.DaoSeller;
import com.cg.DAO.DaoSellerImpl;
import com.cg.DTO.Filter;
import com.cg.DTO.Property;
import com.cg.DTO.User;

public class ServiceImpl implements Service{

	Dao dao = new DaoImpl();
	DaoSeller sellerDao = new DaoSellerImpl();
	DaoBuyer buyerDao = new DaoBuyerImpl();
	User user;
	@Override
	public int verifyOTP(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String updatePassword(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userHome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Home() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String id, String pass) {
		User temp = dao.login(id, pass);
		if(temp == null)
			return false;
		else{
			if(user.getType().equals("SELLER")){
				
			
			}else{
				
			}
			user = temp;
			return true;
		}
	}

	@Override
	public String Register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> Search(Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserProfile(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Property> addProperty(Property prop) {
		sellerDao.addProperty(prop);
		return null;
	}

}