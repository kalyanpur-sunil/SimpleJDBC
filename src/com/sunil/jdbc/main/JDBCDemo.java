package com.sunil.jdbc.main;

import com.sunil.dao.impl.JdbcDaoImpl;
import com.sunil.jdbc.model.Circle;

public class JDBCDemo {

	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(2);
		System.out.println(circle);
	}

}
