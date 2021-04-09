package Kspring.Kspring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT SYSDATE();")
	public String getTime();
	
	public String getTime2();
	
//	@Select("select dayofweek('1998-02-03');")
//	public String getMyBirthDay();

//	@Select("SELECT SYSDATE();") 
//	public String getTime2();
	 
	
	
	
}
