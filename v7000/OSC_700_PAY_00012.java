package osc.v7000;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_PAY_00012 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-29
	 * @ ExpectedResult = 결제 페이지 > 환불 안내 영역 [자세히 보기] 선택 시 청약 철회 규정 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_PAY_00012() throws Exception {
		TCID = "OSC600_09_APP_00012 구매하기 선택";
		result = "FAIL";
		size = driver.manage().window().getSize();

		popupCheck();
		
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search_layout").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_keyword_edittext").sendKeys("SPEDOG");
		driver.findElementById("com.skt.skaf.A000Z00040:id/searchbar_search_icon").click();
		
		Thread.sleep(3000);
		Click("com.skt.skaf.A000Z00040:id/search_result_item_app_title");
		
		Thread.sleep(3000);
		driver.findElementById("com.skt.skaf.A000Z00040:id/text").click();
						
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='자세히 보기']"));
		
		Thread.sleep(3000);
		for(int i = 0; i <= 5; i++) {
			upSwipe(0.90);
		}		
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='자세히 보기']").click();
		
		Thread.sleep(3000);
		downscroll(By.xpath("//*[@text='청약 철회 규정 안내']"));
		downscroll(By.xpath("//*[@text='청약철회 제한']"));
		downscroll(By.xpath("//*[@text='- 유료아이템 구매 시 별도의 요금이 청구될 수 있으며, 구매한 상품의 가치가 현저히 감소되거나 디지털 콘텐츠 상품을 바로보기/다운로드 한 경우에는 전자상거래법이 정한 바에 따라 청약철회가 제한됩니다.']"));
		downscroll(By.xpath("//*[@text='청약철회 가능한 경우']"));
		downscroll(By.xpath("//*[@text='- 상품이 표시광고 내용과 다르거나 불량 등 계약과 다르게 이행된 경우에는 상품 구매일부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 교환/반품이 가능합니다.\n" + 
				"- 법정 대리인의 동의 없는 미성년자 회원의 상품구매행위는 취소할 수 있습니다. 다만, 미성년자 회원이 성년자의 주민등록번호, 결제 정보 등을 회사에 제공하여 성년자로 믿게 하거나 회사가 통신과금서비스 이용 동의를 이미 수령하는 등의 일정한 경우에는 취소권이 제한됩니다.']"));
		downscroll(By.xpath("//*[@text='청약철회 요청 방법']"));
		downscroll(By.xpath("//*[@text='- 원스토어 결제 상품의 청약철회는 상품상세설명 페이지 내 판매사 문의하기 또는 ONE store 고객센터(1600-6573)를 통해 행사할 수 있습니다.\n" + 
				"- 외부결제 상품의 환불/취소 문의는 판매사 문의하기를 통해 행사할 수 있습니다.\n" + 
				"- 정당한 청약철회가 있는 경우 전자상거래법이 정한 바에 따라 환불처리가 됩니다.\n" + 
				"- 신용카드 등 결제수단에 따라 소요되는 기간이 다를 수 있습니다.']"));
		
		result = "PASS";

	}
}