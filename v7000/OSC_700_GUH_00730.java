package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_GUH_00730 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-01
	 * @ ExpectedResult = 앱&라이프 추천 화면 > 최하단 Footer 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 2020-10-15
	 * @ 타이틀 상이하게 인식되는 단말 대응
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_GUH_00730() throws Exception {
		TCID = "OSC700_01_Home_00730 최하단 Footer 영역 확인";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").click();
				
		Thread.sleep(3000);
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/btn_app_life").isSelected());
		assertTrue(driver.findElementById("com.skt.skaf.A000Z00040:id/app_tap_layout").isSelected());
		
		for(int i = 0; i < 10; i++) {
			upSwipe(0.80);
		}
			
		assertEquals("이용약관", upscroll(By.id("com.skt.skaf.A000Z00040:id/footer_policy")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/footer_policy").click();
		
		Thread.sleep(5000);
		try {
			driver.findElementByXPath("//*[@text='이전페이지 이용약관']").isDisplayed();
		} catch(Exception e) {
			try {
				driver.findElementByXPath("//*[@text='이용약관']").isDisplayed();
			} catch(Exception ee) {
				driver.findElementByXPath("//*[@content-desc='이용약관']").isDisplayed();
			}
		}
		
		driver.navigate().back();
		
		Thread.sleep(3000);		
		assertEquals("개인정보처리방침", downscroll(By.id("com.skt.skaf.A000Z00040:id/footer_information")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/footer_information").click();
		
		Thread.sleep(5000);
		try {
			driver.findElementByXPath("//*[@text='이전페이지 개인정보처리방침']").isDisplayed();
		} catch(Exception e) {
			try {
				driver.findElementByXPath("//*[@text='개인정보처리방침']").isDisplayed();
			} catch(Exception ee) {
				driver.findElementByXPath("//*[@content-desc='개인정보처리방침']").isDisplayed();
			}
		}
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		assertEquals("고객센터", downscroll(By.id("com.skt.skaf.A000Z00040:id/footer_cs")).getText());
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/footer_cs").click();
		
		Thread.sleep(3000);
		assertEquals("고객센터", driver.findElementById("com.skt.skaf.A000Z00040:id/toolbar_title").getText());
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='ⓒ One store Co., Ltd.']"));
		
		driver.findElementByXPath("//*[@text='대표이사 : 구현모']").isDisplayed();
		driver.findElementByXPath("//*[@text='주소 : 경기도 성남시 분당구 불정로 90']").isDisplayed();
		driver.findElementByXPath("//*[@text='사업자등록번호 : 102-81-42945']").isDisplayed();
		assertEquals("통신판매업신고 : 제2002-경기성남-0048호", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_seller_info_kt").getText());
		
		driver.findElementByXPath("//*[@text='대표이사 : 하현회']").isDisplayed();
		driver.findElementByXPath("//*[@text='주소 : 서울특별시 용산구 한강대로 32']").isDisplayed();
		driver.findElementByXPath("//*[@text='사업자등록번호 : 220-81-39938']").isDisplayed();
		assertEquals("통신판매업신고 : 제2015-서울용산-00481호", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_seller_info_uplus").getText());
		
		driver.findElementByXPath("//*[@text='대표이사 : 이재환']").isDisplayed();
		driver.findElementByXPath("//*[@text='주소 : 경기도 성남시 분당구 판교역로 146번길 20']").isDisplayed();
		driver.findElementByXPath("//*[@text='사업자등록번호 : 856-86-00329']").isDisplayed();
		assertEquals("통신판매업신고 : 제2016-성남분당-0175호", driver.findElementById("com.skt.skaf.A000Z00040:id/tv_seller_info_onestore").getText());
		
		driver.findElementByXPath("//*[@text='KT(주), (주)LG유플러스, 원스토어(주)는 통신판매중개자로서 상품의 등록정보, 판매, 문의답변에 대한 의무와 책임은 각 판매자에게 있습니다.']").isDisplayed();
		
				
		result = "PASS";

	}
}