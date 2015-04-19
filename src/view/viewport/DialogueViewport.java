package view.viewport;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DialogueViewport extends Viewport{
	public static DialogueViewport instance;
	JTextArea textArea;
	
	private DialogueViewport(){
		this.setLayout(new BorderLayout());
		textArea = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public static DialogueViewport getInstance(){
		if(instance == null){
			instance = new DialogueViewport();
		}
		return instance;
		
	}

	@Override
	public void render() {
		
		
	}

	public void print(String description) {
		textArea.append(description + "\n");
	}

}
