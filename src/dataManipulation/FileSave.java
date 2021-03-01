package dataManipulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import templates.Template;

public class FileSave {

	private File GameFile;
	public FileSave(String name) {
		this.GameFile = new File(name);
	}
	
	public void SaveData(List<Template> data) throws IOException {
		String data_to_write;
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(GameFile));
		writer.write(data.get(0).getText());
		writer.newLine();
		writer.write("<section>");
		writer.newLine();
		for (int i= 1; i < data.size()-1; i++) {
			writer.write("<template>");
			writer.newLine();
			writer.write(data.get(i).getText());
			writer.newLine();
			
		}
		
		writer.write("<section>");
		writer.newLine();
		writer.write(data.get(data.size()-1).getText());
		writer.close();
	}
}
