package com.artemvoronov.dao;
import java.io.File;

public interface FileDao {
  public void saveFile(); // TODO
  public boolean isExists(String url);
  public File getFile(String url);

}
