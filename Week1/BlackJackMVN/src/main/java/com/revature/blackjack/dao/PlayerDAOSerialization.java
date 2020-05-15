package com.revature.blackjack.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.blackjack.player.Player;

public class PlayerDAOSerialization implements PlayerDAO{

	File directory = new File(".");
	String fileName = "";
	String absolutePath = "";
	
	@Override
	public void savePlayer(Player p) {
		fileName = p.getName() + ".txt";
		try {
			absolutePath = directory.getCanonicalPath() + File.separator + fileName;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(absolutePath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Player getPlayer(String playerName) {
		Player p = null;
		fileName = playerName + ".txt";
		try {
			absolutePath = directory.getCanonicalPath() + File.separator + fileName;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Try-With-Resources         vvvvvv----must implement AutoCloseable
		try (FileInputStream fis = new FileInputStream(absolutePath); ObjectInputStream ois = new ObjectInputStream(fis)){
			p = (Player) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

}
