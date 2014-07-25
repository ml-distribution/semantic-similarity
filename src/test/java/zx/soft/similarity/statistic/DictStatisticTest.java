package zx.soft.similarity.statistic;

import zx.soft.similarity.statistic.DictStatistic;
import junit.framework.TestCase;

/**
 * ./db/coredict.xml.gz是利用的ictclas4j的词典文件，这个文件可以从lib/ictclas4j.jar文件中得到。
 * 即：把ictclas4j.jar文件解压开，里面的dictionary目录下有coredict.xml.gz文件。
 * 
*/
public class DictStatisticTest extends TestCase {

	public void testCount() {
		DictStatistic ds = new DictStatistic();
		ds.testFromXml("./db/coredict.xml.gz", true);
	}

}
