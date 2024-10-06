import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerAnimation{
	private ArrayList<OneScene> motion;
	private int motionIndex;
	private long movieTime;
	private long totalTime;

	public PlayerAnimation(){
		motion = new ArrayList<>();
		totalTime = 0;
		start();
	}//Constructor

	public synchronized void addScene(BufferedImage spritesheet, int frameWidth, int frameHeight, int frameIndex, long t){
		int x = (frameIndex % (spritesheet.getWidth()/frameWidth)) * frameWidth;
		int y = (frameIndex % (spritesheet.getWidth()/frameWidth)) * frameHeight;

		Image frame = spritesheet.getSubimage(x, y, frameWidth, frameHeight);
		totalTime += t;
		motion.add(new OneScene(frame, totalTime));
	}

	public synchronized void start(){
		movieTime = 0;
		motionIndex = 0;
	}

	public synchronized void update(long timePassed){
		if(motion.size() > 1){
			movieTime += timePassed;
		}

		if(movieTime >= totalTime){
			movieTime = 0;
			motionIndex = 0;
		}

		while((motionIndex < motion.size() - 1) && (movieTime > getScene(motionIndex + 1).endTime)){
			motionIndex++;
		}
	}

	public synchronized Image getCurrentImage(){
		return getScene(motionIndex).image;
	}

	public synchronized OneScene getScene(int index){
		return motion.get(index);
	}

	private class OneScene{
		Image image;	//The image of the scene
		long endTime;	//The end time of this scene 

		OneScene(Image image, long endTime){
			this.image = image; //Sets the image
			this.endTime = endTime; //Sets the end time
		}//Constructor
	}//Class OneScene to represent a single scene in the animation
}