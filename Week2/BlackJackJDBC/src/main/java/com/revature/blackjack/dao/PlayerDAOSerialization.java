package com.revature.blackjack.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.blackjack.player.Player;

public class PlayerDAOSerialization implements PlayerDAO{

	@Override
	public void savePlayer(Player p) {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(p.getName());
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
		// Try-With-Resources         vvvvvv----must implement AutoCloseable
		try (FileInputStream fis = new FileInputStream(playerName); ObjectInputStream ois = new ObjectInputStream(fis)){
			p = (Player) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		return p;
	}

}
