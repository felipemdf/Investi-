package com.felipemdf.investimais;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InvestiMais {

    public static void main(String[] args) {
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}
