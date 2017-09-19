package com.theNakedAsian.NudelInvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH/12*9;
	
	private Thread thread;
	private boolean isRunning = false;
	
	private Handler handler;
	private HUD hud;
	private Menu menu;
	private Spawner spawner;
	
	public enum STATE{
		Menu,
		Game,
		End;
	}
	
	public static STATE gameState = STATE.Menu;
	
	public static BufferedImage Sprite_Sheet;
	
	public Game() {
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		spawner = new Spawner(handler, hud);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		
		new Window(WIDTH, HEIGHT, "Noodel Invaders!", this);
		
		BufferedImageLoader loader = new BufferedImageLoader();
		Sprite_Sheet = loader.loadImage("/Sprite_sheet.png");
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
		
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
			hud.tick();
			spawner.tick();
			KeyInput.time -= 1;
			
			if(HUD.health1 == 0 && hud.health2 == 0 && hud.health3 == 0) {
				hud.health1 = 32;
				hud.health2 = 32;
				hud.health3 = 32;
				
				gameState = STATE.End;
				handler.clearEnemys();
			}else if(gameState == STATE.Menu || gameState == STATE.End) {
				menu.tick();
			}
		}
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		////////////////////////////////////////////////
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(gameState == STATE.Game) {
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.End) {
			menu.render(g);
		}
		
		////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	
	public static void main(String[] args) {
		new Game();
	}

}
