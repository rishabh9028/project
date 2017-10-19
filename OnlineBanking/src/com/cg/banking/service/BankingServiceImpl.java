package com.cg.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.UserBean1;
import com.cg.banking.dao.BankingDaoImpl;
import com.cg.banking.dao.IBankingDao;


public class BankingServiceImpl implements IBankingService {

	@Override
	public int createNewAcc(UserBean ub) throws IOException, SQLException {
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.createNewAcc(ub);
	}

	@Override
	public ArrayList<UserBean1> reteriveDaily() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveDaily();
	}

	@Override
	public ArrayList<UserBean1> reteriveMonthly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveMonthly();
		
	}

	@Override
	public ArrayList<UserBean1> reteriveYearly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveYearly();
		
	}

	@Override
	public ArrayList<UserBean1> reteriveQuaterly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		IBankingDao ibd = new BankingDaoImpl();
		return ibd.reteriveQuaterly();
	}

	@Override
	public boolean validateName(String name) {
		String ptn="[A-Z]{1}[a-z]{2,19}";
		if(Pattern.matches(ptn,name))
		{
			return true;
		}
		else
		{
			
			System.out.println("Please enter valide details");
			return false;
		}
	}

	@Override
	public boolean validateBal(int accbal) {
	if(accbal>0)
	{
		return true;
	}
	else
	{
		System.out.println("Please enter valide details");
		return false;
	}
	}

	@Override
	public boolean validateBal(long mobileno) {
		
		int length = (int) Math.log10(mobileno) + 1;
		
		if(length==10)
		{
			return true;
		}
		else
		{
			System.out.println("Please enter valide mobileno");
			return false;
		}
	}

	@Override
	public boolean validateBal(String email) {
		// TODO Auto-generated method stub
		 String emailPattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		if(Pattern.matches(emailPattern,email))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter valide email");
			return false;
		}
	}

	@Override
	public boolean validateName(int acctype) {
		if(acctype ==1 || acctype==2)
		{
			return true;
		}
		else{
			System.out.println("Please enter valide choice");
			return false;
		}
	}

}
