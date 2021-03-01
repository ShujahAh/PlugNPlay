package dataManipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import templates.Certification;
import templates.StartingTemplate;
import templates.Template;

public class FileRead {
	
	private File GameFile;
	private List<Template> templates_to_send=new ArrayList<Template>(); 
	
	public FileRead(String GameFile) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException{
		this.GameFile = new File(GameFile);
		try {
			ReadFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Template> getTemplates(){
		return this.templates_to_send;
	}
	
	private void ReadFile() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		String contents = "";
		
		String[] sections;
		String[] templates;
		String[] texts;
		String[] text_subs;
		
		Scanner scanner = new Scanner(GameFile);
		while(scanner.hasNextLine()) {
			contents += scanner.nextLine(); 
		}
		
		sections = contents.split("<section>");
		// create starting template
		Template starting = new StartingTemplate(sections[0]);
		templates_to_send.add(starting);
		templates = sections[1].split("<template>");
		
		for (int i = 1; i < templates.length; i++) {
			List<String> text_to_send=new ArrayList<String>(); 
			texts = templates[i].split("<text>");
			text_subs = texts[1].split("<textsub>");
			for (int y = 1; y<text_subs.length; y++){
				text_to_send.add(text_subs[y]);
			}
			text_to_send.add(texts[2]);
			Template tmp = (Template) Class.forName("templates."+texts[0]).getConstructor(List.class).newInstance(text_to_send);
			templates_to_send.add(tmp);
		}
		
		Template ending = new Certification(sections[2]);
		templates_to_send.add(ending);
		scanner.close();
		
	}
	
	
	
}
