package osc.v7000;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	OSC_700_GUH_00020.class,
	OSC_700_GUH_00030.class,
	OSC_700_GUH_00250.class,
	OSC_700_GUH_00340.class,
	OSC_700_GUH_00350.class,
	OSC_700_GUH_00370.class,
	OSC_700_GUH_00380.class,
	OSC_700_GUH_00470.class,
	OSC_700_GUH_00480.class,
	OSC_700_GUH_00490.class,
	OSC_700_GUH_00520.class,
	OSC_700_GUH_00530.class,
	OSC_700_GUH_00540.class,
	OSC_700_GUH_00710.class,
	OSC_700_GUH_00750.class,
	OSC_700_GUH_02720.class,
	OSC_700_GUH_02730.class,
	OSC_700_GUH_02750.class,
	OSC_700_GUH_02760.class,
	OSC_700_GUH_02770.class,
	OSC_700_GUH_02780.class,
	OSC_700_CAT_00040.class,
	OSC_700_CAT_00120.class,
	OSC_700_CAT_00230.class,
	OSC_700_CAT_00500.class,
	OSC_700_CAT_00590.class,
	OSC_700_CAT_00670.class,
	OSC_700_CAT_00870.class,
	OSC_700_CAT_00880.class,
	OSC_700_CAT_00920.class,
	OSC_700_CAT_00970.class,
	OSC_700_CAT_00980.class,
	OSC_700_CAT_00990.class,
	OSC_700_CAT_01100.class,
	OSC_700_CAT_01130.class,

	OSC_700_CAT_01210.class,
	OSC_700_CAT_01220.class,
	OSC_700_CAT_01320.class,
	OSC_700_CAT_02200.class,
	OSC_700_CAT_02240.class,
	OSC_700_CAT_02280.class,
	OSC_700_CAT_02320.class,
	OSC_700_CAT_02420.class,
	OSC_700_CAT_02620.class,
	OSC_700_CAT_02650.class,
	OSC_700_CAT_02820.class,
	OSC_700_MYP_00070.class,
	OSC_700_MYP_00120.class,
	OSC_700_MYP_00480.class,
	OSC_700_MYP_00140.class,
	OSC_700_MYP_00310.class,
	OSC_700_MYP_00460.class,
	OSC_700_MYP_00500.class,
	OSC_700_MYP_00820.class,
	OSC_700_MYP_00890.class,
	OSC_700_MYP_00950.class,
	OSC_700_MYP_01090.class,
	OSC_700_MYP_01710.class,
	OSC_700_MYP_01750.class,
	OSC_700_MYP_02010.class,
	OSC_700_MYP_02040.class,
	OSC_700_MYP_02190.class,
	OSC_700_MYP_00800.class,
	OSC_700_MYP_02020.class,
	OSC_700_MYP_02980.class,
	OSC_700_MYP_03110.class,
	OSC_700_MYP_02970.class,
	OSC_700_MYP_04150.class,
	OSC_700_MYP_04760.class,
	OSC_700_MYP_04770.class,

	OSC_700_MYP_04780.class,
	OSC_700_MYP_04860.class,
	OSC_700_MYP_04980.class,
	OSC_700_MYP_05010.class,
	OSC_700_MYP_05020.class,
	OSC_700_MYP_05310.class,
	OSC_700_MYP_05340.class,
	OSC_700_MYP_05350.class,
	OSC_700_MYP_05380.class,
	OSC_700_MYP_05460.class,
	OSC_700_MYP_05750.class,
	OSC_700_MYP_05770.class,
	OSC_700_MYP_05790.class,
	OSC_700_MYP_05840.class,
	OSC_700_SRH_00120.class,
	OSC_700_SRH_00140.class,
	OSC_700_SRH_00220.class,
	OSC_700_SRH_00250.class,
	OSC_700_SRH_00520.class,
	OSC_700_SRH_00580.class,
	OSC_700_SRH_00790.class,
	OSC_700_SRH_00850.class,
	OSC_700_SRH_00980.class,
	OSC_700_SRH_01250.class,
	OSC_700_SRH_01260.class,
	OSC_700_SRH_01320.class,
	OSC_700_SRH_01350.class,
	OSC_700_SRH_01370.class,
	OSC_700_SRH_01372.class,
	OSC_700_SRH_01450.class,
	OSC_700_SRH_01460.class,
	OSC_700_SRH_01810.class,
	OSC_700_PAD_00260.class,
	OSC_700_PAD_00570.class,
	OSC_700_PAD_00940.class,

	OSC_700_PAD_00950.class,
	OSC_700_SRH_02090.class,
	OSC_700_MEM_01950.class,
	OSC_700_MEM_02380.class,
	OSC_700_MKT_00290.class,
	OSC_700_MKT_00380.class,
	OSC_700_MKT_00470.class,
	OSC_700_MKT_00480.class,
	OSC_700_MKT_00481.class,
	OSC_700_MKT_00490.class,
	OSC_700_MKT_02590.class,
	OSC_700_MKT_02640.class,
	OSC_700_MKT_02650.class,
	OSC_700_MKT_02660.class,
	OSC_700_MKT_02680.class,
	OSC_700_MKT_02690.class,
	OSC_700_MKT_02700.class,
	OSC_700_MKT_02710.class,
	OSC_700_MKT_02720.class,
	OSC_700_MKT_02730.class,
	OSC_700_MKT_02740.class,
	OSC_700_MKT_02780.class,
	OSC_700_MKT_02800.class,
	OSC_700_MKT_02810.class,
	OSC_700_MKT_02830.class,
	OSC_700_MKT_02840.class,
	OSC_700_MKT_02850.class,
	OSC_700_MKT_02860.class,
	OSC_700_MKT_03010.class,
	OSC_700_MKT_03050.class,
	OSC_700_MKT_04570.class,
	OSC_700_PAY_00011.class,
	OSC_700_PAY_00012.class,
	OSC_700_PAY_00400.class,
	OSC_700_PAY_00440.class,
		
	})
public class OSC_700_All_IOT {

}
 