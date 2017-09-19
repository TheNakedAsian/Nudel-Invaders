package com.theNakedAsian.NudelInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
	
	Handler handler;
	
	private BufferedImage player_image;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.Sprite_Sheet);
		
		player_image = ss.grabImage(1, 1, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {	
		x += velX;
		y += velY;
		
		x= Game.clamp(x, 0, Game.WIDTH - 37);
		y= Game.clamp(y, 0, Game.HEIGHT - 62);
		
		
	}

	public void render(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(player_image, (int)x, (int)y, null);
	}

}
