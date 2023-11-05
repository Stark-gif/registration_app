package com.registration_app.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
		
	
	public boolean verifycredentials(String email, String password);


	public void createRegistration(String name, String email, String city, String mobile);


	public ResultSet readreg();


	public void DeleteReg(String email);


	public void updatereg(String email, String mobile);






	
	
}
