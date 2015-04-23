package zx.soft.similarity.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

/**
 * 关于xsimilarity项目的说明信息
 *
 */
public class About extends JFrame {

	private static final long serialVersionUID = -2307582155443587993L;

	public static JPanel createPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JTextPane editorPane = new JTextPane();
		editorPane.setEditable(false);
		//让长文本自动换行
		editorPane.setEditorKit(new StyledEditorKit());
		editorPane.setContentType("text/html");
		try {
			URLClassLoader urlLoader = (URLClassLoader) About.class.getClassLoader();
			String html = "data/about.html";
			System.out.println(html);
			URL url = urlLoader.findResource(html); // 可以用html格式文件做你的帮助系统了
			editorPane.setPage(url);
		} catch (IOException e1) {
			editorPane.setText(e1.getMessage());
		}
		// editorPane.setText("<html><body>个人主页：<a href='xiatian.irm.cn'>http://xiatian.irm.cn/</a></body></html>");

		mainPanel.add(new JScrollPane(editorPane), BorderLayout.CENTER);
		return mainPanel;
	}

	public About() {
		this.setTitle("关于Semantic-Similarity");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(600, 400));
		this.getContentPane().add(createPanel());
		this.pack();
	}

	public static void main(String[] args) {
		new About().setVisible(true);
	}

}
