package main.java.furniture.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import main.java.furniture.model.Raport;

public class FileRaport implements IRaport {

	@Override
	public String genereazaRaport(List<Raport> list) {
		if (list != null && list.size() > 0) {
			try {
				String file = "C:\\Users\\sandy\\workspace\\project-furniture\\raport.txt";
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				list.forEach(raportEntry -> scrieLinie(bw, raportEntry));
				bw.close();
				return file;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	private void scrieLinie(BufferedWriter bw, Raport raportEntry) {
		try {
			bw.write(raportEntry.getUser() + "," + raportEntry.getActiune() + " resursa " + raportEntry.getResourceId() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
