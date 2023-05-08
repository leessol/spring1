package com.shinhan.util;




import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	//util의 DATE를 sql DATE로 바꾼다. 
	public static Date convertodate(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//util의 데이터가 import되어있으므로 sql은 풀네임을 써야 한다. 
		Date sqlDate = null;
		try {
			java.util.Date d = sdf.parse(sdate);
			sqlDate = new Date(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}

}
