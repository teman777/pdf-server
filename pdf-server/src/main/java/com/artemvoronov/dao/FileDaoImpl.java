package com.artemvoronov.dao;
import java.io.File;
import org.springframework.stereotype.Repository;

@Repository
public class FileDaoImpl implements FileDao {
    @Override
    public void saveFile(File file){
        if(file != null){
        }

    }
    @Override
    public boolean isExists(String url){

    	return true;
    }
    @Override
    public File getFile(String url){
        return null; 
    }
}
