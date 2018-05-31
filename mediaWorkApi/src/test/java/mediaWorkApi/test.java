package mediaWorkApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fang.mediaWorkApi.service.IUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class test {

	@Resource
	private IUserInfoService userInfoService=null;
	
	@Test
	public void testper(){
		Calendar calendar=Calendar.getInstance();		
		Date date = calendar.getTime();
		SimpleDateFormat format = null;
		String startMonth="";
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		if (calendar.get(Calendar.DAY_OF_WEEK)-1==0){
			
			calendar.add(Calendar.DATE, -6);
			format=new SimpleDateFormat("yyyy-MM-dd");
			date=calendar.getTime();
			startMonth = format.format(date);
			
		} else {
			
			calendar.add(Calendar.DATE, 1-(calendar.get(Calendar.DAY_OF_WEEK)-1));
			format=new SimpleDateFormat("yyyy-MM-dd");
			date=calendar.getTime();
			startMonth = format.format(date);
								
		}
		
		System.out.println(startMonth);
	}
}
