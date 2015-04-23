package zx.soft.classification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.similarity.sentence.SegmentProxy;
import zx.soft.similarity.sentence.SegmentProxy.Word;

/**
 * 代表一个文档实例
 *
 */
public class Instance {

	private static Logger logger = LoggerFactory.getLogger(Instance.class);

	/** 文档类别 */
	private String category;
	/** 文档内容 */
	private final Set<String> bag = new HashSet<>();

	public Instance() {
		//
	}

	public Instance(String category, File f, String encoding) {
		this.category = category;
		String line = null;

		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), encoding));) {
			while ((line = in.readLine()) != null) {
				//				System.out.println(line);
				List<Word> words = SegmentProxy.segment(line);
				for (Word w : words) {
					if (w.getPos().endsWith("adj") || w.getPos().startsWith("n") || w.getPos().startsWith("v")) {
						bag.add(w.getWord());
					}
				}
			}
		} catch (IOException e) {
			logger.error("current file:{},current line:{}", f.getAbsolutePath(), line);
			e.printStackTrace();
		}
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<String> getWords() {
		return bag;
	}

}
