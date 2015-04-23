package zx.soft.similarity;

import zx.soft.similarity.sentence.SentenceSimilarity;
import zx.soft.similarity.sentence.morphology.MorphoSimilarity;
import zx.soft.similarity.word.WordSimilarity;
import zx.soft.similarity.word.hownet2.concept.XiaConceptParser;

public class SimilarityFactory {

	private static WordSimilarity wordSimilarity = XiaConceptParser.getInstance();
	private static SentenceSimilarity sentenceSimilarity = MorphoSimilarity.getInstance();

	private SimilarityFactory() {
		//
	}

	public static WordSimilarity getWordSimilarity() {
		return wordSimilarity;
	}

	public static SentenceSimilarity getSentenceSimilarity() {
		return sentenceSimilarity;
	}

}
