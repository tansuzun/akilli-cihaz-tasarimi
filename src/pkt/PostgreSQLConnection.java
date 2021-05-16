package pkt;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner; 

public class PostgreSQLConnection implements IVeritabani{
	
	private final String jdbcUrl = "jdbc:postgresql://localhost:5432/dbAkilliCihaz";
	private final String sqlUsername = "postgres";
	private final String sqlPassword = "12345t";
	
	private static PostgreSQLConnection instance;
	
	public static PostgreSQLConnection getInstance() {
		if(instance==null) {
			instance=new PostgreSQLConnection();
		}
		return instance;
	}
	
	private Connection baglan() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(jdbcUrl,sqlUsername,sqlPassword);
		}catch(SQLException e){
			System.out.println("Veritabanina baglanilamadi!");
			e.printStackTrace();
		}
		return connection;
	}

	public boolean kullaniciDogrulama(){
		
		String username;
		String password;
		Connection connection=baglan();
		try {
			 Scanner scn = new Scanner(System.in); 
			 System.out.println("Kullanici adinizi giriniz:");
			 username = scn.nextLine(); 
			 System.out.println("Sifrenizi giriniz:");
			 password = scn.nextLine(); 

			 String sql= "SELECT *  FROM \"Users\" WHERE \"username\"=\'"+ username+"\' AND \"password\"=\'"+ password+"\'";

	         Statement statement = connection.createStatement();
	         ResultSet result = statement.executeQuery(sql);    
		   	 connection.close();
   
	         if(!result.next()) {
	        	 System.out.println("Kullanici dogrulanamadi!");
	        	 return false;
	         }else {
	        	 System.out.println("Kullanici dogrulama basarili!");
	        	 return true;
	         }
	       
		}catch(SQLException e){
			System.out.println("Veritabanina baglanilamadi!");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public void kullaniciEkle() {
		
		String username;
		String password;	
		String email;
		Connection connection=baglan();

		try {
			 Scanner scn = new Scanner(System.in); 
			 System.out.println("Kullanici adi giriniz:");
			 username = scn.nextLine(); 
			 System.out.println("Sifre giriniz:");
			 password = scn.nextLine(); 
			 System.out.println("Email giriniz (Zorunlu degil):");
			 email = scn.nextLine(); 
			 if(email!="\\s+") {
				 Kullanici kullanici1=new Kullanici.KullaniciBuilder(username, password).email(email).build();
				 String sql1= "INSERT INTO \"Users\" (username,password,email) VALUES (\'"+ username+"\',\'"+ password+"\',\'"+email+"\')";
				 Statement statement1 = connection.createStatement();
		         int rows1=statement1.executeUpdate(sql1);
		         if(rows1>0) {
		        	 System.out.println("Yeni kullanici eklendi!");
		        	 System.out.println(kullanici1);
		         }

			 }else {
				 Kullanici kullanici=new Kullanici.KullaniciBuilder(username, password).build();
				 String sql= "INSERT INTO \"Users\" (username,password) VALUES (\'"+ username+"\',\'"+ password+"\')";
				 Statement statement = connection.createStatement();
		         int rows=statement.executeUpdate(sql);
		         
		         if(rows>0) {
		        	 System.out.println("Yeni kullanici eklendi!");
		        	 System.out.println(kullanici);
		         }
			 }
	
				connection.close();

		}catch(SQLException e){
			System.out.println("Veritabanina baglanilamadi!");
			e.printStackTrace();
		}
	}
}

