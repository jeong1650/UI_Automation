package osc.v7000;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class OSC_700_SRH_00320 extends OSC_Base_text {

	/* -----------------------------------------------------------------------------
	 * @ Writer = Park Cheolmin
	 * @ Date = 2020-09-16
	 * @ ExpectedResult = 메인 > 검색 > 북스 바로가기 영역 정상 노출
	 * @ Editor = 
	 * @ EditDate = 
	 * @ 
	 * -----------------------------------------------------------------------------
	 */

	@Test
	public void OSC_SRH_00320() throws Exception {
		TCID = "OSC700_05_검색_00320 북스 바로가기 영역";
		result = "FAIL";
		size = driver.manage().window().getSize();
		
		popupCheck();
				
		driver.findElementById("com.skt.skaf.A000Z00040:id/btn_search").click();
		
		Thread.sleep(3000);
		assertEquals("원스토어 북스 바로가기", downscroll(By.id("com.skt.skaf.A000Z00040:id/search_move_books_title")).getText());
				
		result = "PASS";
	}
}