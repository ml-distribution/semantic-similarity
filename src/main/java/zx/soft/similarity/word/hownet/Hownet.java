package zx.soft.similarity.word.hownet;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.similarity.Similaritable;
import zx.soft.similarity.word.hownet2.concept.BaseConceptParser;
import zx.soft.similarity.word.hownet2.concept.XiaConceptParser;
import zx.soft.similarity.word.hownet2.sememe.BaseSememeParser;
import zx.soft.similarity.word.hownet2.sememe.XiaSememeParser;

/**
 * Hownet的主控制类, 通过知网的概念和义原及其关系计算汉语词语之间的相似度.
 * 相似度的计算理论参考论文《汉语词语语义相似度计算研究》
 *
 * @see zx.soft.similarity.Similaritable
 */
public class Hownet implements Similaritable {

	/** the logger */
	private static final Logger logger = LoggerFactory.getLogger(Hownet.class);
	/** 知网的单例 */
	private static Hownet instance = null;

	private BaseConceptParser conceptParser = null;

	private Hownet() {
		try {
			BaseSememeParser sememeParser = new XiaSememeParser();
			conceptParser = new XiaConceptParser(sememeParser);
		} catch (IOException e) {
			logger.error("Exception:{}", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 单例获取知网对象
	 * @return
	 */
	public static Hownet instance() {
		if (null == instance) {
			instance = new Hownet();
		}
		return instance;
	}

	/**
	 * 获取概念解析器
	 * @return
	 */
	public BaseConceptParser getConceptParser() {
		return conceptParser;
	}

	@Override
	public double getSimilarity(String item1, String item2) {
		return conceptParser.getSimilarity(item1, item2);
	}

}
