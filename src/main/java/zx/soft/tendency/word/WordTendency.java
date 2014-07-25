package zx.soft.tendency.word;

/**
 * 计算词语的语义倾向性，词语的语义倾向性为一个介于[-1, 1]之间的实数，数值越大，褒义性越强，否则，贬义性越强
 * 
 */
public interface WordTendency {

	/**
	 * 获取词语的语义倾向性，词语的语义倾向性为一个介于[-1, 1]之间的实数，数值越大，褒义性越强，否则，贬义性越强
	 * @param word
	 * @return
	 */
	public double getTendency(String word);

}
