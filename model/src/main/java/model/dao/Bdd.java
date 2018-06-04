
package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Bdd {
	
	
	
	private String[][][] monTableau;
	private String[][] monTableauMobile;

	public String[][][] lireEnBase(int level) {
		String url = "jdbc:mysql://localhost/lorann";
		String login = "pascal";
		String passwd = "";

		java.sql.Connection cn=null;
		java.sql.Statement st =null;
		java.sql.ResultSet rs =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "call lorann.map("+level+");";
			rs = st.executeQuery(sql);

			String [][][] monTableau = new String[20][11][3];

			for (int i=0;i<20;i++) {
					for (int j=0;j<11;j++) {
						rs.next();
				monTableau[i][j][0] = rs.getString("model");	
				monTableau[i][j][1] = rs.getString("xAxis");	
				monTableau[i][j][2] = rs.getString("yAxis");
					
										
				}
			
		}
			this.monTableau=monTableau;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return monTableau;
	}
	 
	public String[][] lireEnBaseMobile(int level) {
		String url = "jdbc:mysql://localhost/lorann";
		String login = "pascal";
		String passwd = "";

		java.sql.Connection cn=null;
		java.sql.Statement st =null;
		java.sql.ResultSet rs =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "call lorann.mapMobile("+level+");";
			rs = st.executeQuery(sql);

			rs.next();

			int nbrmobile = rs.getInt("NbrMobile");
			String [][] monTableauMobile = new String[nbrmobile][3];

			monTableauMobile[0][0] = rs.getString("NbrMobile");
			
			for (int i=1;i<nbrmobile;i++) {
				rs.next();
				monTableauMobile[i][0] = rs.getString("model");	
				monTableauMobile[i][1] = rs.getString("xAxis");	
				monTableauMobile[i][2] = rs.getString("yAxis");
					
			
		}
			this.monTableauMobile=monTableauMobile;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return monTableauMobile;
	}

public void Movementest() {
	String [][] monTableau = new String[20][12];
	for (int i=0;i<20;i++) {
		for (int j=0;j<12;j++) {
		monTableau[i][j] = "A["+ i+ "]"+"["+j +"]";	
		System.out.println(monTableau[i][j]);
		}
	}
	
}
	
}
