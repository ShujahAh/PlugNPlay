package dataManipulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import templates.Template;

public class FileSave {

	private File GameFile;
	private final String templateID = "T";
	private final String nontemplateID = "M";
	public FileSave(String name) {
		this.GameFile = new File(name);
	}
	
	public FileSave(File name) {
		this.GameFile = name;
	}
	
	public void SaveData(List<Template> data) throws IOException {
		String data_to_write;
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(GameFile));
		//writer.write(data.get(0).getText());
		writer.write("PopTart");
		writer.newLine();
		writer.write("<section>");
		writer.newLine();
		for (int i= 0; i < data.size(); i++) {
			if (!data.get(i).getID().equals(nontemplateID)) {
				writer.write("<template>");
				writer.newLine();
				writer.write(data.get(i).getText());
				writer.newLine();
			}
			
		}
		
		writer.write("<section>");
		writer.newLine();
		//writer.write(data.get(data.size()-1).getText());
		writer.write("finished");
		writer.close();
	}
}
