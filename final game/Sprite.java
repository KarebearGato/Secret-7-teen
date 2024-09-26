import java.awt.*;

class Sprite {
	private GamePanel sprt;
	private float x;
	private float y;
	private float vx; //speed / velocity of the sprite
	private float vy;
	
	public Sprite(GamePanel sprt){
		this.sprt=sprt;
	}
	
	public void update(long timePassed){
		x+=vx*timePassed;
		y+=vy*timePassed;
		sprt.update(timePassed);
	}
	
	public float getX(){   // get the position of the player/sprite
		return x;
	}
	public float getY(){
		return y;
	}
	
	
	public void setX(float x){
		this.x=x;
	}
	public void setY(float y){
		this.y=y;
	}
	
	public int getWidth(){
		return sprt.getImage().getWidth(null);
	}
	public int getHeight(){
		return sprt.getImage().getHeight(null);
	}
	
	public float getVelocityX(){
		return vx;
	}
	public float getVelocityY(){
		return vy;
	}
	
	public void setVelocityX(){
		this.vx=vx;
	}
	public void setVelocityY(){
		this.vy=vy;
	}
	
	public Image getImage(){
		return sprt.getImage();
	}
}