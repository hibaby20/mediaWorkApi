package mediaWorkApi;

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
		String per = userInfoService.GetPositionByOAUserID(344);
		
		System.out.println(per);
	}
}
