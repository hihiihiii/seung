package Kspring.Kspring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT NOW();")
	public String getTime();
	
	@Select("select dayofweek('1998-02-03');")
	public String getMyBirthDay();
}
