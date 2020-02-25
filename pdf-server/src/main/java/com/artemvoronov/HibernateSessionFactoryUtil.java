package com.artemvoronov;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import com.artemvoronov.entity.*;

public class HibernateSessionFactoryUtil {
  private static SessionFactory sessionFactory;
  private static StandardServiceRegistry registry;

  private HibernateSessionFactoryUtil(){}

  public static SessionFactory getSessionFactory(){
    if (sessionFactory == null){
      try{
          registry = new StandardServiceRegistryBuilder().configure().build();
          MetadataSources sources = new MetadataSources(registry);
          Metadata metadata = sources.getMetadataBuilder().build();
          sessionFactory = metadata.getSessionFactoryBuilder().build();
      } catch(Exception e){
	        e.printStackTrace();
          if(registry !=null){
            StandardServiceRegistryBuilder.destroy(registry);
          }
      }
    }
    return sessionFactory;
  }
}
