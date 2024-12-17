package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_MYP_05770 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-15
	 * @ ExpectedResult = 마이페이지 > 이용안내 > 통신판매 사업자 안내 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_MYP_05770() throws Exception {
		TCID = "OSC700_04_설정_05770 통신판매 사업자 안내 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my_layout").click();
		
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_my").isSelected());
		
		downscroll(By.id("com.skt.skaf.A000Z00040:id/menu_use_guide")).click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='통신판매 사업자 안내']").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_up_indicator").isDisplayed();
		assertEquals("통신판매 사업자 안내", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.findElementByXPath("//*[@text='고객센터']").click();
		driver.findElementByXPath("//*[@text='1600-6573(유료)']").click();
		
		driver.findElementByXPath("//*[@text='이메일']").click();
		driver.findElementByXPath("//*[@text='cscenter@onestore.co.kr']").click();
		
		driver.findElementByXPath("//*[@text='대표이사 : 구현모\n" + 
				"주소 : 경기도 성남시 분당구 불정로 90\n" + 
				"사업자등록번호 : 102-81-42945\n" + 
				"통신판매업신고 : 제2002-경기성남-0048호']").click();
		
		driver.findElementByXPath("//*[@text='대표이사 : 하현회\n" + 
				"주소 : 서울특별시 용산구 한강대로 32\n" + 
				"사업자등록번호 : 220-81-39938\n" + 
				"통신판매업신고 : 제2015-서울용산-00481호']").click();

		driver.findElementByXPath("//*[@text='대표이사 : 이재환\n" + 
				"주소 : 경기도 성남시 분당구 판교역로 146번길 20\n" + 
				"사업자등록번호 : 856-86-00329\n" + 
				"통신판매업신고 : 제2016-성남분당-0175호']").click();
		
		result = "PASS";
	}
}