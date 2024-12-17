package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAY_00400 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-10-16
	 * @ ExpectedResult = 배송상품 결제 페이지 > 상품 정보 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAY_00400() throws Exception {
		TCID = "OSC600_09_쇼핑_00400 배송 상품 구매하기 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();

		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		try {
			driver.findElementById("com.skt.skaf.A000Z00040:id/search_history_all_delete").click();
		} catch (Exception e) {}
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("고속 충전 USB C타입 PD 보조배터리 10000mAh A10D");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/search_result_item_shop_title").click();
		
		Thread.sleep(3000);
		String itemTitle = driver.findElementById("com.skt.skaf.A000Z00040:id/main_info_title").getText();
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(3000);
		String optionName = driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_selected_item").getText();
		String price = driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_price").getText();
		price = price.replace("원", " 원");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/shopping_option_purchase").click();
		
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='우편번호 찾기']").click();
		
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@resource-id='sch_zip']").sendKeys("분당내곡로 117");
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='검색']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='경기도 성남시 분당구 분당내곡로 117 (백현동, 크래프톤타워)']").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='receiverName']").sendKeys("테스트");
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='subAddress']").sendKeys("5층");
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@resource-id='phoneNumber']").sendKeys("010-1234-5678");
		
		upSwipe(0.80);
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='확인']")).click();
		
		Thread.sleep(5000);		
		driver.findElementByXPath("//*[@resource-id='btnCancelSubmit']").isDisplayed();
		driver.findElementByXPath("//*[@text='쇼핑']").isDisplayed();
		driver.findElementByXPath("//*[@text='" + itemTitle + "']").isDisplayed();
		driver.findElementByXPath("//*[@text='" + optionName + "']").isDisplayed();
		driver.findElementByXPath("//*[@text='" + price + "']").isDisplayed();
		driver.findElementByXPath("//*[@text='배송 상품']").isDisplayed();
										
		result = "PASS";
	}
}