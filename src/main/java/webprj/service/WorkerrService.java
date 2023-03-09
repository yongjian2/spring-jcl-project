package webprj.service;

import java.sql.SQLException;
import java.util.List;

import webprj.entity.Workerr;

public interface WorkerrService {
	
	List<Workerr> getWorkerr() throws SQLException, ClassNotFoundException;

}
